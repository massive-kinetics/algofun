package com.algofun.codility.lesson2;

public class FrogRiverOne2 {


    /**
     * A small frog wants to get to the other side of a river. The frog is currently located at position 0, and wants to get to position X. Leaves fall from a tree onto the surface of the river.
     You are given a non-empty zero-indexed array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in minutes.
     The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X.
     For example, you are given integer X = 5 and array A such that:
     A[0] = 1
     A[1] = 3
     A[2] = 1
     A[3] = 4
     A[4] = 2
     A[5] = 3
     A[6] = 5
     A[7] = 4
     In minute 6, a leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.
     Write a function:
     class Solution { public int solution(int X, int[] A); }
     that, given a non-empty zero-indexed array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.
     If the frog is never able to jump to the other side of the river, the function should return −1.
     * */

    public static void main(String[] args){
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(X, A));
    }

    public static int solution(int X, int[] A) {
        int N = A.length;
        int sum = 0;
        int[] B = new int[X];

        int index = -1;

        for(int i=0; i<N; i++){
            int currPos = A[i] - 1;

            if( (currPos < X) && (B[currPos] == 0) ){
                B[currPos] = 1;
                sum++;
            }

            if(sum == X) {
                index = i;
                break;
            }
        }

        return index;
    }
}
