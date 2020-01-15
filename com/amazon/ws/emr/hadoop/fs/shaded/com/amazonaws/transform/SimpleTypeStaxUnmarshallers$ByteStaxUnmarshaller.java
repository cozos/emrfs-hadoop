package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$ByteStaxUnmarshaller
  implements Unmarshaller<Byte, StaxUnmarshallerContext>
{
  public Byte unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String byteString = unmarshallerContext.readText();
    return byteString == null ? null : Byte.valueOf(byteString);
  }
  
  private static final ByteStaxUnmarshaller instance = new ByteStaxUnmarshaller();
  
  public static ByteStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */