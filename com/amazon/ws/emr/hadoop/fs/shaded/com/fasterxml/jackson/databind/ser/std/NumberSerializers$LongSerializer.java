package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$LongSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Long EMPTY = Long.valueOf(0L);
  static final LongSerializer instance = new LongSerializer();
  
  public NumberSerializers$LongSerializer()
  {
    super(Long.class, JsonParser.NumberType.LONG, "number");
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    return EMPTY.equals(value);
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(((Long)value).longValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.LongSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */