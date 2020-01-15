package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;

class Lists$AbstractListWrapper<E>
  extends AbstractList<E>
{
  final List<E> backingList;
  
  Lists$AbstractListWrapper(List<E> backingList)
  {
    this.backingList = ((List)Preconditions.checkNotNull(backingList));
  }
  
  public void add(int index, E element)
  {
    backingList.add(index, element);
  }
  
  public boolean addAll(int index, Collection<? extends E> c)
  {
    return backingList.addAll(index, c);
  }
  
  public E get(int index)
  {
    return (E)backingList.get(index);
  }
  
  public E remove(int index)
  {
    return (E)backingList.remove(index);
  }
  
  public E set(int index, E element)
  {
    return (E)backingList.set(index, element);
  }
  
  public boolean contains(Object o)
  {
    return backingList.contains(o);
  }
  
  public int size()
  {
    return backingList.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.AbstractListWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */