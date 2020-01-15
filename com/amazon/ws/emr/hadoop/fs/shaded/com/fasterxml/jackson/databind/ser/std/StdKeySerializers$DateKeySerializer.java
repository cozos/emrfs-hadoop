package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonSerializer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

@Deprecated
public class StdKeySerializers$DateKeySerializer
  extends StdSerializer<Date>
{
  protected static final JsonSerializer<?> instance = new DateKeySerializer();
  
  public StdKeySerializers$DateKeySerializer()
  {
    super(Date.class);
  }
  
  public void serialize(Date value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    provider.defaultSerializeDateKey(value, g);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.DateKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */