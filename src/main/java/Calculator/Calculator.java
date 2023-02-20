package Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public static Integer stringSplitSum(String text) {
        if (text.length() == 0) {
            return 0;
        }
        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] words = matcher.group(2).split(customDelimiter);
            return convertStringToSumNumber(words);
        }
        String[] words = textSplit(text);
        return convertStringToSumNumber(words);
    }

    private static String[] textSplit(String text) {
        return text.split(",|:");
    }


    private static int convertStringToSumNumber(String[] words) {
        int sumNum = 0;
        List<String> strings = Arrays.asList(words);
        for (int i = 0; i < strings.size(); i++) {
            String result = (strings.get(i));
            int num = Integer.parseInt(result);
            isMinusNum(num);
            sumNum += num;
        }
        return sumNum;
    }


    private static void isMinusNum(int num) {
        if (num < 0) {throw new IllegalArgumentException("마이너스 값은 들어올 수 없습니다.");}
    }
}
