package string.util;

import java.util.regex.Pattern;

public class StringHelper {

    public static String[] splitByWords(String text, String... words) {
        StringBuilder regexBuilder = new StringBuilder();
        for (String word : words) {
            regexBuilder.append(word).append("|");
        }
        regexBuilder.deleteCharAt(regexBuilder.length() - 1);
        return text.split(regexBuilder.toString());
    }

    public static String replaceVowelsByCharacter(String text, char character) {
        return text.replaceAll("[aeiouAEIOU]", Character.toString(character));
    }

    public static boolean checkBeginsCapitalEndsPeriodSentence(String text) {
        Pattern pattern = Pattern.compile("^[A-Z].*[.]$");
        return pattern.matcher(text).matches();
    }
}
