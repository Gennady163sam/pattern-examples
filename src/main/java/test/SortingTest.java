package test;

import com.nexign.services.PatternService;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;


public class SortingTest {

    @State(Scope.Thread)
    public static class StaticArray {
        int[] array;

        @Setup(Level.Trial)
        public void init() {
            array =  new Random().ints(10000, 1, 5000000).toArray();
        }

        @TearDown(Level.Trial)
        public void clean() {
            System.out.println("Clean");
        }
    }

    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testQuickSort(StaticArray staticArray, Blackhole blackhole) {
        PatternService.quickSort(staticArray.array,0, staticArray.array.length - 1);
        blackhole.consume(staticArray.array);
    }
    @Benchmark
    @BenchmarkMode(value = Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void testBubbleSort(StaticArray staticArray, Blackhole blackhole) {
        PatternService.bubbleSort(staticArray.array);
        blackhole.consume(staticArray.array);
    }

    @Test
    public void testQuickSortMethod() {
        StaticArray staticArray = new StaticArray();
        PatternService.quickSort(staticArray.array,0, staticArray.array.length - 1);
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SortingTest.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
