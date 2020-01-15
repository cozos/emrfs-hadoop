package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

final class $ReflectUtils$4
  extends .ClassInfo
{
  private final .Type val$type;
  private final .Type val$sc;
  private final Class val$clazz;
  
  $ReflectUtils$4(.Type paramType1, .Type paramType2, Class paramClass)
  {
    val$type = paramType1;val$sc = paramType2;val$clazz = paramClass;
  }
  
  public .Type getType()
  {
    return val$type;
  }
  
  public .Type getSuperType()
  {
    return val$sc;
  }
  
  public .Type[] getInterfaces()
  {
    return .TypeUtils.getTypes(val$clazz.getInterfaces());
  }
  
  public int getModifiers()
  {
    return val$clazz.getModifiers();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ReflectUtils.4
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */