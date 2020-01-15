package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.Type;

 enum Types$JavaVersion$2
{
  Types$JavaVersion$2()
  {
    super(paramString, paramInt, null);
  }
  
  Type newArrayType(Type componentType)
  {
    if ((componentType instanceof Class)) {
      return Types.getArrayClass((Class)componentType);
    }
    return new Types.GenericArrayTypeImpl(componentType);
  }
  
  Type usedInGenericType(Type type)
  {
    return (Type)Preconditions.checkNotNull(type);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.JavaVersion.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */