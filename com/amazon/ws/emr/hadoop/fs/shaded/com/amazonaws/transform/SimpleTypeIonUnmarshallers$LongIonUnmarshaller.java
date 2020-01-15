package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$LongIonUnmarshaller
  implements Unmarshaller<Long, JsonUnmarshallerContext>
{
  public Long unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Long.valueOf(context.getJsonParser().getLongValue());
  }
  
  private static final LongIonUnmarshaller instance = new LongIonUnmarshaller();
  
  public static LongIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.LongIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */