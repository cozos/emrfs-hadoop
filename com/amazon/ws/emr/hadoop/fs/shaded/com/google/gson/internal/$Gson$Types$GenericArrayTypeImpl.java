package com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal;

import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

final class $Gson$Types$GenericArrayTypeImpl
  implements GenericArrayType, Serializable
{
  private final Type componentType;
  private static final long serialVersionUID = 0L;
  
  public $Gson$Types$GenericArrayTypeImpl(Type componentType)
  {
    this.componentType = .Gson.Types.canonicalize(componentType);
  }
  
  public Type getGenericComponentType()
  {
    return componentType;
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof GenericArrayType)) && (.Gson.Types.equals(this, (GenericArrayType)o));
  }
  
  public int hashCode()
  {
    return componentType.hashCode();
  }
  
  public String toString()
  {
    return .Gson.Types.typeToString(componentType) + "[]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.gson.internal..Gson.Types.GenericArrayTypeImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */