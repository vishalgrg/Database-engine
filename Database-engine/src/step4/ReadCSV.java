package step4;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class ReadCSV {



    // file path - C:\\Users\\VI20047816\\Desktop\\data.csv
	public static void main(String[] args) {
		
		System.out.println("Enter File name");
		
	  Scanner scanner = new Scanner(System.in);
	  String file =  scanner.nextLine();
	  scanner.close();
		
		ReadCSV csv = new ReadCSV();
		csv.readCSVFile(file);
		

	    
	}

	public void readCSVFile(String filePath) {
		
		FileReader filereader;
		try {
			filereader = new FileReader(filePath);
		
		BufferedReader br = new BufferedReader(filereader);
		String strHeader = br.readLine();
		String strFirstRow = br.readLine();
		String[] fields = strFirstRow.split(",",18);
		String[] dataTypeArray = new String[fields.length];
		int count = 0;
		for (String s:fields) {
		
		
			if(s.matches("[0-9]+")) {
				dataTypeArray[count] = "java.lang.Integer";
				count++;
			}else if(s.matches("[0-9]+.[0-9]+")){
				dataTypeArray[count] = "java.lang.Double";
				count++;
			}else if(s.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$")||s.matches("^[0-9]{2}-[a-z]{3}-[0-9]{2}$")||s.matches("^[0-9]{2}-[a-z]{3}-[0-9]{4}$")||s.matches("^[0-9]{2}-[a-z]{3,9}-[0-9]{2}$")||s.matches("^[0-9]{2}-[a-z]{3,9}-[0-9]{4}$")||s.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")){
				dataTypeArray[count] = "java.util.Date";
				count++;
			}else if(s.isEmpty()){
				dataTypeArray[count] = "java.lang.Object";
				count++;
			}
			else {
				dataTypeArray[count] = "java.lang.String";
				count++;
			}			
		}
		
		
		
		for (int i = 0; i < dataTypeArray.length; i++) {
			System.out.println(dataTypeArray[i]);
		}
	}catch (Exception e) {
		// TODO: handle exception
	}
	}
}