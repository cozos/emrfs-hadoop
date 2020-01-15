package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$IntegerCborUnmarshaller
  implements Unmarshaller<Integer, JsonUnmarshallerContext>
{
  public Integer unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Integer.valueOf(unmarshallerContext.getJsonParser().getIntValue());
  }
  
  private static final IntegerCborUnmarshaller instance = new IntegerCborUnmarshaller();
  
  public static IntegerCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.IntegerCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */