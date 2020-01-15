package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;

final class AnnotatedSubscriberFinder$1
  extends CacheLoader<Class<?>, ImmutableList<Method>>
{
  public ImmutableList<Method> load(Class<?> concreteClass)
    throws Exception
  {
    return AnnotatedSubscriberFinder.access$000(concreteClass);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.eventbus.AnnotatedSubscriberFinder.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */