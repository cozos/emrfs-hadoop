package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser.NumberType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberSerializers$IntLikeSerializer
  extends NumberSerializers.Base<Number>
{
  static final IntLikeSerializer instance = new IntLikeSerializer();
  
  public NumberSerializers$IntLikeSerializer()
  {
    super(Number.class, JsonParser.NumberType.INT, "integer");
  }
  
  public boolean isEmpty(SerializerProvider prov, Number value)
  {
    return value.intValue() == 0;
  }
  
  public void serialize(Number value, JsonGenerator gen, SerializerProvider provider)
    throws IOException
  {
    gen.writeNumber(value.intValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NumberSerializers.IntLikeSerializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */