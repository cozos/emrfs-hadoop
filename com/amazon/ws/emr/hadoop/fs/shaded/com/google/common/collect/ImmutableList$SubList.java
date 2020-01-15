package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class ImmutableList$SubList
  extends ImmutableList<E>
{
  final transient int offset;
  final transient int length;
  
  ImmutableList$SubList(ImmutableList paramImmutableList, int offset, int length)
  {
    this.offset = offset;
    this.length = length;
  }
  
  public int size()
  {
    return length;
  }
  
  public E get(int index)
  {
    Preconditions.checkElementIndex(index, length);
    return (E)this$0.get(index + offset);
  }
  
  public ImmutableList<E> subList(int fromIndex, int toIndex)
  {
    Preconditions.checkPositionIndexes(fromIndex, toIndex, length);
    return this$0.subList(fromIndex + offset, toIndex + offset);
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.SubList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */