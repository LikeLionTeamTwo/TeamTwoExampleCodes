package Junho.실습문제.functionalAPI;

import java.util.Arrays;

public class Example02 {
    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 4};
        Arrays.sort(arr, (a,b) -> (a-b));
        System.out.println(Arrays.toString(arr));
    }
}
