package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$IntegerSerializer
  extends NumberSerializers.Base<Object>
{
  public NumberSerializers$IntegerSerializer()
  {
    super(Integer.class, JsonParser.NumberType.INT, "integer");
  }
  
  public void serialize(Object value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(((Integer)value).intValue());
  }
  
  public void serializeWithType(Object value, JsonGenerator gen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    serialize(value, gen, provider);
  }
  
  public boolean isEmpty(SerializerProvider prov, Object value)
  {
    return EMPTY_INTEGER.equals(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntegerSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */