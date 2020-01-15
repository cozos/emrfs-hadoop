package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal;

import java.lang.annotation.Annotation;

final class UniqueAnnotations$1
  implements UniqueAnnotations.Internal
{
  UniqueAnnotations$1(int paramInt) {}
  
  public int value()
  {
    return val$value;
  }
  
  public Class<? extends Annotation> annotationType()
  {
    return UniqueAnnotations.Internal.class;
  }
  
  public String toString()
  {
    return "@" + UniqueAnnotations.Internal.class.getName() + "(value=" + val$value + ")";
  }
  
  public boolean equals(Object o)
  {
    return ((o instanceof UniqueAnnotations.Internal)) && (((UniqueAnnotations.Internal)o).value() == value());
  }
  
  public int hashCode()
  {
    return 127 * "value".hashCode() ^ val$value;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.UniqueAnnotations.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */