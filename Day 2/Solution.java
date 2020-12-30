import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        ArrayList<String> inputs = solution.readInputsFromFile("Input.txt");

        int count = 0;
        for (String input : inputs) if (solution.isValidP2(input)) count++;

        System.out.println(count);
    }

    private ArrayList<String> readInputsFromFile(String filename) {
        ArrayList<String> inputs = new ArrayList<>();
        try {
            File inputFile = new File(filename);
            Scanner sc = new Scanner(inputFile);
            while (sc.hasNextLine()) inputs.add(sc.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
        return inputs;
    }

    private boolean isValidP2(String input) {
        String[] parts = input.split(":");
        String condition = parts[0].trim();
        String password = parts[1].trim();

        int pos1 = Integer.parseInt(condition.split(" ")[0].split("-")[0]) - 1;
        int pos2 = Integer.parseInt(condition.split(" ")[0].split("-")[1]) - 1;
        char testChar = condition.split(" ")[1].charAt(0);

        if (password.charAt(pos1) != testChar && password.charAt(pos2) != testChar) return false;
        if (password.charAt(pos1) == testChar && password.charAt(pos2) != testChar) return true;
        if (password.charAt(pos1) != testChar && password.charAt(pos2) == testChar) return true;
        if (password.charAt(pos1) == testChar && password.charAt(pos2) == testChar) return false;

        return false;
    }

    private boolean isValidP1(String input) {
        String[] parts = input.split(":");
        String condition = parts[0].trim();
        String password = parts[1].trim();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            Integer count = map.get(c);
            if (count == null) count = 1;
            else count++;
            map.put(c, count);
        }

        int minLimit = Integer.parseInt(condition.split(" ")[0].split("-")[0]);
        int maxLimit = Integer.parseInt(condition.split(" ")[0].split("-")[1]);
        char testChar = condition.split(" ")[1].charAt(0);

        Integer resultCount = map.get(testChar);
        if (resultCount == null) resultCount = 0;

        return resultCount <= maxLimit && resultCount >= minLimit;
    }

}