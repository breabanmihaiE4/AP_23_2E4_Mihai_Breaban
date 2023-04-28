package org.example;

import jdk.internal.icu.util.CodePointMap;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    public CodePointMap.Range dotsField;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesCombo;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));

        Double[] lineProbability = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        linesCombo = new JComboBox(lineProbability);

        Button button = new Button("Create a new game");
        button.addActionListener(this::createGame);

        add(dotsLabel);
        add(dotsSpinner);
        add(linesCombo);
        add(button);
    }

    private void createGame(ActionEvent actionEvent) {
        frame.canvas.newBoard();
    }
}

