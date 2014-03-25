package com.Kruglov.file.system.model;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.File;

public class SystemFile implements IFile {

    private File file;

    public SystemFile(String pathName) throws InvalidArgumentException {
        file = new File(pathName);
        //if(!file.exists()) {
            //throw  new InvalidArgumentException(new String[] {pathName});
        //}
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
        File[] files = file.listFiles();
//        if (files != null) {
//
//        }
        IFile[] iFiles = myListFiles(files);
        return iFiles;
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

    public static class RootSystemFile implements IFile {

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
            File[] files = File.listRoots();
//        if (files != null) {
//
//        }
            IFile[] iFiles = myListFiles(files);
            return iFiles;
        }

        @Override
        public String getFileExtension() {
            return null;
        }
    }

    private static IFile[] myListFiles(File[] files) {
        IFile[] iFiles = new IFile[files.length];
        int cntr = 0;
        for (File f : files) {
            try {
                IFile iFile = new SystemFile(f.getAbsolutePath());
                iFiles[cntr++] = iFile;
            } catch (InvalidArgumentException ignored) {
            }
        }
        return iFiles;
    }

}
