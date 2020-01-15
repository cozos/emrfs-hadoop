package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$StringStaxUnmarshaller
  implements Unmarshaller<String, StaxUnmarshallerContext>
{
  public String unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return unmarshallerContext.readText();
  }
  
  private static final StringStaxUnmarshaller instance = new StringStaxUnmarshaller();
  
  public static StringStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */