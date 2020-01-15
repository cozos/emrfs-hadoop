package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$IntegerDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Integer>
{
  private static final long serialVersionUID = 1L;
  static final IntegerDeserializer primitiveInstance = new IntegerDeserializer(Integer.TYPE, Integer.valueOf(0));
  static final IntegerDeserializer wrapperInstance = new IntegerDeserializer(Integer.class, null);
  
  public NumberDeserializers$IntegerDeserializer(Class<Integer> cls, Integer nvl)
  {
    super(cls, nvl);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public Integer deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Integer.valueOf(p.getIntValue());
    }
    return _parseInteger(p, ctxt);
  }
  
  public Integer deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Integer.valueOf(p.getIntValue());
    }
    return _parseInteger(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.IntegerDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */