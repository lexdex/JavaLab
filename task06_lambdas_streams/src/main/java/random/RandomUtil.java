package random;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomUtil {

    public static List<Integer> getIntegerListByRandom(int amount) {
        return new Random().ints(amount).boxed().collect(Collectors.toList());
    }

    public static List<Integer> getIntegerListByThreadLocal(int amount) {
        return ThreadLocalRandom.current().ints().limit(amount).boxed().collect(Collectors.toList());
    }





}
