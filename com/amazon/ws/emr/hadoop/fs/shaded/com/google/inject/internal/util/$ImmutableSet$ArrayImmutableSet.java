package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Collection;

abstract class $ImmutableSet$ArrayImmutableSet<E>
  extends .ImmutableSet<E>
{
  final Object[] elements;
  
  $ImmutableSet$ArrayImmutableSet(Object[] elements)
  {
    this.elements = elements;
  }
  
  public int size()
  {
    return elements.length;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public .UnmodifiableIterator<E> iterator()
  {
    return .Iterators.forArray(elements);
  }
  
  public Object[] toArray()
  {
    Object[] array = new Object[size()];
    System.arraycopy(elements, 0, array, 0, size());
    return array;
  }
  
  public <T> T[] toArray(T[] array)
  {
    int size = size();
    if (array.length < size) {
      array = .ObjectArrays.newArray(array, size);
    } else if (array.length > size) {
      array[size] = null;
    }
    System.arraycopy(elements, 0, array, 0, size);
    return array;
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    if (targets == this) {
      return true;
    }
    if (!(targets instanceof ArrayImmutableSet)) {
      return super.containsAll(targets);
    }
    if (targets.size() > size()) {
      return false;
    }
    for (Object target : elements) {
      if (!contains(target)) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.ArrayImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */