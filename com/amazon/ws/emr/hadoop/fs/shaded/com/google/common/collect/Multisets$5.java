package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;

final class Multisets$5
  extends Ordering<Multiset.Entry<?>>
{
  public int compare(Multiset.Entry<?> entry1, Multiset.Entry<?> entry2)
  {
    return Ints.compare(entry2.getCount(), entry1.getCount());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */