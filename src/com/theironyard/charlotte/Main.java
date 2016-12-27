package com.theironyard.charlotte;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static String[][] getFileContents(String fileName) {
        File f = new File(fileName);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[][] conway = new String[100][100];

        for (int i = 0;i < 100;i++) {
            String thisLine = fileScanner.nextLine();
            for (int j = 0;j < 100;j++) {
                conway[i][j] = Character.toString(thisLine.charAt(j));
            }
        }

        return conway;
    }

    private static String[][] deepArrayCopy(String[][] input) {
        String[][] copy = new String[input.length][input.length];

        for (int i = 0;i < input.length;i++) {
            copy[i] = Arrays.copyOf(input[i], input.length);
        }

        return copy;
    }

    private static int getAliveNeighbors(String[][] array, int i, int j) {
        // TODO: implement this
        return 42;
    }

    public static void main(String[] args) throws IOException {
        // TODO: Implement this.

        // note: you should be able to use Arrays.deepEquals to
        // compare these arrays
    }


}
