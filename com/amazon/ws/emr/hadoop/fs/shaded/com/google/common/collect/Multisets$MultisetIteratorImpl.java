package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class Multisets$MultisetIteratorImpl<E>
  implements Iterator<E>
{
  private final Multiset<E> multiset;
  private final Iterator<Multiset.Entry<E>> entryIterator;
  private Multiset.Entry<E> currentEntry;
  private int laterCount;
  private int totalCount;
  private boolean canRemove;
  
  Multisets$MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> entryIterator)
  {
    this.multiset = multiset;
    this.entryIterator = entryIterator;
  }
  
  public boolean hasNext()
  {
    return (laterCount > 0) || (entryIterator.hasNext());
  }
  
  public E next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    if (laterCount == 0)
    {
      currentEntry = ((Multiset.Entry)entryIterator.next());
      totalCount = (laterCount = currentEntry.getCount());
    }
    laterCount -= 1;
    canRemove = true;
    return (E)currentEntry.getElement();
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(canRemove);
    if (totalCount == 1) {
      entryIterator.remove();
    } else {
      multiset.remove(currentEntry.getElement());
    }
    totalCount -= 1;
    canRemove = false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.MultisetIteratorImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */