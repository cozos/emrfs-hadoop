package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$FloatCborUnmarshaller
  implements Unmarshaller<Float, JsonUnmarshallerContext>
{
  public Float unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Float.valueOf(unmarshallerContext.getJsonParser().getFloatValue());
  }
  
  private static final FloatCborUnmarshaller instance = new FloatCborUnmarshaller();
  
  public static FloatCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.FloatCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */