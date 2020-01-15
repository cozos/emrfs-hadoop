package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;

abstract class ImmutableCollection$ArrayBasedBuilder<E>
  extends ImmutableCollection.Builder<E>
{
  Object[] contents;
  int size;
  
  ImmutableCollection$ArrayBasedBuilder(int initialCapacity)
  {
    CollectPreconditions.checkNonnegative(initialCapacity, "initialCapacity");
    contents = new Object[initialCapacity];
    size = 0;
  }
  
  private void ensureCapacity(int minCapacity)
  {
    if (contents.length < minCapacity) {
      contents = ObjectArrays.arraysCopyOf(contents, expandedCapacity(contents.length, minCapacity));
    }
  }
  
  public ArrayBasedBuilder<E> add(E element)
  {
    Preconditions.checkNotNull(element);
    ensureCapacity(size + 1);
    contents[(size++)] = element;
    return this;
  }
  
  public ImmutableCollection.Builder<E> add(E... elements)
  {
    ObjectArrays.checkElementsNotNull(elements);
    ensureCapacity(size + elements.length);
    System.arraycopy(elements, 0, contents, size, elements.length);
    size += elements.length;
    return this;
  }
  
  public ImmutableCollection.Builder<E> addAll(Iterable<? extends E> elements)
  {
    if ((elements instanceof Collection))
    {
      Collection<?> collection = (Collection)elements;
      ensureCapacity(size + collection.size());
    }
    super.addAll(elements);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */