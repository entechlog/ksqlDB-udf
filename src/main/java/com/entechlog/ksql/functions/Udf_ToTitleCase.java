package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

@UdfDescription(
    name = "UDF_TOTITLECASE",
    description = "Return capitalized version of first character in each word",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_ToTitleCase {

  @Udf(description = "Given a string as input, returns a string with capitalized version of first character in each word")
  public String udf_ToTitleCase(
      @UdfParameter(value = "source", description = "the value to capitalize")
      final String source
  ) {
    String[] arr = source.split(" ");
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < arr.length; i++) {
        sb.append(Character.toUpperCase(arr[i].charAt(0)))
            .append(arr[i].substring(1)).append(" ");
    }
	
    return new StringBuilder(sb).toString();
  }

}
