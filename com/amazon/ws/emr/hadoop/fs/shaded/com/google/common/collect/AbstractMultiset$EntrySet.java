package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class AbstractMultiset$EntrySet
  extends Multisets.EntrySet<E>
{
  AbstractMultiset$EntrySet(AbstractMultiset paramAbstractMultiset) {}
  
  Multiset<E> multiset()
  {
    return this$0;
  }
  
  public Iterator<Multiset.Entry<E>> iterator()
  {
    return this$0.entryIterator();
  }
  
  public int size()
  {
    return this$0.distinctElements();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMultiset.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */