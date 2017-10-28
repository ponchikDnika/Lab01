package com.company;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

class Functions {

    private static Integer findAverageLength(String... sourceStrings) {
        Integer totalLength = 0;
        for (String str : sourceStrings)
            totalLength += str.length();
        return totalLength / sourceStrings.length;
    }

    static String[] getStringsLessAverageLength(String... sourceStrings) {
        Integer averageLength = findAverageLength(sourceStrings);
        return Arrays.stream(sourceStrings).filter(s -> s.length() < averageLength).toArray(String[]::new);
    }

    static String[] inputStrings() {
        Scanner scanner = new Scanner(System.in);
        Integer n = inputNumber();
        System.out.println("Введите строки:");
        return IntStream.range(0, n).mapToObj(i -> scanner.nextLine()).toArray(String[]::new);
    }

    private static int inputNumber() {
        Boolean ok = false;
        Pattern numberPattern = Pattern.compile("[1-9]([0-9])*");
        Integer n = 0;
        while (!ok) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество строк:");
            try {
                String s = scanner.next(numberPattern);  // InputMismatchException если не удовлетворяет регулярному выражению
                ok = true;
                n = Integer.valueOf(s);
            } catch (InputMismatchException e) {
                ok = false;
            }
        }
        return n;
    }

    static void showStrings(String... strings) {
        Arrays.stream(strings).map(str -> str + " (" + str.length() + ")").forEach(System.out::println);
    }
}