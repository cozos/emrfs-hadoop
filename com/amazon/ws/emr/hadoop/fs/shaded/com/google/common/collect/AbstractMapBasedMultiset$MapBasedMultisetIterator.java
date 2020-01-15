package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMapBasedMultiset$MapBasedMultisetIterator
  implements Iterator<E>
{
  final Iterator<Map.Entry<E, Count>> entryIterator;
  Map.Entry<E, Count> currentEntry;
  int occurrencesLeft;
  boolean canRemove;
  
  AbstractMapBasedMultiset$MapBasedMultisetIterator(AbstractMapBasedMultiset paramAbstractMapBasedMultiset)
  {
    entryIterator = AbstractMapBasedMultiset.access$000(paramAbstractMapBasedMultiset).entrySet().iterator();
  }
  
  public boolean hasNext()
  {
    return (occurrencesLeft > 0) || (entryIterator.hasNext());
  }
  
  public E next()
  {
    if (occurrencesLeft == 0)
    {
      currentEntry = ((Map.Entry)entryIterator.next());
      occurrencesLeft = ((Count)currentEntry.getValue()).get();
    }
    occurrencesLeft -= 1;
    canRemove = true;
    return (E)currentEntry.getKey();
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(canRemove);
    int frequency = ((Count)currentEntry.getValue()).get();
    if (frequency <= 0) {
      throw new ConcurrentModificationException();
    }
    if (((Count)currentEntry.getValue()).addAndGet(-1) == 0) {
      entryIterator.remove();
    }
    AbstractMapBasedMultiset.access$110(this$0);
    canRemove = false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultiset.MapBasedMultisetIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */