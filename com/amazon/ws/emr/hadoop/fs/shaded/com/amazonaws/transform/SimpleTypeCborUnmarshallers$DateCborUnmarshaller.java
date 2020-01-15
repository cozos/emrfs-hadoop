package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.util.Date;

public class SimpleTypeCborUnmarshallers$DateCborUnmarshaller
  implements Unmarshaller<Date, JsonUnmarshallerContext>
{
  public Date unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return new Date(unmarshallerContext.getJsonParser().getLongValue());
  }
  
  private static final DateCborUnmarshaller instance = new DateCborUnmarshaller();
  
  public static DateCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.DateCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */