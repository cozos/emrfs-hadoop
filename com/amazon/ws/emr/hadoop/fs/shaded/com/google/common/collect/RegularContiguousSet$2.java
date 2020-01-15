package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class RegularContiguousSet$2
  extends AbstractSequentialIterator<C>
{
  RegularContiguousSet$2(RegularContiguousSet paramRegularContiguousSet, Comparable x0)
  {
    super(x0);
  }
  
  final C first = this$0.first();
  
  protected C computeNext(C previous)
  {
    return RegularContiguousSet.access$000(previous, first) ? null : this$0.domain.previous(previous);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularContiguousSet.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */