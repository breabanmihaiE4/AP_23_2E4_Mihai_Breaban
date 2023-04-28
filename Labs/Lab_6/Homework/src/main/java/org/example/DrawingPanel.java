package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    private int numVertices;
    private double edgeProbability;
    private int[] x, y;
    List<Boolean> results = new ArrayList<>(Collections.nCopies(10, false));
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image

    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO...
                repaint();
            }
        });
    }

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, W, H);
        graphics.setColor(Color.BLACK);
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createOffscreenImage();
        createVertices();
        drawLines();
        drawVertices();
        repaint();
    }

    final void newBoard() {
        numVertices = (Integer) frame.configPanel.dotsSpinner.getValue();
        edgeProbability = (Double) frame.configPanel.linesCombo.getSelectedItem();
        createProbabilityResults();
        createGameGraph();
        createOffscreenImage();
        createVertices();
        setNodesCoordinates();
        drawLines();
        drawVertices();
        repaint();
        System.out.println(this.frame.gameGraph);
    }

    private void setNodesCoordinates() {
        for (int i = 0; i < numVertices; i++) {
            frame.gameGraph.setNodeCoordinates(i, x[i], y[i]);
        }
    }

    final void drawExistingGraph() {
        if (frame.gameGraph != null) {
            createOffscreenImage();
            drawExistingNodes();
            drawExistingLines();
            repaint();
        }
    }

    final void drawExistingNodes() {
        for (int i = 0; i < frame.gameGraph.getNumberOfNodes(); i++) {
            graphics.fillOval(
                    frame.gameGraph.getNode(i).getX() - 5,
                    frame.gameGraph.getNode(i).getY() - 5,
                    10,
                    10
            );
        }
    }

    final void drawExistingLines() {
        for (int i = 0; i < frame.gameGraph.getNumberOfNodes(); i++) {
            Node startNode = frame.gameGraph.getNode(i);
            for (int j = 0; j < startNode.getLines().size(); j++) {
                int destinationNodeId = startNode.getLines().get(j).getDestinationNodeId();
                Node destinationNode = frame.gameGraph.getNode(destinationNodeId);
                    graphics.drawLine(
                            startNode.getX(),
                            startNode.getY(),
                            destinationNode.getX(),
                            destinationNode.getY()
                    );
                }
            }
    }

    private void createGameGraph() {
        this.frame.gameGraph = new GameGraph(this.numVertices);
    }

    private void createProbabilityResults() {
        int favorableCases = (int) (edgeProbability * 10);
        for (int i = 0; i < favorableCases; i++) {
            results.set(i, true);
        }
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = H / 2 - 10; //board radius
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
    }

    private void drawLines() {
        for (int i = 0; i < numVertices - 1; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                boolean shouldDrawLine = getDrawLineDecision();
                if (shouldDrawLine) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                    frame.gameGraph.addLine(i, j);
                }
            }
        }
    }

    private void drawVertices() {
        for (int i = 0; i < numVertices; i++) {
            graphics.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }
    }

    private boolean getDrawLineDecision() {
        Random randomGenerator = new Random();
        int extraction = randomGenerator.nextInt(10);
        return results.get(extraction);
    }

    @Override
    public void update(Graphics g) {
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.drawImage(image, 0, 0, this);
    }
}