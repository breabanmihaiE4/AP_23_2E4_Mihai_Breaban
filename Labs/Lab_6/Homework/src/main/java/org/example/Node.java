package org.example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int nodeId;
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

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return String.format("\n\t\tNode(\n\t\t\tnodeID = %d, \n\t\t\tlines: %s\n\t\t)", nodeId, lines);
    }
}
