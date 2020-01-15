package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$LongStaxUnmarshaller
  implements Unmarshaller<Long, StaxUnmarshallerContext>
{
  public Long unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String longString = unmarshallerContext.readText();
    return longString == null ? null : Long.valueOf(Long.parseLong(longString));
  }
  
  private static final LongStaxUnmarshaller instance = new LongStaxUnmarshaller();
  
  public static LongStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */