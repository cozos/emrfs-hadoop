package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

 enum $MapMaker$Strength$2
{
  $MapMaker$Strength$2()
  {
    super(paramString, paramInt, null);
  }
  
  boolean equal(Object a, Object b)
  {
    return a == b;
  }
  
  int hash(Object o)
  {
    return System.identityHashCode(o);
  }
  
  <K, V> .MapMaker.ValueReference<K, V> referenceValue(.MapMaker.ReferenceEntry<K, V> entry, V value)
  {
    return new .MapMaker.SoftValueReference(value, entry);
  }
  
  <K, V> .MapMaker.ReferenceEntry<K, V> newEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
  {
    return next == null ? new .MapMaker.SoftEntry(internals, key, hash) : new .MapMaker.LinkedSoftEntry(internals, key, hash, next);
  }
  
  <K, V> .MapMaker.ReferenceEntry<K, V> copyEntry(K key, .MapMaker.ReferenceEntry<K, V> original, .MapMaker.ReferenceEntry<K, V> newNext)
  {
    .MapMaker.SoftEntry<K, V> from = (.MapMaker.SoftEntry)original;
    return newNext == null ? new .MapMaker.SoftEntry(internals, key, hash) : new .MapMaker.LinkedSoftEntry(internals, key, hash, newNext);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.Strength.2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */