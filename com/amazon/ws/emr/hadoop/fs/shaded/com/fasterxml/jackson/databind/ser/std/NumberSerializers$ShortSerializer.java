package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$ShortSerializer
  extends NumberSerializers.Base<Short>
{
  private static final Short EMPTY = Short.valueOf();
  static final ShortSerializer instance = new ShortSerializer();
  
  public NumberSerializers$ShortSerializer()
  {
    super(Short.class, JsonParser.NumberType.INT, "number");
  }
  
  public boolean isEmpty(SerializerProvider prov, Short value)
  {
    return EMPTY.equals(value);
  }
  
  public void serialize(Short value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(value.shortValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.ShortSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */