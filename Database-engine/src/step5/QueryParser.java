package step5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class QueryParser {

	private QueryParameter queryParameter = new QueryParameter();

	/*
	 * This method will parse the queryString and will return the object of
	 * QueryParameter class
	 */
	public QueryParameter parseQuery(String queryString) {
		queryParameter.setFileName(getFileName(queryString));
		queryParameter.setBaseQuery(getBaseQuery(queryString));
		queryParameter.setOrderByFields(getOrderByFields(queryString));
		queryParameter.setGroupByFields(getGroupByFields(queryString));
		queryParameter.setFields(getFields(queryString));
		queryParameter.setLogicalOperators(getLogicalOperators(queryString));
		queryParameter.setAggregateFunctions(getAggregateFunctions(queryString));
		queryParameter.setRestrictions(getConditions(queryString));
		return queryParameter;
	}

	/*
	 * extract the name of the file from the query. File name can be found after
	 * the "from" clause.
	 */
	public String getFileName(String queryString) {
		String strFrom = queryString.split("from")[1].trim();
		String strFileName = strFrom.split(" ")[0].trim();
		return strFileName;
	}

	public ArrayList<String> getOrderByFields(String queryString) {
		String str = queryString.toLowerCase();
		String[] strOrderByFields = null;
		ArrayList<String> list = new ArrayList<String>();
		if (str.contains("order by")) {
			String strNotWhere = str.split("order by")[1].trim();
			if (strNotWhere.contains(",")) {
				strOrderByFields = strNotWhere.split(",");
				for (int i = 0; i < strOrderByFields.length; i++) {
					list.add(strOrderByFields[i]);
				}
			} else {
				list.add(strNotWhere);
			}
			return list;
		} else {
			return null;
		}
	}

	public ArrayList<String> getGroupByFields(String queryString) {
		String str = queryString.toLowerCase();
		String[] strGroupByFields = null;
		ArrayList<String> list = new ArrayList<String>();
		if (str.contains("where") && (str.contains("group by")) && str.contains("order by")) {
			String whereString = str.split("where")[1].trim();
			String groupByString = whereString.split("group by")[1].trim();
			String strbeforeOrderBy = groupByString.split("order by")[0].trim();
			if (strbeforeOrderBy.contains(",")) {
				strGroupByFields = strbeforeOrderBy.split(",");
				for (int i = 0; i < strGroupByFields.length; i++) {
					list.add(strGroupByFields[i]);
				}
			} else {
				list.add(strbeforeOrderBy);
			}
			return list;
		} else if (str.contains("group by")) {
			String notWhereString = str.split("group by")[1].trim();
			if (notWhereString.contains(",")) {
				strGroupByFields = notWhereString.split(",");
				for (int i = 0; i < strGroupByFields.length; i++) {
					list.add(strGroupByFields[i]);
				}
			} else {
				list.add(notWhereString);
			}
			return list;
		} else {
			return null;
		}
	}

	public ArrayList<String> getFields(String queryString) {
		String strSelect = queryString.toLowerCase().split("select")[1].trim();
		String strFrom = strSelect.split("from")[0].trim();
		String[] selectFields = null;
		ArrayList<String> list = new ArrayList<String>();
		if (strFrom.contains(",")) {
			selectFields = strFrom.split(",");
			for (int i = 0; i < selectFields.length; i++) {
				list.add(selectFields[i].trim());
			}
			return list;
		} else {
			list.add(strFrom);
			return list;
		}
	}

	public List<Restriction> getConditions(String queryString) {

		String inlower = queryString.trim();
		String tokens[] = inlower.trim().split("where");

		if (tokens.length == 1) {
			return null;
		}

		String conditions[] = tokens[1].trim().split("order by|group by");
		String indi[] = conditions[0].trim().split(" and | or ");
		List<Restriction> restrictionList = new LinkedList<Restriction>();
		for (String string : indi) {
			String condition = "";
			if (string.contains(">=")) {
				condition = ">=";
			} else if (string.contains("<=")) {
				condition = "<=";
			} else if (string.contains("!=")) {
				condition = "!=";
			} else if (string.contains(">")) {
				condition = ">";
			} else if (string.contains("<")) {
				condition = "<";
			} else if (string.contains("=")) {
				condition = "=";
			}
			String name = string.split(condition)[0].trim();
			String value = string.split(condition)[1].trim().replaceAll("'", "");
			Restriction restrictionInstance = new Restriction(name, value, condition);
			restrictionList.add(restrictionInstance);
		}
		return restrictionList;
	}

	public ArrayList<String> getLogicalOperators(String queryString) {
		String str = queryString.toLowerCase();
		String[] strAndOr = null;
		ArrayList<String> list = new ArrayList<String>();
		if (str.contains("where")) {
			String strwhere = str.split("where")[1].trim();
			strAndOr = strwhere.split(" ");
			for (int i = 0; i < strAndOr.length; i++) {
				if (strAndOr[i].equals("and") || strAndOr[i].equals("or")) {
					list.add(strAndOr[i]);
				}
			}
			return list;
		} else {
			return null;
		}
	}

	public ArrayList<AggregateFunction> getAggregateFunctions(String queryString) {
		String strFrom = queryString.toLowerCase().split("from")[0].trim();
		String strSelect = strFrom.split("select")[1].trim();
		String[] strFieldsAndAggrfunc = strSelect.split(",");
		ArrayList<String> myAggrFuncList = new ArrayList<String>();
		ArrayList<AggregateFunction> list = new ArrayList<AggregateFunction>();
		for (int i = 0; i < strFieldsAndAggrfunc.length; i++) {
			if (strFieldsAndAggrfunc[i].contains("(")) {
				myAggrFuncList.add(strFieldsAndAggrfunc[i].trim());
			}
		}
		int listSize = myAggrFuncList.size();
		if (listSize == 0) {
			return null;
		} else {
			for (int i = 0; i < listSize; i++) {
				String[] aggrFuncArray = myAggrFuncList.get(i).split("\\(|\\)");
				AggregateFunction af = new AggregateFunction(aggrFuncArray[1], aggrFuncArray[0]);
				list.add(af);
			}
			return list;
		}
	}

	public String getBaseQuery(String queryString) {
		String strBaseQuery = "";
		if (queryString.contains("where")) {
			strBaseQuery = queryString.toLowerCase().split("where")[0].trim();
		} else if (queryString.contains("group by") || queryString.contains("order by")) {
			strBaseQuery = queryString.toLowerCase().split("group by|order by")[0].trim();
		} else {
			strBaseQuery = queryString;
		}
		return strBaseQuery;
	}
}
