package step1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import step2.QueryParameter;
import step6.AggregateFunction;

public class Ques1b_9 {

 public static void main(String[] args) {
       System.out.println("Enter the input string-");
       Scanner sc  = new Scanner(System.in);
       String queryString = sc.nextLine();
       Ques1b_9 obj = new Ques1b_9();
     
       
       obj.printAggregateFunctionsList(obj.getAggregateFunctions(queryString.toLowerCase().trim()));
       
       
}
 
 public ArrayList<AggregateFunction> getAggregateFunctions(String queryString) {
		String strFrom = queryString.toLowerCase().split("from")[0].trim();
		String strSelect = strFrom.split("select")[1].trim();
		String[] strFieldsAndAggrfunc = strSelect.split(",");
		ArrayList<String> myAggrFuncList = new  ArrayList<String>();
		ArrayList<AggregateFunction> list = new  ArrayList<AggregateFunction>();
		for(int i = 0;i < strFieldsAndAggrfunc.length;i++) {
			if(strFieldsAndAggrfunc[i].contains("(")) {
				myAggrFuncList.add(strFieldsAndAggrfunc[i].trim());
			}
		}
		int listSize = myAggrFuncList.size();
		if(listSize == 0) {
			return null;
		}else {
			for(int i=0;i<listSize;i++) {
				String[] aggrFuncArray = myAggrFuncList.get(i).split("\\(|\\)");
				AggregateFunction af = new AggregateFunction(aggrFuncArray[1], aggrFuncArray[0]);
				list.add(af);
			}
		return list;
		}
	}
 
 public void printAggregateFunctionsList(List<AggregateFunction> list) {

		for (AggregateFunction aggregateFunction : list) {

			//System.out.println("AggregateFieldIndex " + aggregateFunction.getAggregateFieldIndex() + " :");
			System.out.println("Aggregate Name : " + aggregateFunction.getFunction());
			System.out.println("Aggregate Field : " + aggregateFunction.getField());
			//System.out.println("Aggregate Result : " + aggregateFunction.getResult());
		}

		System.out.println("-------------------------------");
	}
}
