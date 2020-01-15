package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import java.nio.charset.Charset;

public class SimpleTypeJsonUnmarshallers$JsonValueStringUnmarshaller
  extends SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller
{
  public String unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String stringValue = super.unmarshall(unmarshallerContext);
    return !unmarshallerContext.isInsideResponseHeader() ? stringValue : new String(
    
      Base64.decode(stringValue), Charset.forName("utf-8"));
  }
  
  private static final JsonValueStringUnmarshaller INSTANCE = new JsonValueStringUnmarshaller();
  
  public static JsonValueStringUnmarshaller getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.JsonValueStringUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */