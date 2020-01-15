package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeStaxUnmarshallers$IntegerStaxUnmarshaller
  implements Unmarshaller<Integer, StaxUnmarshallerContext>
{
  public Integer unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String intString = unmarshallerContext.readText();
    return intString == null ? null : Integer.valueOf(Integer.parseInt(intString));
  }
  
  private static final IntegerStaxUnmarshaller instance = new IntegerStaxUnmarshaller();
  
  public static IntegerStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */