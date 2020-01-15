package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$SoftValueReference<K, V>
  extends .FinalizableSoftReference<V>
  implements .MapMaker.ValueReference<K, V>
{
  final .MapMaker.ReferenceEntry<K, V> entry;
  
  $MapMaker$SoftValueReference(V referent, .MapMaker.ReferenceEntry<K, V> entry)
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
    return new SoftValueReference(get(), entry);
  }
  
  public V waitForValue()
  {
    return (V)get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.SoftValueReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */