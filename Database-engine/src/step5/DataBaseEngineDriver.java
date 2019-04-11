package step5;

import java.util.Scanner;

public class DataBaseEngineDriver {

	public static void main(String[] args) {

		// Read the query from the user
		Scanner sc = new Scanner(System.in);
		String queryString = sc.nextLine();
		sc.close();
		/*
		 * Instantiate Query class. This class is responsible for: 1. Parsing
		 * the query 2. Select the appropriate type of query processor 3. Get
		 * the resultSet which is populated by the Query Processor
		 */
		Query query = new Query();

		/*
		 * Instantiate JsonWriter class. This class is responsible for writing
		 * the ResultSet into a JSON file
		 */
		JsonWriter jsonWriter = new JsonWriter();
		jsonWriter.writeToJson(query.executeQuery(queryString));

	}
}
