package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

class LinkedHashMultimap$1
  implements Iterator<Map.Entry<K, V>>
{
  LinkedHashMultimap.ValueEntry<K, V> nextEntry = access$300this$0).successorInMultimap;
  LinkedHashMultimap.ValueEntry<K, V> toRemove;
  
  LinkedHashMultimap$1(LinkedHashMultimap paramLinkedHashMultimap) {}
  
  public boolean hasNext()
  {
    return nextEntry != LinkedHashMultimap.access$300(this$0);
  }
  
  public Map.Entry<K, V> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    LinkedHashMultimap.ValueEntry<K, V> result = nextEntry;
    toRemove = result;
    nextEntry = nextEntry.successorInMultimap;
    return result;
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(toRemove != null);
    this$0.remove(toRemove.getKey(), toRemove.getValue());
    toRemove = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */