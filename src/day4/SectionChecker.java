package src.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SectionChecker {

    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day4/data.txt";
        BufferedReader reader = null;
        String line = "";
        List<String> elfAssignments = new ArrayList<>();
        Integer counter = 0;

        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null) {
                String firstElf = line.split(",")[0];
                String secondElf = line.split(",")[1];
                Integer firstElfFirstAssignments = Integer.parseInt(firstElf.split("-")[0]);
                Integer firstElfSecondAssignments = Integer.parseInt(firstElf.split("-")[1]);
                Integer secondElfFirstAssignments = Integer.parseInt(secondElf.split("-")[0]);
                Integer secondElfSecondAssignments = Integer.parseInt(secondElf.split("-")[1]);
                if (!(firstElfSecondAssignments<secondElfFirstAssignments || firstElfFirstAssignments>secondElfSecondAssignments)) {
                    counter += 1;
                }
                elfAssignments.clear();
            }
            System.out.println(counter);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
