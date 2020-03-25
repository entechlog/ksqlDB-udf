package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@UdfDescription(
    name = "UDF_HEXTOTEXT",
    description = "Function to convert HEX to TEXT",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_HexToText {

    @Udf(description = "Function to convert HEX to TEXT")
    public String udf_HexToText(
        @UdfParameter(value = "inputHex", description = "Input Value") final String inputHex
    ) {


// Hex To Text

{
    int l = inputHex.length();
	Charset encodingType = StandardCharsets.UTF_8;
    byte[] data = new byte[l / 2];
    for (int i = 0; i < l; i += 2)
    {
        data[i / 2] = (byte) ((Character.digit(inputHex.charAt(i), 16) << 4)
            + Character.digit(inputHex.charAt(i + 1), 16));
    }
    String st = new String(data, encodingType);
    return st;
}

    }

}