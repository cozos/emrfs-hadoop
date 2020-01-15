package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

public class SimpleTypeIonUnmarshallers$StringIonUnmarshaller
  implements Unmarshaller<String, JsonUnmarshallerContext>
{
  public String unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return context.readText();
  }
  
  private static final StringIonUnmarshaller instance = new StringIonUnmarshaller();
  
  public static StringIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.StringIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */