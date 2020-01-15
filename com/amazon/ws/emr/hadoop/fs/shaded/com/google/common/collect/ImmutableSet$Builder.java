package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

public class ImmutableSet$Builder<E>
  extends ImmutableCollection.ArrayBasedBuilder<E>
{
  public ImmutableSet$Builder()
  {
    this(4);
  }
  
  ImmutableSet$Builder(int capacity)
  {
    super(capacity);
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
  
  public ImmutableSet<E> build()
  {
    ImmutableSet<E> result = ImmutableSet.access$000(size, contents);
    
    size = result.size();
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSet.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */