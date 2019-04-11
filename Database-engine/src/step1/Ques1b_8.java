package step1;

import java.util.Scanner;

// select team1, sum(win_by_runs) from ipl.csv where season > 2016 and city= 'Bangalore' group by team1
public class Ques1b_8 {
	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			String[] parts = input.split("group by");
			System.out.print("output String: ");
			 System.out.println(parts[1]);
			

		} else {
			System.out.println("enter valid input");
		}
	}
}
