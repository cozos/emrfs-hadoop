package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable;

import java.io.Serializable;

public class MutableBoolean
  implements Mutable<Boolean>, Serializable, Comparable<MutableBoolean>
{
  private static final long serialVersionUID = -4830728138360036487L;
  private boolean value;
  
  public MutableBoolean() {}
  
  public MutableBoolean(boolean value)
  {
    this.value = value;
  }
  
  public MutableBoolean(Boolean value)
  {
    this.value = value.booleanValue();
  }
  
  public Boolean getValue()
  {
    return Boolean.valueOf(value);
  }
  
  public void setValue(boolean value)
  {
    this.value = value;
  }
  
  public void setFalse()
  {
    value = false;
  }
  
  public void setTrue()
  {
    value = true;
  }
  
  public void setValue(Boolean value)
  {
    this.value = value.booleanValue();
  }
  
  public boolean isTrue()
  {
    return value == true;
  }
  
  public boolean isFalse()
  {
    return !value;
  }
  
  public boolean booleanValue()
  {
    return value;
  }
  
  public Boolean toBoolean()
  {
    return Boolean.valueOf(booleanValue());
  }
  
  public boolean equals(Object obj)
  {
    if ((obj instanceof MutableBoolean)) {
      return value == ((MutableBoolean)obj).booleanValue();
    }
    return false;
  }
  
  public int hashCode()
  {
    return value ? Boolean.TRUE.hashCode() : Boolean.FALSE.hashCode();
  }
  
  public int compareTo(MutableBoolean other)
  {
    boolean anotherVal = value;
    return value ? 1 : value == anotherVal ? 0 : -1;
  }
  
  public String toString()
  {
    return String.valueOf(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.mutable.MutableBoolean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */