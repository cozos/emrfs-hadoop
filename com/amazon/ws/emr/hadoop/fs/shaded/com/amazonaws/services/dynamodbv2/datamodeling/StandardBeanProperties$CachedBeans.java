package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class StandardBeanProperties$CachedBeans<T>
{
  private static final CachedBeans<Object> CACHE = new CachedBeans();
  private final ConcurrentMap<Class<T>, StandardBeanProperties.Beans<T>> cache = new ConcurrentHashMap();
  
  private final StandardBeanProperties.Beans<T> getBeans(Class<T> clazz)
  {
    if (!cache.containsKey(clazz))
    {
      StandardAnnotationMaps.TableMap<T> annotations = StandardAnnotationMaps.of(clazz);
      StandardBeanProperties.BeanMap<T, Object> map = new StandardBeanProperties.BeanMap(clazz, false);
      cache.putIfAbsent(clazz, new StandardBeanProperties.Beans(annotations, map, null));
    }
    return (StandardBeanProperties.Beans)cache.get(clazz);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.StandardBeanProperties.CachedBeans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */