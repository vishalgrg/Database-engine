package step3;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



import java.util.List;
import java.util.Scanner;



public class ReadCSV {

	private static final int  ID_INDEX=0;
	private static final int season_INDEX=1;
	private static final int city_INDEX=2;
	private static final int date_INDEX=3;
	private static final int team1_INDEX=4;
	private static final int team2_INDEX=5;
	private static final int toss_winner_INDEX=6;
	private static final int toss_dicision_INDEX=7;
	private static final int result_INDEX=8;
	private static final int dl_applied_INDEX=9;
	private static final int winner_INDEX=10;
	private static final int win_by_runs_INDEX=11;
	private static final int win_by_wickets_INDEX=12;
	private static final int player_of_match_INDEX=13;
	private static final int venue_INDEX=14;
	private static final int umpire1_INDEX=15;
	private static final int umpire2_INDEX=16;
	private static final int umpire3_INDEX=17;
	
	
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
		try {
			List <CSVHeaders>dataList = new ArrayList<>();
			
			FileReader fr = new FileReader(filePath);
			BufferedReader br = new BufferedReader(fr);
			CSVHeaders csvHeaders = null;
			
			
			
			while(br.readLine() != null){
				String [] raw2 = br.readLine().split("/n");
				String [] raw = br.readLine().split(",");
				
				if(raw.length>0){
					 csvHeaders = new CSVHeaders(Integer.parseInt(raw[ID_INDEX]), 
							Integer.parseInt(raw[season_INDEX]),
							raw[city_INDEX],
							raw[date_INDEX], 
							raw[team1_INDEX], 
							raw[team2_INDEX], 
							raw[toss_winner_INDEX],
							raw[toss_dicision_INDEX],
							raw[result_INDEX],
							Integer.parseInt(raw[dl_applied_INDEX]),
							raw[winner_INDEX],
							Integer.parseInt(raw[win_by_runs_INDEX]),
							Integer.parseInt(raw[win_by_wickets_INDEX]), 
							raw[player_of_match_INDEX], 
							raw[venue_INDEX], 
							raw[umpire1_INDEX], 
							raw[umpire2_INDEX], 
							raw[umpire3_INDEX]);
					
					
					dataList.add(csvHeaders);
					
				}
			}
			
			
			System.out.println("---------output--------");
			for (int i = 0; i <csvHeaders.myout().size(); i++) {
				System.out.println(	csvHeaders.myout().get(i));
			}
			  

	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
