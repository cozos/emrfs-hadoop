package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible
final class Count
  implements Serializable
{
  private int value;
  
  Count(int value)
  {
    this.value = value;
  }
  
  public int get()
  {
    return value;
  }
  
  public int getAndAdd(int delta)
  {
    int result = value;
    value = (result + delta);
    return result;
  }
  
  public int addAndGet(int delta)
  {
    return value += delta;
  }
  
  public void set(int newValue)
  {
    value = newValue;
  }
  
  public int getAndSet(int newValue)
  {
    int result = value;
    value = newValue;
    return result;
  }
  
  public int hashCode()
  {
    return value;
  }
  
  public boolean equals(@Nullable Object obj)
  {
    return ((obj instanceof Count)) && (value == value);
  }
  
  public String toString()
  {
    return Integer.toString(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Count
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */