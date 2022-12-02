package src.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ElfCalorieCounter {


    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day1/data.txt";
        BufferedReader reader = null;
        String line = "";
        List<String> stringsOfCalories = new ArrayList<>();
        List<Integer> elves = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null){
                stringsOfCalories.add(line);
            }

            Integer calorieCounter = 0;
            for(String s:stringsOfCalories){
                if(s.isBlank()){
                    elves.add(calorieCounter);
                    calorieCounter = 0;
                } else{
                    Integer calories = Integer.valueOf(s);
                    calorieCounter += calories;
                }
            }
            System.out.println(elves);
            Collections.sort(elves);
            Collections.reverse(elves);
            System.out.println(elves);
            Integer loadedElf = elves.get(0);
            System.out.println("First Answer: " + loadedElf);
            Integer loadedElves = loadedElf + elves.get(1) + elves.get(2);
            System.out.println("Second Answer: " + loadedElves);

        }catch(Exception e){
            e.printStackTrace();
        }

    }



}
