package fi.vamk.e1800960.northwind.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CreateAndSearchFile {
    public static void main(String[] args) throws IOException {

        // Read entity class name
        File folder = new File(
                "D:/Database/northwind/e1800960_northwind/src/main/java/fi/vamk/e1800960/northwind/demo/Entity");
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> listOfName = new ArrayList<>();
        char dot = '.';
        for (File file : listOfFiles) {
            String string = file.getName();
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) == dot) {
                    string = string.substring(0, j);
                    break;
                }
            }
            listOfName.add(string);
        }
        // Iterate the arraylist listofName to scan the files name
        for (String string : listOfName) {

            System.out.println(string);// Checking name

            // Generate Repository class
            String fileSeparator = System.getProperty("file.separator");
            String absoluteFilePath = "D:" + fileSeparator + "Database" + fileSeparator + "northwind" + fileSeparator
                    + "e1800960_northwind" + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "java"
                    + fileSeparator + "fi" + fileSeparator + "vamk" + fileSeparator + "e1800960" + fileSeparator
                    + "northwind" + fileSeparator + "demo" + fileSeparator + "Repo" + fileSeparator + string
                    + "Repository.java";

            File file = new File(absoluteFilePath);
            if (file.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
            if (file.exists())
                writeUsingBufferedWriter(data(string,true), 1, file); // Write to Repository file

            // Generate Controller class
            String absoluteFilePath2 = "D:" + fileSeparator + "Database" + fileSeparator + "northwind" + fileSeparator
                    + "e1800960_northwind" + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "java"
                    + fileSeparator + "fi" + fileSeparator + "vamk" + fileSeparator + "e1800960" + fileSeparator
                    + "northwind" + fileSeparator + "demo" + fileSeparator + "Controller" + fileSeparator + string
                    + "Controller.java";
            File file1 = new File(absoluteFilePath2);
            if (file1.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
            if (file.exists())
                writeUsingBufferedWriter(data(string,false), 1, file); // Write to Repository file
        }

    }

    private static void writeUsingBufferedWriter(String data, int noOfLines, File file)
        throws FileNotFoundException {
            //Empty the file first
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();

            FileWriter fr = null;
            BufferedWriter br = null;
           
            try{
                fr = new FileWriter(file);
                br = new BufferedWriter(fr);
                for(int i = noOfLines; i>0; i--){
                    br.write(data);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
    private static String data(String className,boolean x){
        String content_repo="package fi.vamk.e1800960.northwind.demo.Repo;"+System.getProperty("line.separator")+
            "import org.springframework.data.jpa.repository.JpaRepository;"+System.getProperty("line.separator")+
            "public interface "
            +className+"Repository extends JpaRepository<fi.vamk.e1800960.northwind.demo.Entity."+className+", Integer> {}"
            +System.getProperty("line.separator");
        String content_controller="";
        if(x)
            return content_repo;
        else
            return content_controller;
    }
}