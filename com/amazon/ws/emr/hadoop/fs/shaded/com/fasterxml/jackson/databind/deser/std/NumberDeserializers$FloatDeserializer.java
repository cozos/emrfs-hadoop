package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$FloatDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Float>
{
  private static final long serialVersionUID = 1L;
  static final FloatDeserializer primitiveInstance = new FloatDeserializer(Float.TYPE, Float.valueOf(0.0F));
  static final FloatDeserializer wrapperInstance = new FloatDeserializer(Float.class, null);
  
  public NumberDeserializers$FloatDeserializer(Class<Float> cls, Float nvl)
  {
    super(cls, nvl);
  }
  
  public Float deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    return _parseFloat(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.FloatDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */