package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeJsonUnmarshallers$BooleanJsonUnmarshaller
  implements Unmarshaller<Boolean, JsonUnmarshallerContext>
{
  public Boolean unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String booleanString = unmarshallerContext.readText();
    return booleanString == null ? null : Boolean.valueOf(Boolean.parseBoolean(booleanString));
  }
  
  private static final BooleanJsonUnmarshaller instance = new BooleanJsonUnmarshaller();
  
  public static BooleanJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.BooleanJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */