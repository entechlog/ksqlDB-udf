package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.List;
import java.util.ArrayList;

@UdfDescription(
        name = "UDF_MERLIN_PARSE_RATES",
        description = "Returns Array of age bands for rates",
        version = "0.1.0",
        author = "Siva Nadesan"
)
public class Udf_Merlin_Get_Rates {

    @Udf(description = "Returns Array of age bands for rates")

    public List < String > udf_Merlin_Get_Rates(
            @UdfParameter(value = "inputArrayList", description = "Input Array") final List < String > inputArrayList,
            @UdfParameter(value = "inputFilter", description = "Filter for output array") final String inputFilter
    ) {

        List < String > result = new ArrayList < > (); // output list of Strings
        if (inputFilter.toLowerCase().equals("start")) { // block to filter start values
            result.add(0 + ""); // +"" converts the added value to a string
            for (int i = 1; i < inputArrayList.size(); i++) {
                if (!inputArrayList.get(i - 1).equals(inputArrayList.get(i))) { //if previous and current values are not same, add i+1 to the list
                    result.add(i + 1 + "");
                }
            }
        } else if (inputFilter.toLowerCase().equals("end")) { // block to filter end values
            for (int i = 1; i < inputArrayList.size(); i++) {
                if (!inputArrayList.get(i - 1).equals(inputArrayList.get(i))) { //if previous and current values are not same, add i to the list
                    result.add(i + "");
                }
            }
            result.add(inputArrayList.size() + "");
        } else if (inputFilter.toLowerCase().equals("rate")) { //block to filter rate values
            for (int i = 0; i < inputArrayList.size(); i++) {
                if (!result.contains(inputArrayList.get(i))) { // to add unique elements in the list
                    result.add(inputArrayList.get(i));
                }
            }
        }
        return result;
    }

}