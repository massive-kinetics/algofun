package com.algofun.codility.lesson2;

public class FrogRiverOne2 {

    public static void main(String[] args){
        int X = 5;
        int[] A = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(X, A));
    }

        public static int solution(int X, int[] timeToPosition) {
            // write your code in Java SE 8
            int N = timeToPosition.length;

            int[] positionToTimeGist = new int[X+1];
            for(int i=0;i<X+1;i++){
                positionToTimeGist[i]=-1;
            }

            //A is function A[time] = position
            for(int time=0; time<N; time++){
                int pos = timeToPosition[time];


                if(pos <= X && (positionToTimeGist[pos] == -1 || positionToTimeGist[pos] > time))
                    positionToTimeGist[pos] = time;
            }

            int timeForPosition = positionToTimeGist[X];
            if(timeForPosition != -1) {
                for (int i = X; i >= 0; i--) {
                    if (timeForPosition < positionToTimeGist[i])
                        timeForPosition = positionToTimeGist[i];
                }
            }

            return timeForPosition;
        }
}
