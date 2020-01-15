package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public final class NumberDeserializers$LongDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Long>
{
  private static final long serialVersionUID = 1L;
  static final LongDeserializer primitiveInstance = new LongDeserializer(Long.TYPE, Long.valueOf(0L));
  static final LongDeserializer wrapperInstance = new LongDeserializer(Long.class, null);
  
  public NumberDeserializers$LongDeserializer(Class<Long> cls, Long nvl)
  {
    super(cls, nvl);
  }
  
  public boolean isCachable()
  {
    return true;
  }
  
  public Long deserialize(JsonParser p, DeserializationContext ctxt)
    throws IOException
  {
    if (p.hasToken(JsonToken.VALUE_NUMBER_INT)) {
      return Long.valueOf(p.getLongValue());
    }
    return _parseLong(p, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.LongDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */