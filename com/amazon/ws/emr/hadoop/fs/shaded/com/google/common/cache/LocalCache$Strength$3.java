package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

 enum LocalCache$Strength$3
{
  LocalCache$Strength$3()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> segment, LocalCache.ReferenceEntry<K, V> entry, V value, int weight)
  {
    return weight == 1 ? new LocalCache.WeakValueReference(valueReferenceQueue, value, entry) : new LocalCache.WeightedWeakValueReference(valueReferenceQueue, value, entry, weight);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalence.identity();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Strength.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */