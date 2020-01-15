package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;

class Multisets$FilteredMultiset$1
  implements Predicate<Multiset.Entry<E>>
{
  Multisets$FilteredMultiset$1(Multisets.FilteredMultiset paramFilteredMultiset) {}
  
  public boolean apply(Multiset.Entry<E> entry)
  {
    return this$0.predicate.apply(entry.getElement());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.FilteredMultiset.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */