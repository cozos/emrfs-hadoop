package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReferenceArray;

final class ComputingConcurrentHashMap$ComputingSegment<K, V>
  extends MapMakerInternalMap.Segment<K, V>
{
  ComputingConcurrentHashMap$ComputingSegment(MapMakerInternalMap<K, V> map, int initialCapacity, int maxSegmentSize)
  {
    super(map, initialCapacity, maxSegmentSize);
  }
  
  V getOrCompute(K key, int hash, Function<? super K, ? extends V> computingFunction)
    throws ExecutionException
  {
    try
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e;
      Object computingValueReference;
      V value;
      do
      {
        e = getEntry(key, hash);
        if (e != null)
        {
          V value = getLiveValue(e);
          if (value != null)
          {
            recordRead(e);
            return value;
          }
        }
        if ((e == null) || (!e.getValueReference().isComputingReference()))
        {
          boolean createNewEntry = true;
          computingValueReference = null;
          lock();
          int newCount;
          try
          {
            preWriteCleanup();
            
            newCount = count - 1;
            AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
            int index = hash & table.length() - 1;
            MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
            for (e = first; e != null; e = e.getNext())
            {
              K entryKey = e.getKey();
              if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
              {
                MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
                if (valueReference.isComputingReference())
                {
                  createNewEntry = false; break;
                }
                V value = e.getValueReference().get();
                if (value == null)
                {
                  enqueueNotification(entryKey, hash, value, MapMaker.RemovalCause.COLLECTED);
                }
                else if ((map.expires()) && (map.isExpired(e)))
                {
                  enqueueNotification(entryKey, hash, value, MapMaker.RemovalCause.EXPIRED);
                }
                else
                {
                  recordLockedRead(e);
                  return value;
                }
                evictionQueue.remove(e);
                expirationQueue.remove(e);
                count = newCount;
                
                break;
              }
            }
            if (createNewEntry)
            {
              computingValueReference = new ComputingConcurrentHashMap.ComputingValueReference(computingFunction);
              if (e == null)
              {
                e = newEntry(key, hash, first);
                e.setValueReference((MapMakerInternalMap.ValueReference)computingValueReference);
                table.set(index, e);
              }
              else
              {
                e.setValueReference((MapMakerInternalMap.ValueReference)computingValueReference);
              }
            }
          }
          finally
          {
            unlock();
          }
          if (createNewEntry) {
            return (V)compute(key, hash, e, (ComputingConcurrentHashMap.ComputingValueReference)computingValueReference);
          }
        }
        Preconditions.checkState(!Thread.holdsLock(e), "Recursive computation");
        
        value = e.getValueReference().waitForValue();
      } while (value == null);
      recordRead(e);
      return value;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  V compute(K key, int hash, MapMakerInternalMap.ReferenceEntry<K, V> e, ComputingConcurrentHashMap.ComputingValueReference<K, V> computingValueReference)
    throws ExecutionException
  {
    V value = null;
    long start = System.nanoTime();
    long end = 0L;
    try
    {
      synchronized (e)
      {
        value = computingValueReference.compute(key, hash);
        end = System.nanoTime();
      }
      V oldValue;
      if (value != null)
      {
        oldValue = put(key, hash, value, true);
        if (oldValue != null) {
          enqueueNotification(key, hash, value, MapMaker.RemovalCause.REPLACED);
        }
      }
      return value;
    }
    finally
    {
      if (end == 0L) {
        end = System.nanoTime();
      }
      if (value == null) {
        clearValue(key, hash, computingValueReference);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ComputingConcurrentHashMap.ComputingSegment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */