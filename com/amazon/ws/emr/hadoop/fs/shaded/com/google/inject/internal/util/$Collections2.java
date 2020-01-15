package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Collection;
import java.util.Set;

public final class $Collections2
{
  static <E> Collection<E> toCollection(Iterable<E> iterable)
  {
    return (iterable instanceof Collection) ? (Collection)iterable : .Lists.newArrayList(iterable);
  }
  
  static boolean setEquals(Set<?> thisSet, @.Nullable Object object)
  {
    if (object == thisSet) {
      return true;
    }
    if ((object instanceof Set))
    {
      Set<?> thatSet = (Set)object;
      return (thisSet.size() == thatSet.size()) && (thisSet.containsAll(thatSet));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Collections2
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */