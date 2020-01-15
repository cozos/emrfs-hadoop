package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils;

import java.util.ArrayList;
import java.util.Collection;

public class FluentArrayList<E>
  extends ArrayList<E>
{
  private static final long serialVersionUID = -8269850815375778149L;
  
  public FluentArrayList(int initialCapacity)
  {
    super(initialCapacity);
  }
  
  public FluentArrayList() {}
  
  public FluentArrayList(E... elements)
  {
    appendAll(elements);
  }
  
  public FluentArrayList(Collection<? extends E> c)
  {
    super(c);
  }
  
  public FluentArrayList<E> append(E e)
  {
    super.add(e);
    return this;
  }
  
  public FluentArrayList<E> delete(Object o)
  {
    super.remove(o);
    return this;
  }
  
  public FluentArrayList<E> appendAll(Collection<? extends E> c)
  {
    super.addAll(c);
    return this;
  }
  
  public FluentArrayList<E> appendAll(E... elements)
  {
    if (elements != null) {
      for (E e : elements) {
        add(e);
      }
    }
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.document.utils.FluentArrayList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */