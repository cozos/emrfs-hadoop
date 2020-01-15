package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

public abstract class $MethodInfo
{
  public abstract .ClassInfo getClassInfo();
  
  public abstract int getModifiers();
  
  public abstract .Signature getSignature();
  
  public abstract .Type[] getExceptionTypes();
  
  public boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (!(o instanceof MethodInfo)) {
      return false;
    }
    return getSignature().equals(((MethodInfo)o).getSignature());
  }
  
  public int hashCode()
  {
    return getSignature().hashCode();
  }
  
  public String toString()
  {
    return getSignature().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..MethodInfo
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */