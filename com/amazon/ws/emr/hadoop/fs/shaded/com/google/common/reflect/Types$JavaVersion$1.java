package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

 enum Types$JavaVersion$1
{
  Types$JavaVersion$1()
  {
    super(paramString, paramInt, null);
  }
  
  GenericArrayType newArrayType(Type componentType)
  {
    return new Types.GenericArrayTypeImpl(componentType);
  }
  
  Type usedInGenericType(Type type)
  {
    Preconditions.checkNotNull(type);
    if ((type instanceof Class))
    {
      Class<?> cls = (Class)type;
      if (cls.isArray()) {
        return new Types.GenericArrayTypeImpl(cls.getComponentType());
      }
    }
    return type;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.JavaVersion.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */