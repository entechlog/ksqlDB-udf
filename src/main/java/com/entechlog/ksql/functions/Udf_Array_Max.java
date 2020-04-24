package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;
import java.text.*;

@UdfDescription(
    name = "UDF_ARRAY_MAX",
    description = "Returns maximum from a list/array",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_Array_Max {

    @Udf(description = "Returns maximum from a list/array")

    public String udf_Array_Max(
        @UdfParameter(value = "inputArrayList", description = "Input Array") final List < String > inputArrayList
    ) {

        // check list is empty or not 
        if (inputArrayList == null || inputArrayList.size() == 0) {
            return "";
        }

        // create a new list to avoid modification in the original list 
        List < String > sortedList = new ArrayList < > (inputArrayList);

        // sort list in natural order 
        Collections.sort(sortedList);

        // last element in the sorted list would be maximum 
        return sortedList.get(sortedList.size() - 1);
    }

}