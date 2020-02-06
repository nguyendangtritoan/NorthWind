package fi.vamk.e1800960.northwind.demo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CreateAndSearchFile {
    public static void main(String[] args) throws IOException {
        //Read entity class name
        File folder = new File(
                "D:/Database/northwind/e1800960_northwind/src/main/java/fi/vamk/e1800960/northwind/demo");
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
        for (String string : listOfName) {
            System.out.println(string);
            String fileSeparator = System.getProperty("file.separator");
            String absoluteFilePath = "D:" + fileSeparator + "Test" + fileSeparator + string +"Repository.java";
            File file = new File(absoluteFilePath);
            if (file.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
            String absoluteFilePath2 = "D:" + fileSeparator + "Test" + fileSeparator + string +"Controller.java";
            File file1 = new File(absoluteFilePath2);
            if (file1.createNewFile()) {
                System.out.println(absoluteFilePath + " File Created");
            } else
                System.out.println("File " + absoluteFilePath + " already exists");
        }

    }
}