package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

final class $ImmutableList$EmptyImmutableList
  extends .ImmutableList<Object>
{
  private $ImmutableList$EmptyImmutableList()
  {
    super(null);
  }
  
  public int size()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean contains(Object target)
  {
    return false;
  }
  
  public .UnmodifiableIterator<Object> iterator()
  {
    return .Iterators.emptyIterator();
  }
  
  private static final Object[] EMPTY_ARRAY = new Object[0];
  
  public Object[] toArray()
  {
    return EMPTY_ARRAY;
  }
  
  public <T> T[] toArray(T[] a)
  {
    if (a.length > 0) {
      a[0] = null;
    }
    return a;
  }
  
  public Object get(int index)
  {
    .Preconditions.checkElementIndex(index, 0);
    throw new AssertionError("unreachable");
  }
  
  public int indexOf(Object target)
  {
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    return -1;
  }
  
  public .ImmutableList<Object> subList(int fromIndex, int toIndex)
  {
    .Preconditions.checkPositionIndexes(fromIndex, toIndex, 0);
    return this;
  }
  
  public ListIterator<Object> listIterator()
  {
    return .Iterators.emptyListIterator();
  }
  
  public ListIterator<Object> listIterator(int start)
  {
    .Preconditions.checkPositionIndex(start, 0);
    return .Iterators.emptyListIterator();
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    return targets.isEmpty();
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if ((object instanceof List))
    {
      List<?> that = (List)object;
      return that.isEmpty();
    }
    return false;
  }
  
  public int hashCode()
  {
    return 1;
  }
  
  public String toString()
  {
    return "[]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.EmptyImmutableList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */