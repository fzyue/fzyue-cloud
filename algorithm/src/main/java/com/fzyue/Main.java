package com.fzyue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        float f = 2.4F;
        short s1 = 1;
        s1 = (short) (s1 + 1);
        s1 += 1;

        int i = 1;
        i = i++;
        System.out.println(i);
        int k = 1;
        k = k+1;
        System.out.println(k);

        int j = 1;
        j = ++j;
        System.out.println(j);

    }
}