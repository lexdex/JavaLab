package stream_application;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ConsoleApplication {

    private List<String> stringList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in, "UTF-8");

    public void start() {

        while (true) {
            String userInput = scanner.nextLine();

            if (Objects.equals(userInput, "")) {
                break;
            } else {
                stringList.add(userInput);
            }
        }

        System.out.println(getUniqueWordsNumber());
        System.out.println(getSortedUniqueWordsList());
        System.out.println(getOccurrenceNumberOfEachWord());
        System.out.println(getCharOccurrenceNumber());

    }

    private int getUniqueWordsNumber() {
        return (int) stringList.stream().distinct().count();
    }

    private List<String> getSortedUniqueWordsList() {
        return stringList.stream().distinct().sorted().collect(Collectors.toList());
    }

    private Map<String, Long> getOccurrenceNumberOfEachWord() {
        return stringList.stream().collect(groupingBy(Function.identity(), counting()));
    }

    private int getCharOccurrenceNumber() {
        return stringList.stream()
                .flatMap(e -> e.chars().boxed())
                .map(e -> (char)e.intValue())
                .filter(e -> !Character.isUpperCase(e))
                .collect(Collectors.toSet()).size();
    }
}
