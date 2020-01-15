package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class $FastConstructor
  extends .FastMember
{
  $FastConstructor(.FastClass fc, Constructor constructor)
  {
    super(fc, constructor, fc.getIndex(constructor.getParameterTypes()));
  }
  
  public Class[] getParameterTypes()
  {
    return ((Constructor)member).getParameterTypes();
  }
  
  public Class[] getExceptionTypes()
  {
    return ((Constructor)member).getExceptionTypes();
  }
  
  public Object newInstance()
    throws InvocationTargetException
  {
    return fc.newInstance(index, null);
  }
  
  public Object newInstance(Object[] args)
    throws InvocationTargetException
  {
    return fc.newInstance(index, args);
  }
  
  public Constructor getJavaConstructor()
  {
    return (Constructor)member;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastConstructor
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */