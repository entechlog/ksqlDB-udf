package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;

@UdfDescription(
    name = "UDF_SORTARRAY",
    description = "Returns sorted list/array",
    version = "0.1.0",
    author = "Arul Nadesan / Siva Nadesan"
)
public class Udf_SortArray {

    @Udf(description = "Returns sorted list/array")

    public List < String > udf_SortArray(
        @UdfParameter(value = "inputArrayList", description = "Input Array") final List < String > inputArrayList,
        @UdfParameter(value = "sortOrder", description = "Sort Order") final String...sortOrder
    ) {

//        List < String > outputArrayList = new ArrayList < > ();
//        outputArrayList = inputArrayList;

        if (sortOrder.length > 0 && sortOrder[0].equals("DESC")) {
            Collections.sort(inputArrayList, Collections.reverseOrder());
            return inputArrayList;
        } else {
            Collections.sort(inputArrayList);
            return inputArrayList;
        }

    }

}