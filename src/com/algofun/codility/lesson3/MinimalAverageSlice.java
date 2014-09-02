package com.algofun.codility.lesson3;

public class MinimalAverageSlice {
    public int solution(int[] A) {
        int N = A.length;
        int minIndex = N-2;
        double minAvg = (A[N-1] + A[N-2]) / 2.0;

        for(int i=0; i < N-2; i++){
            int sumTwo = A[i] + A[i+1];
            int sumThree = sumTwo + A[i+2];
            double localAvg2 = sumTwo / 2.0;
            double localAvg3 = sumThree / 3.0;

            double localAvg = Math.min(localAvg2, localAvg3);
            if(minAvg > localAvg){
                minIndex = i;
                minAvg = localAvg;
            } else if (minAvg == localAvg){
                minIndex = Math.min(minIndex, i);
            }
        }

        return minIndex;
    }
}
