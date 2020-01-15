package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class DateDeserializers$TimestampDeserializer
  extends DateDeserializers.DateBasedDeserializer<Timestamp>
{
  public DateDeserializers$TimestampDeserializer()
  {
    super(Timestamp.class);
  }
  
  public DateDeserializers$TimestampDeserializer(TimestampDeserializer src, DateFormat df, String formatString)
  {
    super(src, df, formatString);
  }
  
  protected TimestampDeserializer withDateFormat(DateFormat df, String formatString)
  {
    return new TimestampDeserializer(this, df, formatString);
  }
  
  public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return new Timestamp(_parseDate(jp, ctxt).getTime());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers.TimestampDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */