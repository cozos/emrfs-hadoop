package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

final class Multisets$2
  extends AbstractMultiset<E>
{
  Multisets$2(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public int count(Object element)
  {
    int count1 = val$multiset1.count(element);
    return count1 == 0 ? 0 : Math.min(count1, val$multiset2.count(element));
  }
  
  Set<E> createElementSet()
  {
    return Sets.intersection(val$multiset1.elementSet(), val$multiset2.elementSet());
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    final Iterator<Multiset.Entry<E>> iterator1 = val$multiset1.entrySet().iterator();
    
    new AbstractIterator()
    {
      protected Multiset.Entry<E> computeNext()
      {
        while (iterator1.hasNext())
        {
          Multiset.Entry<E> entry1 = (Multiset.Entry)iterator1.next();
          E element = entry1.getElement();
          int count = Math.min(entry1.getCount(), val$multiset2.count(element));
          if (count > 0) {
            return Multisets.immutableEntry(element, count);
          }
        }
        return (Multiset.Entry)endOfData();
      }
    };
  }
  
  int distinctElements()
  {
    return elementSet().size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */