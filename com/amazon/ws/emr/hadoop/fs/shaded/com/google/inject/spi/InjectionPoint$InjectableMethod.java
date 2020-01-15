package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class InjectionPoint$InjectableMethod
  extends InjectionPoint.InjectableMember
{
  final Method method;
  boolean overrodeGuiceInject;
  
  InjectionPoint$InjectableMethod(TypeLiteral<?> declaringType, Method method, Annotation atInject)
  {
    super(declaringType, atInject);
    this.method = method;
  }
  
  InjectionPoint toInjectionPoint()
  {
    return new InjectionPoint(declaringType, method, optional);
  }
  
  public boolean isFinal()
  {
    return Modifier.isFinal(method.getModifiers());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.InjectableMethod
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */