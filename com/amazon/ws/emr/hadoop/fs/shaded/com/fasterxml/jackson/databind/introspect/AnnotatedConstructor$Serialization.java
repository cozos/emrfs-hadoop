package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Constructor;

final class AnnotatedConstructor$Serialization
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Class<?> clazz;
  protected Class<?>[] args;
  
  public AnnotatedConstructor$Serialization(Constructor<?> ctor)
  {
    clazz = ctor.getDeclaringClass();
    args = ctor.getParameterTypes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedConstructor.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */