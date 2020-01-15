package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class MoreTypes$GenericArrayTypeImpl
  implements GenericArrayType, Serializable, MoreTypes.CompositeType
{
  private final Type componentType;
  private static final long serialVersionUID = 0L;
  
  public MoreTypes$GenericArrayTypeImpl(Type componentType)
  {
    this.componentType = MoreTypes.canonicalize(componentType);
  }
  
  public Type getGenericComponentType()
  {
    return componentType;
  }
  
  public boolean isFullySpecified()
  {
    return MoreTypes.access$100(componentType);
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof GenericArrayType)) && (MoreTypes.equals(this, (GenericArrayType)o));
  }
  
  public int hashCode()
  {
    return componentType.hashCode();
  }
  
  public String toString()
  {
    return MoreTypes.typeToString(componentType) + "[]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.MoreTypes.GenericArrayTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */