package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class EmptyImmutableSet
  extends ImmutableSet<Object>
{
  static final EmptyImmutableSet INSTANCE = new EmptyImmutableSet();
  private static final long serialVersionUID = 0L;
  
  public int size()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public boolean contains(@Nullable Object target)
  {
    return false;
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    return targets.isEmpty();
  }
  
  public UnmodifiableIterator<Object> iterator()
  {
    return Iterators.emptyIterator();
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  int copyIntoArray(Object[] dst, int offset)
  {
    return offset;
  }
  
  public ImmutableList<Object> asList()
  {
    return ImmutableList.of();
  }
  
  public boolean equals(@Nullable Object object)
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
  
  Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EmptyImmutableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */