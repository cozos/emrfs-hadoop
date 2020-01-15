package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.math.BigInteger;

public class SimpleTypeStaxUnmarshallers$BigIntegerStaxUnmarshaller
  implements Unmarshaller<BigInteger, StaxUnmarshallerContext>
{
  public BigInteger unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String s = unmarshallerContext.readText();
    return s == null ? null : new BigInteger(s);
  }
  
  private static final BigIntegerStaxUnmarshaller instance = new BigIntegerStaxUnmarshaller();
  
  public static BigIntegerStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BigIntegerStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */