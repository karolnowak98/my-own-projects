package com.company;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui implements ActionListener {
    private JFrame frame;
    private JButton[] buttons;
    private JLabel label = new JLabel("0");
    private String actualText = "";

    public Gui() {
        this.frame = new JFrame("Calculator");
        this.frame.setLayout(new GridLayout(2,1));
        this.frame.add(this.creatingPanelOfValue());
        this.frame.add(this.creatingPanelOfButtons());
        this.frame.setBackground(Color.darkGray);
        this.frame.setSize(480,640);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }

    private JPanel creatingPanelOfValue(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,1));

        panel.setBackground(Color.darkGray);
        this.label.setFont(new Font("Dialog", Font.BOLD, 50));
        this.label.setForeground(Color.white);
        this.label.setBackground(Color.darkGray);
        this.label.setOpaque(true);
        this.label.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.add(this.label);
        return panel;
    }

    private JPanel creatingPanelOfButtons(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,4));
        String[] buttonTitles = {   "^", "√", "C", "%",
                                    "7", "8", "9", "x",
                                    "4", "5", "6", "-",
                                    "1", "2", "3", "+",
                                    "/", "0", ",", "="  };
        this.buttons = new JButton[buttonTitles.length];

        for (int i = 0; i < buttonTitles.length; i++) {
            this.buttons[i] = new JButton(buttonTitles[i]);
            this.buttons[i].addActionListener(this);
            this.buttons[i].setFont(new Font("Dialog", Font.BOLD, 20));
            this.buttons[i].setFocusPainted(false);
            this.buttons[i].setForeground(Color.white);
            this.buttons[i].setBackground(Color.black);
            this.buttons[i].setVerticalTextPosition(SwingConstants.CENTER);
            this.buttons[i].setHorizontalTextPosition(SwingConstants.CENTER);
            panel.add(this.buttons[i]);
        }
        return panel;
    }

    public void actionPerformed(ActionEvent e){

        switch(e.getActionCommand()){
            case "^":
                this.label.setText("x");
                break;
            case "√":
                break;
            case "C":
                actualText="";
                break;
            case "%":
                break;
            case "x":
                break;
            case "-":
                break;
            case "+":
                break;
            case "=":
                break;
            case ",":
                break;
            case "0":
                if(!actualText.startsWith("0"))
                    actualText+=e.getActionCommand();
                break;
            case "/":
                break;
            default:
                actualText+=e.getActionCommand();
        }

        this.label.setText(actualText);
    }


}
