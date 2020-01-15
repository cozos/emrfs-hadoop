package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class Multisets$2$1
  extends AbstractIterator<Multiset.Entry<E>>
{
  Multisets$2$1(Multisets.2 param2, Iterator paramIterator) {}
  
  protected Multiset.Entry<E> computeNext()
  {
    while (val$iterator1.hasNext())
    {
      Multiset.Entry<E> entry1 = (Multiset.Entry)val$iterator1.next();
      E element = entry1.getElement();
      int count = Math.min(entry1.getCount(), this$0.val$multiset2.count(element));
      if (count > 0) {
        return Multisets.immutableEntry(element, count);
      }
    }
    return (Multiset.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.2.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */