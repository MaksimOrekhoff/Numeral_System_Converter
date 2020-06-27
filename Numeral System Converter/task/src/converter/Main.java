package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     /*   Scanner sc = new Scanner(System.in);
       int decimal = sc.nextInt();
        String s = "";
        //System.out.print(decimal + " = 0b");
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
        */
        Scanner sc = new Scanner(System.in);
        int decimal = sc.nextInt();
        String s = "";
        int div = decimal % 8;
        if (div == 0) {
            s = "0";
        } else {
            for (; 0 < div; ) {
                if (div == 1) {
                    s += Integer.toString(div);
                    break;
                }
                int b = div % 8;
                div = div / 8;
                s += Integer.toString(b);
           }
        }
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[array.length - 1 - i]);
        }
    }
}
