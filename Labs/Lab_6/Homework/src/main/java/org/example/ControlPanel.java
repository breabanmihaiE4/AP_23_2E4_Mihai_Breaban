package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        //configure listeners for all buttons
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
    }

    private void loadGame(ActionEvent actionEvent) {
        System.out.println("Load");
    }

    private void saveGame(ActionEvent actionEvent) {
        //this.frame.gameGraph.save(,"C:\\Users\\mihai\\Downloads\\AP_23_2E4_Mihai_Breaban\\Labs\\Lab_7/Graph.txt");
    }

    private void resetGame(ActionEvent actionEvent) {
        System.out.println("Reset");
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}

