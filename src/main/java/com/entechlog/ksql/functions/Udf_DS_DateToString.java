package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@UdfDescription(
    name = "UDF_DS_DATETOSTRING",
    description = "Returns the string representation of the given date",
    version = "0.1.0",
    author = "Siva Nadesan"
)

public class Udf_DS_DateToString {

    @Udf(description = "Function to return string representation of the given date")
    public String udf_DS_DateToString(
        @UdfParameter(value = "date", description = "Input Date") final Date date,
        @UdfParameter(value = "format", description = "Specify the response string format for the date") final String format
    ) {

        // Set Default Date, Will be used to handle errors 
        Date defaultDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String stringDate = formatter.format(date);
        return stringDate.toString();
    }
}