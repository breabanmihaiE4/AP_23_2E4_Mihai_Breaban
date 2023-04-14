import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Robot implements Runnable {
    private final String name;
    private boolean isRunning = true;
    ExplorationMap explorationMap;
    SharedMemory sharedMemory;
    int currentRow;
    int currentColumn;
    int n;

    public Robot(String name, ExplorationMap explorationMap, SharedMemory sharedMemory, int startRow, int startColumn, int n) {
        this.name = name;
        this.explorationMap = explorationMap;
        this.sharedMemory = sharedMemory;
        this.currentRow = startRow;
        this.currentColumn = startColumn;
        this.n = n;
        System.out.println("Robot: " + this.name + " started on row: " + this.currentRow + " and column: " + this.currentColumn);
    }

    public void run() {
        while (isRunning) {
            List<List<Integer>> positions = new ArrayList<>(
                    Arrays.asList(
                            Arrays.asList(0, -1), // Left
                            Arrays.asList(-1, 0), // Up
                            Arrays.asList(0, 1), // Right
                            Arrays.asList(1, 0)  // Down
                    )
            );

            Collections.shuffle(positions);

            int row = this.currentRow + positions.get(FIRST).get(ROW);
            int column = this.currentColumn + positions.get(FIRST).get(COLUMN);

            if (row >= 0 && row < this.n && column >= 0 && column < this.n) {
                this.currentRow = row;
                this.currentColumn = column;
                explorationMap.visit(currentRow, currentColumn, this);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getName() {
        return name;
    }

    private static final int FIRST = 0;
    private static final int ROW = 0;
    private static final int COLUMN = 1;

}