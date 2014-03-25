package com.Kruglov.table.model;

import com.Kruglov.file.system.model.IFile;
import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.io.File;
import java.util.Date;

public class FileSystemTableModel extends AbstractTableModel {

    // number of columns in table
    private final int COLUMN_COUNT = 3;
    // list of files in current directory
    private static IFile[] files;
    // current directory
    private static IFile currentDir;

    // constructor
    // take current directory and make list of files of it
    public FileSystemTableModel(IFile currentDir) {
        setCurrentDir(currentDir);
    }

    // change current directory
    public void setCurrentDir(IFile currentDir) {
        if (currentDir != null) {
            this.currentDir = currentDir;
            this.files = this.currentDir.listFiles();
        }
    }

    @Override
    public int getRowCount() {
        return files.length;
    }

    @Override
    public int getColumnCount() {
        return COLUMN_COUNT;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Name";
            case 1:
                return "Size";
            case 2:
                return "Modified";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return IFile.class;
            case 1:
                return Long.class;
            case 2:
                return Date.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        assert rowIndex >= 0 && rowIndex < this.files.length;

        IFile file = this.files[rowIndex];
        switch (columnIndex) {
            case 0:
                return file.getName();
            case 1:
                return file.size();
            case 2:
                return new Date(file.lastModified());
            default:
                return file;
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

}
