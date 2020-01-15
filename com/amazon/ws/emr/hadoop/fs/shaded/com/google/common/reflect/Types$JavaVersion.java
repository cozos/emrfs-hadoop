package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

 enum Types$JavaVersion
{
  JAVA6,  JAVA7,  JAVA8;
  
  static final JavaVersion CURRENT;
  
  static
  {
    if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
      CURRENT = JAVA8;
    } else if ((new TypeCapture() {}.capture() instanceof Class)) {
      CURRENT = JAVA7;
    } else {
      CURRENT = JAVA6;
    }
  }
  
  String typeName(Type type)
  {
    return Types.toString(type);
  }
  
  final ImmutableList<Type> usedInGenericType(Type[] types)
  {
    ImmutableList.Builder<Type> builder = ImmutableList.builder();
    for (Type type : types) {
      builder.add(usedInGenericType(type));
    }
    return builder.build();
  }
  
  private Types$JavaVersion() {}
  
  abstract Type newArrayType(Type paramType);
  
  abstract Type usedInGenericType(Type paramType);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.JavaVersion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */