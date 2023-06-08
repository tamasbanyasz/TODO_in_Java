package todo;

import java.util.Scanner;


/*--------------- Simple TODO ---------------------
 * 
 * Firstly the code make for every day an empty .txt file. (For example: MONDAY.txt)
 * In these .txt files contains all 'DO' things by categories. Lines are equals the categories. (For example: first line = SHOP)
 * Choose a day by index number. 
 * Then you could choose a specific ToDo category of the day by index number.
 * After choosing you could write into.
 * Then the file has been overwritten.
 * 
 */

public class Main {
	
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			new Main().run(scanner);
		}	
	}

	private void run(Scanner scanner) {
		SetTheDo setTheDO = new SetTheDo();
		setTheDO.setState(scanner);
	}
}
