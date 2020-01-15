package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeResolver$TypeVariableKey
{
  private final TypeVariable<?> var;
  
  TypeResolver$TypeVariableKey(TypeVariable<?> var)
  {
    this.var = ((TypeVariable)Preconditions.checkNotNull(var));
  }
  
  public int hashCode()
  {
    return Objects.hashCode(new Object[] { var.getGenericDeclaration(), var.getName() });
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof TypeVariableKey))
    {
      TypeVariableKey that = (TypeVariableKey)obj;
      return equalsTypeVariable(var);
    }
    return false;
  }
  
  public String toString()
  {
    return var.toString();
  }
  
  static Object forLookup(Type t)
  {
    if ((t instanceof TypeVariable)) {
      return new TypeVariableKey((TypeVariable)t);
    }
    return null;
  }
  
  boolean equalsType(Type type)
  {
    if ((type instanceof TypeVariable)) {
      return equalsTypeVariable((TypeVariable)type);
    }
    return false;
  }
  
  private boolean equalsTypeVariable(TypeVariable<?> that)
  {
    return (var.getGenericDeclaration().equals(that.getGenericDeclaration())) && (var.getName().equals(that.getName()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.TypeResolver.TypeVariableKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */