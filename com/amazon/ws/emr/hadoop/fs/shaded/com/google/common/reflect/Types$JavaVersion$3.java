package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

 enum Types$JavaVersion$3
{
  Types$JavaVersion$3()
  {
    super(paramString, paramInt, null);
  }
  
  Type newArrayType(Type componentType)
  {
    return JAVA7.newArrayType(componentType);
  }
  
  Type usedInGenericType(Type type)
  {
    return JAVA7.usedInGenericType(type);
  }
  
  String typeName(Type type)
  {
    try
    {
      Method getTypeName = Type.class.getMethod("getTypeName", new Class[0]);
      return (String)getTypeName.invoke(type, new Object[0]);
    }
    catch (NoSuchMethodException e)
    {
      throw new AssertionError("Type.getTypeName should be available in Java 8");
    }
    catch (InvocationTargetException e)
    {
      throw new RuntimeException(e);
    }
    catch (IllegalAccessException e)
    {
      throw new RuntimeException(e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.reflect.Types.JavaVersion.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */