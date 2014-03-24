package com.Kruglov.main.form.elements;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainMenu extends JMenuBar {

    MainMenu() {

        JMenu menu = new JMenu("File");
        menu.add(new JMenu("Connect to ..."));
        menu.add(new JMenu("Exit"));

        JMenu menu1 = new JMenu("Help");
        menu1.add(new JMenu("About author"));
        add(menu);
        add(menu1);

    }

    MouseListener mouseListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

}
