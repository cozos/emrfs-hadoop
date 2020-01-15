package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.proxy..CallbackFilter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Maps;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

class ProxyFactory$IndicesCallbackFilter
  implements .CallbackFilter
{
  final Class<?> declaringClass;
  final Map<Method, Integer> indices;
  
  ProxyFactory$IndicesCallbackFilter(Class<?> declaringClass, List<Method> methods)
  {
    this.declaringClass = declaringClass;
    Map<Method, Integer> indices = .Maps.newHashMap();
    for (int i = 0; i < methods.size(); i++)
    {
      Method method = (Method)methods.get(i);
      indices.put(method, Integer.valueOf(i));
    }
    this.indices = indices;
  }
  
  public int accept(Method method)
  {
    return ((Integer)indices.get(method)).intValue();
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof IndicesCallbackFilter)) && (declaringClass == declaringClass);
  }
  
  public int hashCode()
  {
    return declaringClass.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.ProxyFactory.IndicesCallbackFilter
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */