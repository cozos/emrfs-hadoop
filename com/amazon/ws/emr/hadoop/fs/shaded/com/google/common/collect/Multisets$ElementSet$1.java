package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

class Multisets$ElementSet$1
  extends TransformedIterator<Multiset.Entry<E>, E>
{
  Multisets$ElementSet$1(Multisets.ElementSet paramElementSet, Iterator x0)
  {
    super(x0);
  }
  
  E transform(Multiset.Entry<E> entry)
  {
    return (E)entry.getElement();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.ElementSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */