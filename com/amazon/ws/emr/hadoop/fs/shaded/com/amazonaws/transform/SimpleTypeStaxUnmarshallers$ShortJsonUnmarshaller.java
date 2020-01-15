package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$ShortJsonUnmarshaller
  implements Unmarshaller<Short, StaxUnmarshallerContext>
{
  public Short unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String shortString = unmarshallerContext.readText();
    return shortString == null ? null : Short.valueOf(shortString);
  }
  
  private static final ShortJsonUnmarshaller instance = new ShortJsonUnmarshaller();
  
  public static ShortJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ShortJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */