package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.Set;

final class $ImmutableSet$SingletonImmutableSet<E>
  extends .ImmutableSet<E>
{
  final E element;
  final int hashCode;
  
  $ImmutableSet$SingletonImmutableSet(E element, int hashCode)
  {
    this.element = element;
    this.hashCode = hashCode;
  }
  
  public int size()
  {
    return 1;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean contains(Object target)
  {
    return element.equals(target);
  }
  
  public .UnmodifiableIterator<E> iterator()
  {
    return .Iterators.singletonIterator(element);
  }
  
  public Object[] toArray()
  {
    return new Object[] { element };
  }
  
  public <T> T[] toArray(T[] array)
  {
    if (array.length == 0) {
      array = .ObjectArrays.newArray(array, 1);
    } else if (array.length > 1) {
      array[1] = null;
    }
    array[0] = element;
    return array;
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if ((object instanceof Set))
    {
      Set<?> that = (Set)object;
      return (that.size() == 1) && (element.equals(that.iterator().next()));
    }
    return false;
  }
  
  public final int hashCode()
  {
    return hashCode;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  public String toString()
  {
    String elementToString = element.toString();
    return elementToString.length() + 2 + '[' + elementToString + ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet.SingletonImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */