package lock.me;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class MainDriver {
	//Files location in you pc, to test this app please create an folder
	// named " LockME " in your D drive or change the path accordingly
	
	static File path = new File("D://LockME");
	// this single scanner is used along the application
	static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	
	public static void main(String[] args) throws IOException {
		//Main menu
		showMenu();
		
		try {
			int sel=Integer.parseInt(sc.nextLine()) ;
			do {
				if(sel==1) {
				   FileHandler.getAllFiles();
				   main(args);
				}
				else if(sel==2) {
					subMenu(); // showing sub menu
					int choice = Integer.parseInt(sc.nextLine());
					switch (choice) {
					case 1:
						FileHandler.createFile(sc);
						break;
					case 2:
						FileHandler.searchFiles(sc);
						break;
					case 3:
						FileHandler.deleteFile(sc);
						break;
					case 4:
						main(args);
						
					default:		
						break;
					}
					
				}
				else {
					FileHandler.PrintMessage(">>>Program terminated<<<<");
					System.exit(0);
				}
				
			}
			while(sel != 3);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			FileHandler.PrintMessage("invalid input,run the program again!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//main menu
	public static void showMenu() {
		System.out.println("===================================");
		System.out.println(">>>>>> WELCOME TO LOCKME.COM <<<<<<");
		System.out.println("===================================");
		System.out.println("      Designed by Malay Sarkar");
		System.out.println("===================================");
		System.out.println(">  MAIN MENU");
		System.out.println("-----------------------------------");
		System.out.println("1. Show Files");
		System.out.println("2. Manage Files");
		System.out.println("3. Exit");
		System.out.println("===================================");
		System.out.println("-> Enter a choice ");
		
	}
	// code for subMenu
	public static void subMenu() {
		// TODO Auto-generated method stub
		System.out.println("===================================");
		System.out.println(">  SUB MENU");
		System.out.println("===================================");
		System.out.println("1. Add a file");
		System.out.println("2. Search a file");
		System.out.println("3. delete a file");
		System.out.println("4. Back");
		System.out.println("===================================");
		System.out.println("-> Enter a choice ");
	}
}
