package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$StringJsonUnmarshaller
  implements Unmarshaller<String, JsonUnmarshallerContext>
{
  public String unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return unmarshallerContext.readText();
  }
  
  private static final StringJsonUnmarshaller instance = new StringJsonUnmarshaller();
  
  public static StringJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */