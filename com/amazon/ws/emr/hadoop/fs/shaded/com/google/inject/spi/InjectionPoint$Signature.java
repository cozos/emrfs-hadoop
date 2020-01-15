package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import java.lang.reflect.Method;

class InjectionPoint$Signature
{
  final String name;
  final Class[] parameterTypes;
  final int hash;
  
  InjectionPoint$Signature(Method method)
  {
    name = method.getName();
    parameterTypes = method.getParameterTypes();
    
    int h = name.hashCode();
    h = h * 31 + parameterTypes.length;
    for (Class parameterType : parameterTypes) {
      h = h * 31 + parameterType.hashCode();
    }
    hash = h;
  }
  
  public int hashCode()
  {
    return hash;
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof Signature)) {
      return false;
    }
    Signature other = (Signature)o;
    if (!name.equals(name)) {
      return false;
    }
    if (parameterTypes.length != parameterTypes.length) {
      return false;
    }
    for (int i = 0; i < parameterTypes.length; i++) {
      if (parameterTypes[i] != parameterTypes[i]) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.Signature
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */