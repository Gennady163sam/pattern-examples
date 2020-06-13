package com.genius;

import com.genius.tuples.TestTube;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;
import io.vavr.control.Validation;

public class TubeValidator {
    private static final String VALID_NAME_CHARS = "[a-zA-Z ]";
    private static final int MIN_VOLUME = 0;

    public Validation<Seq<String>, TestTube> validateTube(String ingredientName, int volume) {
        return Validation.combine(validateName(ingredientName), validateVolume(volume)).ap(TestTube::new);
    }

    public Validation<Seq<String>, TestTube> validateTube(TestTube tube) {
        return Validation.combine(validateName(tube.getMainIngredient()._1), validateVolume(tube.getMainIngredient()._2)).ap(TestTube::new);
    }

    private Validation<String, String> validateName(String name) {
        return CharSeq.of(name).replaceAll(VALID_NAME_CHARS, "").transform(seq -> seq.isEmpty()
                ? Validation.valid(name)
                : Validation.invalid("Name contains invalid characters: '"
                + seq.distinct().sorted() + "'"));
    }

    private Validation<String, Integer> validateVolume(int volume) {
        return volume < MIN_VOLUME
                ? Validation.invalid("Volume must be at least " + MIN_VOLUME)
                : Validation.valid(volume);
    }
}
