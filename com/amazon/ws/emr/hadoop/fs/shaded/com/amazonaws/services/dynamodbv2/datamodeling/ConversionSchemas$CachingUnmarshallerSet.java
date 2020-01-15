package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

class ConversionSchemas$CachingUnmarshallerSet
  implements ConversionSchemas.UnmarshallerSet
{
  private final Map<Method, ArgumentUnmarshaller> cache = new HashMap();
  private final Map<Type, ArgumentUnmarshaller> memberCache = new HashMap();
  private final ConversionSchemas.UnmarshallerSet wrapped;
  
  public ConversionSchemas$CachingUnmarshallerSet(ConversionSchemas.UnmarshallerSet wrapped)
  {
    this.wrapped = wrapped;
  }
  
  public ArgumentUnmarshaller getUnmarshaller(Method getter, Method setter)
  {
    synchronized (cache)
    {
      ArgumentUnmarshaller unmarshaler = (ArgumentUnmarshaller)cache.get(getter);
      if (unmarshaler != null) {
        return unmarshaler;
      }
      unmarshaler = wrapped.getUnmarshaller(getter, setter);
      cache.put(getter, unmarshaler);
      return unmarshaler;
    }
  }
  
  public ArgumentUnmarshaller getMemberUnmarshaller(Type memberType)
  {
    synchronized (memberCache)
    {
      ArgumentUnmarshaller unmarshaller = (ArgumentUnmarshaller)memberCache.get(memberType);
      if (unmarshaller != null) {
        return unmarshaller;
      }
      unmarshaller = wrapped.getMemberUnmarshaller(memberType);
      memberCache.put(memberType, unmarshaller);
      return unmarshaller;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.CachingUnmarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */