package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;

final class LocalCache$WeightedWeakValueReference<K, V>
  extends LocalCache.WeakValueReference<K, V>
{
  final int weight;
  
  LocalCache$WeightedWeakValueReference(ReferenceQueue<V> queue, V referent, LocalCache.ReferenceEntry<K, V> entry, int weight)
  {
    super(queue, referent, entry);
    this.weight = weight;
  }
  
  public int getWeight()
  {
    return weight;
  }
  
  public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, LocalCache.ReferenceEntry<K, V> entry)
  {
    return new WeightedWeakValueReference(queue, value, entry, weight);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WeightedWeakValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */