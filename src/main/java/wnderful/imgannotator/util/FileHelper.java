package wnderful.imgannotator.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileHelper {
    public boolean taskFolderExist(String taskname) {
        File file = new File("src/main/resources/picture/" + taskname);
        return file.exists();
    }

    public boolean pictureExist(String taskname){
        File file = new File("src/main/resources/static/picture/" + taskname);
        return file.exists();
    }

    public boolean write(String pathname, String content) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("src/main/resources/static/entity/" + pathname + ".txt"));
            out.write(content);
            out.close();
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean writeFile(String pathname,byte[] bytes){
        try{
            Path path = Paths.get("src/main/resources/static/picture/"+pathname);
            Files.write(path, bytes);
            return true;
        }catch (IOException ex){
            ex.printStackTrace();
            return false;
        }
    }

    public String read(String name) {
        String content = "";
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/static/entity/" + name)));
            String str;
            while ((str = in.readLine()) != null) {
                content = content + str;
            }
            in.close();
            return content;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            return null;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (Exception ex) {
            return null;
        }
        return null;
    }

    public ArrayList<String> readList(String path){
        File file = new File("src/main/resources/static/entity/"+path);
        File[] files = file.listFiles();
        ArrayList<String> list = new ArrayList<>();
        if(files!=null){
            for(File aFile:files){
                String content = read(path+aFile.getName());
                list.add(content);
            }
            return list;
        }else {
            return null;
        }
    }

    public boolean newTaskFolder(String taskname){
        if(taskFolderExist(taskname)){
            deleteTaskFolder(taskname);
        }
        File file = new File("src/main/resources/picture/" + taskname);
        return file.mkdir();
    }

    public boolean delete(String path) {
        try {
            File file = new File("src/main/resources/static/" + path);
            return file.delete();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteTaskFolder(String taskname){
        try {
            File dir = new File("src/main/resources/picture/" + taskname);
            if (dir.isDirectory()) {
                String[] children = dir.list();

                if(children!=null){
                    for (String aChildren : children) {
                        boolean success = deleteTaskFolder(taskname + "/" + aChildren);
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
