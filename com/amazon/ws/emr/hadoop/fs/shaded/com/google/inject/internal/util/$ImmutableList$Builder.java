package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.ArrayList;
import java.util.Collection;

public class $ImmutableList$Builder<E>
{
  private final ArrayList<E> contents = .Lists.newArrayList();
  
  public Builder<E> add(E element)
  {
    .Preconditions.checkNotNull(element, "element cannot be null");
    contents.add(element);
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    if ((elements instanceof Collection))
    {
      Collection<? extends E> collection = (Collection)elements;
      contents.ensureCapacity(contents.size() + collection.size());
    }
    for (E elem : elements)
    {
      .Preconditions.checkNotNull(elem, "elements contains a null");
      contents.add(elem);
    }
    return this;
  }
  
  public .ImmutableList<E> build()
  {
    return .ImmutableList.copyOf(contents);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */