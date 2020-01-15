package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class $ImmutableSet<E>
  extends .ImmutableCollection<E>
  implements Set<E>
{
  private static final ImmutableSet<?> EMPTY_IMMUTABLE_SET = new EmptyImmutableSet(null);
  
  public static <E> ImmutableSet<E> of()
  {
    return EMPTY_IMMUTABLE_SET;
  }
  
  public static <E> ImmutableSet<E> of(E element)
  {
    return new SingletonImmutableSet(element, element.hashCode());
  }
  
  public static <E> ImmutableSet<E> of(E... elements)
  {
    switch (elements.length)
    {
    case 0: 
      return of();
    case 1: 
      return of(elements[0]);
    }
    return create(Arrays.asList(elements), elements.length);
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> elements)
  {
    if ((elements instanceof ImmutableSet))
    {
      ImmutableSet<E> set = (ImmutableSet)elements;
      return set;
    }
    return copyOfInternal(.Collections2.toCollection(elements));
  }
  
  public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> elements)
  {
    Collection<E> list = .Lists.newArrayList(elements);
    return copyOfInternal(list);
  }
  
  private static <E> ImmutableSet<E> copyOfInternal(Collection<? extends E> collection)
  {
    switch (collection.size())
    {
    case 0: 
      return of();
    case 1: 
      return of(collection.iterator().next());
    }
    return create(collection, collection.size());
  }
  
  boolean isHashCodeFast()
  {
    return false;
  }
  
  public boolean equals(@.Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if (((object instanceof ImmutableSet)) && (isHashCodeFast()) && (((ImmutableSet)object).isHashCodeFast()) && (hashCode() != object.hashCode())) {
      return false;
    }
    return .Collections2.setEquals(this, object);
  }
  
  public int hashCode()
  {
    int hashCode = 0;
    for (Object o : this) {
      hashCode += o.hashCode();
    }
    return hashCode;
  }
  
  public abstract .UnmodifiableIterator<E> iterator();
  
  public String toString()
  {
    if (isEmpty()) {
      return "[]";
    }
    Iterator<E> iterator = iterator();
    StringBuilder result = new StringBuilder(size() * 16);
    result.append('[').append(iterator.next().toString());
    for (int i = 1; i < size(); i++) {
      result.append(", ").append(iterator.next().toString());
    }
    return ']';
  }
  
  private static final class EmptyImmutableSet
    extends .ImmutableSet<Object>
  {
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
    
    public boolean containsAll(Collection<?> targets)
    {
      return targets.isEmpty();
    }
    
    public boolean equals(@.Nullable Object object)
    {
      if ((object instanceof Set))
      {
        Set<?> that = (Set)object;
        return that.isEmpty();
      }
      return false;
    }
    
    public final int hashCode()
    {
      return 0;
    }
    
    boolean isHashCodeFast()
    {
      return true;
    }
    
    public String toString()
    {
      return "[]";
    }
  }
  
  private static final class SingletonImmutableSet<E>
    extends .ImmutableSet<E>
  {
    final E element;
    final int hashCode;
    
    SingletonImmutableSet(E element, int hashCode)
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
  
  private static <E> ImmutableSet<E> create(Iterable<? extends E> iterable, int count)
  {
    int tableSize = .Hashing.chooseTableSize(count);
    Object[] table = new Object[tableSize];
    int mask = tableSize - 1;
    
    List<E> elements = new ArrayList(count);
    int hashCode = 0;
    for (E element : iterable)
    {
      int hash = element.hashCode();
      for (int i = .Hashing.smear(hash);; i++)
      {
        int index = i & mask;
        Object value = table[index];
        if (value == null)
        {
          table[index] = element;
          elements.add(element);
          hashCode += hash;
        }
        else
        {
          if (value.equals(element)) {
            break;
          }
        }
      }
    }
    return elements.size() == 1 ? new SingletonImmutableSet(elements.get(0), hashCode) : new RegularImmutableSet(elements.toArray(), hashCode, table, mask);
  }
  
  static abstract class ArrayImmutableSet<E>
    extends .ImmutableSet<E>
  {
    final Object[] elements;
    
    ArrayImmutableSet(Object[] elements)
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
  
  private static final class RegularImmutableSet<E>
    extends .ImmutableSet.ArrayImmutableSet<E>
  {
    final Object[] table;
    final int mask;
    final int hashCode;
    
    RegularImmutableSet(Object[] elements, int hashCode, Object[] table, int mask)
    {
      super();
      this.table = table;
      this.mask = mask;
      this.hashCode = hashCode;
    }
    
    public boolean contains(Object target)
    {
      if (target == null) {
        return false;
      }
      for (int i = .Hashing.smear(target.hashCode());; i++)
      {
        Object candidate = table[(i & mask)];
        if (candidate == null) {
          return false;
        }
        if (candidate.equals(target)) {
          return true;
        }
      }
    }
    
    public int hashCode()
    {
      return hashCode;
    }
    
    boolean isHashCodeFast()
    {
      return true;
    }
  }
  
  static abstract class TransformedImmutableSet<D, E>
    extends .ImmutableSet<E>
  {
    final D[] source;
    final int hashCode;
    
    TransformedImmutableSet(D[] source, int hashCode)
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
      return .ImmutableSet.of(elements);
    }
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
    final ArrayList<E> contents = .Lists.newArrayList();
    
    public Builder<E> add(E element)
    {
      .Preconditions.checkNotNull(element, "element cannot be null");
      contents.add(element);
      return this;
    }
    
    public Builder<E> add(E... elements)
    {
      .Preconditions.checkNotNull(elements, "elements cannot be null");
      List<E> elemsAsList = Arrays.asList(elements);
      .Preconditions.checkContentsNotNull(elemsAsList, "elements cannot contain null");
      
      contents.addAll(elemsAsList);
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
    
    public Builder<E> addAll(Iterator<? extends E> elements)
    {
      while (elements.hasNext())
      {
        E element = elements.next();
        .Preconditions.checkNotNull(element, "element cannot be null");
        contents.add(element);
      }
      return this;
    }
    
    public .ImmutableSet<E> build()
    {
      return .ImmutableSet.copyOf(contents);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableSet
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */