package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

 enum $MapMaker$Strength
{
  WEAK,  SOFT,  STRONG;
  
  private $MapMaker$Strength() {}
  
  abstract boolean equal(Object paramObject1, Object paramObject2);
  
  abstract int hash(Object paramObject);
  
  abstract <K, V> .MapMaker.ValueReference<K, V> referenceValue(.MapMaker.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
  
  abstract <K, V> .MapMaker.ReferenceEntry<K, V> newEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> paramInternals, K paramK, int paramInt, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry);
  
  abstract <K, V> .MapMaker.ReferenceEntry<K, V> copyEntry(K paramK, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry1, .MapMaker.ReferenceEntry<K, V> paramReferenceEntry2);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.Strength
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */