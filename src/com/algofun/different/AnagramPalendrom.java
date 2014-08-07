package com.algofun.different;


public class AnagramPalendrom {
    public static void main(String[] args){
        System.out.println(isAnagramPalendrom("qSONBqqBBNOSq"));

    }

    public static boolean isAnagramPalendrom(String value){
        int size = 'z' - 'A';
        int[] gist = new int[size];
        for(int i = 0; i<value.length(); i++){
            char c = value.charAt(i);
            gist[c - 'A'] += 1;
        }




        int oddCounter = 0;
        for(int count : gist){
            if(count%2 == 0)
                continue;
             oddCounter += 1;

            if(oddCounter > 1)
                return false;
        }

        return true;
    }

}
