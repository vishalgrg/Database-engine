package step6;
/*
 * Implementation of DataTypeDefinitions class. This class contains a method getDataTypes() 
 * which will contain the logic for getting the datatype for a given field value. This
 * method will be called from QueryProcessors.
 *    
 */
public class DataTypeDefinitions {

	// method stub
	public static String getDataTypes(String input) {
		if (input.matches("[0-9]+")) {
			return "java.lang.Integer";
		} else if (input.matches("[0-9]+.[0-9]+")) {
			return "java.lang.Double";
		} else if (input.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$") || input.matches("^[0-9]{2}-[a-z]{3}-[0-9]{2}$")
				|| input.matches("^[0-9]{2}-[a-z]{3}-[0-9]{4}$") || input.matches("^[0-9]{2}-[a-z]{3,9}-[0-9]{2}$")
				|| input.matches("^[0-9]{2}-[a-z]{3,9}-[0-9]{4}$") || input.matches("^[0-9]{4}-[0-9]{2}-[0-9]{2}$")) {
			return "java.util.Date";
		} else if (input.isEmpty()) {
			return "java.lang.Object";
		} else {
			return "java.lang.String";
		}

	}
}
