package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

class TypeResolver$TypeTable$1
  extends TypeResolver.TypeTable
{
  TypeResolver$TypeTable$1(TypeResolver.TypeTable paramTypeTable1, TypeVariable paramTypeVariable, TypeResolver.TypeTable paramTypeTable2) {}
  
  public Type resolveInternal(TypeVariable<?> intermediateVar, TypeResolver.TypeTable forDependent)
  {
    if (intermediateVar.getGenericDeclaration().equals(val$var.getGenericDeclaration())) {
      return intermediateVar;
    }
    return val$unguarded.resolveInternal(intermediateVar, forDependent);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.TypeTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */