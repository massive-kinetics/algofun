package com.algofun.different;

public class Permutations {

    public static void main(String[] args){
        permutation("", "ABCD");
    }


    public static void permutation(String prefix, String input) {
        int length = input.length();
        if (length == 0) System.out.println(prefix);
        else {
            for(int i=0; i< length; i++){
                String newPrefix = prefix+input.charAt(i);
                String newInput = input.substring(0, i) + input.substring(i+1);
                permutation(newPrefix, newInput);
            }
        }
    }
}
