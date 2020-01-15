package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$DoubleDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Double>
{
  private static final long serialVersionUID = 1L;
  static final DoubleDeserializer primitiveInstance = new DoubleDeserializer(Double.TYPE, Double.valueOf(0.0D));
  static final DoubleDeserializer wrapperInstance = new DoubleDeserializer(Double.class, null);
  
  public NumberDeserializers$DoubleDeserializer(Class<Double> cls, Double nvl)
  {
    super(cls, nvl);
  }
  
  public Double deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException
  {
    return _parseDouble(jp, ctxt);
  }
  
  public Double deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return _parseDouble(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.DoubleDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */