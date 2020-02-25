package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
    name = "UDF_REPLACEALL",
    description = "Calls Java String ReplaceAll",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_ReplaceAll {

    @Udf(description = "Calls Java String ReplaceAll")
    public String udf_ReplaceAll(
        @UdfParameter(value = "inputString", description = "Input Value") final String inputString,
        @UdfParameter(value = "regex", description = "Regular expression") final String regex,
        @UdfParameter(value = "replacement", description = "Replacement String") final String replacement
    ) {

        String outputString = inputString.replaceAll(regex, replacement);
        return outputString;
    }

}