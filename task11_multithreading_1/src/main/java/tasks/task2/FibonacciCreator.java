package tasks.task2;

import java.util.ArrayList;
import java.util.List;

public class FibonacciCreator {
    private List<Long> sequence;
    private int set;

    public FibonacciCreator(int set) {
        this.set = set;
    }

    public List<Long> getFibonacciSequence() {
        sequence = new ArrayList<>();
        for (int i = 0; i < set; i++) {
            sequence.add(getFibonacci(i));
        }
        return sequence;
    }

    private long getFibonacci(final int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long previous = 0;
        long next = 1;
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = previous + next;
            previous = next;
            next = sum;
        }
        return sum;
    }

    List<Long> getSequence() {
        return sequence;
    }
}

