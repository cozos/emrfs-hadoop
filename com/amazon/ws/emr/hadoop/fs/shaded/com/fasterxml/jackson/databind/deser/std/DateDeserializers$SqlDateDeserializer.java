package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import java.text.DateFormat;

public class DateDeserializers$SqlDateDeserializer
  extends DateDeserializers.DateBasedDeserializer<java.sql.Date>
{
  public DateDeserializers$SqlDateDeserializer()
  {
    super(java.sql.Date.class);
  }
  
  public DateDeserializers$SqlDateDeserializer(SqlDateDeserializer src, DateFormat df, String formatString)
  {
    super(src, df, formatString);
  }
  
  protected SqlDateDeserializer withDateFormat(DateFormat df, String formatString)
  {
    return new SqlDateDeserializer(this, df, formatString);
  }
  
  public java.sql.Date deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    java.util.Date d = _parseDate(jp, ctxt);
    return d == null ? null : new java.sql.Date(d.getTime());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.DateDeserializers.SqlDateDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */