package com.algofun.codility.lesson2;

import java.util.Arrays;

public class MaxCounters {
    int currentMaxCounter;
    int[] counters;

    boolean previousMaxCounter;

    public int[] solution(int N, int[] A) {
        currentMaxCounter = 0;
        counters = new int[N];

        for (int a : A) {
            if (isIncrease(a, N))
                increase(a - 1);
            else if (isMaxCounter(a, N))
                maxCounter();
        }

        return counters;
    }

    public boolean isIncrease(int val, int N) {
        if (1 <= val && val <= N) return true;
        return false;
    }

    public boolean isMaxCounter(int val, int N) {
        if (val == N + 1) return true;
        return false;
    }

    public void increase(int index) {
        previousMaxCounter = false;

        counters[index]++;
        if (counters[index] > currentMaxCounter) currentMaxCounter = counters[index];
    }

    public void maxCounter() {
        if (!previousMaxCounter) {
            Arrays.fill(counters, currentMaxCounter);
            previousMaxCounter = true;
        }
    }
}