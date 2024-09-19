package com.example;

import java.util.Arrays;

public class SortingApp {
    public static void main(String[] args) {

        if (args.length > 0) {
            try {
                int[] numbers = Arrays.stream(args)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                Arrays.sort(numbers);
                System.out.println("Sorted numbers: " + Arrays.toString(numbers));
            } catch (NumberFormatException e) {
                System.out.println("Error: One or more arguments are not valid integers.");
            }
        } else {
            System.out.println("No numbers provided.");
        }
    }
}

