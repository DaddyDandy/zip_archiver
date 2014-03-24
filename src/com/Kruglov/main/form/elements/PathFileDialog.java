package com.Kruglov.main.form.elements;

import javax.swing.*;
import java.awt.*;

public class PathFileDialog extends JDialog {

    PathFileDialog() {

        JFileChooser fileDialog = new JFileChooser();

        add(fileDialog);
        setVisible(true);
        setMinimumSize(new Dimension(450, 300));
        setLocationRelativeTo(null);

    }

}
