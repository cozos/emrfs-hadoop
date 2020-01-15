package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Collection;
import java.util.Set;

final class $ImmutableSet$EmptyImmutableSet
  extends .ImmutableSet<Object>
{
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
  
  public boolean containsAll(Collection<?> targets)
  {
    return targets.isEmpty();
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if ((object instanceof Set))
    {
      Set<?> that = (Set)object;
      return that.isEmpty();
    }
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  public String toString()
  {
    return "[]";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.EmptyImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */