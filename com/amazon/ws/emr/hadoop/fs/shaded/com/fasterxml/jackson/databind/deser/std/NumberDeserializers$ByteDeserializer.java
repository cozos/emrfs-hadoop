package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$ByteDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Byte>
{
  private static final long serialVersionUID = 1L;
  static final ByteDeserializer primitiveInstance = new ByteDeserializer(Byte.TYPE, Byte.valueOf((byte)0));
  static final ByteDeserializer wrapperInstance = new ByteDeserializer(Byte.class, null);
  
  public NumberDeserializers$ByteDeserializer(Class<Byte> cls, Byte nvl)
  {
    super(cls, nvl);
  }
  
  public Byte deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    return _parseByte(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.ByteDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */