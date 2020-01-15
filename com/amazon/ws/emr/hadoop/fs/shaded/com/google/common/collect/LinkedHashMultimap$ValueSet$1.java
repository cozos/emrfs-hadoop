package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedHashMultimap$ValueSet$1
  implements Iterator<V>
{
  LinkedHashMultimap.ValueSetLink<K, V> nextEntry = LinkedHashMultimap.ValueSet.access$000(this$1);
  LinkedHashMultimap.ValueEntry<K, V> toRemove;
  int expectedModCount = LinkedHashMultimap.ValueSet.access$100(this$1);
  
  LinkedHashMultimap$ValueSet$1(LinkedHashMultimap.ValueSet paramValueSet) {}
  
  private void checkForComodification()
  {
    if (LinkedHashMultimap.ValueSet.access$100(this$1) != expectedModCount) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean hasNext()
  {
    checkForComodification();
    return nextEntry != this$1;
  }
  
  public V next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    LinkedHashMultimap.ValueEntry<K, V> entry = (LinkedHashMultimap.ValueEntry)nextEntry;
    V result = entry.getValue();
    toRemove = entry;
    nextEntry = entry.getSuccessorInValueSet();
    return result;
  }
  
  public void remove()
  {
    checkForComodification();
    CollectPreconditions.checkRemove(toRemove != null);
    this$1.remove(toRemove.getValue());
    expectedModCount = LinkedHashMultimap.ValueSet.access$100(this$1);
    toRemove = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap.ValueSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */