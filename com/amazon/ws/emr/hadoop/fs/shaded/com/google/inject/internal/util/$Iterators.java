package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class $Iterators
{
  static final Iterator<Object> EMPTY_ITERATOR = new .UnmodifiableIterator()
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
  
  public static <T> .UnmodifiableIterator<T> emptyIterator()
  {
    return (.UnmodifiableIterator)EMPTY_ITERATOR;
  }
  
  private static final ListIterator<Object> EMPTY_LIST_ITERATOR = new ListIterator()
  {
    public boolean hasNext()
    {
      return false;
    }
    
    public boolean hasPrevious()
    {
      return false;
    }
    
    public int nextIndex()
    {
      return 0;
    }
    
    public int previousIndex()
    {
      return -1;
    }
    
    public Object next()
    {
      throw new NoSuchElementException();
    }
    
    public Object previous()
    {
      throw new NoSuchElementException();
    }
    
    public void set(Object o)
    {
      throw new UnsupportedOperationException();
    }
    
    public void add(Object o)
    {
      throw new UnsupportedOperationException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  };
  
  public static <T> ListIterator<T> emptyListIterator()
  {
    return EMPTY_LIST_ITERATOR;
  }
  
  public static <T> .UnmodifiableIterator<T> unmodifiableIterator(Iterator<T> iterator)
  {
    .Preconditions.checkNotNull(iterator);
    new .UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return val$iterator.hasNext();
      }
      
      public T next()
      {
        return (T)val$iterator.next();
      }
    };
  }
  
  public static String toString(Iterator<?> iterator)
  {
    if (!iterator.hasNext()) {
      return "[]";
    }
    StringBuilder builder = new StringBuilder();
    builder.append('[').append(iterator.next());
    while (iterator.hasNext()) {
      builder.append(", ").append(iterator.next());
    }
    return ']';
  }
  
  public static <T> T getOnlyElement(Iterator<T> iterator)
  {
    T first = iterator.next();
    if (!iterator.hasNext()) {
      return first;
    }
    StringBuilder sb = new StringBuilder();
    sb.append("expected one element but was: <" + first);
    for (int i = 0; (i < 4) && (iterator.hasNext()); i++) {
      sb.append(", " + iterator.next());
    }
    if (iterator.hasNext()) {
      sb.append(", ...");
    }
    sb.append(">");
    
    throw new IllegalArgumentException(sb.toString());
  }
  
  public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> inputs)
  {
    .Preconditions.checkNotNull(inputs);
    new Iterator()
    {
      Iterator<? extends T> current = .Iterators.emptyIterator();
      Iterator<? extends T> removeFrom;
      
      public boolean hasNext()
      {
        while ((!current.hasNext()) && (val$inputs.hasNext())) {
          current = ((Iterator)val$inputs.next());
        }
        return current.hasNext();
      }
      
      public T next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        removeFrom = current;
        return (T)current.next();
      }
      
      public void remove()
      {
        .Preconditions.checkState(removeFrom != null, "no calls to next() since last call to remove()");
        
        removeFrom.remove();
        removeFrom = null;
      }
    };
  }
  
  public static <F, T> Iterator<T> transform(Iterator<F> fromIterator, final .Function<? super F, ? extends T> function)
  {
    .Preconditions.checkNotNull(fromIterator);
    .Preconditions.checkNotNull(function);
    new Iterator()
    {
      public boolean hasNext()
      {
        return val$fromIterator.hasNext();
      }
      
      public T next()
      {
        F from = val$fromIterator.next();
        return (T)function.apply(from);
      }
      
      public void remove()
      {
        val$fromIterator.remove();
      }
    };
  }
  
  public static <T> .UnmodifiableIterator<T> forArray(T... array)
  {
    new .UnmodifiableIterator()
    {
      final int length = val$array.length;
      int i = 0;
      
      public boolean hasNext()
      {
        return i < length;
      }
      
      public T next()
      {
        try
        {
          T t = val$array[i];
          i += 1;
          return t;
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
          throw new NoSuchElementException();
        }
      }
    };
  }
  
  public static <T> .UnmodifiableIterator<T> forArray(final T[] array, int offset, int length)
  {
    .Preconditions.checkArgument(length >= 0);
    final int end = offset + length;
    
    .Preconditions.checkPositionIndexes(offset, end, array.length);
    
    new .UnmodifiableIterator()
    {
      int i = val$offset;
      
      public boolean hasNext()
      {
        return i < end;
      }
      
      public T next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return (T)array[(i++)];
      }
    };
  }
  
  public static <T> .UnmodifiableIterator<T> singletonIterator(@.Nullable T value)
  {
    new .UnmodifiableIterator()
    {
      boolean done;
      
      public boolean hasNext()
      {
        return !done;
      }
      
      public T next()
      {
        if (done) {
          throw new NoSuchElementException();
        }
        done = true;
        return (T)val$value;
      }
    };
  }
  
  public static <T> Enumeration<T> asEnumeration(Iterator<T> iterator)
  {
    .Preconditions.checkNotNull(iterator);
    new Enumeration()
    {
      public boolean hasMoreElements()
      {
        return val$iterator.hasNext();
      }
      
      public T nextElement()
      {
        return (T)val$iterator.next();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterators
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */