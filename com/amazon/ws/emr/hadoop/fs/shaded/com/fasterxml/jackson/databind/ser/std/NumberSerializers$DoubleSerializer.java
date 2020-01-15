package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$DoubleSerializer
  extends NumberSerializers.Base<Object>
{
  private static final Double EMPTY = Double.valueOf(0.0D);
  static final DoubleSerializer instance = new DoubleSerializer();
  
  public NumberSerializers$DoubleSerializer()
  {
    super(Double.class, JsonParser.NumberType.DOUBLE, "number");
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    return EMPTY.equals(value);
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(((Double)value).doubleValue());
  }
  
  public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    serialize(value, gen, provider);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.DoubleSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */