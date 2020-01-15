package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class $ImmutableList<E>
  extends .ImmutableCollection<E>
  implements List<E>, RandomAccess
{
  private static final ImmutableList<?> EMPTY_IMMUTABLE_LIST = new EmptyImmutableList(null);
  
  public static <E> ImmutableList<E> of()
  {
    return EMPTY_IMMUTABLE_LIST;
  }
  
  public static <E> ImmutableList<E> of(E element)
  {
    return new RegularImmutableList(copyIntoArray(new Object[] { element }), null);
  }
  
  public static <E> ImmutableList<E> of(E e1, E e2)
  {
    return new RegularImmutableList(copyIntoArray(new Object[] { e1, e2 }), null);
  }
  
  public static <E> ImmutableList<E> of(E e1, E e2, E e3)
  {
    return new RegularImmutableList(copyIntoArray(new Object[] { e1, e2, e3 }), null);
  }
  
  public static <E> ImmutableList<E> of(E e1, E e2, E e3, E e4)
  {
    return new RegularImmutableList(copyIntoArray(new Object[] { e1, e2, e3, e4 }), null);
  }
  
  public static <E> ImmutableList<E> of(E e1, E e2, E e3, E e4, E e5)
  {
    return new RegularImmutableList(copyIntoArray(new Object[] { e1, e2, e3, e4, e5 }), null);
  }
  
  public static <E> ImmutableList<E> of(E... elements)
  {
    return elements.length == 0 ? of() : new RegularImmutableList(copyIntoArray(elements), null);
  }
  
  public static <E> ImmutableList<E> copyOf(Iterable<? extends E> elements)
  {
    if ((elements instanceof ImmutableList))
    {
      ImmutableList<E> list = (ImmutableList)elements;
      return list;
    }
    if ((elements instanceof Collection))
    {
      Collection<? extends E> coll = (Collection)elements;
      return copyOfInternal(coll);
    }
    return copyOfInternal(.Lists.newArrayList(elements));
  }
  
  public static <E> ImmutableList<E> copyOf(Iterator<? extends E> elements)
  {
    return copyOfInternal(.Lists.newArrayList(elements));
  }
  
  private static <E> ImmutableList<E> copyOfInternal(ArrayList<? extends E> list)
  {
    return list.isEmpty() ? of() : new RegularImmutableList(nullChecked(list.toArray()), null);
  }
  
  private static Object[] nullChecked(Object[] array)
  {
    int i = 0;
    for (int len = array.length; i < len; i++) {
      if (array[i] == null) {
        throw new NullPointerException("at index " + i);
      }
    }
    return array;
  }
  
  private static <E> ImmutableList<E> copyOfInternal(Collection<? extends E> collection)
  {
    int size = collection.size();
    return size == 0 ? of() : createFromIterable(collection, size);
  }
  
  public abstract .UnmodifiableIterator<E> iterator();
  
  public abstract int indexOf(@.Nullable Object paramObject);
  
  public abstract int lastIndexOf(@.Nullable Object paramObject);
  
  public abstract ImmutableList<E> subList(int paramInt1, int paramInt2);
  
  public final boolean addAll(int index, Collection<? extends E> newElements)
  {
    throw new UnsupportedOperationException();
  }
  
  public final E set(int index, E element)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void add(int index, E element)
  {
    throw new UnsupportedOperationException();
  }
  
  public final E remove(int index)
  {
    throw new UnsupportedOperationException();
  }
  
  private static final class EmptyImmutableList
    extends .ImmutableList<Object>
  {
    private EmptyImmutableList()
    {
      super();
    }
    
    public int size()
    {
      return 0;
    }
    
    public boolean isEmpty()
    {
      return true;
    }
    
    public boolean contains(Object target)
    {
      return false;
    }
    
    public .UnmodifiableIterator<Object> iterator()
    {
      return .Iterators.emptyIterator();
    }
    
    private static final Object[] EMPTY_ARRAY = new Object[0];
    
    public Object[] toArray()
    {
      return EMPTY_ARRAY;
    }
    
    public <T> T[] toArray(T[] a)
    {
      if (a.length > 0) {
        a[0] = null;
      }
      return a;
    }
    
    public Object get(int index)
    {
      .Preconditions.checkElementIndex(index, 0);
      throw new AssertionError("unreachable");
    }
    
    public int indexOf(Object target)
    {
      return -1;
    }
    
    public int lastIndexOf(Object target)
    {
      return -1;
    }
    
    public .ImmutableList<Object> subList(int fromIndex, int toIndex)
    {
      .Preconditions.checkPositionIndexes(fromIndex, toIndex, 0);
      return this;
    }
    
    public ListIterator<Object> listIterator()
    {
      return .Iterators.emptyListIterator();
    }
    
    public ListIterator<Object> listIterator(int start)
    {
      .Preconditions.checkPositionIndex(start, 0);
      return .Iterators.emptyListIterator();
    }
    
    public boolean containsAll(Collection<?> targets)
    {
      return targets.isEmpty();
    }
    
    public boolean equals(@.Nullable Object object)
    {
      if ((object instanceof List))
      {
        List<?> that = (List)object;
        return that.isEmpty();
      }
      return false;
    }
    
    public int hashCode()
    {
      return 1;
    }
    
    public String toString()
    {
      return "[]";
    }
  }
  
  private static final class RegularImmutableList<E>
    extends .ImmutableList<E>
  {
    private final int offset;
    private final int size;
    private final Object[] array;
    
    private RegularImmutableList(Object[] array, int offset, int size)
    {
      super();
      this.offset = offset;
      this.size = size;
      this.array = array;
    }
    
    private RegularImmutableList(Object[] array)
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
  
  private static Object[] copyIntoArray(Object... source)
  {
    Object[] array = new Object[source.length];
    int index = 0;
    for (Object element : source)
    {
      if (element == null) {
        throw new NullPointerException("at index " + index);
      }
      array[(index++)] = element;
    }
    return array;
  }
  
  private static <E> ImmutableList<E> createFromIterable(Iterable<?> source, int estimatedSize)
  {
    Object[] array = new Object[estimatedSize];
    int index = 0;
    for (Object element : source)
    {
      if (index == estimatedSize)
      {
        estimatedSize = (estimatedSize / 2 + 1) * 3;
        array = copyOf(array, estimatedSize);
      }
      if (element == null) {
        throw new NullPointerException("at index " + index);
      }
      array[(index++)] = element;
    }
    if (index == 0) {
      return of();
    }
    if (index != estimatedSize) {
      array = copyOf(array, index);
    }
    return new RegularImmutableList(array, 0, index, null);
  }
  
  private static Object[] copyOf(Object[] oldArray, int newSize)
  {
    Object[] newArray = new Object[newSize];
    System.arraycopy(oldArray, 0, newArray, 0, Math.min(oldArray.length, newSize));
    
    return newArray;
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
      return .ImmutableList.of(elements);
    }
  }
  
  private void readObject(ObjectInputStream stream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  Object writeReplace()
  {
    return new SerializedForm(toArray());
  }
  
  public static <E> Builder<E> builder()
  {
    return new Builder();
  }
  
  public static class Builder<E>
  {
    private final ArrayList<E> contents = .Lists.newArrayList();
    
    public Builder<E> add(E element)
    {
      .Preconditions.checkNotNull(element, "element cannot be null");
      contents.add(element);
      return this;
    }
    
    public Builder<E> addAll(Iterable<? extends E> elements)
    {
      if ((elements instanceof Collection))
      {
        Collection<? extends E> collection = (Collection)elements;
        contents.ensureCapacity(contents.size() + collection.size());
      }
      for (E elem : elements)
      {
        .Preconditions.checkNotNull(elem, "elements contains a null");
        contents.add(elem);
      }
      return this;
    }
    
    public .ImmutableList<E> build()
    {
      return .ImmutableList.copyOf(contents);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableList
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */