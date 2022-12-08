package src.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.Collections.reverse;

public class SignalDetector {

    public static void main(String[] arguments){
        run();
    }

    public static void run(){
        String filename = "src/day6/data.txt";
        BufferedReader reader = null;
        String line = "";
        List<Character> marker = new ArrayList<>();
        Integer count = 0;


        try{
            reader = new BufferedReader(new FileReader(filename));
            while((line = reader.readLine()) != null) {
                char[] letters = line.toCharArray();
                outerloop:
                for (Character letter : letters){
                    if(marker.size()<14){
                        marker.add(letter);
                    } else {
                        for(Character c : marker){
                            Set<Character> setMarker = new HashSet<>(marker);
                            if (setMarker.size() < marker.size()){
                                marker.remove(0);
                                marker.add(letter);
                                break;
                            } else {
                                System.out.println("The Answer is: " + count);
                                break outerloop;
                            }
                        }
                    }
                    count += 1;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
