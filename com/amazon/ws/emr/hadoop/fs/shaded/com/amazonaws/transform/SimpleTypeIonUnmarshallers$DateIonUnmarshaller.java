package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.util.Date;

public class SimpleTypeIonUnmarshallers$DateIonUnmarshaller
  implements Unmarshaller<Date, JsonUnmarshallerContext>
{
  public Date unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return (Date)context.getJsonParser().getEmbeddedObject();
  }
  
  private static final DateIonUnmarshaller instance = new DateIonUnmarshaller();
  
  public static DateIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.DateIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */