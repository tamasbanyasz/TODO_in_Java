package todo;

import java.util.Scanner;

public class UserInputHandler {
	
private final Scanner scanner;
	
	public UserInputHandler(Scanner scanner) {
		this.scanner = scanner;
	}
	
	//Write into the list
	public String writeIntoTheList() {
		return scanner.nextLine();
	}
	
	// Question to set the ToDo or not
	public String setTheList() {
		boolean correctUserInput;
		String userInput;
		
		do {
			System.out.println("Set the list? ('yes' | 'no'): ");
			userInput = scanner.nextLine();

			correctUserInput = false;
			if (userInput.toLowerCase().equals("yes") || userInput.toLowerCase().equals("no")) {
				correctUserInput = true;
			} else {
				System.out.println("Wrong answer!");
			}
		} while (!correctUserInput);
		
		return userInput.toLowerCase();
	}
	
	// Select the by index
	public int selectByIndex(Integer maxInt) {
		boolean correctUserInput;
		String userInput;
		
		do {
			System.out.println("Select by index number: ");
			userInput = scanner.nextLine();
			correctUserInput = true;
			if (!userInput.matches("^[1-"+maxInt+"]{1}")) {
				System.out.println("Invalid input!");
				correctUserInput = false;
			}
		} while (!correctUserInput);
		
		int userNumber = Integer.parseInt(userInput);
		return userNumber;
	}
}
