package test;

import com.genius.TubeValidator;
import com.genius.tuples.TestTube;
import io.vavr.*;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VavrTest {

    @Test
    public void testTuples() {
        TestTube tube = new TestTube("water", 2);
        assertEquals("Invalid ingredient name", "water", tube.getMainIngredient()._1);
        assertEquals("Invalid ingredient volume",2L, (long) tube.getMainIngredient()._2);
        Tuple2<String, Integer> newIngredient = tube.getMainIngredient().map(
                s -> s.substring(0, 3).concat("t"),
                i -> i
        );
        assertEquals("Invalid new ingredient name", "watt", newIngredient._1);
        assertEquals("Invalid new ingredient volume",2L, (long) newIngredient._2);
    }

    @Test
    public void testCombineFunctions() {
        TestTube tube = new TestTube("water", 2);
        TestTube tube2 = new TestTube(tube.getMainIngredient().map(
                s -> s.substring(0, 3).concat("t"),
                i -> i
        ));
        Function2<TestTube, TestTube, TestTube> combineTubes = (testTube, testTube2) -> new TestTube(
                Tuple.of(
                        testTube.getMainIngredient()._1 + " and " + testTube2.getMainIngredient()._1,
                        testTube.getMainIngredient()._2 + testTube2.getMainIngredient()._2
                )
        );

        Function1<TestTube, TestTube> lowerConcentrateFun = Function1.of(TestTube::lowerConcentration);
        Function2<TestTube, TestTube, TestTube> process = combineTubes.andThen(lowerConcentrateFun);
        TestTube result = process.apply(tube, tube2);
        assertEquals("Invalid new ingredient name", "water and watt", result.getMainIngredient()._1);
        assertEquals("Invalid new ingredient volume",2L, (long) result.getMainIngredient()._2);
    }

    @Test
    public void testSafeFunctionCall() {
        Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;
        Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);
        Option<Integer> divideByZeroResult = safeDivide.apply(1, 0);
        Option<Integer> correctDivide = safeDivide.apply(4, 2);
        assertTrue(divideByZeroResult.isEmpty());
        assertFalse(correctDivide.isEmpty());
        assertEquals(2L, (long) correctDivide.get());
    }

    @Test
    public void partitialApplication() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> add = sum.apply(2);
        assertEquals(96L, (long) add.apply(94));
    }

    @Test
    public void curring() {
        Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
        Function1<Integer, Integer> curringAdd = sum.curried().apply(2);
        assertEquals(96L, (long) curringAdd.apply(94));
    }

    @Test
    public void memorizing() {
        Function0<Double> hashCache =
                Function0.of(Math::random).memoized();

        double randomValue1 = hashCache.apply();
        double randomValue2 = hashCache.apply();
        assertEquals(randomValue1, randomValue2, 0.00001);
    }

    @Test
    public void lazy() {
        Lazy<Double> lazy = Lazy.of(Math::random);
        assertFalse(lazy.isEvaluated());
        double lazyVal1 = lazy.get();
        assertTrue(lazy.isEvaluated());
        double lazyVal2 = lazy.get();
        assertEquals(lazyVal1, lazyVal2, 0.00001);
    }

    @Test
    public void validation() {
        TubeValidator tubeValidator = new TubeValidator();
        TestTube tube = new TestTube("water", 2);
        assertTrue(tubeValidator.validateTube(tube).isValid());
        TestTube invalidTube = new TestTube("NaMe-1ss", -20);
        assertTrue(tubeValidator.validateTube(invalidTube).isInvalid());
    }

    @Test
    public void collections() {
        List<Double> values = new ArrayList<>();
        for (double random : Stream.continually(Math::random).take(1000)) {
            values.add(random);
        }
        assertEquals("Incorrect size of list", 1000, values.size());
    }
}
