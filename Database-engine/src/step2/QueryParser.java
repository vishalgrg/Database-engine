package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class QueryParser {

	public QueryParameter parseQuery(String queryString) {

		QueryParameter parameter = new QueryParameter();
		queryString = queryString.toLowerCase();

		parameter.setQueryString(queryString);
		parameter.setBaseQuery(getBaseQuery(queryString));
		parameter.setFile(getFile(queryString));
		parameter.setFields(getFields(queryString));
		parameter.setRestrictions(getConditions(queryString));
		parameter.setAggregateListFunctions(getAggregateListFunctions(queryString));
		parameter.setAggregateFunctions(getAggregateFunctionsArray(queryString));
		parameter.setOrderByFields(getFields(queryString));
		parameter.setGroupByFields(getGroupByFields(queryString));
		
		return parameter;

	}

	// getting the baseQuery and display
	public String getBaseQuery(String queryString) {
		String baseQuery = queryString.split("order by")[0].split("group by")[0].split("where")[0];
		return baseQuery;

	}

	// get and display the filename
	public String getFile(String queryString) {

		String fileName = queryString.split("from")[1].split("\\s+")[1];
		return fileName;
	}

	public List<String> getFields(String queryString) {
		String[] requiredfields = queryString.split("select")[1].trim().split("from")[0].split("[\\s,]+");
		return Arrays.asList(requiredfields);

	}

	public Restriction[] getConditions(String queryString) {
		queryString = queryString.toLowerCase();
		String[] nameAndValue;
		String propertyName, propertyValue, conditionalOperator;

		int counter = 0;
		if (queryString.contains("where")) {
			String whereCondition = queryString.split("order by")[0].trim().split("group by")[0].trim()
					.split("where")[1].trim();
			String[] conditions = whereCondition.split("\\s+and\\s+|\\s+or\\s+");
			Restriction[] arrayRestriction = new Restriction[conditions.length];
		

			for (String condition : conditions) {
				Restriction restriction = new Restriction();
				nameAndValue = condition.split("<=|>=|!=|=|<|>");
				propertyName = nameAndValue[0].trim();
				propertyValue = nameAndValue[1].trim();
				conditionalOperator = condition.split(propertyName)[1].trim().split(propertyValue)[0].trim();

				restriction.setCondition(conditionalOperator);
				restriction.setPropertyName(propertyName);
				restriction.setPropertyValue(propertyValue);

				arrayRestriction[counter] = restriction;
				counter++;
			}
			return arrayRestriction;
		} else {
			return null;
		}
	}

	public List<AggregateFunction> getAggregateListFunctions(String queryString) {
		String aggregateName, aggregateField;
		List<AggregateFunction> aggregateFunctionsList = new ArrayList<AggregateFunction>();
		int counter = 0;
		if (queryString.contains("count") || queryString.contains("sum") || queryString.contains("min")
				|| queryString.contains("max") || queryString.contains("avg")) {

			String[] aggregateFunctions = queryString.split("select")[1].trim().split("from")[0].trim().split(",");

			
			for (String function : aggregateFunctions) {
				AggregateFunction aggregateFunction = new AggregateFunction();

				aggregateName = function.split("\\(")[0].trim();
				aggregateField = function.split("\\(")[1].trim().split("\\)")[0].trim();

				aggregateFunction.setAggregateFieldIndex(counter);
				aggregateFunction.setField(aggregateField);
				aggregateFunction.setFunction(aggregateName);
				aggregateFunctionsList.add(aggregateFunction);
				counter++;

			}
			return aggregateFunctionsList;
		} else {
			return null;
		}
	}
	

	
	public AggregateFunction [] getAggregateFunctionsArray(String queryString) {
		String aggregateName, aggregateField;
		
		int counter = 0;
		if (queryString.contains("count") || queryString.contains("sum") || queryString.contains("min")
				|| queryString.contains("max") || queryString.contains("avg")) {

			String[] aggregateFunctions = queryString.split("select")[1].trim().split("from")[0].trim().split(",");
			AggregateFunction [] arrayOfAggregateFun = new AggregateFunction[aggregateFunctions.length];

			
			for (String function : aggregateFunctions) {
				AggregateFunction aggregateFunction = new AggregateFunction();

				aggregateName = function.split("\\(")[0].trim();
				aggregateField = function.split("\\(")[1].trim().split("\\)")[0].trim();

				aggregateFunction.setAggregateFieldIndex(counter);
				aggregateFunction.setField(aggregateField);
				aggregateFunction.setFunction(aggregateName);
				arrayOfAggregateFun[counter] = aggregateFunction;
				counter++;

			}
			return arrayOfAggregateFun;
		} else {
			return null;
		}
	}
	
	
	
	// get order by fields if order by clause exists
	public List<String> getOrderByFields(String queryString) {
		
		if(queryString.contains("order by"))
		{
			
			String[] orderByField=queryString.split("order by")[1].trim().split("[\\s,]+");
			return Arrays.asList(orderByField);
		}
		else
		{
			return null;
		}
	}
	
	// get group by fields if group by clause exists
	public List<String> getGroupByFields(String queryString) {
		
		if(queryString.contains("group by"))
		{
			
			String[] groupByField=queryString.split("group by")[1].trim().split("[\\s,]+");
			return Arrays.asList(groupByField);
		}
		else
		{
			return null;
		}
}

	public void printRestrictions(Restriction[] restrictions, QueryParameter parameter) {

		int count = 1;

		for (Restriction res : parameter.getRestrictions()) {
			System.out.println("Condition " + count + " :");
			System.out.println("variable : " + res.getPropertyName());
			System.out.println("operator : " + res.getCondition());
			System.out.println("value : " + res.getPropertyValue());
			count++;
		}

		System.out.println("-------------------------------");
	}

	public void printAggregateFunctionsList(List<AggregateFunction> list, QueryParameter parameter) {

		for (AggregateFunction aggregateFunction : list) {

			System.out.println("AggregateFieldIndex " + aggregateFunction.getAggregateFieldIndex() + " :");
			System.out.println("Aggregate Name : " + aggregateFunction.getFunction());
			System.out.println("Aggregate Field : " + aggregateFunction.getField());
			System.out.println("Aggregate Result : " + aggregateFunction.getResult());
		}

		System.out.println("-------------------------------");
	}
	
	
	
	public void printAggregateFunctionsArray(AggregateFunction[] array, QueryParameter parameter) {

		for (AggregateFunction aggregateFunction : array) {

			System.out.println("AggregateFieldIndex " + aggregateFunction.getAggregateFieldIndex() + " :");
			System.out.println("Aggregate Name : " + aggregateFunction.getFunction());
			System.out.println("Aggregate Field : " + aggregateFunction.getField());
			System.out.println("Aggregate Result : " + aggregateFunction.getResult());
		}

		System.out.println("-------------------------------");
	}

	

	public static void main(String[] args) {

		QueryParser parser = new QueryParser();
		QueryParameter parameter;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the query : ");
		String queryString = scanner.nextLine();
		parameter = parser.parseQuery(queryString);
		scanner.close();
		
		

		System.out.println("BASE QUERY: " + parameter.getBaseQuery());

		System.out.println("QUERY STRING: " + parameter.getQueryString());

		System.out.println("QUERY FIELDS: " + parameter.getFields());

		if (parameter.getRestrictions() != null) {
			System.out.println("-----------Restrictions--------");
			parser.printRestrictions(parameter.getRestrictions(), parameter);
		}

		if (parameter.getAggregateListFunctions() != null) {
			System.out.println("-----------Aggregate Functions using List--------");
			parser.printAggregateFunctionsList(parameter.getAggregateListFunctions(), parameter);
		}
		
		if (parameter.getAggregateFunctions() != null) {
			System.out.println("-----------Aggregate Functions using Array--------");
			parser.printAggregateFunctionsArray(parameter.getAggregateFunctions(), parameter);
		}
		
		if (parameter.getOrderByFields() != null) {
			System.out.println("ORDER BY:- "+parameter.getOrderByFields().get(0));
		}
		if (parameter.getGroupByFields() != null) {
			System.out.println("GROUP BY:- "+parameter.getGroupByFields().get(0));
		}
		

	}

}
