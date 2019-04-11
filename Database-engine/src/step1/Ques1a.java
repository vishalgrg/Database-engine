package step1;

import java.util.Scanner;

public class Ques1a {

	// Select * from ipl.csv where Season > 2014 and city = 'Benglore'

	public String[] getSplitStrings(String queryString) {
		queryString = queryString.toLowerCase();
		String[] words = queryString.split("\\s+");
		System.out.println("output String :- ");
		for (String word : words) {

			System.out.println(word);
		}

		return words;
	}

	public static void main(String[] args) {
		Ques1a obj = new Ques1a();
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		obj.getSplitStrings(input);

	}

}
