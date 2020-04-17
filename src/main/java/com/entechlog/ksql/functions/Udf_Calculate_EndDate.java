package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;
import java.text.*;

@UdfDescription(
    name = "UDF_CALCULATE_ENDDATE",
    description = "Calculates end date based on a input list/array of dates",
    version = "0.1.0",
    author = "Arul Nadesan / Siva Nadesan"
)
public class Udf_Calculate_EndDate {

    @Udf(description = "Calculates end date based on a input list/array of dates")

    public List < String > udf_Calculate_EndDate(
        @UdfParameter(value = "inputArrayList", description = "Input Array") final List < String > inputArrayList
    ) {

        List < String > outputArrayList = new ArrayList < > ();
        Collections.sort(inputArrayList);

        for (int counter = 1; counter < inputArrayList.size(); counter++) {
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                Date myDate = dateFormat.parse(inputArrayList.get(counter));
                Date oneDayBefore = new Date(myDate.getTime() - 2);
                String previous_day = dateFormat.format(oneDayBefore);
                outputArrayList.add(previous_day);
            } catch (Exception e) {}
        }
        outputArrayList.add("99991231");
        Collections.sort(outputArrayList);
        return outputArrayList;

    }

}
