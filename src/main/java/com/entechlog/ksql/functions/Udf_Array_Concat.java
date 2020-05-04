package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;

@UdfDescription(
    name = "UDF_ARRAY_CONCAT",
    description = "Concatenates strings in a List",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_Array_Concat {

    @Udf(description = "Concatenates strings in a List")

    public String udf_Array_Concat(
        @UdfParameter(value = "inputArrayList", description = "Input Array") final List < String > inputArrayList,
        @UdfParameter(value = "inputDelimiter", description = "Filter for output array") final String inputDelimiter
    ) {
        String result = String.join(inputDelimiter, inputArrayList);
        return result;
    }

}
