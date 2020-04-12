package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;

@UdfDescription(
    name = "UDF_ARRAYLEN",
    description = "Returns lenght of an Array",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_ArrayLen {

    @Udf(description = "Returns lenght of an Array")
	
    public int udf_ArrayLen(
        @UdfParameter(value = "arrayList", description = "Input Array") final List<String> arrayList
    ) {
        return arrayList.size();
    }

}
