package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

final class $ImmutableList$RegularImmutableList<E>
  extends .ImmutableList<E>
{
  private final int offset;
  private final int size;
  private final Object[] array;
  
  private $ImmutableList$RegularImmutableList(Object[] array, int offset, int size)
  {
    super(null);
    this.offset = offset;
    this.size = size;
    this.array = array;
  }
  
  private $ImmutableList$RegularImmutableList(Object[] array)
  {
    this(array, 0, array.length);
  }
  
  public int size()
  {
    return size;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public boolean contains(Object target)
  {
    return indexOf(target) != -1;
  }
  
  public .UnmodifiableIterator<E> iterator()
  {
    return .Iterators.forArray(array, offset, size);
  }
  
  public Object[] toArray()
  {
    Object[] newArray = new Object[size()];
    System.arraycopy(array, offset, newArray, 0, size);
    return newArray;
  }
  
  public <T> T[] toArray(T[] other)
  {
    if (other.length < size) {
      other = .ObjectArrays.newArray(other, size);
    } else if (other.length > size) {
      other[size] = null;
    }
    System.arraycopy(array, offset, other, 0, size);
    return other;
  }
  
  public E get(int index)
  {
    .Preconditions.checkElementIndex(index, size);
    return (E)array[(index + offset)];
  }
  
  public int indexOf(Object target)
  {
    if (target != null) {
      for (int i = offset; i < offset + size; i++) {
        if (array[i].equals(target)) {
          return i - offset;
        }
      }
    }
    return -1;
  }
  
  public int lastIndexOf(Object target)
  {
    if (target != null) {
      for (int i = offset + size - 1; i >= offset; i--) {
        if (array[i].equals(target)) {
          return i - offset;
        }
      }
    }
    return -1;
  }
  
  public .ImmutableList<E> subList(int fromIndex, int toIndex)
  {
    .Preconditions.checkPositionIndexes(fromIndex, toIndex, size);
    return fromIndex == toIndex ? .ImmutableList.of() : new RegularImmutableList(array, offset + fromIndex, toIndex - fromIndex);
  }
  
  public ListIterator<E> listIterator()
  {
    return listIterator(0);
  }
  
  public ListIterator<E> listIterator(final int start)
  {
    .Preconditions.checkPositionIndex(start, size);
    
    new ListIterator()
    {
      int index = start;
      
      public boolean hasNext()
      {
        return index < size;
      }
      
      public boolean hasPrevious()
      {
        return index > 0;
      }
      
      public int nextIndex()
      {
        return index;
      }
      
      public int previousIndex()
      {
        return index - 1;
      }
      
      public E next()
      {
        E result;
        try
        {
          result = get(index);
        }
        catch (IndexOutOfBoundsException rethrown)
        {
          throw new NoSuchElementException();
        }
        index += 1;
        return result;
      }
      
      public E previous()
      {
        E result;
        try
        {
          result = get(index - 1);
        }
        catch (IndexOutOfBoundsException rethrown)
        {
          throw new NoSuchElementException();
        }
        index -= 1;
        return result;
      }
      
      public void set(E o)
      {
        throw new UnsupportedOperationException();
      }
      
      public void add(E o)
      {
        throw new UnsupportedOperationException();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof List)) {
      return false;
    }
    List<?> that = (List)object;
    if (size() != that.size()) {
      return false;
    }
    int index = offset;
    if ((object instanceof RegularImmutableList))
    {
      RegularImmutableList<?> other = (RegularImmutableList)object;
      for (int i = offset; i < offset + size; i++) {
        if (!array[(index++)].equals(array[i])) {
          return false;
        }
      }
    }
    else
    {
      for (Object element : that) {
        if (!array[(index++)].equals(element)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    int hashCode = 1;
    for (int i = offset; i < offset + size; i++) {
      hashCode = 31 * hashCode + array[i].hashCode();
    }
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(size() * 16);
    sb.append('[').append(array[offset]);
    for (int i = offset + 1; i < offset + size; i++) {
      sb.append(", ").append(array[i]);
    }
    return ']';
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList.RegularImmutableList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */