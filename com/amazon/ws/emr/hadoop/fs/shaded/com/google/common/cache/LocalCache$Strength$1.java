package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

 enum LocalCache$Strength$1
{
  LocalCache$Strength$1()
  {
    super(paramString, paramInt, null);
  }
  
  <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> segment, LocalCache.ReferenceEntry<K, V> entry, V value, int weight)
  {
    return weight == 1 ? new LocalCache.StrongValueReference(value) : new LocalCache.WeightedStrongValueReference(value, weight);
  }
  
  Equivalence<Object> defaultEquivalence()
  {
    return Equivalence.equals();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Strength.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */