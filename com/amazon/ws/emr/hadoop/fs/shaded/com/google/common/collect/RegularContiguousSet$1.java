package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class RegularContiguousSet$1
  extends AbstractSequentialIterator<C>
{
  RegularContiguousSet$1(RegularContiguousSet paramRegularContiguousSet, Comparable x0)
  {
    super(x0);
  }
  
  final C last = this$0.last();
  
  protected C computeNext(C previous)
  {
    return RegularContiguousSet.access$000(previous, last) ? null : this$0.domain.next(previous);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularContiguousSet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */