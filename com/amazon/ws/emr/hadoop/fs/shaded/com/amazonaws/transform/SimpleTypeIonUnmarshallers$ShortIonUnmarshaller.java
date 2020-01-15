package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$ShortIonUnmarshaller
  implements Unmarshaller<Short, JsonUnmarshallerContext>
{
  public Short unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Short.valueOf(context.getJsonParser().getShortValue());
  }
  
  private static final ShortIonUnmarshaller instance = new ShortIonUnmarshaller();
  
  public static ShortIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ShortIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */