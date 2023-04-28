package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;


public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    FileOutputStream fileOutputStream = null;
    FileInputStream fileInputStream = null;

    ObjectOutputStream writer = null;
    ObjectInputStream reader = null;


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
    private void saveGame(ActionEvent actionEvent) {
        try{
            fileOutputStream = new FileOutputStream("Save&Load.txt");
            writer = new ObjectOutputStream(fileOutputStream);

            writer.writeObject(frame.gameGraph);
            writer.close();
            System.out.println("am ajuns aici");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private void loadGame(ActionEvent actionEvent) {
        //System.out.println("Load");
        try{
            fileInputStream = new FileInputStream("Save&Load.txt");
            reader = new ObjectInputStream(fileInputStream);

            GameGraph gameGraph1 = null;
            gameGraph1 = (GameGraph) reader.readObject();
            frame.gameGraph = gameGraph1;
            frame.canvas.drawExistingGraph();
        }
        catch (IOException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void resetGame(ActionEvent actionEvent) {
        System.out.println("Reset");
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}

