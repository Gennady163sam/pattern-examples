package com.genius.tuples;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class TestTube {
    private Tuple2<String, Integer> mainIngredient;

    public TestTube(String ingrName, int volume) {
        mainIngredient = Tuple.of(ingrName, volume);
    }
}
