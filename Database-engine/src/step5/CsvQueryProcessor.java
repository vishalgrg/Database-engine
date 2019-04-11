package step5;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CsvQueryProcessor implements QueryProcessingEngine {
	/*
	 * This method will take QueryParameter object as a parameter which contains
	 * the parsed query and will process and populate the ResultSet
	 */
	public DataSet getResultSet(QueryParameter queryParameter) throws Exception {

		FileReader fileReader = new FileReader("D:\\core java assissment\\Step5_test\\src\\data\\ipl.csv");
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String[] headers = bufferedReader.readLine().split(",");
		bufferedReader.mark(1);

		String[] fields = bufferedReader.readLine().split(",", headers.length);

		Header headerMap = new Header();
		for (int i = 0; i < headers.length; i++) {
			headerMap.put(headers[i].trim(), i);
		}

		/*
		 * We have read the first line of text already and kept it in an array.
		 * Now, we can populate the RowDataTypeDefinition Map object.
		 * RowDataTypeDefinition map is having data type <Integer,String> to
		 * contain the index of the field and it's data type. To find the
		 * dataType by the field value, we will use getDataType() method of
		 * DataTypeDefinitions class
		 */
		RowDataTypeDefinitions rowDataTypeDefinitionMap = new RowDataTypeDefinitions();
		for (int i = 0; i < fields.length; i++) {
			rowDataTypeDefinitionMap.put(i, (String) DataTypeDefinitions.getDataTypes(fields[i]));
		}

		/*
		 * once we have the header and dataTypeDefinitions maps populated, we
		 * can start reading from the first line. We will read one line at a
		 * time, then check whether the field values satisfy the conditions
		 * mentioned in the query,if yes, then we will add it to the resultSet.
		 * Otherwise, we will continue to read the next line. We will continue
		 * this till we have read till the last line of the CSV file.
		 */

		/*
		 * reset the buffered reader so that it can start reading from the first
		 * line
		 */
		bufferedReader.reset();

		DataSet dataSet = new DataSet();
		long setRowIndex = 1;
		Filter filter = new Filter();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] rowFields = line.split(",", headers.length);
			boolean result = false;
			ArrayList<Boolean> bools = new ArrayList<Boolean>();
			if (queryParameter.getRestrictions() == null)
				result = true;
			else {
				for (int i = 0; i < queryParameter.getRestrictions().size(); i++) {
					int index = headerMap.get(queryParameter.getRestrictions().get(i).getPropertyName());
					bools.add(filter.evaluateExpression(queryParameter.getRestrictions().get(i),
							rowFields[index].trim(), rowDataTypeDefinitionMap.get(index)));
				}
				result = solveOperators(bools, queryParameter.getLogicalOperators());
			}
			if (result) {
				Row rowMap = new Row();
				for (int i = 0; i < queryParameter.getFields().size(); i++) {
					if (queryParameter.getFields().get(i).equals("*")) {
						for (int j = 0; j < rowFields.length; j++) {
							rowMap.put(headers[j].trim(), rowFields[j]);
						}
					} else {
						rowMap.put(queryParameter.getFields().get(i),
								rowFields[headerMap.get(queryParameter.getFields().get(i))]);
					}
				}
				dataSet.put(setRowIndex++, rowMap);

			}
		}
		bufferedReader.close();
		return dataSet;
	}

	private boolean solveOperators(ArrayList<Boolean> bools, List<String> operators) {
		if (bools.size() == 1) {
			return bools.get(0);
		} else if (bools.size() == 2) {
			if (operators.get(0).matches("AND|and"))
				return bools.get(0) & bools.get(1);
			else
				return bools.get(0) | bools.get(1);
		} else if (bools.size() == 3) {
			int i = operators.indexOf("AND|and");
			boolean res;
			if (i < 0)
				return bools.get(0) | bools.get(1) | bools.get(2);
			else if (i == 0)
				return bools.get(0) & bools.get(1) | bools.get(2);
			else if (i == 1)
				return bools.get(0) | bools.get(1) & bools.get(2);
			else
				return false;

		} else
			return false;
	}

}