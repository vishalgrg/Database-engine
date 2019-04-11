package step1;

import java.util.Scanner;

public class Ques1b_6 {
	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			String[] parts = input.split("from");
			parts = parts[0].split(",");

			for (int i = 0; i < parts.length; i++) {
				if (parts[i].contains("select")) {

					System.out.println(parts[i].replaceAll("select", ""));

				} else {
					System.out.println(parts[i]);
				}
			}
		} else {
			System.out.println("enter valid input");
		}
	}

}
