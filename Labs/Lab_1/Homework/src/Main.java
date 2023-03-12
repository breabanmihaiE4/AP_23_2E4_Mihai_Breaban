import java.util.*;

public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        if (args.length == 0) {
            System.out.println("No args");
        } else {
            try {
                int n = Integer.parseInt(args[0]);
                List<List<Integer>> latinMatrix = getLatinSquare(n);
                if(n > 30000) {
                    System.out.println(System.currentTimeMillis() - startTime);
                } else {
                    printLatinSquare(latinMatrix, n);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }
        }
    }

    public static List<List<Integer>> getLatinSquare(int n) {
        List<List<Integer>> latinMatrix = new ArrayList<>();
        Queue<Integer> line = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            line.add(i);
        }

        for (int i = 1; i <= n; i++) {
            latinMatrix.add(new ArrayList<>(line));
            int auxiliary = line.poll();
            line.add(auxiliary);
        }
        return latinMatrix;
    }

    public static void printLatinSquare(List<List<Integer>> latinMatrix, int n) {
        for(int i = 0; i < n; i++) {
            String line = "";
            String column = "";
            for(int j = 0; j < n; j++) {
                line = line + latinMatrix.get(i).get(j).toString();
                column = column + latinMatrix.get(j).get(i).toString();
            }
            System.out.println(line);
            System.out.println(column);
        }
    }
}
