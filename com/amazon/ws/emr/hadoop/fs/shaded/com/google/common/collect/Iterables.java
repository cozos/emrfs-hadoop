package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterables
{
  public static <T> Iterable<T> unmodifiableIterable(Iterable<T> iterable)
  {
    Preconditions.checkNotNull(iterable);
    if (((iterable instanceof UnmodifiableIterable)) || ((iterable instanceof ImmutableCollection))) {
      return iterable;
    }
    return new UnmodifiableIterable(iterable, null);
  }
  
  @Deprecated
  public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> iterable)
  {
    return (Iterable)Preconditions.checkNotNull(iterable);
  }
  
  private static final class UnmodifiableIterable<T>
    extends FluentIterable<T>
  {
    private final Iterable<T> iterable;
    
    private UnmodifiableIterable(Iterable<T> iterable)
    {
      this.iterable = iterable;
    }
    
    public Iterator<T> iterator()
    {
      return Iterators.unmodifiableIterator(iterable.iterator());
    }
    
    public String toString()
    {
      return iterable.toString();
    }
  }
  
  public static int size(Iterable<?> iterable)
  {
    return (iterable instanceof Collection) ? ((Collection)iterable).size() : Iterators.size(iterable.iterator());
  }
  
  public static boolean contains(Iterable<?> iterable, @Nullable Object element)
  {
    if ((iterable instanceof Collection))
    {
      Collection<?> collection = (Collection)iterable;
      return Collections2.safeContains(collection, element);
    }
    return Iterators.contains(iterable.iterator(), element);
  }
  
  public static boolean removeAll(Iterable<?> removeFrom, Collection<?> elementsToRemove)
  {
    return (removeFrom instanceof Collection) ? ((Collection)removeFrom).removeAll((Collection)Preconditions.checkNotNull(elementsToRemove)) : Iterators.removeAll(removeFrom.iterator(), elementsToRemove);
  }
  
  public static boolean retainAll(Iterable<?> removeFrom, Collection<?> elementsToRetain)
  {
    return (removeFrom instanceof Collection) ? ((Collection)removeFrom).retainAll((Collection)Preconditions.checkNotNull(elementsToRetain)) : Iterators.retainAll(removeFrom.iterator(), elementsToRetain);
  }
  
  public static <T> boolean removeIf(Iterable<T> removeFrom, Predicate<? super T> predicate)
  {
    if (((removeFrom instanceof RandomAccess)) && ((removeFrom instanceof List))) {
      return removeIfFromRandomAccessList((List)removeFrom, (Predicate)Preconditions.checkNotNull(predicate));
    }
    return Iterators.removeIf(removeFrom.iterator(), predicate);
  }
  
  private static <T> boolean removeIfFromRandomAccessList(List<T> list, Predicate<? super T> predicate)
  {
    int from = 0;
    int to = 0;
    for (; from < list.size(); from++)
    {
      T element = list.get(from);
      if (!predicate.apply(element))
      {
        if (from > to) {
          try
          {
            list.set(to, element);
          }
          catch (UnsupportedOperationException e)
          {
            slowRemoveIfForRemainingElements(list, predicate, to, from);
            return true;
          }
        }
        to++;
      }
    }
    list.subList(to, list.size()).clear();
    return from != to;
  }
  
  private static <T> void slowRemoveIfForRemainingElements(List<T> list, Predicate<? super T> predicate, int to, int from)
  {
    for (int n = list.size() - 1; n > from; n--) {
      if (predicate.apply(list.get(n))) {
        list.remove(n);
      }
    }
    for (int n = from - 1; n >= to; n--) {
      list.remove(n);
    }
  }
  
  @Nullable
  static <T> T removeFirstMatching(Iterable<T> removeFrom, Predicate<? super T> predicate)
  {
    Preconditions.checkNotNull(predicate);
    Iterator<T> iterator = removeFrom.iterator();
    while (iterator.hasNext())
    {
      T next = iterator.next();
      if (predicate.apply(next))
      {
        iterator.remove();
        return next;
      }
    }
    return null;
  }
  
  public static boolean elementsEqual(Iterable<?> iterable1, Iterable<?> iterable2)
  {
    if (((iterable1 instanceof Collection)) && ((iterable2 instanceof Collection)))
    {
      Collection<?> collection1 = (Collection)iterable1;
      Collection<?> collection2 = (Collection)iterable2;
      if (collection1.size() != collection2.size()) {
        return false;
      }
    }
    return Iterators.elementsEqual(iterable1.iterator(), iterable2.iterator());
  }
  
  public static String toString(Iterable<?> iterable)
  {
    return Iterators.toString(iterable.iterator());
  }
  
  public static <T> T getOnlyElement(Iterable<T> iterable)
  {
    return (T)Iterators.getOnlyElement(iterable.iterator());
  }
  
  @Nullable
  public static <T> T getOnlyElement(Iterable<? extends T> iterable, @Nullable T defaultValue)
  {
    return (T)Iterators.getOnlyElement(iterable.iterator(), defaultValue);
  }
  
  @GwtIncompatible("Array.newInstance(Class, int)")
  public static <T> T[] toArray(Iterable<? extends T> iterable, Class<T> type)
  {
    Collection<? extends T> collection = toCollection(iterable);
    T[] array = ObjectArrays.newArray(type, collection.size());
    return collection.toArray(array);
  }
  
  static Object[] toArray(Iterable<?> iterable)
  {
    return toCollection(iterable).toArray();
  }
  
  private static <E> Collection<E> toCollection(Iterable<E> iterable)
  {
    return (iterable instanceof Collection) ? (Collection)iterable : Lists.newArrayList(iterable.iterator());
  }
  
  public static <T> boolean addAll(Collection<T> addTo, Iterable<? extends T> elementsToAdd)
  {
    if ((elementsToAdd instanceof Collection))
    {
      Collection<? extends T> c = Collections2.cast(elementsToAdd);
      return addTo.addAll(c);
    }
    return Iterators.addAll(addTo, ((Iterable)Preconditions.checkNotNull(elementsToAdd)).iterator());
  }
  
  public static int frequency(Iterable<?> iterable, @Nullable Object element)
  {
    if ((iterable instanceof Multiset)) {
      return ((Multiset)iterable).count(element);
    }
    if ((iterable instanceof Set)) {
      return ((Set)iterable).contains(element) ? 1 : 0;
    }
    return Iterators.frequency(iterable.iterator(), element);
  }
  
  public static <T> Iterable<T> cycle(Iterable<T> iterable)
  {
    Preconditions.checkNotNull(iterable);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.cycle(val$iterable);
      }
      
      public String toString()
      {
        return String.valueOf(val$iterable.toString()).concat(" (cycled)");
      }
    };
  }
  
  public static <T> Iterable<T> cycle(T... elements)
  {
    return cycle(Lists.newArrayList(elements));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b)
  {
    return concat(ImmutableList.of(a, b));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c)
  {
    return concat(ImmutableList.of(a, b, c));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> a, Iterable<? extends T> b, Iterable<? extends T> c, Iterable<? extends T> d)
  {
    return concat(ImmutableList.of(a, b, c, d));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T>... inputs)
  {
    return concat(ImmutableList.copyOf(inputs));
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> inputs)
  {
    Preconditions.checkNotNull(inputs);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.concat(Iterables.iterators(val$inputs));
      }
    };
  }
  
  private static <T> Iterator<Iterator<? extends T>> iterators(Iterable<? extends Iterable<? extends T>> iterables)
  {
    new TransformedIterator(iterables.iterator())
    {
      Iterator<? extends T> transform(Iterable<? extends T> from)
      {
        return from.iterator();
      }
    };
  }
  
  public static <T> Iterable<List<T>> partition(Iterable<T> iterable, final int size)
  {
    Preconditions.checkNotNull(iterable);
    Preconditions.checkArgument(size > 0);
    new FluentIterable()
    {
      public Iterator<List<T>> iterator()
      {
        return Iterators.partition(val$iterable.iterator(), size);
      }
    };
  }
  
  public static <T> Iterable<List<T>> paddedPartition(Iterable<T> iterable, final int size)
  {
    Preconditions.checkNotNull(iterable);
    Preconditions.checkArgument(size > 0);
    new FluentIterable()
    {
      public Iterator<List<T>> iterator()
      {
        return Iterators.paddedPartition(val$iterable.iterator(), size);
      }
    };
  }
  
  public static <T> Iterable<T> filter(Iterable<T> unfiltered, final Predicate<? super T> predicate)
  {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(predicate);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.filter(val$unfiltered.iterator(), predicate);
      }
    };
  }
  
  @GwtIncompatible("Class.isInstance")
  public static <T> Iterable<T> filter(Iterable<?> unfiltered, final Class<T> type)
  {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(type);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.filter(val$unfiltered.iterator(), type);
      }
    };
  }
  
  public static <T> boolean any(Iterable<T> iterable, Predicate<? super T> predicate)
  {
    return Iterators.any(iterable.iterator(), predicate);
  }
  
  public static <T> boolean all(Iterable<T> iterable, Predicate<? super T> predicate)
  {
    return Iterators.all(iterable.iterator(), predicate);
  }
  
  public static <T> T find(Iterable<T> iterable, Predicate<? super T> predicate)
  {
    return (T)Iterators.find(iterable.iterator(), predicate);
  }
  
  @Nullable
  public static <T> T find(Iterable<? extends T> iterable, Predicate<? super T> predicate, @Nullable T defaultValue)
  {
    return (T)Iterators.find(iterable.iterator(), predicate, defaultValue);
  }
  
  public static <T> Optional<T> tryFind(Iterable<T> iterable, Predicate<? super T> predicate)
  {
    return Iterators.tryFind(iterable.iterator(), predicate);
  }
  
  public static <T> int indexOf(Iterable<T> iterable, Predicate<? super T> predicate)
  {
    return Iterators.indexOf(iterable.iterator(), predicate);
  }
  
  public static <F, T> Iterable<T> transform(Iterable<F> fromIterable, final Function<? super F, ? extends T> function)
  {
    Preconditions.checkNotNull(fromIterable);
    Preconditions.checkNotNull(function);
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.transform(val$fromIterable.iterator(), function);
      }
    };
  }
  
  public static <T> T get(Iterable<T> iterable, int position)
  {
    Preconditions.checkNotNull(iterable);
    return (T)((iterable instanceof List) ? ((List)iterable).get(position) : Iterators.get(iterable.iterator(), position));
  }
  
  @Nullable
  public static <T> T get(Iterable<? extends T> iterable, int position, @Nullable T defaultValue)
  {
    Preconditions.checkNotNull(iterable);
    Iterators.checkNonnegative(position);
    if ((iterable instanceof List))
    {
      List<? extends T> list = Lists.cast(iterable);
      return (T)(position < list.size() ? list.get(position) : defaultValue);
    }
    Iterator<? extends T> iterator = iterable.iterator();
    Iterators.advance(iterator, position);
    return (T)Iterators.getNext(iterator, defaultValue);
  }
  
  @Nullable
  public static <T> T getFirst(Iterable<? extends T> iterable, @Nullable T defaultValue)
  {
    return (T)Iterators.getNext(iterable.iterator(), defaultValue);
  }
  
  public static <T> T getLast(Iterable<T> iterable)
  {
    if ((iterable instanceof List))
    {
      List<T> list = (List)iterable;
      if (list.isEmpty()) {
        throw new NoSuchElementException();
      }
      return (T)getLastInNonemptyList(list);
    }
    return (T)Iterators.getLast(iterable.iterator());
  }
  
  @Nullable
  public static <T> T getLast(Iterable<? extends T> iterable, @Nullable T defaultValue)
  {
    if ((iterable instanceof Collection))
    {
      Collection<? extends T> c = Collections2.cast(iterable);
      if (c.isEmpty()) {
        return defaultValue;
      }
      if ((iterable instanceof List)) {
        return (T)getLastInNonemptyList(Lists.cast(iterable));
      }
    }
    return (T)Iterators.getLast(iterable.iterator(), defaultValue);
  }
  
  private static <T> T getLastInNonemptyList(List<T> list)
  {
    return (T)list.get(list.size() - 1);
  }
  
  public static <T> Iterable<T> skip(Iterable<T> iterable, final int numberToSkip)
  {
    Preconditions.checkNotNull(iterable);
    Preconditions.checkArgument(numberToSkip >= 0, "number to skip cannot be negative");
    if ((iterable instanceof List))
    {
      List<T> list = (List)iterable;
      new FluentIterable()
      {
        public Iterator<T> iterator()
        {
          int toSkip = Math.min(val$list.size(), numberToSkip);
          return val$list.subList(toSkip, val$list.size()).iterator();
        }
      };
    }
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        final Iterator<T> iterator = val$iterable.iterator();
        
        Iterators.advance(iterator, numberToSkip);
        
        new Iterator()
        {
          boolean atStart = true;
          
          public boolean hasNext()
          {
            return iterator.hasNext();
          }
          
          public T next()
          {
            T result = iterator.next();
            atStart = false;
            return result;
          }
          
          public void remove()
          {
            CollectPreconditions.checkRemove(!atStart);
            iterator.remove();
          }
        };
      }
    };
  }
  
  public static <T> Iterable<T> limit(Iterable<T> iterable, final int limitSize)
  {
    Preconditions.checkNotNull(iterable);
    Preconditions.checkArgument(limitSize >= 0, "limit is negative");
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.limit(val$iterable.iterator(), limitSize);
      }
    };
  }
  
  public static <T> Iterable<T> consumingIterable(Iterable<T> iterable)
  {
    if ((iterable instanceof Queue)) {
      new FluentIterable()
      {
        public Iterator<T> iterator()
        {
          return new Iterables.ConsumingQueueIterator((Queue)val$iterable, null);
        }
        
        public String toString()
        {
          return "Iterables.consumingIterable(...)";
        }
      };
    }
    Preconditions.checkNotNull(iterable);
    
    new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.consumingIterator(val$iterable.iterator());
      }
      
      public String toString()
      {
        return "Iterables.consumingIterable(...)";
      }
    };
  }
  
  private static class ConsumingQueueIterator<T>
    extends AbstractIterator<T>
  {
    private final Queue<T> queue;
    
    private ConsumingQueueIterator(Queue<T> queue)
    {
      this.queue = queue;
    }
    
    public T computeNext()
    {
      try
      {
        return (T)queue.remove();
      }
      catch (NoSuchElementException e) {}
      return (T)endOfData();
    }
  }
  
  public static boolean isEmpty(Iterable<?> iterable)
  {
    if ((iterable instanceof Collection)) {
      return ((Collection)iterable).isEmpty();
    }
    return !iterable.iterator().hasNext();
  }
  
  @Beta
  public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> iterables, final Comparator<? super T> comparator)
  {
    Preconditions.checkNotNull(iterables, "iterables");
    Preconditions.checkNotNull(comparator, "comparator");
    Iterable<T> iterable = new FluentIterable()
    {
      public Iterator<T> iterator()
      {
        return Iterators.mergeSorted(Iterables.transform(val$iterables, Iterables.access$300()), comparator);
      }
    };
    return new UnmodifiableIterable(iterable, null);
  }
  
  private static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator()
  {
    new Function()
    {
      public Iterator<? extends T> apply(Iterable<? extends T> iterable)
      {
        return iterable.iterator();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Iterables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */