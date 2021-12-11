/*THIS CODE WAS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES. Diego Bobrow*/
import java.util.*;

public class Question2 {

    public char[] stringToArray(String s) {
        char[] array = new char[s.length()];
        for (int i = 0; i < array.length; i++) {
            array[i] = s.charAt(i);
        }
        return array;
    }

    public List<String> removeInvalidParentheses(String s) {
        char[] arrayChar = stringToArray(s);
        int leftParenthesis = 0;
        int rightParenthesis = 0;

        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == '(') {
                leftParenthesis++;
            }
            if (leftParenthesis == 0) {
                if (arrayChar[i] == ')') {
                    rightParenthesis++;
                }
            } else if (leftParenthesis != 0) {
                if (arrayChar[i] == ')') {
                    leftParenthesis--;
                }
            }
        }

        List<String> result = new ArrayList<>();
        fixString(s, 0, leftParenthesis, rightParenthesis, result);
        return result;
    }

    private boolean checkValid(String s) {
        int num = 0;
        char[] arrayChar = stringToArray(s);
        for (int i = 0; i < arrayChar.length; i++) {
            if (arrayChar[i] == '(') {
                num++;
            } else if (arrayChar[i] == ')') {
                num--;
            }
            if (num < 0) return false;
        }
        return num == 0;
    }

    private void fixString(String s, int begin, int remainingLeft, int remainingRight, List<String> result) {
        if (remainingLeft == 0 && remainingRight == 0) {
            if (checkValid(s)) {
                result.add(s);
                return;
            }
        }

        for (int i = begin; i < s.length(); i++) {
            if (i != begin && s.charAt(i) == s.charAt(i - 1)){
                continue;
            }

            char character = s.charAt(i);
            if (character == '(' || character == ')') {
                String temp = s.substring(0, i) + s.substring(i + 1);
                if (remainingRight > 0 && s.charAt(i) == ')') {
                    fixString(temp, i, remainingLeft, remainingRight - 1, result);
                } else if (remainingLeft > 0 && s.charAt(i) == '(') {
                    fixString(temp, i, remainingLeft - 1, remainingRight, result);
                }
            }
        }
    }
}