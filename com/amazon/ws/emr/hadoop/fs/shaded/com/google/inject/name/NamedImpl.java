package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Preconditions;
import java.io.Serializable;
import java.lang.annotation.Annotation;

class NamedImpl
  implements Named, Serializable
{
  private final String value;
  private static final long serialVersionUID = 0L;
  
  public NamedImpl(String value)
  {
    this.value = ((String).Preconditions.checkNotNull(value, "name"));
  }
  
  public String value()
  {
    return value;
  }
  
  public int hashCode()
  {
    return 127 * "value".hashCode() ^ value.hashCode();
  }
  
  public boolean equals(Object o)
  {
    if (!(o instanceof Named)) {
      return false;
    }
    Named other = (Named)o;
    return value.equals(other.value());
  }
  
  public String toString()
  {
    return "@" + Named.class.getName() + "(value=" + value + ")";
  }
  
  public Class<? extends Annotation> annotationType()
  {
    return Named.class;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.name.NamedImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */