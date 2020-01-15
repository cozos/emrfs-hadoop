package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
abstract class TypeVisitor
{
  private final Set<Type> visited = Sets.newHashSet();
  
  public final void visit(Type... types)
  {
    for (Type type : types) {
      if ((type != null) && (visited.add(type)))
      {
        boolean succeeded = false;
        try
        {
          if ((type instanceof TypeVariable))
          {
            visitTypeVariable((TypeVariable)type);
          }
          else if ((type instanceof WildcardType))
          {
            visitWildcardType((WildcardType)type);
          }
          else if ((type instanceof ParameterizedType))
          {
            visitParameterizedType((ParameterizedType)type);
          }
          else if ((type instanceof Class))
          {
            visitClass((Class)type);
          }
          else if ((type instanceof GenericArrayType))
          {
            visitGenericArrayType((GenericArrayType)type);
          }
          else
          {
            String str = String.valueOf(String.valueOf(type));throw new AssertionError(14 + str.length() + "Unknown type: " + str);
          }
          succeeded = true;
        }
        finally
        {
          if (!succeeded) {
            visited.remove(type);
          }
        }
      }
    }
  }
  
  void visitClass(Class<?> t) {}
  
  void visitGenericArrayType(GenericArrayType t) {}
  
  void visitParameterizedType(ParameterizedType t) {}
  
  void visitTypeVariable(TypeVariable<?> t) {}
  
  void visitWildcardType(WildcardType t) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeVisitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */