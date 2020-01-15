package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$DoubleStaxUnmarshaller
  implements Unmarshaller<Double, StaxUnmarshallerContext>
{
  public Double unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String doubleString = unmarshallerContext.readText();
    return doubleString == null ? null : Double.valueOf(Double.parseDouble(doubleString));
  }
  
  private static final DoubleStaxUnmarshaller instance = new DoubleStaxUnmarshaller();
  
  public static DoubleStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */