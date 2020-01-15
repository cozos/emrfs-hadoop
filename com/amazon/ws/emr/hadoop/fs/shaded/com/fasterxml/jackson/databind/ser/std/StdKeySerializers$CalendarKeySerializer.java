package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Calendar;

@Deprecated
public class StdKeySerializers$CalendarKeySerializer
  extends StdSerializer<Calendar>
{
  protected static final JsonSerializer<?> instance = new CalendarKeySerializer();
  
  public StdKeySerializers$CalendarKeySerializer()
  {
    super(Calendar.class);
  }
  
  public void serialize(Calendar value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    provider.defaultSerializeDateKey(value.getTimeInMillis(), g);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.CalendarKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */