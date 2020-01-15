package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import java.math.BigDecimal;

public class SimpleTypeJsonUnmarshallers$BigDecimalJsonUnmarshaller
  implements Unmarshaller<BigDecimal, JsonUnmarshallerContext>
{
  public BigDecimal unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String s = unmarshallerContext.readText();
    return s == null ? null : new BigDecimal(s);
  }
  
  private static final BigDecimalJsonUnmarshaller instance = new BigDecimalJsonUnmarshaller();
  
  public static BigDecimalJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BigDecimalJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */