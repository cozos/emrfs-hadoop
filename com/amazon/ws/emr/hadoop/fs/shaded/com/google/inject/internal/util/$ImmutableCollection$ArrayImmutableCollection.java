package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;

class $ImmutableCollection$ArrayImmutableCollection<E>
  extends .ImmutableCollection<E>
{
  private final E[] elements;
  
  $ImmutableCollection$ArrayImmutableCollection(E[] elements)
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
    new .UnmodifiableIterator()
    {
      int i = 0;
      
      public boolean hasNext()
      {
        return i < elements.length;
      }
      
      public E next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return (E)elements[(i++)];
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableCollection.ArrayImmutableCollection
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */