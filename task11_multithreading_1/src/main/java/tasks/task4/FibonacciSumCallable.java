package tasks.task4;

import tasks.Tools;
import tasks.task2.FibonacciCreator;

import java.util.List;
import java.util.concurrent.Callable;

public class FibonacciSumCallable implements Callable<Long> {
    private String name;

    public FibonacciSumCallable(String name) {
        this.name = name;
    }

    @Override
    public Long call() {
        int set = Tools.getRandomInt(10, 15);
        List<Long> sequence = new FibonacciCreator(set).getFibonacciSequence();
        System.out.println(name + " sequence: " + sequence);
        return getFibonacciSum(sequence);
    }

    private long getFibonacciSum(List<Long> sequence) {
        return sequence.stream().mapToLong(Long::longValue).sum();
    }
}
