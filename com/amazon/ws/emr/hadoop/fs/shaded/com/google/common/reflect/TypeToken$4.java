package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet.Builder;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

final class TypeToken$4
  extends TypeVisitor
{
  TypeToken$4(ImmutableSet.Builder paramBuilder) {}
  
  void visitTypeVariable(TypeVariable<?> t)
  {
    visit(t.getBounds());
  }
  
  void visitWildcardType(WildcardType t)
  {
    visit(t.getUpperBounds());
  }
  
  void visitParameterizedType(ParameterizedType t)
  {
    val$builder.add((Class)t.getRawType());
  }
  
  void visitClass(Class<?> t)
  {
    val$builder.add(t);
  }
  
  void visitGenericArrayType(GenericArrayType t)
  {
    val$builder.add(Types.getArrayClass(TypeToken.getRawType(t.getGenericComponentType())));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */