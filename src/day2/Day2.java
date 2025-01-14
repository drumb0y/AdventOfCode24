package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/day2/day2.txt"));
        //Scanner fileScanner = new Scanner(new File("src/day2/test.txt"));

        int safeCases = 0;

        while(fileScanner.hasNextLine()) {
            String curString = fileScanner.nextLine();
            int[] lineAsInts = lineToInts(curString);
            System.out.println(Arrays.toString(lineAsInts));

            if (isSafeCase(lineAsInts)) safeCases++;

        }

        System.out.println(safeCases + " reports are safe");

    }

    //part one

    public static int[] lineToInts(String line) {
        String[] integersAsStrings = line.split(" ");
        int[] ints = new int[integersAsStrings.length];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(integersAsStrings[i]);
        }

        return ints;
    }

    public static boolean isSafeCase(int[] values) {
        boolean increasing = true;
        int safeLevels = 0;

        if (values[0] > values[1]) increasing = false;

        for (int i = 1; i < values.length; i++) {
            if (values[i-1] == values[i]) return false;

            if(increasing) {
                if (values[i-1] < values[i] && (values[i] - values[i-1]) <= 3) safeLevels++;
                else return false;
            }

            else {
                if (values[i-1] > values[i] && (values[i-1] - values[i]) <= 3) safeLevels++;
                else return false;
            }

        }
        System.out.println("success");
        return true;

    }


}
