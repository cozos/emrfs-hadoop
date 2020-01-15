package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSequentialIterator;

class LocalCache$AccessQueue$2
  extends AbstractSequentialIterator<LocalCache.ReferenceEntry<K, V>>
{
  LocalCache$AccessQueue$2(LocalCache.AccessQueue paramAccessQueue, LocalCache.ReferenceEntry x0)
  {
    super(x0);
  }
  
  protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> previous)
  {
    LocalCache.ReferenceEntry<K, V> next = previous.getNextInAccessQueue();
    return next == this$0.head ? null : next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.AccessQueue.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */