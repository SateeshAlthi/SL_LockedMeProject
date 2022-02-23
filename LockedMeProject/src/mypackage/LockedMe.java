package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {

	
		static final String projectFilesPath = "D:\\LockedMe Files";
		static final String errorMessage = "Some error occured. Please contact admin Team ";

		public static void main(String[] args) {
			Scanner obj = new Scanner(System.in);
			int ch;

			do {
				displayMenu();
				System.out.println("Enter your choice");
				ch = Integer.parseInt(obj.nextLine());

				switch (ch) {
				case 1:
					getAllFiles();
					break;
				case 2:
					createFiles();
					break;
				case 3:
					deleteFiles();
					break;
				case 4:
					SearchFiles();
					break;
				case 5:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option");
					break;
				}
			} while (ch > 0);
			obj.close();
		}

		public static void displayMenu() {

			System.out.println("*******************************************");
			System.out.println("\t\tWelcome to LockedMe.com");
			System.out.println("*******************************************");
			System.out.println("\t\t1. Display all the files");
			System.out.println("\t\t2. Add a new file");
			System.out.println("\t\t3. Delete a file");
			System.out.println("\t\t4. Search a file");
			System.out.println("\t\t5. Exit");
		}

		/**
	  		 * This function will return all the files from project directory
	  		 */

	  		public static void getAllFiles() {
	  			
	  			try {
					
	  				File folder = new File(projectFilesPath);
	  				File[] listOfFiles = folder.listFiles();
	  				
	  				if (listOfFiles.length==0) {
						System.out.println("No files exist in the directory");
	  				}
					else {
						for(File l: listOfFiles)
						{
	                     System.out.println(l.getName());
					    }
					}
	  			}
				 catch (Exception Ex) {
					 System.out.println(errorMessage);
				}
	  		}

		public static void createFiles() {
			try {
				Scanner obj = new Scanner(System.in);
				String fileName;

				System.out.println("Enter file name:");
				fileName = obj.nextLine();

				int linesCount;
				System.out.println("Enter how many lines in the file:");
				linesCount = Integer.parseInt(obj.nextLine());

				FileWriter mywriter = new FileWriter(projectFilesPath + "\\" + fileName);

				for (int i = 1; i <= linesCount; i++) {
					System.out.println("Enter the file line:");
					mywriter.write(obj.nextLine() + "\n");
				}

				System.out.println("File Created Successfully");
				mywriter.close();
				obj.close();

			} catch (Exception Ex) {
				System.out.println(errorMessage);
			}

		}

		public static void deleteFiles() {

			Scanner obj = new Scanner(System.in);
			try {
				String fileName;

				System.out.println("Enter file name to be deleted");
				fileName = obj.nextLine();

				File file = new File(projectFilesPath + "\\" + fileName);
				if (file.exists()) {
					file.delete();
					System.out.println("File deleted successfully:" + fileName);
				} else
					System.out.println("File do not exist");
			} catch (Exception ex) {
				System.out.println(errorMessage);
			} finally {
				obj.close();
			}

		}

		public static void SearchFiles() {
					
						Scanner obj = new Scanner (System.in);
						try {
						String fileName;
						
						System.out.println("Enter file name to be searched");
						fileName=obj.nextLine();
						
					File folder = new File(projectFilesPath);
					File[] listOfFiles = folder.listFiles();
				
					LinkedList<String> filenames = new LinkedList<String>();
					for (File l : listOfFiles) 
					filenames.add(l.getName());	
					
					if (filenames.contains(fileName)) 
						System.out.println("File is available");
					else 
						System.out.println("File is not available");
							}
					catch (Exception ex)
						{  				
						System.out.println(errorMessage);   
						}
					finally 
					{
					obj.close();
					}
						}
	}

	
	

