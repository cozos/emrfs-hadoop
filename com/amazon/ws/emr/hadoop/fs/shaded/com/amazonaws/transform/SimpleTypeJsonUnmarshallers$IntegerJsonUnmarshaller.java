package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$IntegerJsonUnmarshaller
  implements Unmarshaller<Integer, JsonUnmarshallerContext>
{
  public Integer unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String intString = unmarshallerContext.readText();
    return intString == null ? null : Integer.valueOf(Integer.parseInt(intString));
  }
  
  private static final IntegerJsonUnmarshaller instance = new IntegerJsonUnmarshaller();
  
  public static IntegerJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.IntegerJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */