package com.company;

public class Main {
    public static void main(String[] args) {
        String[] inputStrings = Functions.inputStrings();
        Functions.showStrings(Functions.getStringsLessAverageLength(inputStrings));
    }
}
