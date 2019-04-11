package step1;

import java.util.Scanner;

public class Ques1b_1 {

	// Select * from ipl.csv where Season > 2014 and city = 'Benglore'

	// get and display the filename
	public String getFile(String queryString) {

		queryString = queryString.toLowerCase();
		String fileName = queryString.split("from")[1].split("\\s+")[1];
		System.out.println("File Name : " + fileName);
		return fileName;
	}

	public static void main(String[] args) {
		System.out.print("Input String: ");

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		new Ques1b_1().getFile(input);

	}

}
