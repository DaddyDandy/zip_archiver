package com.Kruglov.main.form.elements;

import com.Kruglov.file.system.model.SystemFile;
import com.Kruglov.table.model.BandedTableCellRenderer;
import com.Kruglov.table.model.FileSystemTableModel;
import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainFrame extends JFrame {

    public static final int COLUMN_INDEX = -1;
    public static final String BACK = "Back";
    public static final String FOLDER = "Folder";
    public static final String ADD = "Add";
    public static final String EXTRACT = "Extract";
    public static final String REMOVE = "Remove";
    public static final String ADD24_GIF = "Add24.gif";
    public static final int WIDTH_MAIN_FRAME = 350;
    public static final int HEIGHT_MAIN_FRAME = 450;
    public static final String ZIP_ARCHIVER_V1_0 = "ZIP Archiver v1.0";

    // text field with file system path
    private JTextField txtFilePath;

    // main form buttons
    private JButton btnExtract;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnBack;
    private JButton btnFolder;

    // main form elements' containers
    private JPanel buttonsContainer1;
    private JPanel pNav;
    private JPanel pControl;

    // main table, that displays file system
    private JTable tFiles;

    // type of file system
    private SystemFile root;

    // abstract class for tFiles JTable, that provide displaying information of file system
    private final FileSystemTableModel fileSystemTableModel;

    public MainFrame() throws HeadlessException {

        // initializing main form
        super(ZIP_ARCHIVER_V1_0);
        setMinimumSize(new Dimension(WIDTH_MAIN_FRAME, HEIGHT_MAIN_FRAME));
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
            btnAdd = new JButton(ADD, new ImageIcon(ADD24_GIF));
            btnExtract = new JButton(EXTRACT);
            btnRemove = new JButton(REMOVE);
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
            //
            //buttons init
            btnBack = new JButton(BACK);
            btnBack.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (root.getParentFile().getClass() == SystemFile.class) {
                        root = (SystemFile) root.getParentFile();
                        // MAST USE OBSERVER FOR THIS!!!
                        fileSystemTableModel.setCurrentDir(root);
                        txtFilePath.setText(root.getAbsolutePath());
                    } else if (root.getParentFile().getClass() == SystemFile.RootSystemFile.class) {
                        // MAST USE OBSERVER FOR THIS!!!
                        fileSystemTableModel.setCurrentDir(new SystemFile.RootSystemFile());
                        txtFilePath.setText(" ");
                    }
                    // MAST USE OBSERVER FOR THIS!!!
                    tFiles.updateUI();
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
            btnFolder = new JButton(FOLDER);
            btnFolder.setEnabled(false);
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
            fileSystemTableModel = new FileSystemTableModel(new SystemFile.RootSystemFile());
            tFiles = new JTable(fileSystemTableModel);

            //написать для каждой колонки разные
            // styles for DataTable columns & right displaying of information in them
            tFiles.setDefaultRenderer(fileSystemTableModel.getColumnClass(0), new BandedTableCellRenderer());
            tFiles.setDefaultRenderer(fileSystemTableModel.getColumnClass(1), new BandedTableCellRenderer());
            tFiles.setDefaultRenderer(fileSystemTableModel.getColumnClass(2), new BandedTableCellRenderer());
            // adding mouse listener for table's rows to make file system
            // when you're clicking on the row(if it's folder), thah you go to that folder
            tFiles.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() >= 2) {
                        int rootRow = tFiles.getSelectedRow();
                        root = (SystemFile) fileSystemTableModel.getValueAt(rootRow, COLUMN_INDEX);
                        if(root != null) {
                            fileSystemTableModel.setCurrentDir(root);
                            tFiles.updateUI();
                        }
                        txtFilePath.setText(root.getAbsolutePath());
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

            //adding scroll panel to table
            JScrollPane dataPanel = new JScrollPane(tFiles);
            // adding to main form
            add(dataPanel, BorderLayout.CENTER);
        }

        // set form visible
        setVisible(true);
    }

}
