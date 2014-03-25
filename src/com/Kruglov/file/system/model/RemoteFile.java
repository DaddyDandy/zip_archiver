package com.Kruglov.file.system.model;

import java.io.File;

public class RemoteFile implements IFile {

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getParent() {
        return null;
    }

    @Override
    public String getPath() {
        return null;
    }

    @Override
    public String getAbsolutePath() {
        return null;
    }

    @Override
    public long lastModified() {
        return 0;
    }

    @Override
    public boolean isFile() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public long size() {
        return 0;
    }

    @Override
    public boolean exists() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    @Override
    public void getInputStream() {

    }

    @Override
    public void getOutputStream() {

    }

    @Override
    public IFile[] listFiles() {
        return null;
    }

    @Override
    public String getFileExtension() {
        return null;
    }

    @Override
    public IFile getParentFile() {
        return null;
    }
}
