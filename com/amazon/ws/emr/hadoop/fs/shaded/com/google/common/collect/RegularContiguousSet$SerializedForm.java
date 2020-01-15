package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
final class RegularContiguousSet$SerializedForm<C extends Comparable>
  implements Serializable
{
  final Range<C> range;
  final DiscreteDomain<C> domain;
  
  private RegularContiguousSet$SerializedForm(Range<C> range, DiscreteDomain<C> domain)
  {
    this.range = range;
    this.domain = domain;
  }
  
  private Object readResolve()
  {
    return new RegularContiguousSet(range, domain);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularContiguousSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */