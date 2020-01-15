package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;

class LocalCache$StrongValueReference<K, V>
  implements LocalCache.ValueReference<K, V>
{
  final V referent;
  
  LocalCache$StrongValueReference(V referent)
  {
    this.referent = referent;
  }
  
  public V get()
  {
    return (V)referent;
  }
  
  public int getWeight()
  {
    return 1;
  }
  
  public LocalCache.ReferenceEntry<K, V> getEntry()
  {
    return null;
  }
  
  public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, LocalCache.ReferenceEntry<K, V> entry)
  {
    return this;
  }
  
  public boolean isLoading()
  {
    return false;
  }
  
  public boolean isActive()
  {
    return true;
  }
  
  public V waitForValue()
  {
    return (V)get();
  }
  
  public void notifyNewValue(V newValue) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.StrongValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */