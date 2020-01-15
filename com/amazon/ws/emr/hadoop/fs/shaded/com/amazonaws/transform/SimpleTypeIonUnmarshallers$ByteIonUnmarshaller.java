package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$ByteIonUnmarshaller
  implements Unmarshaller<Byte, JsonUnmarshallerContext>
{
  public Byte unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Byte.valueOf(context.getJsonParser().getByteValue());
  }
  
  private static final ByteIonUnmarshaller instance = new ByteIonUnmarshaller();
  
  public static ByteIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ByteIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */