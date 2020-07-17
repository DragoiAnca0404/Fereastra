package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fereastra extends Frame {
    private TextField t1, t2, t3, t4;
    private Button b;

    public  Fereastra() {
        super("Fereastra Creare Cont");
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new Label("CNP"));
        t1 = new TextField(15);
        add(t1);
        add(new Label("Parola"));
        t2 = new TextField(15);
        add(t2);
        add(new Label("Email"));
        t3 = new TextField(15);
        add(t3);
        add(new Label("Numar Telefon"));
        t4 = new TextField(15);
        add(t4);
        b = new Button("Creaza cont");
        add(b);
        Ascultator a = new Ascultator();
        b.addActionListener(a);
    }

    private class Ascultator implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            t1.setBackground(null);
            t2.setBackground(null);
            t3.setBackground(null);
            t4.setBackground(null);
            if (CampText.CNP.verificaText(t1.getText()) == false) {
                t1.setBackground(Color.RED);
            }
            if (CampText.PAROLA.verificaText(t2.getText()) == false) {
                t2.setBackground(Color.RED);
            } else {
                t2.setText((CampText.PAROLA.getContinut()));
            }
            if (CampText.EMAIL.verificaText(t3.getText()) == false) {
                t3.setBackground(Color.RED);
            }
            if (CampText.TELEFON.verificaText(t4.getText()) == false) {
                t4.setBackground(Color.RED);
            }
        }
    }
}
