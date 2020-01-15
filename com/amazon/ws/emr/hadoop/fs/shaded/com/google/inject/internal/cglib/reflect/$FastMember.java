package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect;

import java.lang.reflect.Member;

public abstract class $FastMember
{
  protected .FastClass fc;
  protected Member member;
  protected int index;
  
  protected $FastMember(.FastClass fc, Member member, int index)
  {
    this.fc = fc;
    this.member = member;
    this.index = index;
  }
  
  public abstract Class[] getParameterTypes();
  
  public abstract Class[] getExceptionTypes();
  
  public int getIndex()
  {
    return index;
  }
  
  public String getName()
  {
    return member.getName();
  }
  
  public Class getDeclaringClass()
  {
    return fc.getJavaClass();
  }
  
  public int getModifiers()
  {
    return member.getModifiers();
  }
  
  public String toString()
  {
    return member.toString();
  }
  
  public int hashCode()
  {
    return member.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if ((o == null) || (!(o instanceof FastMember))) {
      return false;
    }
    return member.equals(member);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.cglib.reflect..FastMember
 * Java Class Version: 1.2 (46.0)
 * JD-Core Version:    0.7.1
 */