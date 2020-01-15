package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.asm..Type;

public class $Signature
{
  private String name;
  private String desc;
  
  public $Signature(String name, String desc)
  {
    if (name.indexOf('(') >= 0) {
      throw new IllegalArgumentException("Name '" + name + "' is invalid");
    }
    this.name = name;
    this.desc = desc;
  }
  
  public $Signature(String name, .Type returnType, .Type[] argumentTypes)
  {
    this(name, .Type.getMethodDescriptor(returnType, argumentTypes));
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getDescriptor()
  {
    return desc;
  }
  
  public .Type getReturnType()
  {
    return .Type.getReturnType(desc);
  }
  
  public .Type[] getArgumentTypes()
  {
    return .Type.getArgumentTypes(desc);
  }
  
  public String toString()
  {
    return name + desc;
  }
  
  public boolean equals(Object o)
  {
    if (o == null) {
      return false;
    }
    if (!(o instanceof Signature)) {
      return false;
    }
    Signature other = (Signature)o;
    return (name.equals(name)) && (desc.equals(desc));
  }
  
  public int hashCode()
  {
    return name.hashCode() ^ desc.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.core..Signature
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */