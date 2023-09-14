package com.github.confuzzedcat.Ex2;

import java.util.Arrays;

public class Main {
    @FunctionalInterface
    interface MyTransformingType{
        int transform(int value);
    }

    interface MyValidatingType{
        boolean validate(int value);
    }

    public static void main(String[] args) {
        int[] intArry = {1,2,3,4,5,6};
        int[] resultArry = map(intArry, x -> x * 4);
        System.out.println(Arrays.toString(resultArry));

        int[] even = filter(intArry, x -> x%2 == 0);
        System.out.println(Arrays.toString(even));

    }

    static int[] map(int[] a, MyTransformingType op){
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = op.transform(a[i]);
        }
        return result;
    }
    static int[] filter(int[] a, MyValidatingType ex){
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if(ex.validate(a[i])){
                count++;
            }
        }
        int[] result = new int[count];
        int counter = 0;
        for (int i = 0; i < a.length; i++) {
            if(ex.validate(a[i])){
                result[counter] = a[i];
                counter++;
            }
        }
        return result;
    }
}
