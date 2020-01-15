package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Arrays;
import java.util.Iterator;

public final class $Iterables
{
  public static String toString(Iterable<?> iterable)
  {
    return .Iterators.toString(iterable.iterator());
  }
  
  public static <T> T getOnlyElement(Iterable<T> iterable)
  {
    return (T).Iterators.getOnlyElement(iterable.iterator());
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b)
  {
    .Preconditions.checkNotNull(a);
    .Preconditions.checkNotNull(b);
    return concat(Arrays.asList(new Iterable[] { a, b }));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> inputs)
  {
    .Function<Iterable<? extends T>, Iterator<? extends T>> function = new .Function()
    {
      public Iterator<? extends T> apply(Iterable<? extends T> from)
      {
        return from.iterator();
      }
    };
    Iterable<Iterator<? extends T>> iterators = transform(inputs, function);
    
    new IterableWithToString()
    {
      public Iterator<T> iterator()
      {
        return .Iterators.concat(val$iterators.iterator());
      }
    };
  }
  
  public static <F, T> Iterable<T> transform(Iterable<F> fromIterable, final .Function<? super F, ? extends T> function)
  {
    .Preconditions.checkNotNull(fromIterable);
    .Preconditions.checkNotNull(function);
    new IterableWithToString()
    {
      public Iterator<T> iterator()
      {
        return .Iterators.transform(val$fromIterable.iterator(), function);
      }
    };
  }
  
  static abstract class IterableWithToString<E>
    implements Iterable<E>
  {
    public String toString()
    {
      return .Iterables.toString(this);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..Iterables
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */