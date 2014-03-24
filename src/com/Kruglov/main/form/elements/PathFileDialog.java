package com.Kruglov.main.form.elements;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class PathFileDialog extends JDialog {

    private JList list;

    public JList getList() {
        return list;
    }

    PathFileDialog() {

        setName("PATH");
        File[] roots = File.listRoots();
        JList list = new JList(roots);

        JScrollPane jScrollPane = new JScrollPane(list);
        add(jScrollPane);

        setVisible(false);
        setMinimumSize(new Dimension(100, 150));
        setLocationRelativeTo(null);

    }

}
