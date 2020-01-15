package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.math.BigDecimal;

public class SimpleTypeIonUnmarshallers$BigDecimalIonUnmarshaller
  implements Unmarshaller<BigDecimal, JsonUnmarshallerContext>
{
  public BigDecimal unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return context.getJsonParser().getDecimalValue();
  }
  
  private static final BigDecimalIonUnmarshaller instance = new BigDecimalIonUnmarshaller();
  
  public static BigDecimalIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BigDecimalIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */