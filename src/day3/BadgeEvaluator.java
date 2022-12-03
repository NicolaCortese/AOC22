package src.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BadgeEvaluator {

    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day3/data.txt";
        BufferedReader reader = null;
        String line = "";
        List<Character> listOfItems = new ArrayList<>();
        List<String> groupsOfElves = new ArrayList<>();
        List<List<String>> allGroups = new ArrayList<>();
        Integer counter = 0;
        Integer score = 0;

        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null) {
                groupsOfElves.add(line);
                counter += 1;
                if (counter % 3 == 0) {
                    System.out.println(Arrays.toString(List.of(groupsOfElves).toArray()));
                    String firstElf = groupsOfElves.get(0);
                    String secondElf = groupsOfElves.get(1);
                    String thirdElf = groupsOfElves.get(2);
                    char[] firstElfItems = firstElf.toCharArray();
                    for (char c : firstElfItems){
                        if (secondElf.contains(String.valueOf(c))&&thirdElf.contains(String.valueOf(c))){
                            listOfItems.add(c);
                            break;
                        }
                    }
                    groupsOfElves.clear();
                }
            }
            System.out.println(Arrays.toString(List.of(listOfItems).toArray()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Character c : listOfItems){
            Integer i = Integer.valueOf(c);
            System.out.println(c);
            System.out.println((i));
            if(i<91) {
                System.out.println((i-38));
                score += i - 38;
            } else {
                System.out.println((i-96));
                score += i - 96;
            }
        }
        System.out.println(score);
    }
}


//                String[] parts = {line.substring(0, mid),line.substring(mid)};
//                char[] first = parts[0].toCharArray();
//                char[] second = parts[1].toCharArray();
//                for (char c:first){
//                    if(parts[1].contains(String.valueOf(c))){
//                        listOfItems.add(c);
//                        break;
//                    }

//            for (Character c : listOfItems){
//                Integer i = Integer.valueOf(c);
//                System.out.println(c);
//                System.out.println((i));
//                if(i<91) {
//                    System.out.println((i-38));
//                    score += i - 38;
//                } else {
//                    System.out.println((i-96));
//                    score += i - 96;
//                }
//            }
//                System.out.println(score);


