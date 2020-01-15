package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

 enum $MapMaker$Strength$3
{
  $MapMaker$Strength$3()
  {
    super(paramString, paramInt, null);
  }
  
  boolean equal(Object a, Object b)
  {
    return a.equals(b);
  }
  
  int hash(Object o)
  {
    return o.hashCode();
  }
  
  <K, V> .MapMaker.ValueReference<K, V> referenceValue(.MapMaker.ReferenceEntry<K, V> entry, V value)
  {
    return new .MapMaker.StrongValueReference(value);
  }
  
  <K, V> .MapMaker.ReferenceEntry<K, V> newEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash, .MapMaker.ReferenceEntry<K, V> next)
  {
    return next == null ? new .MapMaker.StrongEntry(internals, key, hash) : new .MapMaker.LinkedStrongEntry(internals, key, hash, next);
  }
  
  <K, V> .MapMaker.ReferenceEntry<K, V> copyEntry(K key, .MapMaker.ReferenceEntry<K, V> original, .MapMaker.ReferenceEntry<K, V> newNext)
  {
    .MapMaker.StrongEntry<K, V> from = (.MapMaker.StrongEntry)original;
    return newNext == null ? new .MapMaker.StrongEntry(internals, key, hash) : new .MapMaker.LinkedStrongEntry(internals, key, hash, newNext);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.Strength.3
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */