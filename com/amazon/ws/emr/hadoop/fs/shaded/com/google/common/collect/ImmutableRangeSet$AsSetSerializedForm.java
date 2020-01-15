package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

class ImmutableRangeSet$AsSetSerializedForm<C extends Comparable>
  implements Serializable
{
  private final ImmutableList<Range<C>> ranges;
  private final DiscreteDomain<C> domain;
  
  ImmutableRangeSet$AsSetSerializedForm(ImmutableList<Range<C>> ranges, DiscreteDomain<C> domain)
  {
    this.ranges = ranges;
    this.domain = domain;
  }
  
  Object readResolve()
  {
    return new ImmutableRangeSet(ranges).asSet(domain);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeSet.AsSetSerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */