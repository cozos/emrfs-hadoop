package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$4
  extends AbstractMultiset<E>
{
  Multisets$4(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public int count(@Nullable Object element)
  {
    int count1 = val$multiset1.count(element);
    return count1 == 0 ? 0 : Math.max(0, count1 - val$multiset2.count(element));
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
          int count = entry1.getCount() - val$multiset2.count(element);
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
    return Iterators.size(entryIterator());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */