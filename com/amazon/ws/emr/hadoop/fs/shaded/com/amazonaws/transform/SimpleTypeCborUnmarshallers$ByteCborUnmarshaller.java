package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$ByteCborUnmarshaller
  implements Unmarshaller<Byte, JsonUnmarshallerContext>
{
  public Byte unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Byte.valueOf(unmarshallerContext.getJsonParser().getByteValue());
  }
  
  private static final ByteCborUnmarshaller instance = new ByteCborUnmarshaller();
  
  public static ByteCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ByteCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */