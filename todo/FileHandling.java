package todo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class FileHandling {
	
	private File file;
	
	public File getFile() {
		return file;
	}

	//Load the contains of the categories
	public List<String> load(DaysOfTheWeek day) {
		try(Scanner scanner = new Scanner(new File(day+".txt"))) {
			List<String> contain = new ArrayList<>();
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				contain.add(line);
			}
			return contain;
		} catch (FileNotFoundException e )  {
			return Collections.emptyList();
		}
	}
	
	// Create first an empty file for every day if they doesn't exist
	public void createFirstAnEmptyFile(DaysOfTheWeek day) {
		try {
			file = new File(day+".txt");
			
			if (file.createNewFile()) {
	    	  
				System.out.println("File created: " + file.getName());
				
			} else {
				System.out.println("File already exists: " + day +".txt");
			}
	    } catch (IOException e) {
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    	}
	}
	
	//Overwrite the file
	public void overWriteTheFile(Day day) {
		try (FileWriter writer = new FileWriter(day.getFile(), false)) {
		
			for (Entry<Integer, ToDoCategory> entry : day.getCategories().entrySet()) {
				if(!entry.getValue().getTheList().isEmpty()) {
					writer.write(entry.getValue().getTheList().get(0) + System.lineSeparator());
				} else {
					writer.write(" " + System.lineSeparator());
				}
			}	  

		} catch (IOException e) {
	        	e.printStackTrace();
		}  
	}
}
