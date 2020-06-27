package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimal = 50;//sc.nextInt();
        String s = "";
        System.out.print(decimal + " = 0b");
        for (; 1 < decimal; ) {
            int div = decimal % 2;
            decimal = decimal / 2;
            s += Integer.toString(div);
            if (decimal == 1) {
                s += Integer.toString(decimal);
            }

        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[array.length - 1 - i]);
        }

    }
}
