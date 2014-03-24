package com.Kruglov.main.form.elements;

import com.Kruglov.file.system.model.SystemFile;
import com.Kruglov.table.model.BandedTableCellRenderer;
import com.Kruglov.table.model.FileSystemTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

    private JTextField txtFilePath;

    private JButton btnExtract;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnBack;
    private JButton btnFolder;

    private JPanel buttonsContainer1;

    private JPanel pNav;
    private JPanel pControl;

    private JTable tFiles;

    private SystemFile systemFile;
    private final FileSystemTableModel fileSystemTableModel;
    private final PathFileDialog pathFileDialog = new PathFileDialog();

    public MainFrame() throws HeadlessException {

        // initializing main form
        super("ZIP Archiver v1.0");
        setMinimumSize(new Dimension(350, 450));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();

        // creating main menu
        {
            setJMenuBar(new MainMenu());
        }

        // initializing of navigation panel
        {
            // buttons init
            btnAdd = new JButton("Add" , new ImageIcon("Add24.gif"));
            btnExtract = new JButton("Extract");
            btnRemove = new JButton("Remove");
            //
            //adding buttons to some JPanel, that will contain them
            buttonsContainer1 = new JPanel(new GridLayout(1, 3, 10, 0));
            buttonsContainer1.add(btnExtract);
            buttonsContainer1.add(btnAdd);
            buttonsContainer1.add(btnRemove);

            // adding buttons' panel to navigation panel like 1 element
            // to provide necessary view
            pNav = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pNav.add(buttonsContainer1);
        }


        // initializing of control panel
        {
            // text line init
            txtFilePath = new JTextField();
            txtFilePath.setEditable(false);
            txtFilePath.addMouseListener(filePathListener);
            //
            //buttons init
            btnBack = new JButton("Back");
            btnFolder = new JButton("Folder");
            //
            //adding buttons and txt field to control panel
            pControl = new JPanel();//(new FlowLayout(FlowLayout.LEFT));
            pControl.setLayout(new BoxLayout(pControl, BoxLayout.X_AXIS));
            pControl.add(btnBack);
            pControl.add(btnFolder);
            pControl.add(txtFilePath);
        }

        // adding components to main form
        {
            JPanel managePanel = new JPanel();
            managePanel.setLayout(new BoxLayout(managePanel, BoxLayout.Y_AXIS));
            managePanel.add(pNav);
            managePanel.add(pControl);

            add(managePanel, BorderLayout.NORTH);
        }

        // initializing of data table
        {
            systemFile = new SystemFile("E:/");

            txtFilePath.setText(systemFile.getPath());

            fileSystemTableModel = new FileSystemTableModel(systemFile);

            tFiles = new JTable(fileSystemTableModel);
            tFiles.setDefaultRenderer(fileSystemTableModel.getColumnClass(0), new BandedTableCellRenderer());
            tFiles.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() >= 2) {
                        //SystemFile root = (SystemFile) fileSystemTableModel.getValueAt(tFiles.getSelectedRow(), 3);
                        SystemFile root = new SystemFile(fileSystemTableModel.
                                getValueAt(tFiles.getSelectedRow(), 0).toString());
                        txtFilePath.setText(root.getParent() + " " + root.getPath());
//                        if(root != null) {
//                            fileSystemTableModel.setCurrentDir(root);
//                            //fileSystemTableModel.fireTableDataChanged();
//                            //txtFilePath.setText(root.getAbsolutePath());
//                        }
                    }
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
            });

            // adding scroll panel to table
            JScrollPane dataPanel = new JScrollPane(tFiles);
            // adding to main form
            add(dataPanel, BorderLayout.CENTER);
        }

        // set form visible
        setVisible(true);
    }

    // mouse listener for text field with data path
    MouseListener filePathListener = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
                pathFileDialog.setVisible(true);
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
