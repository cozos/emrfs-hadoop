package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

 enum LocalCache$Strength
{
  STRONG,  SOFT,  WEAK;
  
  private LocalCache$Strength() {}
  
  abstract <K, V> LocalCache.ValueReference<K, V> referenceValue(LocalCache.Segment<K, V> paramSegment, LocalCache.ReferenceEntry<K, V> paramReferenceEntry, V paramV, int paramInt);
  
  abstract Equivalence<Object> defaultEquivalence();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Strength
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */