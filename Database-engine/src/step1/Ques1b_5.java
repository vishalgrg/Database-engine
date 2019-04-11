package step1;

import java.util.Scanner;

public class Ques1b_5 {
	// select city,winter,player_match from ipl.csv where season > 2014 and city = "bang" or date > '31-12-2014'
	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input != null && !input.isEmpty()) {
			if(input.contains("and")){
				System.out.println("and");
			}if(input.contains("or")){
				System.out.println("or");
			}
		}else{
			System.out.println("enter valid input");
		}
	}
}
