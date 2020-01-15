package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.ListIterator;
import java.util.NoSuchElementException;

class $ImmutableList$RegularImmutableList$1
  implements ListIterator<E>
{
  int index = val$start;
  
  $ImmutableList$RegularImmutableList$1(.ImmutableList.RegularImmutableList paramRegularImmutableList, int paramInt) {}
  
  public boolean hasNext()
  {
    return index < .ImmutableList.RegularImmutableList.access$300(this$0);
  }
  
  public boolean hasPrevious()
  {
    return index > 0;
  }
  
  public int nextIndex()
  {
    return index;
  }
  
  public int previousIndex()
  {
    return index - 1;
  }
  
  public E next()
  {
    E result;
    try
    {
      result = this$0.get(index);
    }
    catch (IndexOutOfBoundsException rethrown)
    {
      throw new NoSuchElementException();
    }
    index += 1;
    return result;
  }
  
  public E previous()
  {
    E result;
    try
    {
      result = this$0.get(index - 1);
    }
    catch (IndexOutOfBoundsException rethrown)
    {
      throw new NoSuchElementException();
    }
    index -= 1;
    return result;
  }
  
  public void set(E o)
  {
    throw new UnsupportedOperationException();
  }
  
  public void add(E o)
  {
    throw new UnsupportedOperationException();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.RegularImmutableList.1
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */