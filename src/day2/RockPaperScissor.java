package src.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class RockPaperScissor {

    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day2/data.txt";
        BufferedReader reader = null;
        String line = "";

        HashMap<String, Integer> scoreForSelection = new HashMap<>();
        scoreForSelection.put("X", 1);
        scoreForSelection.put("Y", 2);
        scoreForSelection.put("Z", 3);

        HashMap<String, Integer> scoreForResult = new HashMap<>();
        scoreForResult.put("X", 0);
        scoreForResult.put("Y", 3);
        scoreForResult.put("Z", 6);

        HashMap<String, Integer> scoreForHand = new HashMap<>();
        scoreForHand.put("A X", 3);
        scoreForHand.put("A Y", 6);
        scoreForHand.put("A Z", 0);
        scoreForHand.put("B X", 0);
        scoreForHand.put("B Y", 3);
        scoreForHand.put("B Z", 6);
        scoreForHand.put("C X", 6);
        scoreForHand.put("C Y", 0);
        scoreForHand.put("C Z", 3);

        HashMap<String, Integer> scoreForSecondHand = new HashMap<>();
        scoreForSecondHand.put("A X", 3);
        scoreForSecondHand.put("A Y", 1);
        scoreForSecondHand.put("A Z", 2);
        scoreForSecondHand.put("B X", 1);
        scoreForSecondHand.put("B Y", 2);
        scoreForSecondHand.put("B Z", 3);
        scoreForSecondHand.put("C X", 2);
        scoreForSecondHand.put("C Y", 3);
        scoreForSecondHand.put("C Z", 1);

        System.out.println(scoreForSecondHand.get("A X"));
        try{
            reader = new BufferedReader(new FileReader(filename));
            Integer scoreCount = 0;
            Integer scoreCountTwo = 0;
            while((line = reader.readLine()) != null){
                System.out.println(line);
                scoreCount += scoreForSecondHand.get(line) + scoreForSelection.get(String.valueOf(line.charAt(2)));
                scoreCountTwo += scoreForSecondHand.get(line) + scoreForResult.get(String.valueOf(line.charAt(2)));
            }
            System.out.println("Part 1: " + scoreCount);
            System.out.println("Part 2: " + scoreCountTwo);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
