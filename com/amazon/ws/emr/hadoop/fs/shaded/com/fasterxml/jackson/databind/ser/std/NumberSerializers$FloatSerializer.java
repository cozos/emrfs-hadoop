package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$FloatSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Float EMPTY = Float.valueOf(0.0F);
  static final FloatSerializer instance = new FloatSerializer();
  
  public NumberSerializers$FloatSerializer()
  {
    super(Float.class, JsonParser.NumberType.FLOAT, "number");
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    return EMPTY.equals(value);
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(((Float)value).floatValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.FloatSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */