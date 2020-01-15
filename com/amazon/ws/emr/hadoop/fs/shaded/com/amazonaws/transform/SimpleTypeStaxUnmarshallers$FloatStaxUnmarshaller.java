package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$FloatStaxUnmarshaller
  implements Unmarshaller<Float, StaxUnmarshallerContext>
{
  public Float unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String floatString = unmarshallerContext.readText();
    return floatString == null ? null : Float.valueOf(floatString);
  }
  
  private static final FloatStaxUnmarshaller instance = new FloatStaxUnmarshaller();
  
  public static FloatStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.FloatStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */