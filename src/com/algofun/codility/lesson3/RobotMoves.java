package com.algofun.codility.lesson3;

/**
 * You are given a non-empty, zero-indexed array A of n integers: a0, a1, . . . , an−1
 * such that (0 ¬ ai ¬ 1 000), and integers k and m such that 0 < k, m < n < 100 000.
 * A robot is at position k in array A and should perform m moves. One move moves
 * a robot to an adjacent cell of the array. In every cell, the robot collects the value in the cell
 * and replaces it with 0. The sum is the total of all collected values, and the goal is to calculate
 * the maximum sum that the robot can collect in m moves.
 */
public class RobotMoves {

    public static void main(String... args) {
        RobotMoves rm = new RobotMoves();
        int[] A = {2, 3, 1, 5, 1, 3, 9};


        int r = rm.solution(A, 4, 4);

        boolean b = true;

    }

    public int solution(int[] A, int k, int m) {
        int leftSum = 0;
        int rightSum = 0;
        int N = A.length;

        if (k + m < N) {
            rightSum = prefixSum(A, k, k+m);
        } else {
            int movesRight = (N-1) - k;
            int movesLeft = m - movesRight;
            int leftPos = (N-1)-movesLeft;

            //if(movesRight > 0) leftPos--;
            rightSum = prefixSum(A, leftPos, A.length);
        }

        if (k - m >= 0){
            leftSum = prefixSum(A, k-m, k);
        } else {
            int movesLeft = m - k;
            int movesRight = m - movesLeft;
            int rightPos = 0 + movesRight; //just to explain start index 0 + movesRight = rightPos
            leftSum = prefixSum(A, rightPos + 1);
        }

        return Math.max(leftSum, rightSum);
    }

    public int prefixSum(int[] A, int left, int right) {
        return prefixSum(A, right + 1) - prefixSum(A, left);
    }

    public int prefixSum(int[] A, int index) {
        if (index > A.length)
            index = A.length;

        int sum = 0;

        for (int i = 0; i < index; i++) {
            sum += A[i];
        }
        return sum;
    }
}
