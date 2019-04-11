package step5;


import java.io.FileNotFoundException;
import java.io.IOException;



public interface QueryProcessingEngine {

	public DataSet getResultSet(QueryParameter queryParameter) throws FileNotFoundException, IOException, Exception;
	
}
