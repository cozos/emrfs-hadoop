package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class Multisets$3$1
  extends AbstractIterator<Multiset.Entry<E>>
{
  Multisets$3$1(Multisets.3 param3, Iterator paramIterator1, Iterator paramIterator2) {}
  
  protected Multiset.Entry<E> computeNext()
  {
    if (val$iterator1.hasNext())
    {
      Multiset.Entry<? extends E> entry1 = (Multiset.Entry)val$iterator1.next();
      E element = entry1.getElement();
      int count = entry1.getCount() + this$0.val$multiset2.count(element);
      return Multisets.immutableEntry(element, count);
    }
    while (val$iterator2.hasNext())
    {
      Multiset.Entry<? extends E> entry2 = (Multiset.Entry)val$iterator2.next();
      E element = entry2.getElement();
      if (!this$0.val$multiset1.contains(element)) {
        return Multisets.immutableEntry(element, entry2.getCount());
      }
    }
    return (Multiset.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.3.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */