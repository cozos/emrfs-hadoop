package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.NavigableMap;
import java.util.Set;
import javax.annotation.Nullable;

final class TreeRangeSet$AsRanges
  extends ForwardingCollection<Range<C>>
  implements Set<Range<C>>
{
  TreeRangeSet$AsRanges(TreeRangeSet paramTreeRangeSet) {}
  
  protected Collection<Range<C>> delegate()
  {
    return this$0.rangesByLowerBound.values();
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  public boolean equals(@Nullable Object o)
  {
    return Sets.equalsImpl(this, o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.AsRanges
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */