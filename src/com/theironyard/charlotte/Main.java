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

    private static void saveToFile(String[][] contents, String fileName) {
        try {
            FileWriter fw = new FileWriter(new File(fileName));

            for (String[] line : contents) {
                for (String s : line) {
                    fw.write(s);
                }

                fw.write("\n");
            }


            fw.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String[][] deepArrayCopy(String[][] input) {
        String[][] copy = new String[input.length][input.length];

        for (int i = 0;i < input.length;i++) {
            copy[i] = Arrays.copyOf(input[i], input.length);
        }

        return copy;
    }

    private static int getAliveNeighbors(String[][] array, int i, int j) {
        int count = 0;

        if (i > 0 && j > 0 && array[i - 1][j - 1].equals("1")) {
            count++;
        }

        if (i > 0 && array[i - 1][j].equals("1")) {
            count++;
        }

        if (i > 0 && j < array.length - 1 && array[i - 1][j + 1].equals("1")) {
            count++;
        }


        if (j > 0 && array[i][j - 1].equals("1")) {
            count++;
        }

        if (j < array.length - 1 && array[i][j + 1].equals("1")) {
            count++;
        }

        if (i < array.length - 1 && j > 0 && array[i + 1][j - 1].equals("1")) {
            count++;
        }

        if (i < array.length - 1 && array[i + 1][j].equals("1")) {
            count++;
        }

        if (i < array.length - 1 && j < array.length - 1 && array[i + 1][j + 1].equals('1')) {
            count++;
        }

        return count;
    }

    private static String[][] conway(String[][] original) {
        String[][] copy = deepArrayCopy(original);

        for (int i = 0;i < copy.length;i++) {
            for (int j = 0; j < copy.length;j++) {
                if (copy[i][j].equals("1")) {
                    switch(getAliveNeighbors(original, i, j)) {
                        case 0:
                        case 1:
                            copy[i][j] = "0";
                            break;
                        case 2:
                        case 3:
                            break;
                        default:
                            copy[i][j] = "0";
                            break;
                    }
                } else {
                    if (getAliveNeighbors(original, i, j) == 3) {
                        copy[i][j] = "1";
                    }
                }
            }
        }

        return copy;
    }

    public static void main(String[] args) throws IOException {
        // TODO: Implement this.
        String[][] original = getFileContents("input.txt");

        for (int i = 0;i < 1000;i++) {
           original = conway(original);
        }


        System.out.println(Arrays.deepEquals(original, getFileContents("output.txt")));
//        saveToFile(original, "output.txt");
    }
}
