package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$FloatJsonUnmarshaller
  implements Unmarshaller<Float, JsonUnmarshallerContext>
{
  public Float unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String floatString = unmarshallerContext.readText();
    return floatString == null ? null : Float.valueOf(floatString);
  }
  
  private static final FloatJsonUnmarshaller instance = new FloatJsonUnmarshaller();
  
  public static FloatJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.FloatJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */