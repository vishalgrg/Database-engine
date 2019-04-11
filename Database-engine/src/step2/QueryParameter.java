package step2;

import java.util.List;

public class QueryParameter {
	
	private String queryString;
	private String file;
	private String baseQuery;
	private List<String> fields;
	private String QUERY_TYPE;
	private Restriction[]restrictions;
    private List<AggregateFunction> aggregateListFunctions;
    private List<String> orderByFields;
    private List<String> groupByFields ;
    private AggregateFunction[] aggregateFunctions;
    
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(String baseQuery) {
		this.baseQuery = baseQuery;
	}
	
	public List<String> getFields() {
		return fields;
	}
	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	public String getQUERY_TYPE() {
		return QUERY_TYPE;
	}
	public void setQUERY_TYPE(String qUERY_TYPE) {
		QUERY_TYPE = qUERY_TYPE;
	}
	public Restriction[] getRestrictions() {
		return restrictions;
	}
	public void setRestrictions(Restriction[] restrictions) {
		this.restrictions = restrictions;
	}
	
	public List<String> getOrderByFields() {
		return orderByFields;
	}
	public void setOrderByFields(List<String> orderByFields) {
		this.orderByFields = orderByFields;
	}
	public List<String> getGroupByFields() {
		return groupByFields;
	}
	public void setGroupByFields(List<String> groupByFields) {
		this.groupByFields = groupByFields;
	}
	public List<AggregateFunction> getAggregateListFunctions() {
		return aggregateListFunctions;
	}
	public void setAggregateListFunctions(List<AggregateFunction> aggregateListFunctions) {
		this.aggregateListFunctions = aggregateListFunctions;
	}
	public AggregateFunction[] getAggregateFunctions() {
		return aggregateFunctions;
	}
	public void setAggregateFunctions(AggregateFunction[] aggregateFunctions) {
		this.aggregateFunctions = aggregateFunctions;
	}
	
    
    
    
    
    
    
    
    
}
