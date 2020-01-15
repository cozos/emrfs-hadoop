package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSequentialIterator;

class LocalCache$WriteQueue$2
  extends AbstractSequentialIterator<LocalCache.ReferenceEntry<K, V>>
{
  LocalCache$WriteQueue$2(LocalCache.WriteQueue paramWriteQueue, LocalCache.ReferenceEntry x0)
  {
    super(x0);
  }
  
  protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> previous)
  {
    LocalCache.ReferenceEntry<K, V> next = previous.getNextInWriteQueue();
    return next == this$0.head ? null : next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WriteQueue.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */