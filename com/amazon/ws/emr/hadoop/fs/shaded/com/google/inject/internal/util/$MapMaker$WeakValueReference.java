package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$WeakValueReference<K, V>
  extends .FinalizableWeakReference<V>
  implements .MapMaker.ValueReference<K, V>
{
  final .MapMaker.ReferenceEntry<K, V> entry;
  
  $MapMaker$WeakValueReference(V referent, .MapMaker.ReferenceEntry<K, V> entry)
  {
    super(referent, .MapMaker.QueueHolder.queue);
    this.entry = entry;
  }
  
  public void finalizeReferent()
  {
    entry.valueReclaimed();
  }
  
  public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return new WeakValueReference(get(), entry);
  }
  
  public V waitForValue()
    throws InterruptedException
  {
    return (V)get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.WeakValueReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */