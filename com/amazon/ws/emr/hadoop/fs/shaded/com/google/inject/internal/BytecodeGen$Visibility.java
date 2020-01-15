package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public enum BytecodeGen$Visibility
{
  PUBLIC,  SAME_PACKAGE;
  
  private BytecodeGen$Visibility() {}
  
  public static Visibility forMember(Member member)
  {
    if ((member.getModifiers() & 0x5) == 0) {
      return SAME_PACKAGE;
    }
    Class[] parameterTypes;
    Class[] parameterTypes;
    if ((member instanceof Constructor))
    {
      parameterTypes = ((Constructor)member).getParameterTypes();
    }
    else
    {
      Method method = (Method)member;
      if (forType(method.getReturnType()) == SAME_PACKAGE) {
        return SAME_PACKAGE;
      }
      parameterTypes = method.getParameterTypes();
    }
    for (Class<?> type : parameterTypes) {
      if (forType(type) == SAME_PACKAGE) {
        return SAME_PACKAGE;
      }
    }
    return PUBLIC;
  }
  
  public static Visibility forType(Class<?> type)
  {
    return (type.getModifiers() & 0x5) != 0 ? PUBLIC : SAME_PACKAGE;
  }
  
  public abstract Visibility and(Visibility paramVisibility);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.BytecodeGen.Visibility
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */