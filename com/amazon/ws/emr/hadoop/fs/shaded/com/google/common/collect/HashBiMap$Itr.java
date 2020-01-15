package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class HashBiMap$Itr<T>
  implements Iterator<T>
{
  int nextBucket = 0;
  HashBiMap.BiEntry<K, V> next = null;
  HashBiMap.BiEntry<K, V> toRemove = null;
  int expectedModCount = HashBiMap.access$000(this$0);
  
  HashBiMap$Itr(HashBiMap paramHashBiMap) {}
  
  private void checkForConcurrentModification()
  {
    if (HashBiMap.access$000(this$0) != expectedModCount) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean hasNext()
  {
    checkForConcurrentModification();
    if (next != null) {
      return true;
    }
    while (nextBucket < HashBiMap.access$100(this$0).length)
    {
      if (HashBiMap.access$100(this$0)[nextBucket] != null)
      {
        next = HashBiMap.access$100(this$0)[(nextBucket++)];
        return true;
      }
      nextBucket += 1;
    }
    return false;
  }
  
  public T next()
  {
    checkForConcurrentModification();
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    HashBiMap.BiEntry<K, V> entry = next;
    next = nextInKToVBucket;
    toRemove = entry;
    return (T)output(entry);
  }
  
  public void remove()
  {
    checkForConcurrentModification();
    CollectPreconditions.checkRemove(toRemove != null);
    HashBiMap.access$200(this$0, toRemove);
    expectedModCount = HashBiMap.access$000(this$0);
    toRemove = null;
  }
  
  abstract T output(HashBiMap.BiEntry<K, V> paramBiEntry);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBiMap.Itr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */