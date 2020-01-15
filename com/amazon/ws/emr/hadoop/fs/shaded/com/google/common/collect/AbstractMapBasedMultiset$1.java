package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1
  implements Iterator<Multiset.Entry<E>>
{
  Map.Entry<E, Count> toRemove;
  
  AbstractMapBasedMultiset$1(AbstractMapBasedMultiset paramAbstractMapBasedMultiset, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$backingEntries.hasNext();
  }
  
  public Multiset.Entry<E> next()
  {
    final Map.Entry<E, Count> mapEntry = (Map.Entry)val$backingEntries.next();
    toRemove = mapEntry;
    new Multisets.AbstractEntry()
    {
      public E getElement()
      {
        return (E)mapEntry.getKey();
      }
      
      public int getCount()
      {
        Count count = (Count)mapEntry.getValue();
        if ((count == null) || (count.get() == 0))
        {
          Count frequency = (Count)AbstractMapBasedMultiset.access$000(this$0).get(getElement());
          if (frequency != null) {
            return frequency.get();
          }
        }
        return count == null ? 0 : count.get();
      }
    };
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(toRemove != null);
    AbstractMapBasedMultiset.access$122(this$0, ((Count)toRemove.getValue()).getAndSet(0));
    val$backingEntries.remove();
    toRemove = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultiset.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */