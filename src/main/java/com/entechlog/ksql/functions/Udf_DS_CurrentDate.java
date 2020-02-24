package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;

@UdfDescription(
    name = "UDF_DS_CURRENTDATE",
    description = "Returns the current date in YYYY-MM-DD format",
    version = "0.1.0",
    author = "Siva Nadesan"
)

public class Udf_DS_CurrentDate {

  @Udf(description = "Returns the current date in YYYY-MM-DD format")
  
  public String udf_DS_CurrentDate() {
    return ((String) LocalDate.now().toString());
  }

}
