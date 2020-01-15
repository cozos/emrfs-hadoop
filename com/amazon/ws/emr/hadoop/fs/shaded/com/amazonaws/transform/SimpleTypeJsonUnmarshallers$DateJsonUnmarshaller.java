package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.util.Date;

public class SimpleTypeJsonUnmarshallers$DateJsonUnmarshaller
  implements Unmarshaller<Date, JsonUnmarshallerContext>
{
  public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    if (unmarshallerContext.getCurrentToken() == JsonToken.VALUE_STRING) {
      return DateUtils.parseISO8601Date(unmarshallerContext.readText());
    }
    return DateUtils.parseServiceSpecificDate(unmarshallerContext.readText());
  }
  
  private static final DateJsonUnmarshaller instance = new DateJsonUnmarshaller();
  
  public static DateJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */