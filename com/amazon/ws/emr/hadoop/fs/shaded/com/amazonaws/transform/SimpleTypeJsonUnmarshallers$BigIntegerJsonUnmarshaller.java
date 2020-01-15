package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.math.BigInteger;

public class SimpleTypeJsonUnmarshallers$BigIntegerJsonUnmarshaller
  implements Unmarshaller<BigInteger, JsonUnmarshallerContext>
{
  public BigInteger unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String intString = unmarshallerContext.readText();
    return intString == null ? null : new BigInteger(intString);
  }
  
  private static final BigIntegerJsonUnmarshaller instance = new BigIntegerJsonUnmarshaller();
  
  public static BigIntegerJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BigIntegerJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */