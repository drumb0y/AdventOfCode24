package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("src/day1/day1.txt"));

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        while (fileScanner.hasNextInt()) {
            list1.add(fileScanner.nextInt());
            list2.add(fileScanner.nextInt());
        }

        System.out.println(list1);
        System.out.println(list2);

        System.out.println(partOne(list1,list2));
        System.out.println(partTwo(list1,list2));


    }



    public static int partTwo(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        HashMap<Integer, Integer> occurences = new HashMap<>();


        for (int i = 0; i < list2.size(); i++) {
            int item = list2.get(i);
            System.out.println(item + ",");

            if (occurences.containsKey(item)) {
                occurences.put(item, occurences.get(item)+1);
            }
            else {
                occurences.put(item, 1);
            }

        }

        System.out.println(occurences);

        int similarity = 0;

        for (int i = 0; i < list1.size(); i++) {
                int item = list1.get(i);

            System.out.println(item + ",");
                if (occurences.containsKey(item)) {
                    similarity +=  item * occurences.get(item);
                }
                else {
                    similarity += 0;
                }

            }


        return similarity;
        }






    public static int partOne(ArrayList<Integer> list1, ArrayList<Integer> list2) {

        Collections.sort(list1);
        Collections.sort(list2);

        System.out.println(list1);
        System.out.println(list2);


        int totalDist = 0;

        for (int i = 0; i < list1.size(); i++) {
            totalDist += Math.abs(list1.get(i) - list2.get(i));
        }

        return totalDist;

    }
}
