package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonGenerator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.SerializerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

public abstract class NonTypedScalarSerializerBase<T>
  extends StdScalarSerializer<T>
{
  protected NonTypedScalarSerializerBase(Class<T> t)
  {
    super(t);
  }
  
  protected NonTypedScalarSerializerBase(Class<?> t, boolean bogus)
  {
    super(t, bogus);
  }
  
  public final void serializeWithType(T value, JsonGenerator jgen, SerializerProvider provider, TypeSerializer typeSer)
    throws IOException
  {
    serialize(value, jgen, provider);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.ser.std.NonTypedScalarSerializerBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */