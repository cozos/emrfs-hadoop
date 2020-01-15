package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$DoubleCborUnmarshaller
  implements Unmarshaller<Double, JsonUnmarshallerContext>
{
  public Double unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Double.valueOf(unmarshallerContext.getJsonParser().getDoubleValue());
  }
  
  private static final DoubleCborUnmarshaller instance = new DoubleCborUnmarshaller();
  
  public static DoubleCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.DoubleCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */