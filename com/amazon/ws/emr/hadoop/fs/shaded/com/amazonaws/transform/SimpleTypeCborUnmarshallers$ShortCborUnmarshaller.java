package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$ShortCborUnmarshaller
  implements Unmarshaller<Short, JsonUnmarshallerContext>
{
  public Short unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Short.valueOf(unmarshallerContext.getJsonParser().getShortValue());
  }
  
  private static final ShortCborUnmarshaller instance = new ShortCborUnmarshaller();
  
  public static ShortCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ShortCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */