package org.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private final int nodeId;
    private int x;
    private int y;
    private final List<Line> lines = new ArrayList<>();

    public Node(int nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeId() {
        return nodeId;
    }
    public List<Line> getLines() {
        return lines;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return String.format("\n\t\tNode(\n\t\t\tnodeID = %d, \n\t\t\tlines: %s\n\t\t)", nodeId, lines);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
