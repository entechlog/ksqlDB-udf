package com.entechlog.ksql.functions;

import io.confluent.ksql.function.udf.Udf;
import io.confluent.ksql.function.udf.UdfDescription;
import io.confluent.ksql.function.udf.UdfParameter;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@UdfDescription(
    name = "UDF_TEXTTOHEX",
    description = "Function to convert TEXT to HEX",
    version = "0.1.0",
    author = "Siva Nadesan"
)
public class Udf_TextToHex {

    @Udf(description = "Function to convert TEXT to HEX")
    public String udf_TextToHex(
        @UdfParameter(value = "inputString", description = "Input Value") final String inputString
    ) {


// Text To Hex

{
    byte[] buf = null;
	Charset encodingType = StandardCharsets.UTF_8;
    buf = inputString.getBytes(encodingType);
    char[] HEX_CHARS = "0123456789abcdef".toCharArray();
    char[] chars = new char[2 * buf.length];
    for (int i = 0; i < buf.length; ++i)
    {
        chars[2 * i] = HEX_CHARS[(buf[i] & 0xF0) >>> 4];
        chars[2 * i + 1] = HEX_CHARS[buf[i] & 0x0F];
    }
    return new String(chars);
}
    }

}