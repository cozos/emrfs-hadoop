package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;

@JacksonStdImpl
public class NumberDeserializers$ShortDeserializer
  extends NumberDeserializers.PrimitiveOrWrapperDeserializer<Short>
{
  private static final long serialVersionUID = 1L;
  static final ShortDeserializer primitiveInstance = new ShortDeserializer(Short.TYPE, Short.valueOf((short)0));
  static final ShortDeserializer wrapperInstance = new ShortDeserializer(Short.class, null);
  
  public NumberDeserializers$ShortDeserializer(Class<Short> cls, Short nvl)
  {
    super(cls, nvl);
  }
  
  public Short deserialize(JsonParser jp, DeserializationContext ctxt)
    throws IOException, JsonProcessingException
  {
    return _parseShort(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.NumberDeserializers.ShortDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */