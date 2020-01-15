package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class $MethodWrapper
{
  private static final MethodWrapperKey KEY_FACTORY = (MethodWrapperKey).KeyFactory.create(MethodWrapperKey.class);
  
  public static Object create(Method method)
  {
    return KEY_FACTORY.newInstance(method.getName(), .ReflectUtils.getNames(method.getParameterTypes()), method.getReturnType().getName());
  }
  
  public static Set createSet(Collection methods)
  {
    Set set = new HashSet();
    for (Iterator it = methods.iterator(); it.hasNext();) {
      set.add(create((Method)it.next()));
    }
    return set;
  }
  
  public static abstract interface MethodWrapperKey
  {
    public abstract Object newInstance(String paramString1, String[] paramArrayOfString, String paramString2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodWrapper
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */