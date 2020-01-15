package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ConcurrentModificationException;
import javax.annotation.Nullable;

final class TreeMultiset$Reference<T>
{
  @Nullable
  private T value;
  
  @Nullable
  public T get()
  {
    return (T)value;
  }
  
  public void checkAndSet(@Nullable T expected, T newValue)
  {
    if (value != expected) {
      throw new ConcurrentModificationException();
    }
    value = newValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeMultiset.Reference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */