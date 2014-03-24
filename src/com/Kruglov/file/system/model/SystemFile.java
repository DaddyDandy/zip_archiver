package com.Kruglov.file.system.model;

import java.io.File;

public class SystemFile implements IFile {

    private File file;

    public SystemFile(String pathName) {
        file = new File(pathName);
    }

    @Override
    public String getName() {
        return file.getName();
    }

    @Override
    public String getParent() {
        return file.getParent();
    }

    @Override
    public String getPath() {
        return file.getPath();
    }

    @Override
    public String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    @Override
    public long lastModified() {
        return file.lastModified();
    }

    @Override
    public boolean isFile() {
        return file.isFile();
    }

    @Override
    public boolean isDirectory() {
        return file.isDirectory();
    }

    @Override
    public long size() {
        return file.length();
    }

    @Override
    public boolean exists() {
        return file.exists();
    }

    @Override
    public boolean delete() {
        return file.delete();
    }

    @Override
    public void getInputStream() {

    }

    @Override
    public void getOutputStream() {

    }

    // took from File class
    @Override
    public IFile[] listFiles() {
        String[] ss = file.list();
        if (ss == null) return null;
        int n = ss.length;
        SystemFile[] fs = new SystemFile[n];
        for (int i = 0; i < n; i++) {
            fs[i] = new SystemFile(ss[i]);
        }
        return fs;
    }

    @Override
    public String getFileExtension() {
        String[] urlSplit = file.getName().split("/");
        String filename = urlSplit[urlSplit.length - 1];
        String[] nameSplit = filename.split("[.]");
        StringBuffer fileExtension = new StringBuffer();

        if (nameSplit.length > 1) {
            for (int index = 1; index < nameSplit.length; index++) {
                if (index != nameSplit.length - 1)
                    fileExtension.append(nameSplit[index] + ".");
                else
                    fileExtension.append(nameSplit[index]);
            }
        } else {
            fileExtension.append(nameSplit[0]);
        }
        return fileExtension.toString();
    }

}
