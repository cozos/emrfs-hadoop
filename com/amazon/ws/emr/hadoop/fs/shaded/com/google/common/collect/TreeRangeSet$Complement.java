package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class TreeRangeSet$Complement
  extends TreeRangeSet<C>
{
  TreeRangeSet$Complement(TreeRangeSet paramTreeRangeSet)
  {
    super(new TreeRangeSet.ComplementRangesByLowerBound(rangesByLowerBound), null);
  }
  
  public void add(Range<C> rangeToAdd)
  {
    this$0.remove(rangeToAdd);
  }
  
  public void remove(Range<C> rangeToRemove)
  {
    this$0.add(rangeToRemove);
  }
  
  public boolean contains(C value)
  {
    return !this$0.contains(value);
  }
  
  public RangeSet<C> complement()
  {
    return this$0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeSet.Complement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */