package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class Types$GenericArrayTypeImpl
  implements GenericArrayType, Serializable
{
  private final Type componentType;
  private static final long serialVersionUID = 0L;
  
  Types$GenericArrayTypeImpl(Type componentType)
  {
    this.componentType = Types.JavaVersion.CURRENT.usedInGenericType(componentType);
  }
  
  public Type getGenericComponentType()
  {
    return componentType;
  }
  
  public String toString()
  {
    return String.valueOf(Types.toString(componentType)).concat("[]");
  }
  
  public int hashCode()
  {
    return componentType.hashCode();
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof GenericArrayType))
    {
      GenericArrayType that = (GenericArrayType)obj;
      return Objects.equal(getGenericComponentType(), that.getGenericComponentType());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.GenericArrayTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */