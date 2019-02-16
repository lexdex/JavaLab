package functional_interface;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        IntValuesFunction maxValueFunc = (a, b, c) -> Stream.of(a, b, c)
                .reduce(Integer::max)
                .orElse(Integer.MIN_VALUE);

        IntValuesFunction averageFunc = (a, b, c) -> (int) Stream.of(a, b, c)
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();

        System.out.println(maxValueFunc.apply(1, 2, 3));
        System.out.println(averageFunc.apply(4, 5, 6));
    }
}
