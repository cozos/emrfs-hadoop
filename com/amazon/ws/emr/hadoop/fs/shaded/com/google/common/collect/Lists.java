package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.math.IntMath;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Lists
{
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList(E... elements)
  {
    Preconditions.checkNotNull(elements);
    
    int capacity = computeArrayListCapacity(elements.length);
    ArrayList<E> list = new ArrayList(capacity);
    Collections.addAll(list, elements);
    return list;
  }
  
  @VisibleForTesting
  static int computeArrayListCapacity(int arraySize)
  {
    CollectPreconditions.checkNonnegative(arraySize, "arraySize");
    
    return Ints.saturatedCast(5L + arraySize + arraySize / 10);
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList(Iterable<? extends E> elements)
  {
    Preconditions.checkNotNull(elements);
    
    return (elements instanceof Collection) ? new ArrayList(Collections2.cast(elements)) : newArrayList(elements.iterator());
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements)
  {
    ArrayList<E> list = newArrayList();
    Iterators.addAll(list, elements);
    return list;
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayListWithCapacity(int initialArraySize)
  {
    CollectPreconditions.checkNonnegative(initialArraySize, "initialArraySize");
    return new ArrayList(initialArraySize);
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayListWithExpectedSize(int estimatedSize)
  {
    return new ArrayList(computeArrayListCapacity(estimatedSize));
  }
  
  @GwtCompatible(serializable=true)
  public static <E> LinkedList<E> newLinkedList()
  {
    return new LinkedList();
  }
  
  @GwtCompatible(serializable=true)
  public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> elements)
  {
    LinkedList<E> list = newLinkedList();
    Iterables.addAll(list, elements);
    return list;
  }
  
  @GwtIncompatible("CopyOnWriteArrayList")
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList()
  {
    return new CopyOnWriteArrayList();
  }
  
  @GwtIncompatible("CopyOnWriteArrayList")
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> elements)
  {
    Collection<? extends E> elementsCollection = (elements instanceof Collection) ? Collections2.cast(elements) : newArrayList(elements);
    
    return new CopyOnWriteArrayList(elementsCollection);
  }
  
  public static <E> List<E> asList(@Nullable E first, E[] rest)
  {
    return new OnePlusArrayList(first, rest);
  }
  
  private static class OnePlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    final E first;
    final E[] rest;
    private static final long serialVersionUID = 0L;
    
    OnePlusArrayList(@Nullable E first, E[] rest)
    {
      this.first = first;
      this.rest = ((Object[])Preconditions.checkNotNull(rest));
    }
    
    public int size()
    {
      return rest.length + 1;
    }
    
    public E get(int index)
    {
      Preconditions.checkElementIndex(index, size());
      return (E)(index == 0 ? first : rest[(index - 1)]);
    }
  }
  
  public static <E> List<E> asList(@Nullable E first, @Nullable E second, E[] rest)
  {
    return new TwoPlusArrayList(first, second, rest);
  }
  
  private static class TwoPlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    final E first;
    final E second;
    final E[] rest;
    private static final long serialVersionUID = 0L;
    
    TwoPlusArrayList(@Nullable E first, @Nullable E second, E[] rest)
    {
      this.first = first;
      this.second = second;
      this.rest = ((Object[])Preconditions.checkNotNull(rest));
    }
    
    public int size()
    {
      return rest.length + 2;
    }
    
    public E get(int index)
    {
      switch (index)
      {
      case 0: 
        return (E)first;
      case 1: 
        return (E)second;
      }
      Preconditions.checkElementIndex(index, size());
      return (E)rest[(index - 2)];
    }
  }
  
  static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> lists)
  {
    return CartesianList.create(lists);
  }
  
  static <B> List<List<B>> cartesianProduct(List<? extends B>... lists)
  {
    return cartesianProduct(Arrays.asList(lists));
  }
  
  public static <F, T> List<T> transform(List<F> fromList, Function<? super F, ? extends T> function)
  {
    return (fromList instanceof RandomAccess) ? new TransformingRandomAccessList(fromList, function) : new TransformingSequentialList(fromList, function);
  }
  
  private static class TransformingSequentialList<F, T>
    extends AbstractSequentialList<T>
    implements Serializable
  {
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    private static final long serialVersionUID = 0L;
    
    TransformingSequentialList(List<F> fromList, Function<? super F, ? extends T> function)
    {
      this.fromList = ((List)Preconditions.checkNotNull(fromList));
      this.function = ((Function)Preconditions.checkNotNull(function));
    }
    
    public void clear()
    {
      fromList.clear();
    }
    
    public int size()
    {
      return fromList.size();
    }
    
    public ListIterator<T> listIterator(int index)
    {
      new TransformedListIterator(fromList.listIterator(index))
      {
        T transform(F from)
        {
          return (T)function.apply(from);
        }
      };
    }
  }
  
  private static class TransformingRandomAccessList<F, T>
    extends AbstractList<T>
    implements RandomAccess, Serializable
  {
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    private static final long serialVersionUID = 0L;
    
    TransformingRandomAccessList(List<F> fromList, Function<? super F, ? extends T> function)
    {
      this.fromList = ((List)Preconditions.checkNotNull(fromList));
      this.function = ((Function)Preconditions.checkNotNull(function));
    }
    
    public void clear()
    {
      fromList.clear();
    }
    
    public T get(int index)
    {
      return (T)function.apply(fromList.get(index));
    }
    
    public Iterator<T> iterator()
    {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int index)
    {
      new TransformedListIterator(fromList.listIterator(index))
      {
        T transform(F from)
        {
          return (T)function.apply(from);
        }
      };
    }
    
    public boolean isEmpty()
    {
      return fromList.isEmpty();
    }
    
    public T remove(int index)
    {
      return (T)function.apply(fromList.remove(index));
    }
    
    public int size()
    {
      return fromList.size();
    }
  }
  
  public static <T> List<List<T>> partition(List<T> list, int size)
  {
    Preconditions.checkNotNull(list);
    Preconditions.checkArgument(size > 0);
    return (list instanceof RandomAccess) ? new RandomAccessPartition(list, size) : new Partition(list, size);
  }
  
  private static class Partition<T>
    extends AbstractList<List<T>>
  {
    final List<T> list;
    final int size;
    
    Partition(List<T> list, int size)
    {
      this.list = list;
      this.size = size;
    }
    
    public List<T> get(int index)
    {
      Preconditions.checkElementIndex(index, size());
      int start = index * size;
      int end = Math.min(start + size, list.size());
      return list.subList(start, end);
    }
    
    public int size()
    {
      return IntMath.divide(list.size(), size, RoundingMode.CEILING);
    }
    
    public boolean isEmpty()
    {
      return list.isEmpty();
    }
  }
  
  private static class RandomAccessPartition<T>
    extends Lists.Partition<T>
    implements RandomAccess
  {
    RandomAccessPartition(List<T> list, int size)
    {
      super(size);
    }
  }
  
  @Beta
  public static ImmutableList<Character> charactersOf(String string)
  {
    return new StringAsImmutableList((String)Preconditions.checkNotNull(string));
  }
  
  private static final class StringAsImmutableList
    extends ImmutableList<Character>
  {
    private final String string;
    
    StringAsImmutableList(String string)
    {
      this.string = string;
    }
    
    public int indexOf(@Nullable Object object)
    {
      return (object instanceof Character) ? string.indexOf(((Character)object).charValue()) : -1;
    }
    
    public int lastIndexOf(@Nullable Object object)
    {
      return (object instanceof Character) ? string.lastIndexOf(((Character)object).charValue()) : -1;
    }
    
    public ImmutableList<Character> subList(int fromIndex, int toIndex)
    {
      Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
      return Lists.charactersOf(string.substring(fromIndex, toIndex));
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public Character get(int index)
    {
      Preconditions.checkElementIndex(index, size());
      return Character.valueOf(string.charAt(index));
    }
    
    public int size()
    {
      return string.length();
    }
  }
  
  @Beta
  public static List<Character> charactersOf(CharSequence sequence)
  {
    return new CharSequenceAsList((CharSequence)Preconditions.checkNotNull(sequence));
  }
  
  private static final class CharSequenceAsList
    extends AbstractList<Character>
  {
    private final CharSequence sequence;
    
    CharSequenceAsList(CharSequence sequence)
    {
      this.sequence = sequence;
    }
    
    public Character get(int index)
    {
      Preconditions.checkElementIndex(index, size());
      return Character.valueOf(sequence.charAt(index));
    }
    
    public int size()
    {
      return sequence.length();
    }
  }
  
  public static <T> List<T> reverse(List<T> list)
  {
    if ((list instanceof ImmutableList)) {
      return ((ImmutableList)list).reverse();
    }
    if ((list instanceof ReverseList)) {
      return ((ReverseList)list).getForwardList();
    }
    if ((list instanceof RandomAccess)) {
      return new RandomAccessReverseList(list);
    }
    return new ReverseList(list);
  }
  
  private static class ReverseList<T>
    extends AbstractList<T>
  {
    private final List<T> forwardList;
    
    ReverseList(List<T> forwardList)
    {
      this.forwardList = ((List)Preconditions.checkNotNull(forwardList));
    }
    
    List<T> getForwardList()
    {
      return forwardList;
    }
    
    private int reverseIndex(int index)
    {
      int size = size();
      Preconditions.checkElementIndex(index, size);
      return size - 1 - index;
    }
    
    private int reversePosition(int index)
    {
      int size = size();
      Preconditions.checkPositionIndex(index, size);
      return size - index;
    }
    
    public void add(int index, @Nullable T element)
    {
      forwardList.add(reversePosition(index), element);
    }
    
    public void clear()
    {
      forwardList.clear();
    }
    
    public T remove(int index)
    {
      return (T)forwardList.remove(reverseIndex(index));
    }
    
    protected void removeRange(int fromIndex, int toIndex)
    {
      subList(fromIndex, toIndex).clear();
    }
    
    public T set(int index, @Nullable T element)
    {
      return (T)forwardList.set(reverseIndex(index), element);
    }
    
    public T get(int index)
    {
      return (T)forwardList.get(reverseIndex(index));
    }
    
    public int size()
    {
      return forwardList.size();
    }
    
    public List<T> subList(int fromIndex, int toIndex)
    {
      Preconditions.checkPositionIndexes(fromIndex, toIndex, size());
      return Lists.reverse(forwardList.subList(reversePosition(toIndex), reversePosition(fromIndex)));
    }
    
    public Iterator<T> iterator()
    {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int index)
    {
      int start = reversePosition(index);
      final ListIterator<T> forwardIterator = forwardList.listIterator(start);
      new ListIterator()
      {
        boolean canRemoveOrSet;
        
        public void add(T e)
        {
          forwardIterator.add(e);
          forwardIterator.previous();
          canRemoveOrSet = false;
        }
        
        public boolean hasNext()
        {
          return forwardIterator.hasPrevious();
        }
        
        public boolean hasPrevious()
        {
          return forwardIterator.hasNext();
        }
        
        public T next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          canRemoveOrSet = true;
          return (T)forwardIterator.previous();
        }
        
        public int nextIndex()
        {
          return Lists.ReverseList.this.reversePosition(forwardIterator.nextIndex());
        }
        
        public T previous()
        {
          if (!hasPrevious()) {
            throw new NoSuchElementException();
          }
          canRemoveOrSet = true;
          return (T)forwardIterator.next();
        }
        
        public int previousIndex()
        {
          return nextIndex() - 1;
        }
        
        public void remove()
        {
          CollectPreconditions.checkRemove(canRemoveOrSet);
          forwardIterator.remove();
          canRemoveOrSet = false;
        }
        
        public void set(T e)
        {
          Preconditions.checkState(canRemoveOrSet);
          forwardIterator.set(e);
        }
      };
    }
  }
  
  private static class RandomAccessReverseList<T>
    extends Lists.ReverseList<T>
    implements RandomAccess
  {
    RandomAccessReverseList(List<T> forwardList)
    {
      super();
    }
  }
  
  static int hashCodeImpl(List<?> list)
  {
    int hashCode = 1;
    for (Object o : list)
    {
      hashCode = 31 * hashCode + (o == null ? 0 : o.hashCode());
      
      hashCode = hashCode ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
    return hashCode;
  }
  
  static boolean equalsImpl(List<?> list, @Nullable Object object)
  {
    if (object == Preconditions.checkNotNull(list)) {
      return true;
    }
    if (!(object instanceof List)) {
      return false;
    }
    List<?> o = (List)object;
    
    return (list.size() == o.size()) && (Iterators.elementsEqual(list.iterator(), o.iterator()));
  }
  
  static <E> boolean addAllImpl(List<E> list, int index, Iterable<? extends E> elements)
  {
    boolean changed = false;
    ListIterator<E> listIterator = list.listIterator(index);
    for (E e : elements)
    {
      listIterator.add(e);
      changed = true;
    }
    return changed;
  }
  
  static int indexOfImpl(List<?> list, @Nullable Object element)
  {
    ListIterator<?> listIterator = list.listIterator();
    while (listIterator.hasNext()) {
      if (Objects.equal(element, listIterator.next())) {
        return listIterator.previousIndex();
      }
    }
    return -1;
  }
  
  static int lastIndexOfImpl(List<?> list, @Nullable Object element)
  {
    ListIterator<?> listIterator = list.listIterator(list.size());
    while (listIterator.hasPrevious()) {
      if (Objects.equal(element, listIterator.previous())) {
        return listIterator.nextIndex();
      }
    }
    return -1;
  }
  
  static <E> ListIterator<E> listIteratorImpl(List<E> list, int index)
  {
    return new AbstractListWrapper(list).listIterator(index);
  }
  
  static <E> List<E> subListImpl(List<E> list, int fromIndex, int toIndex)
  {
    List<E> wrapper;
    List<E> wrapper;
    if ((list instanceof RandomAccess)) {
      wrapper = new RandomAccessListWrapper(list)
      {
        private static final long serialVersionUID = 0L;
        
        public ListIterator<E> listIterator(int index)
        {
          return backingList.listIterator(index);
        }
      };
    } else {
      wrapper = new AbstractListWrapper(list)
      {
        private static final long serialVersionUID = 0L;
        
        public ListIterator<E> listIterator(int index)
        {
          return backingList.listIterator(index);
        }
      };
    }
    return wrapper.subList(fromIndex, toIndex);
  }
  
  private static class AbstractListWrapper<E>
    extends AbstractList<E>
  {
    final List<E> backingList;
    
    AbstractListWrapper(List<E> backingList)
    {
      this.backingList = ((List)Preconditions.checkNotNull(backingList));
    }
    
    public void add(int index, E element)
    {
      backingList.add(index, element);
    }
    
    public boolean addAll(int index, Collection<? extends E> c)
    {
      return backingList.addAll(index, c);
    }
    
    public E get(int index)
    {
      return (E)backingList.get(index);
    }
    
    public E remove(int index)
    {
      return (E)backingList.remove(index);
    }
    
    public E set(int index, E element)
    {
      return (E)backingList.set(index, element);
    }
    
    public boolean contains(Object o)
    {
      return backingList.contains(o);
    }
    
    public int size()
    {
      return backingList.size();
    }
  }
  
  private static class RandomAccessListWrapper<E>
    extends Lists.AbstractListWrapper<E>
    implements RandomAccess
  {
    RandomAccessListWrapper(List<E> backingList)
    {
      super();
    }
  }
  
  static <T> List<T> cast(Iterable<T> iterable)
  {
    return (List)iterable;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */