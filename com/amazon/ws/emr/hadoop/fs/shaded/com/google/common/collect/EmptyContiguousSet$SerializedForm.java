package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;

@GwtIncompatible("serialization")
final class EmptyContiguousSet$SerializedForm<C extends Comparable>
  implements Serializable
{
  private final DiscreteDomain<C> domain;
  private static final long serialVersionUID = 0L;
  
  private EmptyContiguousSet$SerializedForm(DiscreteDomain<C> domain)
  {
    this.domain = domain;
  }
  
  private Object readResolve()
  {
    return new EmptyContiguousSet(domain);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EmptyContiguousSet.SerializedForm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */