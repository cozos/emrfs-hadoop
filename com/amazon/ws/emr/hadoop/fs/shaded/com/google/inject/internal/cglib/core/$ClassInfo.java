package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

public abstract class $ClassInfo
{
  public abstract .Type getType();
  
  public abstract .Type getSuperType();
  
  public abstract .Type[] getInterfaces();
  
  public abstract int getModifiers();
  
  public boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (!(o instanceof ClassInfo)) {
      return false;
    }
    return getType().equals(((ClassInfo)o).getType());
  }
  
  public int hashCode()
  {
    return getType().hashCode();
  }
  
  public String toString()
  {
    return getType().getClassName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..ClassInfo
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */