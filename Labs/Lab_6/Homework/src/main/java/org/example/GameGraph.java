package org.example;

import java.io.Serializable;
import java.util.Arrays;

public class GameGraph implements Serializable {
    private static final int INVALID_NODE = -1;
    private final int numberOfNodes;
    private final Node[] nodes;

    public GameGraph(int numberOfNodes) {
        this.numberOfNodes = numberOfNodes;
        this.nodes = new Node[numberOfNodes];
        initializeNodes();
    }

    private void initializeNodes() {
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void setNodeCoordinates(int nodeId, int x, int y) {
        this.nodes[nodeId].setCoordinates(x, y);
    }

    public void addLine(int firstNodeId, int secondNodeId) {
        int firstNode = getNodePosition(firstNodeId);
        int secondNode = getNodePosition(secondNodeId);

        if (firstNode != INVALID_NODE && secondNode != INVALID_NODE) {
            Line firstLine = new Line(secondNodeId);
            Line secondLine = new Line(firstNodeId);

            nodes[firstNode].addLine(firstLine);
            nodes[secondNode].addLine(secondLine);
        }
    }

    public int getNodePosition(int nodeId) {
        for (int i = 0; i < numberOfNodes; i++) {
            if (nodes[i].getNodeId() == nodeId) {
                return i;
            }
        }
        return INVALID_NODE;
    }

    public Node getNode(int nodeId) {
        return this.nodes[nodeId];
    }

    public int getNumberOfNodes() {
        return numberOfNodes;
    }

    @Override
    public String toString() {
        return String.format("GameGraph(\n\tnumberOfNodes: %d, \n\tnodes: %s\n)", numberOfNodes, Arrays.toString(nodes));
    }
}
