package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;

public final class Atomics
{
  public static <V> AtomicReference<V> newReference()
  {
    return new AtomicReference();
  }
  
  public static <V> AtomicReference<V> newReference(@Nullable V initialValue)
  {
    return new AtomicReference(initialValue);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(int length)
  {
    return new AtomicReferenceArray(length);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(E[] array)
  {
    return new AtomicReferenceArray(array);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Atomics
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */