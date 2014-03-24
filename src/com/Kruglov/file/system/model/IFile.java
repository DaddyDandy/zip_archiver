package com.Kruglov.file.system.model;

import java.io.File;

public interface IFile {

    String getName();

    String getParent();

    String getPath();

    String getAbsolutePath();

    long lastModified();

    boolean isFile();

    boolean isDirectory();

    long size();

    boolean exists();

    boolean delete();

    void getInputStream();

    void getOutputStream();

    IFile[] listFiles();

    String getFileExtension();
}
