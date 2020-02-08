package fi.vamk.e1800960.northwind.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
            String absoluteFilePath = "D:\\Database\\northwind" + fileSeparator
                    + "e1800960_northwind\\src\\main\\java"
                    + fileSeparator + "fi\\vamk\\e1800960" + fileSeparator
                    + "northwind\\demo\\Repo" + fileSeparator + string
                    + "Repository.java";

            File file = new File(absoluteFilePath);
            if (file.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
            if (file.exists())
                writeUsingBufferedWriter(data(string,true), 1, file); // Write to Repository file

            // Generate Controller class
            String absoluteFilePath2 = 
            "D:\\Database\\northwind\\e1800960_northwind\\src\\main\\java\\fi\\vamk\\e1800960\\northwind\\demo\\Controller\\" 
            + string+ "Controller.java";
            File file1 = new File(absoluteFilePath2);
            if (file1.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
            if (file.exists())
                writeUsingBufferedWriter(data(string,false), 1, file1); // Write to Repository file
        }

    }

    private static void writeUsingBufferedWriter(String data, int noOfLines, File file) throws FileNotFoundException {
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
    private static String data(String className,boolean x) throws IOException {
        String content_repo="package fi.vamk.e1800960.northwind.demo.Repo;"+System.getProperty("line.separator")+
            "import org.springframework.data.jpa.repository.JpaRepository;"+System.getProperty("line.separator")+
            "public interface "
            +className+"Repository extends JpaRepository<fi.vamk.e1800960.northwind.demo.Entity."+className+", Integer> {}"
            +System.getProperty("line.separator");
            
        String content_controller=readContentFile(className);
        if(x)
            return content_repo; 
        else
            return content_controller;
    }

    private static String readContentFile(String className) throws IOException{
            String fileSeparator = System.getProperty("file.separator");
            String absoluteFilePath = 
            "D:\\Database\\northwind\\e1800960_northwind\\src\\main\\java\\fi\\vamk\\e1800960\\northwind\\demo\\ControllerTemplate.txt";
            File file=new File(absoluteFilePath);    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line.replaceAll("EntityNeedReplace", className));      //appends line to string buffer
                sb.append(System.getProperty("line.separator"));     //line feed
            }
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
            return sb.toString();
        }
    }