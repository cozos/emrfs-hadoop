package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$WeakEntry<K, V>
  extends .FinalizableWeakReference<K>
  implements .MapMaker.ReferenceEntry<K, V>
{
  final .CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals;
  final int hash;
  
  $MapMaker$WeakEntry(.CustomConcurrentHashMap.Internals<K, V, .MapMaker.ReferenceEntry<K, V>> internals, K key, int hash)
  {
    super(key, .MapMaker.QueueHolder.queue);
    this.internals = internals;
    this.hash = hash;
  }
  
  public K getKey()
  {
    return (K)get();
  }
  
  public void finalizeReferent()
  {
    internals.removeEntry(this);
  }
  
  volatile .MapMaker.ValueReference<K, V> valueReference = .MapMaker.access$600();
  
  public .MapMaker.ValueReference<K, V> getValueReference()
  {
    return valueReference;
  }
  
  public void setValueReference(.MapMaker.ValueReference<K, V> valueReference)
  {
    this.valueReference = valueReference;
  }
  
  public void valueReclaimed()
  {
    internals.removeEntry(this, null);
  }
  
  public .MapMaker.ReferenceEntry<K, V> getNext()
  {
    return null;
  }
  
  public int getHash()
  {
    return hash;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.WeakEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */