package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import java.lang.annotation.Annotation;

abstract class InjectionPoint$InjectableMember
{
  final TypeLiteral<?> declaringType;
  final boolean optional;
  final boolean jsr330;
  InjectableMember previous;
  InjectableMember next;
  
  InjectionPoint$InjectableMember(TypeLiteral<?> declaringType, Annotation atInject)
  {
    this.declaringType = declaringType;
    if (atInject.annotationType() == javax.inject.Inject.class)
    {
      optional = false;
      jsr330 = true;
      return;
    }
    jsr330 = false;
    optional = ((com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.Inject)atInject).optional();
  }
  
  abstract InjectionPoint toInjectionPoint();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.InjectableMember
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */