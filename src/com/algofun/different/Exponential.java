package com.algofun.different;

public class Exponential {
    //http://www.programminglogic.com/fast-exponentiation-algorithms/

    public static void main(String[] args) {
        System.out.println("System      16^-2=" + Math.pow(16, -2));
        System.out.println("Obvious     16^-2=" + exponentialObvious(16, -2));
        System.out.println("Squaring    16^-2=" + expBySquaring(16, -2));
        System.out.println("SquaringOpt 16^-2=" + expBySquaringOptimized(16, -2));
    }

    static double exponentialObvious(double base, int exponent) {
        double result = 1;

        if (exponent < 0) {
            base = 1 / base;
            exponent = -exponent;
        }

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }

    static double expBySquaring(double base, int exponent) {
        if (exponent < 0) {
            return expBySquaring(1 / base, -exponent);
        } else if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else if (exponent % 2 == 0) {
            return expBySquaring(base * base, exponent / 2);
        } else {
            return base * expBySquaring(base * base, (exponent - 1) / 2);
        }
    }

    static double expBySquaringOptimized(double base, int exponent) {
        if (exponent < 0) {
            return expBySquaringOptimized(1 / base, -exponent);
        }

        double result = 1;

        while (exponent > 0) {
            if (exponent % 2 == 1)
                result *= base;
            exponent /= 2;
            base *= base;
        }

        return result;
    }

}
