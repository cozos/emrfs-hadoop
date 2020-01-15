package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$3
  extends AbstractMultiset<E>
{
  Multisets$3(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public boolean contains(@Nullable Object element)
  {
    return (val$multiset1.contains(element)) || (val$multiset2.contains(element));
  }
  
  public boolean isEmpty()
  {
    return (val$multiset1.isEmpty()) && (val$multiset2.isEmpty());
  }
  
  public int size()
  {
    return val$multiset1.size() + val$multiset2.size();
  }
  
  public int count(Object element)
  {
    return val$multiset1.count(element) + val$multiset2.count(element);
  }
  
  Set<E> createElementSet()
  {
    return Sets.union(val$multiset1.elementSet(), val$multiset2.elementSet());
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    final Iterator<? extends Multiset.Entry<? extends E>> iterator1 = val$multiset1.entrySet().iterator();
    
    final Iterator<? extends Multiset.Entry<? extends E>> iterator2 = val$multiset2.entrySet().iterator();
    
    new AbstractIterator()
    {
      protected Multiset.Entry<E> computeNext()
      {
        if (iterator1.hasNext())
        {
          Multiset.Entry<? extends E> entry1 = (Multiset.Entry)iterator1.next();
          E element = entry1.getElement();
          int count = entry1.getCount() + val$multiset2.count(element);
          return Multisets.immutableEntry(element, count);
        }
        while (iterator2.hasNext())
        {
          Multiset.Entry<? extends E> entry2 = (Multiset.Entry)iterator2.next();
          E element = entry2.getElement();
          if (!val$multiset1.contains(element)) {
            return Multisets.immutableEntry(element, entry2.getCount());
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */