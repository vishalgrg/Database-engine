package step1;

import java.util.Scanner;

public class Ques1b_4 {
	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			String[] parts = input.split("where");
			System.out.println("Output String: ");
			parts =  parts[1].split("and");
			for (int i = 0; i < parts.length; i++) {
				System.out.println(parts[i]);
			}

		}else{
			System.out.println("Enter valid input");
			
		}
	}
}
