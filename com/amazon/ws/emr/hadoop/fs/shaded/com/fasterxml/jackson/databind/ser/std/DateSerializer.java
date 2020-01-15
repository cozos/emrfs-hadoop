package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

@JacksonStdImpl
public class DateSerializer
  extends DateTimeSerializerBase<Date>
{
  public static final DateSerializer instance = new DateSerializer();
  
  public DateSerializer()
  {
    this(null, null);
  }
  
  public DateSerializer(Boolean useTimestamp, DateFormat customFormat)
  {
    super(Date.class, useTimestamp, customFormat);
  }
  
  public DateSerializer withFormat(Boolean timestamp, DateFormat customFormat)
  {
    return new DateSerializer(timestamp, customFormat);
  }
  
  protected long _timestamp(Date value)
  {
    return value == null ? 0L : value.getTime();
  }
  
  public void serialize(Date value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    if (_asTimestamp(provider)) {
      gen.writeNumber(_timestamp(value));
    } else if (_customFormat != null) {
      synchronized (_customFormat)
      {
        gen.writeString(_customFormat.format(value));
      }
    } else {
      provider.defaultSerializeDateValue(value, gen);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.DateSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */