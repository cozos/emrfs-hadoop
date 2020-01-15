package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class TypeUtils$GenericArrayTypeImpl
  implements GenericArrayType
{
  private final Type componentType;
  
  private TypeUtils$GenericArrayTypeImpl(Type componentType)
  {
    this.componentType = componentType;
  }
  
  public Type getGenericComponentType()
  {
    return componentType;
  }
  
  public String toString()
  {
    return TypeUtils.toString(this);
  }
  
  public boolean equals(Object obj)
  {
    return (obj == this) || (((obj instanceof GenericArrayType)) && (TypeUtils.access$100(this, (GenericArrayType)obj)));
  }
  
  public int hashCode()
  {
    int result = 1072;
    result |= componentType.hashCode();
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.reflect.TypeUtils.GenericArrayTypeImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */