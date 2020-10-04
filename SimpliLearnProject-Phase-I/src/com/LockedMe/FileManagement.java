package com.LockedMe;

import java.util.Scanner;

public class FileManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("LockedME welcomes you! Enjoy our services");
        System.out.println("*****************************************");
        System.out.println("Author:Dhruva Kumar Renuka\n");
        boolean isTrue = true;
        do {
            System.out.println("Make a choice to use the specified service");
            System.out.println("------------------------------------------");
            System.out.println("1: Returns current file names in ascending order");
            System.out.println("2: Takes you to File management service");
            System.out.println("3: Exits the application");
            String choice = "";
            boolean isInput = scanner.hasNext();
            if (isInput) {
                choice = scanner.next();
                // remove spaces around the input if any
                choice = choice.trim();
                switch (choice) {
                    case "1":
                        System.out.println("you invoked 1. Printing file names in ascending order.");
                        UserFile.listFilesInAsc();
                        break;


                    case "2":
                        System.out.println("you invoked 2. Taking you to FMS. . .");
                        fileManagementService();
                        break;

                    case "3":
                        System.out.println("you invoked 3. Exiting the application!!");
                        isTrue = false;
                        break;

                    default:
                        System.out.println(String.format("Invalid option: '%s'. Supported options are 1,2 and 3\n\n", choice));
                }
            }
        } while (isTrue);
    }



    public static void fileManagementService() {
        System.out.println("====================================================");
        System.out.println("You just entered a File Management Service. Happy to serve you!!");
        System.out.println("====================================================");

        Scanner s = new Scanner(System.in);
        boolean isFileLoop = true;
        do {
            System.out.println("Press 1: To add a new file");
            System.out.println("Press 2: To delete a file ");
            System.out.println("Press 3: To search for a file");
            System.out.println("Press 4: To go back to the previous Menu");

            String fileChoiceString = "";
            boolean isNextInput = s.hasNext();


            if (isNextInput) {
                fileChoiceString = s.nextLine();
                fileChoiceString = fileChoiceString.trim();



                FileAPI user= new UserFile();
                switch (fileChoiceString) {

                    // Add file option
                    case "1":
                        System.out.println("Enter the file name you wish to ADD");
                        String fileToAdd = s.nextLine();
                        user.addFile(fileToAdd);
                        break;

                    //Delete file option
                    case "2":
                        System.out.println("Enter the file name you would like to DELETE");
                        String fileToDelete = s.nextLine();
                        user.deleteFile(fileToDelete);
                        break;

                    //Search file option
                    case "3":
                        System.out.println("Enter the file name you wish to SEARCH for");
                        String fileToSearch = s.nextLine();
                        user.searchFile(fileToSearch);
                        break;

                    //Previous Menu option
                    case "4":
                        System.out.println("You are back to the Main Menu");
                        isFileLoop = false;
                        break;

                    default:
                        System.out.println(String.format("Invalid option: '%s'. Supported options are 1,2,3 & 4\n Choose a valid option to continue or press 4 to exit\n", fileChoiceString));
                        break;
                }

            }
        }while (isFileLoop) ;

    }

}

