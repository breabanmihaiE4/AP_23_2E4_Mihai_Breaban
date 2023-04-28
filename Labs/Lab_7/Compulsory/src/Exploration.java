import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exploration {
    private final List<Robot> robots = new ArrayList<>();

    public void start() {
        List<Thread> threads = new ArrayList<>();

        for (Robot robot : robots) {
            threads.add(new Thread(robot));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        var exploration = new Exploration();

        SharedMemory sharedMemory = new SharedMemory(SIZE);
        ExplorationMap explorationMap = new ExplorationMap(SIZE);

        List<Integer> allPositions = new ArrayList<>();

        for (int i = 0; i < SIZE; i++) {
            allPositions.add(i);
            allPositions.add(i);
        }
        Collections.shuffle(allPositions);

        exploration.robots.add(new Robot("Wall-E", explorationMap, sharedMemory, allPositions.get(0), allPositions.get(1), SIZE));
        exploration.robots.add(new Robot("R2D2", explorationMap, sharedMemory,  allPositions.get(2), allPositions.get(3), SIZE));
        exploration.robots.add(new Robot("Optimus Prime", explorationMap, sharedMemory,  allPositions.get(4), allPositions.get(5), SIZE));


        exploration.start();

        
        // comanda de stop/start pt robotul X???
    }

    private static final int SIZE = 4;
}