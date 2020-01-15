package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.math.BigInteger;

public class SimpleTypeCborUnmarshallers$BigIntegerCborUnmarshaller
  implements Unmarshaller<BigInteger, JsonUnmarshallerContext>
{
  public BigInteger unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    JsonParser parser = unmarshallerContext.getJsonParser();
    JsonToken current = parser.getCurrentToken();
    if (current == JsonToken.VALUE_NUMBER_INT) {
      return parser.getBigIntegerValue();
    }
    if (current == JsonToken.VALUE_EMBEDDED_OBJECT)
    {
      Object embedded = parser.getEmbeddedObject();
      return new BigInteger((byte[])embedded);
    }
    throw new SdkClientException("Invalid BigInteger Format.");
  }
  
  private static final BigIntegerCborUnmarshaller instance = new BigIntegerCborUnmarshaller();
  
  public static BigIntegerCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.BigIntegerCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */