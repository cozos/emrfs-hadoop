package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

final class TreeRangeSet$SubRangeSet
  extends TreeRangeSet<C>
{
  private final Range<C> restriction;
  
  TreeRangeSet$SubRangeSet(Range<C> arg1)
  {
    super(new TreeRangeSet.SubRangeSetRangesByLowerBound(Range.all(), restriction, rangesByLowerBound, null), null);
    
    this.restriction = restriction;
  }
  
  public boolean encloses(Range<C> range)
  {
    if ((!restriction.isEmpty()) && (restriction.encloses(range)))
    {
      Range<C> enclosing = TreeRangeSet.access$600(this$0, range);
      return (enclosing != null) && (!enclosing.intersection(restriction).isEmpty());
    }
    return false;
  }
  
  @Nullable
  public Range<C> rangeContaining(C value)
  {
    if (!restriction.contains(value)) {
      return null;
    }
    Range<C> result = this$0.rangeContaining(value);
    return result == null ? null : result.intersection(restriction);
  }
  
  public void add(Range<C> rangeToAdd)
  {
    Preconditions.checkArgument(restriction.encloses(rangeToAdd), "Cannot add range %s to subRangeSet(%s)", new Object[] { rangeToAdd, restriction });
    
    super.add(rangeToAdd);
  }
  
  public void remove(Range<C> rangeToRemove)
  {
    if (rangeToRemove.isConnected(restriction)) {
      this$0.remove(rangeToRemove.intersection(restriction));
    }
  }
  
  public boolean contains(C value)
  {
    return (restriction.contains(value)) && (this$0.contains(value));
  }
  
  public void clear()
  {
    this$0.remove(restriction);
  }
  
  public RangeSet<C> subRangeSet(Range<C> view)
  {
    if (view.encloses(restriction)) {
      return this;
    }
    if (view.isConnected(restriction)) {
      return new SubRangeSet(this, restriction.intersection(view));
    }
    return ImmutableRangeSet.of();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.SubRangeSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */