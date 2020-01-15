package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.math.BigDecimal;
import java.math.BigInteger;

public class SimpleTypeCborUnmarshallers$BigDecimalCborUnmarshaller
  implements Unmarshaller<BigDecimal, JsonUnmarshallerContext>
{
  public BigDecimal unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    JsonParser parser = unmarshallerContext.getJsonParser();
    Unmarshaller<BigInteger, JsonUnmarshallerContext> bigIntegerUnmarshaller = unmarshallerContext.getUnmarshaller(BigInteger.class);
    
    JsonToken current = parser.getCurrentToken();
    if (current != JsonToken.START_ARRAY) {
      throw new SdkClientException("Invalid BigDecimal Format.");
    }
    parser.nextToken();
    int exponent = parser.getIntValue();
    parser.nextToken();
    BigInteger mantissa = (BigInteger)bigIntegerUnmarshaller.unmarshall(unmarshallerContext);
    return new BigDecimal(mantissa, exponent);
  }
  
  private static final BigDecimalCborUnmarshaller instance = new BigDecimalCborUnmarshaller();
  
  public static BigDecimalCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.BigDecimalCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */