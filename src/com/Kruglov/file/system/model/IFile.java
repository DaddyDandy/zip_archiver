package com.Kruglov.file.system.model;

import java.io.File;

public interface IFile {

    public String getName();

    public String getParent();

    public String getPath();

    public String getAbsolutePath();

    public long lastModified();

    public boolean isFile();

    public boolean isDirectory();

    public long size();

    public boolean exists();

    public boolean delete();

    public void getInputStream();

    public void getOutputStream();

    public IFile[] listFiles();

    public String getFileExtension();

    //new
    public IFile getParentFile();
}
