package Junho.실습문제.functionalAPI;

import java.util.Arrays;

@FunctionalInterface
interface FunctionalClass{
    int sum(int a, int b);
}

public class Example01 {
    public static void main(String[] args) {
        FunctionalClass functionalClass = (a, b) -> (a + b);
        System.out.println(functionalClass.sum(1,2));


    }
}
