package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;

public abstract class ImmutableCollection$Builder<E>
{
  static final int DEFAULT_INITIAL_CAPACITY = 4;
  
  static int expandedCapacity(int oldCapacity, int minCapacity)
  {
    if (minCapacity < 0) {
      throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
    int newCapacity = oldCapacity + (oldCapacity >> 1) + 1;
    if (newCapacity < minCapacity) {
      newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
    }
    if (newCapacity < 0) {
      newCapacity = Integer.MAX_VALUE;
    }
    return newCapacity;
  }
  
  public abstract Builder<E> add(E paramE);
  
  public Builder<E> add(E... elements)
  {
    for (E element : elements) {
      add(element);
    }
    return this;
  }
  
  public Builder<E> addAll(Iterable<? extends E> elements)
  {
    for (E element : elements) {
      add(element);
    }
    return this;
  }
  
  public Builder<E> addAll(Iterator<? extends E> elements)
  {
    while (elements.hasNext()) {
      add(elements.next());
    }
    return this;
  }
  
  public abstract ImmutableCollection<E> build();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableCollection.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */