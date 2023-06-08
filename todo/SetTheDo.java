package todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;


public class SetTheDo {
	
	static UserInputHandler input;
	static UserSelectings userSelecting = new UserSelectings();
	
	// ToDo state
	public void setState(Scanner scanner) {
		input = new UserInputHandler(scanner);
		
		List<Day> storedDays = listOfTheDay();
		
		// Event loop
		while (true) {
			System.out.println("------------");
			System.out.println("Select a day!");
			System.out.println("------------");
			for (Day day : storedDays) {
				System.out.println(day);
			}
			System.out.println("------------");
			
			// Select day by index
			int id = input.selectByIndex(storedDays.size());
		
			System.out.println("---------------------------");
			
			storedDays.get(id-1).printTheDayLists();
		
			System.out.println("---------------------------");
			for (Day day : storedDays) {
				if (id == day.getId()) {
					// Set the list of the day or not
					String answer = input.setTheList();
					userSelecting.selectToSetTheList(answer, day);
					break;
				} 
			}
		}
	}
	
	// Add the days to a list
	private List<Day> listOfTheDay() {
		List<Day> storedDays = new ArrayList<>();
		
		for (int i = 1; i < DaysOfTheWeek.values().length + 1 ; i++ ) {
			storedDays.add(new Day(i , DaysOfTheWeek.values()[i - 1]));
		}
		return storedDays;
	}
	
	public static void chooseTheList (Day day) {
		// Select category list by index
		int id = input.selectByIndex(ListCategories.values().length);
		
		for (Entry<Integer, ToDoCategory> entry : day.getCategories().entrySet()) {
			
		    if (id == entry.getKey()) {
		    	userSelecting.selectCategory(entry.getValue().getCategory(), entry.getValue(), day);
		    } 
		}
	}
	
	// Write into the selected category list
	public static void writeIntoTheList (ToDoCategory doCategory, Day day) {
		System.out.println("List: " + doCategory + " of " + day.getDay());
		//Clear the list before it will be updated for the new value (for the new 'DO')
		doCategory.clearListOfTheCategory();
		System.out.println("Write a new ToDO: ");
		String newDo = input.writeIntoTheList();
		//Add the new 'DO'
		doCategory.setToDoList(newDo);
		//Overwrite the file
		day.overWriteTheFile(day);
		
		
		       
	}
}		
