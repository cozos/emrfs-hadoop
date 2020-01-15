package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

class ConversionSchemas$CachingMarshallerSet
  implements ConversionSchemas.MarshallerSet
{
  private final Map<Method, ArgumentMarshaller> cache = new HashMap();
  private final Map<Type, ArgumentMarshaller> memberCache = new HashMap();
  private final ConversionSchemas.MarshallerSet wrapped;
  
  public ConversionSchemas$CachingMarshallerSet(ConversionSchemas.MarshallerSet wrapped)
  {
    this.wrapped = wrapped;
  }
  
  public ArgumentMarshaller getMarshaller(Method getter)
  {
    synchronized (cache)
    {
      ArgumentMarshaller marshaler = (ArgumentMarshaller)cache.get(getter);
      if (marshaler != null) {
        return marshaler;
      }
      marshaler = wrapped.getMarshaller(getter);
      cache.put(getter, marshaler);
      return marshaler;
    }
  }
  
  public ArgumentMarshaller getMemberMarshaller(Type memberType)
  {
    synchronized (memberCache)
    {
      ArgumentMarshaller marshaller = (ArgumentMarshaller)memberCache.get(memberType);
      if (marshaller != null) {
        return marshaller;
      }
      marshaller = wrapped.getMemberMarshaller(memberType);
      memberCache.put(memberType, marshaller);
      return marshaller;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ConversionSchemas.CachingMarshallerSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */