package step5;

import java.util.HashMap;

public class Query {

	@SuppressWarnings("rawtypes")
	public HashMap executeQuery(String queryString) {

		QueryParser queryParser = new QueryParser();

		/*
		 * call parseQuery() method of the class by passing the queryString
		 * which will return object of QueryParameter
		 */
		QueryParameter queryParameter = queryParser.parseQuery(queryString);

		CsvQueryProcessor csvQueryProcessor = new CsvQueryProcessor();
		try {
			return csvQueryProcessor.getResultSet(queryParameter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}