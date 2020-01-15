package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;

 enum MapMakerInternalMap$Strength
{
  STRONG,  SOFT,  WEAK;
  
  private MapMakerInternalMap$Strength() {}
  
  abstract <K, V> MapMakerInternalMap.ValueReference<K, V> referenceValue(MapMakerInternalMap.Segment<K, V> paramSegment, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
  
  abstract Equivalence<Object> defaultEquivalence();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.Strength
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */