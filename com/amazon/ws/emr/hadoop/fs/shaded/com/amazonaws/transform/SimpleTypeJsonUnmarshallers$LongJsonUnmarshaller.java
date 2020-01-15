package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$LongJsonUnmarshaller
  implements Unmarshaller<Long, JsonUnmarshallerContext>
{
  public Long unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String longString = unmarshallerContext.readText();
    return longString == null ? null : Long.valueOf(Long.parseLong(longString));
  }
  
  private static final LongJsonUnmarshaller instance = new LongJsonUnmarshaller();
  
  public static LongJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.LongJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */