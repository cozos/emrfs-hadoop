package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect;

import java.io.Serializable;
import java.lang.reflect.Method;

final class AnnotatedMethod$Serialization
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  protected Class<?> clazz;
  protected String name;
  protected Class<?>[] args;
  
  public AnnotatedMethod$Serialization(Method setter)
  {
    clazz = setter.getDeclaringClass();
    name = setter.getName();
    args = setter.getParameterTypes();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.introspect.AnnotatedMethod.Serialization
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */