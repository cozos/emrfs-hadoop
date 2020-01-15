package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;

public class SimpleTypeIonUnmarshallers$IntegerIonUnmarshaller
  implements Unmarshaller<Integer, JsonUnmarshallerContext>
{
  public Integer unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return Integer.valueOf(context.getJsonParser().getIntValue());
  }
  
  private static final IntegerIonUnmarshaller instance = new IntegerIonUnmarshaller();
  
  public static IntegerIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.IntegerIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */