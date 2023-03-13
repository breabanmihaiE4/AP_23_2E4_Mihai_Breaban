import java.util.*;

public class Main {

    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        if (args.length == 0) {
            System.out.println("No args");
        } else {
            try {
                int n = Integer.parseInt(args[0]);
                int[][] A = new int[n][n];
                adiacencyMatrixCycle(n, A);
                for(int i = 0; i < n ; i++){
                    for (int j = 0; j < n; j++){
                        System.out.println(A[i][j]);
                    }
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Input String cannot be parsed to Integer.");
            }
        }
    }

    public static void adiacencyMatrixCycle(int n, int[][] A){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j - 1){
                    A[i][j] = 1;
                } else {
                    A[i][j] = 0;
                }
            }
        }
        A[n][1] = 1 ;
    }
    public static List<List<Integer>> getLatinSquare(int n) {
        List<List<Integer>> latinMatrix = new ArrayList<>();
        Queue<Integer> line = new LinkedList<Integer>();

        for (int i = 1; i <= n; i++) {
            line.add(i);
        }

        for   (int i = 1; i <= n; i++) {
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
