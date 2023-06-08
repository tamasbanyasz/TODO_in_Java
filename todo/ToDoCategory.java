package todo;

import java.util.ArrayList;
import java.util.List;

public class ToDoCategory {
	
	// Category name
	private ListCategories category;
	private Integer categoryId;
	// List of the category
	private List<String> listOfTheCategory = new ArrayList<>();
	
	public ToDoCategory(ListCategories categories, Integer index) {
		this.category = categories;
		this.categoryId = index;
		
	}

	public ListCategories getCategory() {
		return category;
	}
	
	public Integer getCategoryId() {
		return categoryId;
	}
	
	public List<String> getTheList() {
		return listOfTheCategory;
	}

	public void clearListOfTheCategory() {
		listOfTheCategory.clear();
	}
	
	public void setToDoList(String newToDo) {
		listOfTheCategory.add(newToDo);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(category + ": " + listOfTheCategory);

		return builder.toString();
	}
}
