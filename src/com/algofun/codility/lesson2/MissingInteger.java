package com.algofun.codility.lesson2;

import java.util.HashMap;
import java.util.Map;


public class MissingInteger {
    public int solution(int[] A) {
        int N = A.length;
        Map<Integer, Integer> gist = new HashMap<Integer, Integer>();

        for(int a : A){
            if(a >= 1 && !gist.containsKey(a)){
                gist.put(a, 1);
            }
        }

        int result = N+1;

        for(int i=1, M = Integer.MAX_VALUE; i<M; i++){
            if(!gist.containsKey(i)) {
                result = i;
                break;
            }
        }

        return result;
    }
}
