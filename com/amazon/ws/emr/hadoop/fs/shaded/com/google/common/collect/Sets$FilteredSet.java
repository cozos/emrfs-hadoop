package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Set;
import javax.annotation.Nullable;

class Sets$FilteredSet<E>
  extends Collections2.FilteredCollection<E>
  implements Set<E>
{
  Sets$FilteredSet(Set<E> unfiltered, Predicate<? super E> predicate)
  {
    super(unfiltered, predicate);
  }
  
  public boolean equals(@Nullable Object object)
  {
    return Sets.equalsImpl(this, object);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets.FilteredSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */