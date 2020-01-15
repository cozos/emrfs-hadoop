package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$BooleanDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Boolean>
{
  private static final long serialVersionUID = 1L;
  static final BooleanDeserializer primitiveInstance = new BooleanDeserializer(Boolean.TYPE, Boolean.FALSE);
  static final BooleanDeserializer wrapperInstance = new BooleanDeserializer(Boolean.class, null);
  
  public NumberDeserializers$BooleanDeserializer(Class<Boolean> cls, Boolean nvl)
  {
    super(cls, nvl);
  }
  
  public Boolean deserialize(JsonParser j, DeserializationContext ctxt)
    throws IOException
  {
    return _parseBoolean(j, ctxt);
  }
  
  public Boolean deserializeWithType(JsonParser p, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return _parseBoolean(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BooleanDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */