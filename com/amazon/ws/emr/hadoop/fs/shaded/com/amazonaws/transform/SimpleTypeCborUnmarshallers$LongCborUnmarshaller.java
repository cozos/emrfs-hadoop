package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeCborUnmarshallers$LongCborUnmarshaller
  implements Unmarshaller<Long, JsonUnmarshallerContext>
{
  public Long unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return Long.valueOf(unmarshallerContext.getJsonParser().getLongValue());
  }
  
  private static final LongCborUnmarshaller instance = new LongCborUnmarshaller();
  
  public static LongCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.LongCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */