package random;

import java.util.IntSummaryStatistics;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> randomList = RandomUtil.getIntegerListByRandom(20);

        IntSummaryStatistics intStream = randomList.stream().mapToInt(Integer::intValue).summaryStatistics();

        double average = intStream.getAverage();
        System.out.println("Average: " + average);
        System.out.println("Min: " + intStream.getMin());
        System.out.println("Max: " + intStream.getMax());
        System.out.println("Sum: " + intStream.getSum());
        randomList.stream().reduce((left, right) -> left + right).ifPresent(System.out::println);

        long count = randomList.stream().map(Integer::intValue).filter(e -> e > average).count();

        System.out.println("Average: " + average);
        System.out.println("Number of values that bigger than average: " + count);

    }
}
