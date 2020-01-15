package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.TypeLiteral;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

class InjectionPoint$InjectableField
  extends InjectionPoint.InjectableMember
{
  final Field field;
  
  InjectionPoint$InjectableField(TypeLiteral<?> declaringType, Field field, Annotation atInject)
  {
    super(declaringType, atInject);
    this.field = field;
  }
  
  InjectionPoint toInjectionPoint()
  {
    return new InjectionPoint(declaringType, field, optional);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.spi.InjectionPoint.InjectableField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */