package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$StrategyImpl$FutureValueReference
  implements .MapMaker.ValueReference<K, V>
{
  final .MapMaker.ReferenceEntry<K, V> original;
  final .MapMaker.ReferenceEntry<K, V> newEntry;
  
  $MapMaker$StrategyImpl$FutureValueReference(.MapMaker.ReferenceEntry<K, V> arg1, .MapMaker.ReferenceEntry<K, V> original)
  {
    this.original = original;
    this.newEntry = newEntry;
  }
  
  public V get()
  {
    boolean success = false;
    try
    {
      V value = original.getValueReference().get();
      success = true;
      return value;
    }
    finally
    {
      if (!success) {
        removeEntry();
      }
    }
  }
  
  public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return new FutureValueReference(this$0, original, entry);
  }
  
  public V waitForValue()
    throws InterruptedException
  {
    boolean success = false;
    try
    {
      V value = this$0.waitForValue(original);
      success = true;
      return value;
    }
    finally
    {
      if (!success) {
        removeEntry();
      }
    }
  }
  
  void removeEntry()
  {
    this$0.internals.removeEntry(newEntry);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.StrategyImpl.FutureValueReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */