package lock.me;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class FileHandler {
	
	//get all the file names 
	public static void getAllFiles() {
		// System.out.println("---> getAllFiles_forLoop");
		// Name of files are stored in an array
		File[] listOfFiles = MainDriver.path.listFiles();
		// We use an Arraylist to contain the list of files
		List<File> alListOfFiles = new ArrayList<File>();
		Collections.addAll(alListOfFiles, listOfFiles);
		// Read the Arraylist using a for loop with the name of the files1
		try {
			
			if(alListOfFiles.size()==0) {
				PrintMessage("Folder is empty!! Please create some files first");
			}
			else {
				for (int i = 0; i < alListOfFiles.size(); i++) {
					System.out.println(alListOfFiles.get(i));
				}
			}
			// On error an exception is raised
		} catch (Exception e) {
			PrintMessage("Error: file not found");
		}
	}
	
	//creating new files
	public static void createFile(Scanner scannerCreate) {
		// Writer object to use
		FileWriter writer = null;
		try {
			// Read the name of the file to create
			System.out.println("What is the name of your new file?");
			File newFile = new File(MainDriver.path + "//" + scannerCreate.nextLine());
			writer = new FileWriter(newFile);
			// Read the contents of the file to create
			System.out.println("And the contents of your file are...");
			writer.write(scannerCreate.nextLine());
			writer.close();
			PrintMessage("File created successfully");
			// On error an exception is raised
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void PrintMessage(String message) {
		System.out.println(" --------------------------------------------");
		System.out.println(" " + message);
		System.out.println(" --------------------------------------------");
	}
	
	// delete file method
	
	public static void deleteFile(Scanner scannerdelete) {
		try {
			// Read the name of the file to delete
			System.out.println("Write the name of the file you want to delete:");
			File fileToDelete = new File(MainDriver.path + "//" + scannerdelete.nextLine());
			// On success
			if (fileToDelete.delete()) {
				PrintMessage("File deleted successfully.");
			} else {
				// On error
				PrintMessage("There was an error deleting the file");
			}
			// On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error deleting the file");
		}
	}
	
	// search file method
	public static void searchFiles(Scanner scannerSearch) {
		try {
			// Name of the file to find
			System.out.println("Write the name of the file you want to find:");
			File fileTofind = new File(MainDriver.path + "//" + scannerSearch.nextLine());
			// If the file existes
			if (fileTofind.exists()) {
				PrintMessage("File exists");
			} else {
				// If not a message is sent
				PrintMessage("File does not exist");
			}
			// On error an exception is raised
		} catch (Exception e) {
			PrintMessage("There was an error searching the file.");
		}
	}
	

}
