package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.math.BigInteger;

public class SimpleTypeIonUnmarshallers$BigIntegerIonUnmarshaller
  implements Unmarshaller<BigInteger, JsonUnmarshallerContext>
{
  public BigInteger unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return context.getJsonParser().getBigIntegerValue();
  }
  
  private static final BigIntegerIonUnmarshaller instance = new BigIntegerIonUnmarshaller();
  
  public static BigIntegerIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BigIntegerIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */