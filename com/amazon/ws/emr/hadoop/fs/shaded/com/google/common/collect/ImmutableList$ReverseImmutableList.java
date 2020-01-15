package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import javax.annotation.Nullable;

class ImmutableList$ReverseImmutableList<E>
  extends ImmutableList<E>
{
  private final transient ImmutableList<E> forwardList;
  
  ImmutableList$ReverseImmutableList(ImmutableList<E> backingList)
  {
    forwardList = backingList;
  }
  
  private int reverseIndex(int index)
  {
    return size() - 1 - index;
  }
  
  private int reversePosition(int index)
  {
    return size() - index;
  }
  
  public ImmutableList<E> reverse()
  {
    return forwardList;
  }
  
  public boolean contains(@Nullable Object object)
  {
    return forwardList.contains(object);
  }
  
  public int indexOf(@Nullable Object object)
  {
    int index = forwardList.lastIndexOf(object);
    return index >= 0 ? reverseIndex(index) : -1;
  }
  
  public int lastIndexOf(@Nullable Object object)
  {
    int index = forwardList.indexOf(object);
    return index >= 0 ? reverseIndex(index) : -1;
  }
  
  public ImmutableList<E> subList(int fromIndex, int toIndex)
  {
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
    return forwardList.subList(reversePosition(toIndex), reversePosition(fromIndex)).reverse();
  }
  
  public E get(int index)
  {
    Preconditions.checkElementIndex(index, size());
    return (E)forwardList.get(reverseIndex(index));
  }
  
  public int size()
  {
    return forwardList.size();
  }
  
  boolean isPartialView()
  {
    return forwardList.isPartialView();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.ReverseImmutableList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */