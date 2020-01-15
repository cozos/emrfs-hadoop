package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

class ConcurrentHashMultiset$2
  extends AbstractIterator<Multiset.Entry<E>>
{
  private Iterator<Map.Entry<E, AtomicInteger>> mapEntries = ConcurrentHashMultiset.access$100(this$0).entrySet().iterator();
  
  ConcurrentHashMultiset$2(ConcurrentHashMultiset paramConcurrentHashMultiset) {}
  
  protected Multiset.Entry<E> computeNext()
  {
    for (;;)
    {
      if (!mapEntries.hasNext()) {
        return (Multiset.Entry)endOfData();
      }
      Map.Entry<E, AtomicInteger> mapEntry = (Map.Entry)mapEntries.next();
      int count = ((AtomicInteger)mapEntry.getValue()).get();
      if (count != 0) {
        return Multisets.immutableEntry(mapEntry.getKey(), count);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ConcurrentHashMultiset.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */