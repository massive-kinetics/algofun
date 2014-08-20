package com.algofun.codility.lesson3;

/**
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 Array A contains only 0s and/or 1s:
 0 represents a car traveling east,
 1 represents a car traveling west.
 The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 For example, consider array A such that:
 A[0] = 0
 A[1] = 1
 A[2] = 0
 A[3] = 1
 A[4] = 1
 We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 Write a function:
 class Solution { public int solution(int[] A); }
 that, given a non-empty zero-indexed array A of N integers, returns the number of passing cars.
 The function should return −1 if the number of passing cars exceeds 1,000,000,000.
 For example, given:
 A[0] = 0
 A[1] = 1
 A[2] = 0
 A[3] = 1
 A[4] = 1
 the function should return 5, as explained above.
 * */

 public class CountingCars {

    public static void main(String[] args) {
        CountingCars cc = new CountingCars();
        int[] cars = {0, 1, 0, 1, 1};
        int expected = 5;
        assert (expected == cc.solution(cars));
    }

    public int solution(int[] A) {
        final int N = A.length;
        int arraySum = sum(A);

        int passingCars = 0;
        for (int i = 0; i < N; i++) {
            int e = A[i];
            arraySum -= e;
            if (e == 1)
                continue;
            passingCars += arraySum;
            if (passingCars > 1000000000)
                return -1;
        }

        return passingCars;
    }

    private int sum(int[] A) {
        int sum = 0;
        for (int a : A) sum += a;
        return sum;
    }

}
