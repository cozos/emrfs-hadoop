package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeCborUnmarshallers$StringCborUnmarshaller
  implements Unmarshaller<String, JsonUnmarshallerContext>
{
  public String unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return unmarshallerContext.readText();
  }
  
  private static final StringCborUnmarshaller instance = new StringCborUnmarshaller();
  
  public static StringCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.StringCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */