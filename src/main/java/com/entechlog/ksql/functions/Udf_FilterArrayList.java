package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.util.*;

@UdfDescription(
    name = "UDF_FILTERARRAYLIST",
    description = "Creates a subset of array based on given start and end position",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_FilterArrayList {

    @Udf(description = "Creates a subset of array based on given start and end position")
	
    public List<String> udf_FilterArrayList(
        @UdfParameter(value = "arrayList", description = "Input Array") final List<String> arrayList,
		@UdfParameter(value = "start", description = "Starting position of array") final int start,
		@UdfParameter(value = "end", description = "Ending postion of array") final int end
    ) {
        if(end < start || start <=0 || end > arrayList.size())//to handle invalid start,end
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        for(int i = start - 1; i <= (end - 1); i++)// -1,since indexing start from 0
        {
            result.add(arrayList.get(i));
        }
        return result;
    }

}