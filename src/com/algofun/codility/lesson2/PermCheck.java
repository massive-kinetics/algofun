package com.algofun.codility.lesson2;

/**
 * A non-empty zero-indexed array A consisting of N integers is given.
 * A permutation is a sequence containing each element from 1 to N once, and only once.
 * For example, array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * A[3] = 2
 * is a permutation, but array A such that:
 * A[0] = 4
 * A[1] = 1
 * A[2] = 3
 * is not a permutation.
 * The goal is to check whether array A is a permutation.
 */

public class PermCheck {

    public int solution(int[] A) {
        int counter = 0;
        int N = A.length;
        int[] gist = new int[N + 1];

        for (int a : A) {
            if (a > N)
                return 0;

            gist[a]++;
            if (gist[a] > 1)
                return 0;

            counter++;
        }

        if (counter == N)
            return 1;

        return 0;
    }

}
