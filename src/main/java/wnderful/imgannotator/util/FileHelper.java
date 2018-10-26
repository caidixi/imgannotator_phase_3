package wnderful.imgannotator.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHelper {
    private String absolutePath = "D:\\project\\picture\\";

    public boolean taskFolderExist(String taskname) {
        File file = new File(absolutePath + taskname);
        return file.exists();
    }

    public boolean pictureExist(String taskname){
        File file = new File(absolutePath + taskname);
        return file.exists();
    }

    public boolean savePicture(String taskname,String imgId,byte[] bytes){
        try{
            Path path = Paths.get(absolutePath+taskname+"\\"+imgId);
            Files.write(path, bytes);
            return true;
        }catch (IOException ex){
            ex.printStackTrace();
            return false;
        }
    }



    public boolean newTaskFolder(String taskname){
        if(taskFolderExist(taskname)){
            deleteTaskFolder(taskname);
        }
        File file = new File(absolutePath + taskname);
        return file.mkdir();
    }

    public boolean deleteTaskFolder(String taskname){
        try {
            File dir = new File(absolutePath + taskname);
            if (dir.isDirectory()) {
                String[] children = dir.list();

                if(children!=null){
                    for (String aChildren : children) {
                        boolean success = deleteTaskFolder(taskname + "\\" + aChildren);
                        if (!success) {
                            return false;
                        }
                    }
                }
            }
                return dir.delete();

        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
