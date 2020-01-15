package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class $ImmutableCollection<E>
  implements Collection<E>, Serializable
{
  static final ImmutableCollection<Object> EMPTY_IMMUTABLE_COLLECTION = new EmptyImmutableCollection(null);
  private static final Object[] EMPTY_ARRAY = new Object[0];
  private static final .UnmodifiableIterator<Object> EMPTY_ITERATOR = new .UnmodifiableIterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
  };
  
  public abstract .UnmodifiableIterator<E> iterator();
  
  public Object[] toArray()
  {
    Object[] newArray = new Object[size()];
    return toArray(newArray);
  }
  
  public <T> T[] toArray(T[] other)
  {
    int size = size();
    if (other.length < size) {
      other = .ObjectArrays.newArray(other, size);
    } else if (other.length > size) {
      other[size] = null;
    }
    int index = 0;
    for (E element : this)
    {
      T elementAsT = element;
      
      other[(index++)] = elementAsT;
    }
    return other;
  }
  
  public boolean contains(@.Nullable Object object)
  {
    if (object == null) {
      return false;
    }
    for (E element : this) {
      if (element.equals(object)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    for (Object target : targets) {
      if (!contains(target)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder(size() * 16);
    sb.append('[');
    Iterator<E> i = iterator();
    if (i.hasNext()) {
      sb.append(i.next());
    }
    while (i.hasNext())
    {
      sb.append(", ");
      sb.append(i.next());
    }
    return ']';
  }
  
  public final boolean add(E e)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean remove(Object object)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean addAll(Collection<? extends E> newElements)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean removeAll(Collection<?> oldElements)
  {
    throw new UnsupportedOperationException();
  }
  
  public final boolean retainAll(Collection<?> elementsToKeep)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  private static class EmptyImmutableCollection
    extends .ImmutableCollection<Object>
  {
    public int size()
    {
      return 0;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public boolean contains(@.Nullable Object object)
    {
      return false;
    }
    
    public .UnmodifiableIterator<Object> iterator()
    {
      return .ImmutableCollection.EMPTY_ITERATOR;
    }
    
    public Object[] toArray()
    {
      return .ImmutableCollection.EMPTY_ARRAY;
    }
    
    public <T> T[] toArray(T[] array)
    {
      if (array.length > 0) {
        array[0] = null;
      }
      return array;
    }
  }
  
  private static class ArrayImmutableCollection<E>
    extends .ImmutableCollection<E>
  {
    private final E[] elements;
    
    ArrayImmutableCollection(E[] elements)
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
  
  private static class SerializedForm
    implements Serializable
  {
    final Object[] elements;
    private static final long serialVersionUID = 0L;
    
    SerializedForm(Object[] elements)
    {
      this.elements = elements;
    }
    
    Object readResolve()
    {
      return elements.length == 0 ? .ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION : new .ImmutableCollection.ArrayImmutableCollection((Object[])elements.clone());
    }
  }
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableCollection
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */