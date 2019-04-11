package step3;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVHeaders {

	private int id;
	private int season;
	private String city;
	private String date;
	private String team1;
	private String team2;
	private String toss_winner;
	private String toss_decision;
	private String result;
	private int dl_applied;
	private String winner;
	private int win_by_runs;
	private int win_by_wickets;
	private String player_of_match;
	private String venue;
	private String umpire1;
	private String umpire2;
	private String umpire3;

	private String[] mm;

	public CSVHeaders(int id, int season, String city, String date, String team1, String team2, String toss_winner,
			String toss_decision, String result, int dl_applied, String winner, int win_by_runs, int win_by_wickets,
			String player_of_match, String venue, String umpire1, String umpire2, String umpire3) {
		super();
		this.id = id;
		this.season = season;
		this.city = city;
		this.date = date;
		this.team1 = team1;
		this.team2 = team2;
		this.toss_winner = toss_winner;
		this.toss_decision = toss_decision;
		this.result = result;
		this.dl_applied = dl_applied;
		this.winner = winner;
		this.win_by_runs = win_by_runs;
		this.win_by_wickets = win_by_wickets;
		this.player_of_match = player_of_match;
		this.venue = venue;
		this.umpire1 = umpire1;
		this.umpire2 = umpire2;
		this.umpire3 = umpire3;

	}

	
	public ArrayList myout() {

		ArrayList<String> arrayList = new ArrayList<>();

		arrayList.add("id: " + Integer.valueOf(id).getClass().getName());
		arrayList.add("season: " + Integer.valueOf(season).getClass().getName());
		arrayList.add("date: " + date.getClass().getName());
		arrayList.add("team1: " + team1.getClass().getName());
		arrayList.add("team2: " + team2.getClass().getName());
		arrayList.add("toss_winner: " + toss_winner.getClass().getName());
		arrayList.add("toss_dicision: " + toss_decision.getClass().getName());
		arrayList.add("dl_applied: " + Integer.valueOf(dl_applied).getClass().getName());
		arrayList.add("winner: " + winner.getClass().getName());
		arrayList.add("win_by_runs: " + Integer.valueOf(win_by_runs).getClass().getName());
		arrayList.add("win_by_wickets: " + Integer.valueOf(win_by_wickets).getClass().getName());
		arrayList.add("player_of_match: " + player_of_match.getClass().getName());
		arrayList.add("venue: " + venue.getClass().getName());

		arrayList.add("umpire1: " + umpire1.getClass().getName());

		arrayList.add("umpire2: " + umpire2.getClass().getName());
		arrayList.add("umpire3: " + umpire3.getClass().getName());
		return arrayList;

	}

}
