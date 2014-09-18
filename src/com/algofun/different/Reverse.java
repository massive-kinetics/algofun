package com.algofun.different;

import java.util.Arrays;

public class Reverse {

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        System.out.println("Reverse for 1 2 3 4 5 is " + Arrays.toString(reverse(ar)));
    }

    public static String reverse(String input) {
        return new String(reverse(input.toCharArray()));
    }


    public static char[] reverse(char[] input) {
        int mid = input.length / 2;
        for (int i = 0, j = input.length - 1; i < mid; i++, j--) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        return input;
    }

    public static int[] reverse(int[] input) {
        int mid = input.length / 2;
        for (int i = 0, j = input.length - 1; i < mid; i++, j--) {
            int temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
        return input;
    }
}
