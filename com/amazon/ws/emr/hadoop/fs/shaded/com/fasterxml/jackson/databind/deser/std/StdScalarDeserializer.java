package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;

public abstract class StdScalarDeserializer<T>
  extends StdDeserializer<T>
{
  private static final long serialVersionUID = 1L;
  
  protected StdScalarDeserializer(Class<?> vc)
  {
    super(vc);
  }
  
  protected StdScalarDeserializer(JavaType valueType)
  {
    super(valueType);
  }
  
  protected StdScalarDeserializer(StdScalarDeserializer<?> src)
  {
    super(src);
  }
  
  public Object deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer)
    throws IOException
  {
    return typeDeserializer.deserializeTypedFromScalar(jp, ctxt);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */