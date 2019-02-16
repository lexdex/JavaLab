package string;

import string.application.Console;
import string.application.ConsoleApplication;
import string.application.ConsoleMenu;
import string.util.StringHelper;
import string.util.StringUtils;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        StringUtils stringUtils = new StringUtils();
        String result = stringUtils.add(100).add("aaaa").add(3.1415).concat();
        System.out.println(result);

        System.out.println(Arrays.toString(StringHelper
                .splitByWords("Based on the med. report you were ok",
                        new String[]{"the", "you"})));

        System.out.println(StringHelper
                .replaceVowelsByCharacter(
                        "Cliffs have collapsed in New Zealand during an earthquake in " +
                                "the city of Christchurch on the South Island",
                        '_'));

        System.out.println(StringHelper
                .checkBeginsCapitalEndsPeriodSentence(
                        "No serious damage or fatalities were reported in the " +
                                "Valentine's Day quake that struck at 13:13 local time."));

        new ConsoleApplication(new ConsoleMenu(new Console())).start();
    }
}
