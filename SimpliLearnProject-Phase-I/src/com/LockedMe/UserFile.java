package com.LockedMe;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserFile implements FileAPI {

    /*
     * Method Name:addFile
     * this method add a file in the root directory if it is not present
     * @param (String) fileName i.e file name to be added
     * @return boolean
     */
    @Override
    public boolean addFile(String fileName) {
        boolean isFileCreated = false;
        try {

            File file = getDirectoryPath(fileName);

            if (isFileCreated = file.createNewFile()) {
                System.out.println("File "+file.getName()+ " successfully got created!\n");

            } else {
                System.out.println("File "+file.getName()+ " already exists!!\n");
            }

        } catch (IOException e) {
            System.out.println("An error occured\n\n");
            e.printStackTrace();
        }
        return isFileCreated;
    }

    /*
     * Method Name:searchFile
     * this method searches for a file in the root directory
     * @param (String) fileToBeSearched i.e file name to be searched
     * @return void
     */
    @Override
    public void searchFile (String fileToBeSearched){

        File file = getDirectoryPath(fileToBeSearched);

        if(file.exists()){
            System.out.println("Found the file "+ "'"+  file.getName() +"'");

        }
        else {
            System.out.println("Requested file "+ fileToBeSearched +" is not found");
        }
    }


    /*
     * Method Name:deleteFile
     * this method deletes a file in the root directory if it exists
     * @param (String) fileToDelete i.e file name to be deleted
     * @return void
     */

    @Override
    public void deleteFile (String fileToDelete){
        File file = getDirectoryPath(fileToDelete);
        if (file.delete()){
            System.out.println("File with the name " + "'" +file.getName()+ "' "+"got deleted");
        }
        else {
            System.out.println("Specified file not found");
        }
    }
    //Returns File object with root directory+fileName
    private static File getDirectoryPath(String fileName){
        String directoryPath = System.getProperty("user.dir")+"\\root\\";
        fileName+=".txt";
        File file = new File(directoryPath+fileName);
        return file;
    }
    //Returns File object with root directory.
    private static File getDirectoryPath(){
        String directoryPath = System.getProperty("user.dir")+"\\root\\";
        File file = new File(directoryPath);
        return file;
    }

    // lists the files in ascending order
    public static void listFilesInAsc() {
        // Add files to this fileList
        List<String> fileList = new ArrayList<>();
        File file = getDirectoryPath();
        System.out.println("Path Directory:"+file.toPath()+"\n");
        String a[] =file.list();
        if (a.length>=1){
            for (String fileName:a){
                fileList.add(fileName);
            }
            Collections.sort(fileList);
            System.out.println("Here is the list of files");
            for (String s:fileList) {
                System.out.println(s);
            }
        }
        else {
            System.out.println("The specified directory is empty please add a file\n");
        }

    }


}
