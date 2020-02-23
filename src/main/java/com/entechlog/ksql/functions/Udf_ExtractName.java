package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;
import java.util.*;

@UdfDescription(
    name = "UDF_EXTRACTNAME",
    description = "Function to Extract First Name, Middle Name and Last Name from Full Name",
    version = "0.1.0",
    author = "Siva Nadesan"
)

public class Udf_ExtractName {

    @Udf(description = "Function to Extract First Name, Middle Name and Last Name from Full Name")
    public String udf_ExtractName(
        @UdfParameter(value = "fullName", description = "Full Name") final String fullName,
		@UdfParameter(value = "nameType", description = "Name Type has valid value of firstName, lastName, middleName, suffix") final String nameType
    ) {
    
	String[] components = fullName.split("\\s+");
	
	// Intialize response variables
	String firstName = new String("");
	String lastName = new String("");
	String middleName = new String("");
	String suffix = new String("");
	String emptyString = new String("");

	// Populate Individual Name Fields
    if (components.length == 1) {
        firstName = components[0].trim().toString();
		middleName = "";
	    lastName = "";
		suffix = "";
    } else if (components.length == 2) {
        firstName = components[0].trim().toString();
		middleName = "";
		lastName = components[1].trim().toString();
		suffix = "";
    } else if (components.length == 3) {
		firstName = components[0].trim().toString();
		middleName = components[1].trim().toString();
		lastName = components[2].trim().toString();
		suffix = "";
    } else if (components.length == 4) {
		firstName = components[0].trim().toString();
		middleName = components[1].trim().toString();
		lastName = components[2].trim().toString();
		suffix = components[3].trim().toString();
    } else {
		firstName = "";
		middleName = "";
		lastName = "";
		suffix = "";
    }
	
	// Return Respone
	if (nameType.equals("firstName")) {
        return firstName;
    } else if (nameType.equals("middleName")) {
		return middleName;
    } else if (nameType.equals("lastName")) {
		return lastName;
    } else if (nameType.equals("suffix")) {
		return suffix;
    } else {
		return emptyString;
    }
}
}