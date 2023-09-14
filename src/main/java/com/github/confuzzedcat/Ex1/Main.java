package com.github.confuzzedcat.Ex1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    @FunctionalInterface
    interface ArithmeticOperation{
        float perform(float a, float b);
    }
    @FunctionalInterface
    interface ArithmeticIntOperation{
        int perform(int a, int b);
    }

    public static void main(String[] args) {
        System.out.println("Functional Ex1");

        ArithmeticOperation addition = (a, b) -> a + b;
        ArithmeticOperation subtraction = (a, b) -> a - b;
        ArithmeticOperation multiplication = (a, b) -> a * b;
        ArithmeticOperation division = (a, b) -> a / b;
        ArithmeticOperation modulus = (a, b) -> a % b;
        ArithmeticOperation power = (a, b) -> (int)a ^ (int)b;

        System.out.println("add 5 + 6: " + addition.perform(5,6));
        System.out.println("minus 5 - 6: " + subtraction.perform(5,6));
        System.out.println("multiply 5 * 6: " + multiplication.perform(5,6));
        System.out.println("divide 5 / 6: " + division.perform(5,6));
        System.out.println("modulus 5 % 6: " + modulus.perform(5,6));
        System.out.println("power 5 ^ 6: " + power.perform(5,6));
        System.out.println("operate 22 ad 8: " + operate(22,8, addition));

        float[] firstFloatArray =   {1.2f,2.3f,53f,3.1f,12f     };
        float[] secondFloatArray =  {6.1f,3.3f,13f,19.1f,121.1f };

        printArray(operate(firstFloatArray, secondFloatArray, addition));


    }

    static float operate(float a, float b, ArithmeticOperation op){
        return op.perform(a,b);
    }

    static float[] operate(float[] a, float[] b, ArithmeticOperation op){
        if(a.length != b.length){
            throw new IllegalArgumentException("the two arrays didn't have same amount of elements.");
        }
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++){
            result[i] = op.perform(a[i], b[i]);
        }
        return result;
    }

    static void printArray(float[] array){
        System.out.println(Arrays.toString(array));
    }
}
