package com.Kruglov.main.form.elements;

import com.Kruglov.file.system.model.IFile;
import com.Kruglov.table.model.FileSystemTableModel;

import javax.swing.*;

public class DataTable extends JTable {

    private FileSystemTableModel fileSystemTableModel;

    DataTable(IFile file) {
        this.fileSystemTableModel = new FileSystemTableModel(file);
        JTable tFiles = new JTable(fileSystemTableModel);
    }

}
