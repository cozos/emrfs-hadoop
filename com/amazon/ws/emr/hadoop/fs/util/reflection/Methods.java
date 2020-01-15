package com.amazon.ws.emr.hadoop.fs.util.reflection;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashMultimap;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SetMultimap;
import java.lang.reflect.Method;

public final class Methods
{
  private Methods()
  {
    throw new AssertionError();
  }
  
  public static SetMultimap<String, Method> groupByName(Method... methods)
  {
    Preconditions.checkNotNull(methods, "Methods must not be null");
    SetMultimap<String, Method> nameToMethods = HashMultimap.create();
    for (Method method : methods)
    {
      Preconditions.checkNotNull(method, "One of the methods given is null");
      nameToMethods.put(method.getName(), method);
    }
    return nameToMethods;
  }
  
  public static boolean hasParameterTypeAssignableTo(Method method, Class<?> assignableToType)
  {
    Preconditions.checkNotNull(method, "Method is required");
    Preconditions.checkNotNull(assignableToType, "AssignableToType is required");
    for (Class<?> type : method.getParameterTypes()) {
      if (assignableToType.isAssignableFrom(type)) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean takesOneParameter(Method method)
  {
    Preconditions.checkNotNull(method, "Method is required");
    return (!method.isVarArgs()) && (method.getParameterTypes().length == 1);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.util.reflection.Methods
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */