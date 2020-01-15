package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.TypeSet;
import java.util.Set;

final class EventBus$1
  extends CacheLoader<Class<?>, Set<Class<?>>>
{
  public Set<Class<?>> load(Class<?> concreteClass)
  {
    return TypeToken.of(concreteClass).getTypes().rawTypes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.EventBus.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */