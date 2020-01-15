package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.concurrent.atomic.AtomicReferenceArray;

class $CustomConcurrentHashMap$ComputingImpl<K, V, E>
  extends .CustomConcurrentHashMap.Impl<K, V, E>
{
  static final long serialVersionUID = 0L;
  final .CustomConcurrentHashMap.ComputingStrategy<K, V, E> computingStrategy;
  final .Function<? super K, ? extends V> computer;
  
  $CustomConcurrentHashMap$ComputingImpl(.CustomConcurrentHashMap.ComputingStrategy<K, V, E> strategy, .CustomConcurrentHashMap.Builder builder, .Function<? super K, ? extends V> computer)
  {
    super(strategy, builder);
    computingStrategy = strategy;
    this.computer = computer;
  }
  
  public V get(Object k)
  {
    K key = (K)k;
    if (key == null) {
      throw new NullPointerException("key");
    }
    int hash = hash(key);
    .CustomConcurrentHashMap.Impl<K, V, E>.Segment segment = segmentFor(hash);
    for (;;)
    {
      E entry = segment.getEntry(key, hash);
      V value;
      if (entry == null)
      {
        boolean created = false;
        segment.lock();
        int index;
        try
        {
          entry = segment.getEntry(key, hash);
          if (entry == null)
          {
            created = true;
            int count = count;
            if (count++ > threshold) {
              segment.expand();
            }
            AtomicReferenceArray<E> table = table;
            index = hash & table.length() - 1;
            E first = table.get(index);
            modCount += 1;
            entry = computingStrategy.newEntry(key, hash, first);
            table.set(index, entry);
            count = count;
          }
        }
        finally
        {
          segment.unlock();
        }
        if (created)
        {
          boolean success = false;
          try
          {
            value = computingStrategy.compute(key, entry, computer);
            if (value == null) {
              throw new NullPointerException("compute() returned null unexpectedly");
            }
            success = true;
            return value;
          }
          finally
          {
            if (!success) {
              segment.removeEntry(entry, hash);
            }
          }
        }
      }
      boolean interrupted = false;
      try
      {
        V value = computingStrategy.waitForValue(entry);
        if (value == null)
        {
          segment.removeEntry(entry, hash);
          if (!interrupted) {
            continue;
          }
          Thread.currentThread().interrupt(); continue;
        }
        return value;
      }
      catch (InterruptedException e)
      {
        for (;;)
        {
          interrupted = true;
        }
      }
      finally
      {
        if (interrupted) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.ComputingImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */