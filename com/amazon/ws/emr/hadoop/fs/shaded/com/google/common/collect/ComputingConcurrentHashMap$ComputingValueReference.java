package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

final class ComputingConcurrentHashMap$ComputingValueReference<K, V>
  implements MapMakerInternalMap.ValueReference<K, V>
{
  final Function<? super K, ? extends V> computingFunction;
  @GuardedBy("ComputingValueReference.this")
  volatile MapMakerInternalMap.ValueReference<K, V> computedReference = MapMakerInternalMap.unset();
  
  public ComputingConcurrentHashMap$ComputingValueReference(Function<? super K, ? extends V> computingFunction)
  {
    this.computingFunction = computingFunction;
  }
  
  public V get()
  {
    return null;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
  {
    return null;
  }
  
  public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, @Nullable V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    return this;
  }
  
  public boolean isComputingReference()
  {
    return true;
  }
  
  public V waitForValue()
    throws ExecutionException
  {
    if (computedReference == MapMakerInternalMap.UNSET)
    {
      boolean interrupted = false;
      try
      {
        synchronized (this)
        {
          while (computedReference == MapMakerInternalMap.UNSET) {
            try
            {
              wait();
            }
            catch (InterruptedException ie)
            {
              interrupted = true;
            }
          }
        }
      }
      finally
      {
        if (interrupted) {
          Thread.currentThread().interrupt();
        }
      }
    }
    return (V)computedReference.waitForValue();
  }
  
  public void clear(MapMakerInternalMap.ValueReference<K, V> newValue)
  {
    setValueReference(newValue);
  }
  
  V compute(K key, int hash)
    throws ExecutionException
  {
    V value;
    try
    {
      value = computingFunction.apply(key);
    }
    catch (Throwable t)
    {
      setValueReference(new ComputingConcurrentHashMap.ComputationExceptionReference(t));
      throw new ExecutionException(t);
    }
    setValueReference(new ComputingConcurrentHashMap.ComputedReference(value));
    return value;
  }
  
  void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
  {
    synchronized (this)
    {
      if (computedReference == MapMakerInternalMap.UNSET)
      {
        computedReference = valueReference;
        notifyAll();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputingConcurrentHashMap.ComputingValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */