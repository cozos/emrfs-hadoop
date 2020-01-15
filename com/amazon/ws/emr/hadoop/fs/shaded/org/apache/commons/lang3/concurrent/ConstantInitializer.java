package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.ObjectUtils;

public class ConstantInitializer<T>
  implements ConcurrentInitializer<T>
{
  private static final String FMT_TO_STRING = "ConstantInitializer@%d [ object = %s ]";
  private final T object;
  
  public ConstantInitializer(T obj)
  {
    object = obj;
  }
  
  public final T getObject()
  {
    return (T)object;
  }
  
  public T get()
    throws ConcurrentException
  {
    return (T)getObject();
  }
  
  public int hashCode()
  {
    return getObject() != null ? getObject().hashCode() : 0;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof ConstantInitializer)) {
      return false;
    }
    ConstantInitializer<?> c = (ConstantInitializer)obj;
    return ObjectUtils.equals(getObject(), c.getObject());
  }
  
  public String toString()
  {
    return String.format("ConstantInitializer@%d [ object = %s ]", new Object[] { Integer.valueOf(System.identityHashCode(this)), String.valueOf(getObject()) });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.concurrent.ConstantInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */