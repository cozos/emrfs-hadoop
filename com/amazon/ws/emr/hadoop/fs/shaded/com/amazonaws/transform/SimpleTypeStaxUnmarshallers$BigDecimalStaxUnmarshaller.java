package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.math.BigDecimal;

public class SimpleTypeStaxUnmarshallers$BigDecimalStaxUnmarshaller
  implements Unmarshaller<BigDecimal, StaxUnmarshallerContext>
{
  public BigDecimal unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String s = unmarshallerContext.readText();
    return s == null ? null : new BigDecimal(s);
  }
  
  private static final BigDecimalStaxUnmarshaller instance = new BigDecimalStaxUnmarshaller();
  
  public static BigDecimalStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BigDecimalStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */