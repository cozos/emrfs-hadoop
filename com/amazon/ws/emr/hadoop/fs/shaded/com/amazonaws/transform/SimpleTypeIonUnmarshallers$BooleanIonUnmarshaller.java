package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$BooleanIonUnmarshaller
  implements Unmarshaller<Boolean, JsonUnmarshallerContext>
{
  public Boolean unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Boolean.valueOf(context.getJsonParser().getBooleanValue());
  }
  
  private static final BooleanIonUnmarshaller instance = new BooleanIonUnmarshaller();
  
  public static BooleanIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.BooleanIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */