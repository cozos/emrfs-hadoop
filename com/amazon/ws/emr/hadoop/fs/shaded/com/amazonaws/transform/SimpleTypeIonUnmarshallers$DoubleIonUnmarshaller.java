package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$DoubleIonUnmarshaller
  implements Unmarshaller<Double, JsonUnmarshallerContext>
{
  public Double unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Double.valueOf(context.getJsonParser().getDoubleValue());
  }
  
  private static final DoubleIonUnmarshaller instance = new DoubleIonUnmarshaller();
  
  public static DoubleIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.DoubleIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */