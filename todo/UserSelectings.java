package todo;

public class UserSelectings extends SetTheDo {
	
	// Select the day
	public void selectDay(Day day) {
		 
		switch (day.getDay()) {
        case MONDAY -> chooseTheList(day); 

        case TUESDAY -> chooseTheList(day); 
          
        case WEDNESDAY -> chooseTheList(day); 
            
        case THURSDAY -> chooseTheList(day); 
        
        case FRIDAY -> chooseTheList(day); 
        
        case SATURDAY -> chooseTheList(day);
       
        case SUNDAY -> chooseTheList(day); 
        
		} 
	 }
	
	// Choose to set the list or no
	public void selectToSetTheList(String answer, Day day) {
		switch (answer) {
        case "yes" -> selectDay(day);
        
        case "no" -> System.out.println("List unchanged.");
        
		}
	}
	
	// Select the category of the day
	public void selectCategory(ListCategories category, ToDoCategory doCategory, Day day) {
		switch (category) {
		
		case SHOP -> writeIntoTheList(doCategory, day); 

        case WORK -> writeIntoTheList(doCategory, day); 
          
        case HOME -> writeIntoTheList(doCategory, day); 
            
        case DAILY -> writeIntoTheList(doCategory, day); 
        
		}
	}
}
