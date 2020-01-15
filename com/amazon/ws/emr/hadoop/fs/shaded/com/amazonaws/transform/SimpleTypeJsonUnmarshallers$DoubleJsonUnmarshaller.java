package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$DoubleJsonUnmarshaller
  implements Unmarshaller<Double, JsonUnmarshallerContext>
{
  public Double unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String doubleString = unmarshallerContext.readText();
    return doubleString == null ? null : Double.valueOf(Double.parseDouble(doubleString));
  }
  
  private static final DoubleJsonUnmarshaller instance = new DoubleJsonUnmarshaller();
  
  public static DoubleJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DoubleJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */