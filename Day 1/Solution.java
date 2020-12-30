import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<Integer> inputs = solution.readInputsFromFile("Input.txt");

        long result = solution.getMultiplication(inputs);

        System.out.println(result);
    }

    private ArrayList readInputsFromFile(String filename) {
        ArrayList<Integer> inputs = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextInt()) inputs.add(sc.nextInt());
        } catch (Exception e) {
            System.out.println(e);
        }
        return inputs;
    }

    private long getMultiplication(ArrayList<Integer> inputs) {
        for(Integer x : inputs) {
            for(Integer y : inputs) {
                for(Integer z : inputs) {
                    if (x+y+z == 2020) return x*y*z;
                }
            }
        }
        return 0;
    }

}