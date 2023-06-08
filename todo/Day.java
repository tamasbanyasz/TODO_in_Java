package todo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day extends FileHandling{
	
	// Day id
	private Integer id;
	
	// Day name
	private DaysOfTheWeek day;
	
	// List of the categories
	private Map<Integer, ToDoCategory> categorys = new HashMap<>();

	public Day(Integer id, DaysOfTheWeek day) {
		this.day = day;
		this.id = id;
		
		//Add the categories to the days
		addCategorys();
		
		// Create empty .txt file
		createFirstAnEmptyFile(day);
		
		// Load the contains of categories from the saved files
		loadTheCategoriesFromTheFiles();
		
	}

	public DaysOfTheWeek getDay() {
		return day;
	}
	
	public Integer getId() {
		return id;
	}
	
	public Map<Integer, ToDoCategory> getCategories() {
		return categorys;
	}
	
	// Add the list of categories to the days
	private void addCategorys() {
		for (int i = 1; i < ListCategories.values().length + 1 ; i++ ) {
			categorys.put(i , new ToDoCategory(ListCategories.values()[i - 1], i));
		}
	}
	
	// Print the day and the category lists
	public void printTheDayLists() {
	System.out.println("The "+ day +" ToDo lists: ");
	for (Map.Entry<Integer, ToDoCategory> entry : categorys.entrySet()) {
	    System.out.println(" " + entry.getKey() + " : " + entry.getValue());
		}
	}
	
	// Load the contains of the categories
	private void loadTheCategoriesFromTheFiles() {
		List<String> loadedContains = load(day);
		for (Map.Entry<Integer, ToDoCategory> entry : categorys.entrySet()) {
		    for (int i = 1; i < loadedContains.size() + 1; i++) {
		    	if(entry.getKey() == i) {
		    		entry.getValue().setToDoList(loadedContains.get(i-1));
		    	} 
		    }
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" " + id + " " + day);

		return builder.toString();
	}
}
