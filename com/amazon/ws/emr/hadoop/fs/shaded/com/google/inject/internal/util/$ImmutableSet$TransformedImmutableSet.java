package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;

abstract class $ImmutableSet$TransformedImmutableSet<D, E>
  extends .ImmutableSet<E>
{
  final D[] source;
  final int hashCode;
  
  $ImmutableSet$TransformedImmutableSet(D[] source, int hashCode)
  {
    this.source = source;
    this.hashCode = hashCode;
  }
  
  abstract E transform(D paramD);
  
  public int size()
  {
    return source.length;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public .UnmodifiableIterator<E> iterator()
  {
    Iterator<E> iterator = new .AbstractIterator()
    {
      int index = 0;
      
      protected E computeNext()
      {
        return (E)(index < source.length ? transform(source[(index++)]) : endOfData());
      }
    };
    return .Iterators.unmodifiableIterator(iterator);
  }
  
  public Object[] toArray()
  {
    return toArray(new Object[size()]);
  }
  
  public <T> T[] toArray(T[] array)
  {
    int size = size();
    if (array.length < size) {
      array = .ObjectArrays.newArray(array, size);
    } else if (array.length > size) {
      array[size] = null;
    }
    for (int i = 0; i < source.length; i++) {
      array[i] = transform(source[i]);
    }
    return array;
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.TransformedImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */