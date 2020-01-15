package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.DeserializationContext;
import java.lang.reflect.Method;

final class StdKeyDeserializer$StringFactoryKeyDeserializer
  extends StdKeyDeserializer
{
  private static final long serialVersionUID = 1L;
  final Method _factoryMethod;
  
  public StdKeyDeserializer$StringFactoryKeyDeserializer(Method fm)
  {
    super(-1, fm.getDeclaringClass());
    _factoryMethod = fm;
  }
  
  public Object _parse(String key, DeserializationContext ctxt)
    throws Exception
  {
    return _factoryMethod.invoke(null, new Object[] { key });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer.StringFactoryKeyDeserializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */