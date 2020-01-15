package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$FloatIonUnmarshaller
  implements Unmarshaller<Float, JsonUnmarshallerContext>
{
  public Float unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Float.valueOf(context.getJsonParser().getFloatValue());
  }
  
  private static final FloatIonUnmarshaller instance = new FloatIonUnmarshaller();
  
  public static FloatIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.FloatIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */