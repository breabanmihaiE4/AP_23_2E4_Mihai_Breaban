import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExplorationMap {
    private final List<Token>[][] matrix;

    public ExplorationMap(int n) {
        matrix = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] =  new ArrayList<>();
            }
        }
    }

    public void visit(int row, int column, Robot robot) {
        System.out.println(this);
        synchronized (matrix[row][column]) {
            if (matrix[row][column].isEmpty()) {
                List<Token> extractedTokens = robot.sharedMemory.extractTokens(matrix.length);
                matrix[row][column] = extractedTokens;
                System.out.println("Cell on row: " + row + " and column: " + column + " received tokens: " + extractedTokens + " from robot: " + robot.getName());
            }
        }
    }

    @Override
    public String toString() {
        String stringMatrix = "";
        for (List<Token>[] cells : matrix) {
            stringMatrix = stringMatrix + Arrays.toString(cells);
        }
        return stringMatrix;
    }
}