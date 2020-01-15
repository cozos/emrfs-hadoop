package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

public final class ImmutableList$Builder<E>
  extends ImmutableCollection.ArrayBasedBuilder<E>
{
  public ImmutableList$Builder()
  {
    this(4);
  }
  
  ImmutableList$Builder(int capacity)
  {
    super(capacity);
  }
  
  public Builder<E> add(E element)
  {
    super.add(element);
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public Builder<E> add(E... elements)
  {
    super.add(elements);
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    super.addAll(elements);
    return this;
  }
  
  public ImmutableList<E> build()
  {
    return ImmutableList.asImmutableList(contents, size);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */