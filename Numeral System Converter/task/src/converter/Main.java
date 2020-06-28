package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String initialBase = sc.next();
            String number = sc.next().toLowerCase();
            String[] numb = number.split("[.]");
            String finalBase = sc.next();
            if (Integer.parseInt(initialBase) < 1 || Integer.parseInt(initialBase) > 36) {
                System.out.println("Error: invalid source radix");
            } else if (Integer.parseInt(finalBase) < 1 || Integer.parseInt(finalBase) > 36) {
                System.out.println("Error: invalid target radix");
            } else if (initialBase.equals("1")) {
                System.out.print(fromUnoToFinal(numb[0], finalBase) + " ");
            } else if (finalBase.equals("1")) {
                System.out.println(fromFinalToUno(initialBase, numb[0]));
            } else if (numb.length == 1) {
                System.out.print(fromInitialToFinalInt(initialBase, numb[0], finalBase) + ".");
            } else {
                System.out.print(fromInitialToFinalInt(initialBase, numb[0], finalBase) + ".");
                String fr = convertFractionalPartIntoDecimal(Integer.parseInt(initialBase), numb[1]);
                System.out.println(convertFractionalPartIntoNewBase(fr, Integer.parseInt(finalBase)));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String fromUnoToFinal(String number, String finalBase) {
        int intPart = number.length();
        int count = 0;
        for (int i = 0; i < intPart; ) {
            intPart--;
            count++;
        }
        return Integer.toString(count, Integer.parseInt(finalBase));
    }

    private static String fromFinalToUno(String initialBase, String number) {
        StringBuilder s = new StringBuilder();
        int num = Integer.parseInt(number, Integer.parseInt(initialBase));
        while (num > 0) {
            s.append("1");
            num--;
        }
        return s.toString();
    }

    private static String fromInitialToFinalInt(String initialBase, String intPart, String finalBase) {
        int decimal = Integer.parseInt(intPart, Integer.parseInt(initialBase));
        return Integer.toString(decimal, Integer.parseInt(finalBase));
    }

    private static String convertFractionalPartIntoDecimal(int sourceRadix, String fractionalPart) {
        int[] digits = parseStringInDigitArray(fractionalPart);
        double decimalValue = 0;
        for (int i = 0; i < digits.length; i++) {
            decimalValue += digits[i] / Math.pow(sourceRadix, i + 1);
        }
        return Double.toString(decimalValue).split("[.,]")[1].trim();
    }

    private static int[] parseStringInDigitArray(String data) {
        char[] literals = data.toCharArray();
        int[] digits = new int[literals.length];
        for (int i = 0; i < literals.length; i++) {
            if (Character.isDigit(literals[i])) {
                digits[i] = Character.digit(literals[i], 10);
            } else {
                digits[i] = 10 + literals[i] - 'a';
            }
        }
        return digits;
    }

    private static String convertFractionalPartIntoNewBase(String number, int newBase) {
        StringBuilder newBaseValue = new StringBuilder();
        int accuracy = 5;
        String decimalValue = "0." + number;
        for (int i = 0; i < accuracy; i++) {
            double value = Double.parseDouble(decimalValue);
            int num = (int) (value * newBase);
            if (num > 9) {
                newBaseValue.append((char) ('a' + num - 10));
            } else {
                newBaseValue.append(num);
            }
            decimalValue = Double.toString(value * newBase - num);
        }
        return newBaseValue.toString();
    }

}

