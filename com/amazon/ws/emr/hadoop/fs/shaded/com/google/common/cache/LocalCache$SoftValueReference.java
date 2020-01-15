package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class LocalCache$SoftValueReference<K, V>
  extends SoftReference<V>
  implements LocalCache.ValueReference<K, V>
{
  final LocalCache.ReferenceEntry<K, V> entry;
  
  LocalCache$SoftValueReference(ReferenceQueue<V> queue, V referent, LocalCache.ReferenceEntry<K, V> entry)
  {
    super(referent, queue);
    this.entry = entry;
  }
  
  public int getWeight()
  {
    return 1;
  }
  
  public LocalCache.ReferenceEntry<K, V> getEntry()
  {
    return entry;
  }
  
  public void notifyNewValue(V newValue) {}
  
  public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, LocalCache.ReferenceEntry<K, V> entry)
  {
    return new SoftValueReference(queue, value, entry);
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.SoftValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */