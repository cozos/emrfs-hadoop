package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class Types$TypeVariableImpl<D extends GenericDeclaration>
  implements TypeVariable<D>
{
  private final D genericDeclaration;
  private final String name;
  private final ImmutableList<Type> bounds;
  
  Types$TypeVariableImpl(D genericDeclaration, String name, Type[] bounds)
  {
    Types.access$200(bounds, "bound for type variable");
    this.genericDeclaration = ((GenericDeclaration)Preconditions.checkNotNull(genericDeclaration));
    this.name = ((String)Preconditions.checkNotNull(name));
    this.bounds = ImmutableList.copyOf(bounds);
  }
  
  public Type[] getBounds()
  {
    return Types.access$300(bounds);
  }
  
  public D getGenericDeclaration()
  {
    return genericDeclaration;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String toString()
  {
    return name;
  }
  
  public int hashCode()
  {
    return genericDeclaration.hashCode() ^ name.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    if (Types.NativeTypeVariableEquals.NATIVE_TYPE_VARIABLE_ONLY)
    {
      if ((obj instanceof TypeVariableImpl))
      {
        TypeVariableImpl<?> that = (TypeVariableImpl)obj;
        return (name.equals(that.getName())) && (genericDeclaration.equals(that.getGenericDeclaration())) && (bounds.equals(bounds));
      }
      return false;
    }
    if ((obj instanceof TypeVariable))
    {
      TypeVariable<?> that = (TypeVariable)obj;
      return (name.equals(that.getName())) && (genericDeclaration.equals(that.getGenericDeclaration()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.TypeVariableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */