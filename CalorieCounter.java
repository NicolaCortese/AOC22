import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CalorieCounter {
    public static void main(String[] arguments){
        String filename = "aoc1.txt";
        BufferedReader reader = null;
        String line = "";
        List<String> stringsOfCalories = new ArrayList<>();
        List<Integer> elves = new ArrayList<>();

        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null){
                stringsOfCalories.add(line);
            }

            for(String s:stringsOfCalories){
                Integer calorieCounter = 0;
                if(s==""){
                    elves.add(calorieCounter);
                    calorieCounter = 0;
                } else{
                    Integer calories = Integer.valueOf(s);
                calorieCounter += calories;
                }
            }
            System.out.println(elves);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
