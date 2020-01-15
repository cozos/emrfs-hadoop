package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public abstract class FluentIterable<E>
  implements Iterable<E>
{
  private final Iterable<E> iterable;
  
  protected FluentIterable()
  {
    iterable = this;
  }
  
  FluentIterable(Iterable<E> iterable)
  {
    this.iterable = ((Iterable)Preconditions.checkNotNull(iterable));
  }
  
  public static <E> FluentIterable<E> from(final Iterable<E> iterable)
  {
    (iterable instanceof FluentIterable) ? (FluentIterable)iterable : new FluentIterable(iterable)
    {
      public Iterator<E> iterator()
      {
        return iterable.iterator();
      }
    };
  }
  
  @Deprecated
  public static <E> FluentIterable<E> from(FluentIterable<E> iterable)
  {
    return (FluentIterable)Preconditions.checkNotNull(iterable);
  }
  
  @Beta
  public static <E> FluentIterable<E> of(E[] elements)
  {
    return from(Lists.newArrayList(elements));
  }
  
  public String toString()
  {
    return Iterables.toString(iterable);
  }
  
  public final int size()
  {
    return Iterables.size(iterable);
  }
  
  public final boolean contains(@Nullable Object element)
  {
    return Iterables.contains(iterable, element);
  }
  
  @CheckReturnValue
  public final FluentIterable<E> cycle()
  {
    return from(Iterables.cycle(iterable));
  }
  
  @CheckReturnValue
  @Beta
  public final FluentIterable<E> append(Iterable<? extends E> other)
  {
    return from(Iterables.concat(iterable, other));
  }
  
  @CheckReturnValue
  @Beta
  public final FluentIterable<E> append(E... elements)
  {
    return from(Iterables.concat(iterable, Arrays.asList(elements)));
  }
  
  @CheckReturnValue
  public final FluentIterable<E> filter(Predicate<? super E> predicate)
  {
    return from(Iterables.filter(iterable, predicate));
  }
  
  @CheckReturnValue
  @GwtIncompatible("Class.isInstance")
  public final <T> FluentIterable<T> filter(Class<T> type)
  {
    return from(Iterables.filter(iterable, type));
  }
  
  public final boolean anyMatch(Predicate<? super E> predicate)
  {
    return Iterables.any(iterable, predicate);
  }
  
  public final boolean allMatch(Predicate<? super E> predicate)
  {
    return Iterables.all(iterable, predicate);
  }
  
  public final Optional<E> firstMatch(Predicate<? super E> predicate)
  {
    return Iterables.tryFind(iterable, predicate);
  }
  
  public final <T> FluentIterable<T> transform(Function<? super E, T> function)
  {
    return from(Iterables.transform(iterable, function));
  }
  
  public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function)
  {
    return from(Iterables.concat(transform(function)));
  }
  
  public final Optional<E> first()
  {
    Iterator<E> iterator = iterable.iterator();
    return iterator.hasNext() ? Optional.of(iterator.next()) : Optional.absent();
  }
  
  public final Optional<E> last()
  {
    if ((iterable instanceof List))
    {
      List<E> list = (List)iterable;
      if (list.isEmpty()) {
        return Optional.absent();
      }
      return Optional.of(list.get(list.size() - 1));
    }
    Iterator<E> iterator = iterable.iterator();
    if (!iterator.hasNext()) {
      return Optional.absent();
    }
    if ((iterable instanceof SortedSet))
    {
      SortedSet<E> sortedSet = (SortedSet)iterable;
      return Optional.of(sortedSet.last());
    }
    for (;;)
    {
      E current = iterator.next();
      if (!iterator.hasNext()) {
        return Optional.of(current);
      }
    }
  }
  
  @CheckReturnValue
  public final FluentIterable<E> skip(int numberToSkip)
  {
    return from(Iterables.skip(iterable, numberToSkip));
  }
  
  @CheckReturnValue
  public final FluentIterable<E> limit(int size)
  {
    return from(Iterables.limit(iterable, size));
  }
  
  public final boolean isEmpty()
  {
    return !iterable.iterator().hasNext();
  }
  
  public final ImmutableList<E> toList()
  {
    return ImmutableList.copyOf(iterable);
  }
  
  public final ImmutableList<E> toSortedList(Comparator<? super E> comparator)
  {
    return Ordering.from(comparator).immutableSortedCopy(iterable);
  }
  
  public final ImmutableSet<E> toSet()
  {
    return ImmutableSet.copyOf(iterable);
  }
  
  public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator)
  {
    return ImmutableSortedSet.copyOf(comparator, iterable);
  }
  
  public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> valueFunction)
  {
    return Maps.toMap(iterable, valueFunction);
  }
  
  public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> keyFunction)
  {
    return Multimaps.index(iterable, keyFunction);
  }
  
  public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> keyFunction)
  {
    return Maps.uniqueIndex(iterable, keyFunction);
  }
  
  @GwtIncompatible("Array.newArray(Class, int)")
  public final E[] toArray(Class<E> type)
  {
    return Iterables.toArray(iterable, type);
  }
  
  public final <C extends Collection<? super E>> C copyInto(C collection)
  {
    Preconditions.checkNotNull(collection);
    if ((iterable instanceof Collection)) {
      collection.addAll(Collections2.cast(iterable));
    } else {
      for (E item : iterable) {
        collection.add(item);
      }
    }
    return collection;
  }
  
  @Beta
  public final String join(Joiner joiner)
  {
    return joiner.join(this);
  }
  
  public final E get(int position)
  {
    return (E)Iterables.get(iterable, position);
  }
  
  private static class FromIterableFunction<E>
    implements Function<Iterable<E>, FluentIterable<E>>
  {
    public FluentIterable<E> apply(Iterable<E> fromObject)
    {
      return FluentIterable.from(fromObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FluentIterable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */