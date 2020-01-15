package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class DateDeserializers$DateDeserializer
  extends DateDeserializers.DateBasedDeserializer<Date>
{
  public static final DateDeserializer instance = new DateDeserializer();
  
  public DateDeserializers$DateDeserializer()
  {
    super(Date.class);
  }
  
  public DateDeserializers$DateDeserializer(DateDeserializer base, DateFormat df, String formatString)
  {
    super(base, df, formatString);
  }
  
  protected DateDeserializer withDateFormat(DateFormat df, String formatString)
  {
    return new DateDeserializer(this, df, formatString);
  }
  
  public Date deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _parseDate(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */