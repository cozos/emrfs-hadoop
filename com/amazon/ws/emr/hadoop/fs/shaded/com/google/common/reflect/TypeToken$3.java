package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

class TypeToken$3
  extends TypeVisitor
{
  TypeToken$3(TypeToken paramTypeToken) {}
  
  void visitTypeVariable(TypeVariable<?> type)
  {
    String str = String.valueOf(String.valueOf(TypeToken.access$400(this$0)));throw new IllegalArgumentException(58 + str.length() + str + "contains a type variable and is not safe for the operation");
  }
  
  void visitWildcardType(WildcardType type)
  {
    visit(type.getLowerBounds());
    visit(type.getUpperBounds());
  }
  
  void visitParameterizedType(ParameterizedType type)
  {
    visit(type.getActualTypeArguments());
    visit(new Type[] { type.getOwnerType() });
  }
  
  void visitGenericArrayType(GenericArrayType type)
  {
    visit(new Type[] { type.getGenericComponentType() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeToken.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */