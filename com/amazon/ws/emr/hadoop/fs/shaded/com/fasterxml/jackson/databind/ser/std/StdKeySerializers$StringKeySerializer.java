package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

public class StdKeySerializers$StringKeySerializer
  extends StdSerializer<Object>
{
  public StdKeySerializers$StringKeySerializer()
  {
    super(String.class, false);
  }
  
  public void serialize(Object value, JsonGenerator g, SerializerProvider provider)
    throws IOException
  {
    g.writeFieldName((String)value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.StdKeySerializers.StringKeySerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */