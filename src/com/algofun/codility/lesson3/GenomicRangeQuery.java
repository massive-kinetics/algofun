package com.algofun.codility.lesson3;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int N = S.length();
        int[][] genom = new int[3][N + 1];

        short a, c, g;
        for (int i = 1; i <= N; i++) {
            a = c = g = 0;
            char curr = S.charAt(i - 1);

            if (curr == 'A') a = 1;
            else if (curr == 'C') c = 1;
            else if (curr == 'G') g = 1;

            genom[0][i] = genom[0][i - 1] + a;
            genom[1][i] = genom[1][i - 1] + c;
            genom[2][i] = genom[2][i - 1] + g;
        }

        final int M = P.length;
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            //to find out if genome appeared we should check end state and state before start
            //for example start = end = 4; we should check 3rd and 4th positions difference
            int startIndex = P[i];
            int endIndex = Q[i] + 1;

            if (genom[0][endIndex] - genom[0][startIndex] > 0)
                result[i] = 1;

            else if (genom[1][endIndex] - genom[1][startIndex] > 0)
                result[i] = 2;

            else if (genom[2][endIndex] - genom[2][startIndex] > 0)
                result[i] = 3;

            else
                result[i] = 4;

        }

        return result;

    }
}

