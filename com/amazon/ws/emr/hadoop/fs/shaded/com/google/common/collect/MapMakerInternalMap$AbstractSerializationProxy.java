package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

abstract class MapMakerInternalMap$AbstractSerializationProxy<K, V>
  extends ForwardingConcurrentMap<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 3L;
  final MapMakerInternalMap.Strength keyStrength;
  final MapMakerInternalMap.Strength valueStrength;
  final Equivalence<Object> keyEquivalence;
  final Equivalence<Object> valueEquivalence;
  final long expireAfterWriteNanos;
  final long expireAfterAccessNanos;
  final int maximumSize;
  final int concurrencyLevel;
  final MapMaker.RemovalListener<? super K, ? super V> removalListener;
  transient ConcurrentMap<K, V> delegate;
  
  MapMakerInternalMap$AbstractSerializationProxy(MapMakerInternalMap.Strength keyStrength, MapMakerInternalMap.Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, int maximumSize, int concurrencyLevel, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> delegate)
  {
    this.keyStrength = keyStrength;
    this.valueStrength = valueStrength;
    this.keyEquivalence = keyEquivalence;
    this.valueEquivalence = valueEquivalence;
    this.expireAfterWriteNanos = expireAfterWriteNanos;
    this.expireAfterAccessNanos = expireAfterAccessNanos;
    this.maximumSize = maximumSize;
    this.concurrencyLevel = concurrencyLevel;
    this.removalListener = removalListener;
    this.delegate = delegate;
  }
  
  protected ConcurrentMap<K, V> delegate()
  {
    return delegate;
  }
  
  void writeMapTo(ObjectOutputStream out)
    throws IOException
  {
    out.writeInt(delegate.size());
    for (Map.Entry<K, V> entry : delegate.entrySet())
    {
      out.writeObject(entry.getKey());
      out.writeObject(entry.getValue());
    }
    out.writeObject(null);
  }
  
  MapMaker readMapMaker(ObjectInputStream in)
    throws IOException
  {
    int size = in.readInt();
    MapMaker mapMaker = new MapMaker().initialCapacity(size).setKeyStrength(keyStrength).setValueStrength(valueStrength).keyEquivalence(keyEquivalence).concurrencyLevel(concurrencyLevel);
    
    mapMaker.removalListener(removalListener);
    if (expireAfterWriteNanos > 0L) {
      mapMaker.expireAfterWrite(expireAfterWriteNanos, TimeUnit.NANOSECONDS);
    }
    if (expireAfterAccessNanos > 0L) {
      mapMaker.expireAfterAccess(expireAfterAccessNanos, TimeUnit.NANOSECONDS);
    }
    if (maximumSize != -1) {
      mapMaker.maximumSize(maximumSize);
    }
    return mapMaker;
  }
  
  void readEntries(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    for (;;)
    {
      K key = in.readObject();
      if (key == null) {
        break;
      }
      V value = in.readObject();
      delegate.put(key, value);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.AbstractSerializationProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */