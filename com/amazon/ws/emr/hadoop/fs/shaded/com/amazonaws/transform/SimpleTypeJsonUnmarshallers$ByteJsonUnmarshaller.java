package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$ByteJsonUnmarshaller
  implements Unmarshaller<Byte, JsonUnmarshallerContext>
{
  public Byte unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String byteString = unmarshallerContext.readText();
    return byteString == null ? null : Byte.valueOf(byteString);
  }
  
  private static final ByteJsonUnmarshaller instance = new ByteJsonUnmarshaller();
  
  public static ByteJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ByteJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */