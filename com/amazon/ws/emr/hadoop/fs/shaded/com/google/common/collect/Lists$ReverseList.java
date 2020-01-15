package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

class Lists$ReverseList<T>
  extends AbstractList<T>
{
  private final List<T> forwardList;
  
  Lists$ReverseList(List<T> forwardList)
  {
    this.forwardList = ((List)Preconditions.checkNotNull(forwardList));
  }
  
  List<T> getForwardList()
  {
    return forwardList;
  }
  
  private int reverseIndex(int index)
  {
    int size = size();
    Preconditions.checkElementIndex(index, size);
    return size - 1 - index;
  }
  
  private int reversePosition(int index)
  {
    int size = size();
    Preconditions.checkPositionIndex(index, size);
    return size - index;
  }
  
  public void add(int index, @Nullable T element)
  {
    forwardList.add(reversePosition(index), element);
  }
  
  public void clear()
  {
    forwardList.clear();
  }
  
  public T remove(int index)
  {
    return (T)forwardList.remove(reverseIndex(index));
  }
  
  protected void removeRange(int fromIndex, int toIndex)
  {
    subList(fromIndex, toIndex).clear();
  }
  
  public T set(int index, @Nullable T element)
  {
    return (T)forwardList.set(reverseIndex(index), element);
  }
  
  public T get(int index)
  {
    return (T)forwardList.get(reverseIndex(index));
  }
  
  public int size()
  {
    return forwardList.size();
  }
  
  public List<T> subList(int fromIndex, int toIndex)
  {
    Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
    return Lists.reverse(forwardList.subList(reversePosition(toIndex), reversePosition(fromIndex)));
  }
  
  public Iterator<T> iterator()
  {
    return listIterator();
  }
  
  public ListIterator<T> listIterator(int index)
  {
    int start = reversePosition(index);
    final ListIterator<T> forwardIterator = forwardList.listIterator(start);
    new ListIterator()
    {
      boolean canRemoveOrSet;
      
      public void add(T e)
      {
        forwardIterator.add(e);
        forwardIterator.previous();
        canRemoveOrSet = false;
      }
      
      public boolean hasNext()
      {
        return forwardIterator.hasPrevious();
      }
      
      public boolean hasPrevious()
      {
        return forwardIterator.hasNext();
      }
      
      public T next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        canRemoveOrSet = true;
        return (T)forwardIterator.previous();
      }
      
      public int nextIndex()
      {
        return Lists.ReverseList.this.reversePosition(forwardIterator.nextIndex());
      }
      
      public T previous()
      {
        if (!hasPrevious()) {
          throw new NoSuchElementException();
        }
        canRemoveOrSet = true;
        return (T)forwardIterator.next();
      }
      
      public int previousIndex()
      {
        return nextIndex() - 1;
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(canRemoveOrSet);
        forwardIterator.remove();
        canRemoveOrSet = false;
      }
      
      public void set(T e)
      {
        Preconditions.checkState(canRemoveOrSet);
        forwardIterator.set(e);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists.ReverseList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */