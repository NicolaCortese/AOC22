package src.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

import static java.util.Collections.reverse;

public class Crane {

    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day5/data.txt";
        BufferedReader reader = null;
        String line = "";


        //Manually Instantiating the Stacks
        Stack<String> stackOne = new Stack<>();
        Stack<String> stackTwo = new Stack<>();
        Stack<String> stackThree = new Stack<>();
        Stack<String> stackFour = new Stack<>();
        Stack<String> stackFive = new Stack<>();
        Stack<String> stackSix = new Stack<>();
        Stack<String> stackSeven = new Stack<>();
        Stack<String> stackEight = new Stack<>();
        Stack<String> stackNine = new Stack<>();

        stackOne.push("S");
        stackOne.push("L");
        stackOne.push("F");
        stackOne.push("Z");
        stackOne.push("D");
        stackOne.push("B");
        stackOne.push("R");
        stackOne.push("H");

        stackTwo.push("R");
        stackTwo.push("Z");
        stackTwo.push("M");
        stackTwo.push("B");
        stackTwo.push("T");

        stackThree.push("S");
        stackThree.push("N");
        stackThree.push("H");
        stackThree.push("C");
        stackThree.push("L");
        stackThree.push("Z");

        stackFour.push("J");
        stackFour.push("F");
        stackFour.push("C");
        stackFour.push("S");

        stackFive.push("B");
        stackFive.push("Z");
        stackFive.push("R");
        stackFive.push("W");
        stackFive.push("H");
        stackFive.push("G");
        stackFive.push("P");

        stackSix.push("T");
        stackSix.push("M");
        stackSix.push("N");
        stackSix.push("D");
        stackSix.push("G");
        stackSix.push("Z");
        stackSix.push("J");
        stackSix.push("V");

        stackSeven.push("Q");
        stackSeven.push("P");
        stackSeven.push("S");
        stackSeven.push("F");
        stackSeven.push("W");
        stackSeven.push("N");
        stackSeven.push("L");
        stackSeven.push("G");

        stackEight.push("R");
        stackEight.push("Z");
        stackEight.push("M");

        stackNine.push("T");
        stackNine.push("R");
        stackNine.push("V");
        stackNine.push("G");
        stackNine.push("L");
        stackNine.push("C");
        stackNine.push("M");

        HashMap<Integer,Stack> allStacks = new HashMap<>();
        allStacks.put(1, stackOne);
        allStacks.put(2, stackTwo);
        allStacks.put(3, stackThree);
        allStacks.put(4, stackFour);
        allStacks.put(5, stackFive);
        allStacks.put(6, stackSix);
        allStacks.put(7, stackSeven);
        allStacks.put(8, stackEight);
        allStacks.put(9, stackNine);

        reverse(stackOne);
        reverse(stackTwo);
        reverse(stackThree);
        reverse(stackFour);
        reverse(stackFive);
        reverse(stackSix);
        reverse(stackSeven);
        reverse(stackEight);
        reverse(stackNine);


        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null) {
                String[] lines = line.split(" ");
                Integer numberOfCratesToBeMoved = Integer.valueOf(lines[1]);
                Integer stackFromWhichWePickUpCrate = Integer.valueOf(lines[3]);
                Integer stackWhereWePlaceCrate = Integer.valueOf(lines[5]);

                for (int i = 0; i < numberOfCratesToBeMoved; i++){
                    String crateInTransit = allStacks.get(stackFromWhichWePickUpCrate).pop().toString();
                    allStacks.get(stackWhereWePlaceCrate).push(crateInTransit);
                }
            }
            StringBuilder result = new StringBuilder();
            for (Stack stack : allStacks.values()){
                result.append(stack.pop().toString());
            }
            System.out.println(result);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
