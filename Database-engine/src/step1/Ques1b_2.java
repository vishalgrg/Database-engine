package step1;

import java.util.Scanner;

public class Ques1b_2 {
	// Select * from ipl.csv where Season > 2014 and city = 'Benglore'
		public static void main(String[] args) {
			System.out.print("Input String: ");
			
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			if (input != null && !input.isEmpty()) {
				String[] parts = input.split("where");
				System.out.println("Output String: ");
				System.out.println(parts[0]);
					
				
			}else{
				System.out.println("enter valid input");
			}
		}
}
