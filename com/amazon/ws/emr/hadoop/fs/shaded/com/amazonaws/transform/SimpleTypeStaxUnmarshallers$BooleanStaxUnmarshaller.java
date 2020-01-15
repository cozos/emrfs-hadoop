package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$BooleanStaxUnmarshaller
  implements Unmarshaller<Boolean, StaxUnmarshallerContext>
{
  public Boolean unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String booleanString = unmarshallerContext.readText();
    return booleanString == null ? null : Boolean.valueOf(Boolean.parseBoolean(booleanString));
  }
  
  private static final BooleanStaxUnmarshaller instance = new BooleanStaxUnmarshaller();
  
  public static BooleanStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */