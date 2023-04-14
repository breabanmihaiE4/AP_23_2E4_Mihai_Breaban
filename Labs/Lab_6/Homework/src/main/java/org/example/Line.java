package org.example;

public class Line {

    private LineColor lineColor = LineColor.NO_COLOR;
    private int destinationNodeId;

    public Line(int destinationNodeId) {
        this.destinationNodeId = destinationNodeId;
    }

    public LineColor getLineColor() {
        return lineColor;
    }

    public void setLineColor(LineColor lineColor) {
        this.lineColor = lineColor;
    }

    public int getDestinationNodeId() {
        return destinationNodeId;
    }

    public void setDestinationNodeId(int destinationNodeId) {
        this.destinationNodeId = destinationNodeId;
    }

    @Override
    public String toString() {
        return String.format("\n\t\t\t\tLine(\n\t\t\t\t\tcolor: %s, \n\t\t\t\t\tnodeId: %d\n\t\t\t\t)", lineColor, destinationNodeId);
    }
}
