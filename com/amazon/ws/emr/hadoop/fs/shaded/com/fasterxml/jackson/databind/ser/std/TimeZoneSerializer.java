package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.util.TimeZone;

public class TimeZoneSerializer
  extends StdScalarSerializer<TimeZone>
{
  public TimeZoneSerializer()
  {
    super(TimeZone.class);
  }
  
  public void serialize(TimeZone value, JsonGenerator jgen, SerializerProvider provider)
    throws IOException
  {
    jgen.writeString(value.getID());
  }
  
  public void serializeWithType(TimeZone value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    typeSer.writeTypePrefixForScalar(value, jgen, TimeZone.class);
    serialize(value, jgen, provider);
    typeSer.writeTypeSuffixForScalar(value, jgen);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.TimeZoneSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */