package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

public final class ImmutableSortedSet$Builder<E>
  extends ImmutableSet.Builder<E>
{
  private final Comparator<? super E> comparator;
  
  public ImmutableSortedSet$Builder(Comparator<? super E> comparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(comparator));
  }
  
  public Builder<E> add(E element)
  {
    super.add(element);
    return this;
  }
  
  public Builder<E> add(E... elements)
  {
    super.add(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public ImmutableSortedSet<E> build()
  {
    E[] contentsArray = (Object[])contents;
    ImmutableSortedSet<E> result = ImmutableSortedSet.construct(comparator, size, contentsArray);
    size = result.size();
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedSet.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */