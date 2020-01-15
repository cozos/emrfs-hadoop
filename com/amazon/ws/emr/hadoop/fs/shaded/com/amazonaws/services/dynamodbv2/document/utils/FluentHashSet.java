package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

import java.util.Collection;
import java.util.LinkedHashSet;

public class FluentHashSet<E>
  extends LinkedHashSet<E>
{
  private static final long serialVersionUID = -549868294257559427L;
  
  public FluentHashSet() {}
  
  public FluentHashSet(Collection<? extends E> c)
  {
    super(c);
  }
  
  public FluentHashSet(E... elements)
  {
    withAll(elements);
  }
  
  public FluentHashSet(int initialCapacity, float loadFactor)
  {
    super(initialCapacity, loadFactor);
  }
  
  public FluentHashSet(int initialCapacity)
  {
    super(initialCapacity);
  }
  
  public FluentHashSet<E> with(E e)
  {
    super.add(e);
    return this;
  }
  
  public FluentHashSet<E> withAll(Collection<? extends E> c)
  {
    super.addAll(c);
    return this;
  }
  
  public FluentHashSet<E> withAll(E... elements)
  {
    if (elements != null) {
      for (E e : elements) {
        add(e);
      }
    }
    return this;
  }
  
  public FluentHashSet<E> delete(Object o)
  {
    super.remove(o);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.FluentHashSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */