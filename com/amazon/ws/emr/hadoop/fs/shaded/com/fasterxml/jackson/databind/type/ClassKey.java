package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type;

import java.io.Serializable;

public final class ClassKey
  implements Comparable<ClassKey>, Serializable
{
  private static final long serialVersionUID = 1L;
  private String _className;
  private Class<?> _class;
  private int _hashCode;
  
  public ClassKey()
  {
    _class = null;
    _className = null;
    _hashCode = 0;
  }
  
  public ClassKey(Class<?> clz)
  {
    _class = clz;
    _className = clz.getName();
    _hashCode = _className.hashCode();
  }
  
  public void reset(Class<?> clz)
  {
    _class = clz;
    _className = clz.getName();
    _hashCode = _className.hashCode();
  }
  
  public int compareTo(ClassKey other)
  {
    return _className.compareTo(_className);
  }
  
  public boolean equals(Object o)
  {
    if (o == this) {
      return true;
    }
    if (o == null) {
      return false;
    }
    if (o.getClass() != getClass()) {
      return false;
    }
    ClassKey other = (ClassKey)o;
    
    return _class == _class;
  }
  
  public int hashCode()
  {
    return _hashCode;
  }
  
  public String toString()
  {
    return _className;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.ClassKey
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */