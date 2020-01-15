package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Constructor;

final class StdKeyDeserializer$StringCtorKeyDeserializer
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  protected final Constructor<?> _ctor;
  
  public StdKeyDeserializer$StringCtorKeyDeserializer(Constructor<?> ctor)
  {
    super(-1, ctor.getDeclaringClass());
    _ctor = ctor;
  }
  
  public Object _parse(String key, DeserializationContext ctxt)
    throws Exception
  {
    return _ctor.newInstance(new Object[] { key });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringCtorKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */