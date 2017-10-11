package lesson1;

import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        System.out.println("test str here was here two times or not no test");
        System.out.println(replace("test str here was here two times or not no test", "e", "ee"));
    }


    private static int countQantytyOfReplases(char[] charInput, char[] charTarget) {
        int countOfInput = 0;
        for (int i = 0; i < charInput.length; i++) {
            boolean greateFlag = true;
            if (charInput[i] == charTarget[0]) {

                boolean flag = true;
                int m = 1;
                for (int k = i + 1; k < i + charTarget.length; k++) {

                    if (k >= charInput.length || charInput[k] != charTarget[m]) {
                        flag = false;
                        greateFlag = false;
                    }
                    if (!flag) {
                        break;
                    }
                    m++;
                }
                if (greateFlag)
                    countOfInput++;
            }
        }
        return countOfInput;
    }

    private static int[] findIndexesOfReplases(char[] charInput, char[] charTarget, int countOfInput) {

        int[] inputIndexs = new int[countOfInput];
        int mm = 0;
        for (int i = 0; i < charInput.length; i++) {
            boolean greateFlag = true;
            if (charInput[i] == charTarget[0]) {

                boolean flag = true;
                int m = 1;
                for (int k = i + 1; k < i + charTarget.length; k++) {

                    if (k >= charInput.length || charInput[k] != charTarget[m]) {
                        flag = false;
                        greateFlag = false;
                    }
                    if (!flag) {
                        break;
                    }
                    m++;
                }
                if (greateFlag) {
                    inputIndexs[mm++] = i;
                }
            }
        }

        return inputIndexs;
    }

    private static String doReplace(char[] charInput, char[] charTarget, int[] inputIndexs, String replacement) {
        String resultString = "";

        int j = 0;
        for (int index : inputIndexs) {
            for (; j < index; j++)
                resultString += charInput[j];
            resultString += replacement;
            j = index + charTarget.length;
        }

        for (int i = inputIndexs[inputIndexs.length - 1] + charTarget.length; i < charInput.length; i++)
            resultString += charInput[i];
        return resultString;
    }

    public static String replace(String input, String target, String replacement) {
        if (input == null || target == null || replacement == null || target.isEmpty() || input.isEmpty())
            return input;

        char[] charInput = input.toCharArray();
        char[] charTarget = target.toCharArray();

        int countOfInput = countQantytyOfReplases(charInput, charTarget);

        if (countOfInput == 0)
            return input;

        int[] inputIndexs = findIndexesOfReplases(charInput, charTarget, countOfInput);

        return doReplace(charInput, charTarget, inputIndexs, replacement);
    }
}
