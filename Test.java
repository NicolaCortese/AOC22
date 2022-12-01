import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Test {


    public static void main(String[] args) {
        run();
    }


    public static void run() {

        ArrayList<Integer> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("aoc1.txt"))) {
            String line;
            int elfTotal = 0;
            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    list.add(elfTotal);
                    elfTotal = 0;
                } else {
                    elfTotal += Integer.parseInt(line);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        list.sort(Comparator.comparingInt(a -> a));
        System.out.println("Part 1: "+ list.get(list.size()-1));

        int totalCalories = list.get(list.size()-1) + list.get(list.size()-2) + list.get(list.size()-3);

        System.out.println("Part 2: " + totalCalories);

    }




}