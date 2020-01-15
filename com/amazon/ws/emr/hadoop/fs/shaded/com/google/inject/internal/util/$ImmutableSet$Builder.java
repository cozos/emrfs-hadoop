package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class $ImmutableSet$Builder<E>
{
  final ArrayList<E> contents = .Lists.newArrayList();
  
  public Builder<E> add(E element)
  {
    .Preconditions.checkNotNull(element, "element cannot be null");
    contents.add(element);
    return this;
  }
  
  public Builder<E> add(E... elements)
  {
    .Preconditions.checkNotNull(elements, "elements cannot be null");
    List<E> elemsAsList = Arrays.asList(elements);
    .Preconditions.checkContentsNotNull(elemsAsList, "elements cannot contain null");
    
    contents.addAll(elemsAsList);
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
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    while (elements.hasNext())
    {
      E element = elements.next();
      .Preconditions.checkNotNull(element, "element cannot be null");
      contents.add(element);
    }
    return this;
  }
  
  public .ImmutableSet<E> build()
  {
    return .ImmutableSet.copyOf(contents);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.Builder
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */