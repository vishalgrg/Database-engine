package step1;

import java.util.Scanner;

public class Ques1b_7 {
	//  select * from ipl.csv where season > 2016 and city= 'Bangalore' order by win_by_runs
	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			String[] parts = input.split("order by");
			 System.out.println(parts[1]);
			

		} else {
			System.out.println("enter valid input");
		}
	}
}
