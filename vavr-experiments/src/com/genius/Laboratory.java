package com.genius;

import com.genius.tuples.TestTube;
import io.vavr.*;
import io.vavr.collection.Stream;
import io.vavr.control.Option;

public class Laboratory {
    public static void main(String[] args) {
        System.out.println("Start experiments");
        TestTube tube = new TestTube();
        tube.setMainIngredient(Tuple.of("water", 2));
        System.out.println(tube.getMainIngredient()._1);
        System.out.println(tube.getMainIngredient()._2);

        Tuple2<String, Integer> newIngredient = tube.getMainIngredient().map(
           s -> s.substring(0, 3).concat("t"),
            i -> i
        );
        TestTube tube2 = new TestTube(newIngredient);
        System.out.println(newIngredient);

        Function2<TestTube, TestTube, TestTube> combineTubes = (testTube, testTube2) -> new TestTube(
                Tuple.of(
                        testTube.getMainIngredient()._1 + " and " + testTube2.getMainIngredient()._1,
                        testTube.getMainIngredient()._2 + testTube2.getMainIngredient()._2
                )
        );

        Function1<TestTube, TestTube> lowerConc = Function1.of(Laboratory::lowerConcentration);

        Function2<TestTube, TestTube, TestTube> process = combineTubes.andThen(lowerConc);

        System.out.println(process.apply(tube, tube2));

        // Safe function calling
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> i1 = safeDivide.apply(1, 0);
        Option<Integer> i2 = safeDivide.apply(4, 2);
        System.out.println(i1);
        System.out.println(i2);

        // Partial application
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add2 = sum.apply(2);
        System.out.println(add2.apply(4));

        // Каррирование
        Function1<Integer, Integer> add3 = sum.curried().apply(2);

        // Memorization
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        System.out.println(randomValue1);
        System.out.println(randomValue2);

        // Lazy
        Lazy<Double> lazy = Lazy.of(Math::random);
        lazy.isEvaluated(); // = false
        lazy.get();         // = 0.123 (random generated)
        lazy.isEvaluated(); // = true
        lazy.get();         // = 0.123 (memoized)

        // Validation
        TubeValidator tubeValidator = new TubeValidator();

        //Valid
        System.out.println(tubeValidator.validateTube(tube));
        //Invalid
        TestTube invalidTube = new TestTube("NaMe-1ss", -20);
        System.out.println(tubeValidator.validateTube(invalidTube));

        // Collections
        // 1000 random numbers
        for (double random : Stream.continually(Math::random).take(1000)) {
            if (random < 100) {
                System.out.println(random);
            }
        }

        System.out.println("Stop experiments");
    }

    private static TestTube lowerConcentration(TestTube tube) {
        return new TestTube(Tuple.of(
                tube.getMainIngredient()._1,
                tube.getMainIngredient()._2 / 2
        ));
    }
}
