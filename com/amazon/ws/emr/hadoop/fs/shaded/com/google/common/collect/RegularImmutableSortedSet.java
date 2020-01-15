package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class RegularImmutableSortedSet<E>
  extends ImmutableSortedSet<E>
{
  private final transient ImmutableList<E> elements;
  
  RegularImmutableSortedSet(ImmutableList<E> elements, Comparator<? super E> comparator)
  {
    super(comparator);
    this.elements = elements;
    Preconditions.checkArgument(!elements.isEmpty());
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return elements.iterator();
  }
  
  @GwtIncompatible("NavigableSet")
  public UnmodifiableIterator<E> descendingIterator()
  {
    return elements.reverse().iterator();
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public int size()
  {
    return elements.size();
  }
  
  public boolean contains(Object o)
  {
    try
    {
      return (o != null) && (unsafeBinarySearch(o) >= 0);
    }
    catch (ClassCastException e) {}
    return false;
  }
  
  public boolean containsAll(Collection<?> targets)
  {
    if ((targets instanceof Multiset)) {
      targets = ((Multiset)targets).elementSet();
    }
    if ((!SortedIterables.hasSameComparator(comparator(), targets)) || (targets.size() <= 1)) {
      return super.containsAll(targets);
    }
    PeekingIterator<E> thisIterator = Iterators.peekingIterator(iterator());
    Iterator<?> thatIterator = targets.iterator();
    Object target = thatIterator.next();
    try
    {
      while (thisIterator.hasNext())
      {
        int cmp = unsafeCompare(thisIterator.peek(), target);
        if (cmp < 0)
        {
          thisIterator.next();
        }
        else if (cmp == 0)
        {
          if (!thatIterator.hasNext()) {
            return true;
          }
          target = thatIterator.next();
        }
        else if (cmp > 0)
        {
          return false;
        }
      }
    }
    catch (NullPointerException e)
    {
      return false;
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
  
  private int unsafeBinarySearch(Object key)
    throws ClassCastException
  {
    return Collections.binarySearch(elements, key, unsafeComparator());
  }
  
  boolean isPartialView()
  {
    return elements.isPartialView();
  }
  
  int copyIntoArray(Object[] dst, int offset)
  {
    return elements.copyIntoArray(dst, offset);
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    if (!(object instanceof Set)) {
      return false;
    }
    Set<?> that = (Set)object;
    if (size() != that.size()) {
      return false;
    }
    if (SortedIterables.hasSameComparator(comparator, that))
    {
      Iterator<?> otherIterator = that.iterator();
      try
      {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext())
        {
          Object element = iterator.next();
          Object otherElement = otherIterator.next();
          if ((otherElement == null) || (unsafeCompare(element, otherElement) != 0)) {
            return false;
          }
        }
        return true;
      }
      catch (ClassCastException e)
      {
        return false;
      }
      catch (NoSuchElementException e)
      {
        return false;
      }
    }
    return containsAll(that);
  }
  
  public E first()
  {
    return (E)elements.get(0);
  }
  
  public E last()
  {
    return (E)elements.get(size() - 1);
  }
  
  public E lower(E element)
  {
    int index = headIndex(element, false) - 1;
    return index == -1 ? null : elements.get(index);
  }
  
  public E floor(E element)
  {
    int index = headIndex(element, true) - 1;
    return index == -1 ? null : elements.get(index);
  }
  
  public E ceiling(E element)
  {
    int index = tailIndex(element, true);
    return index == size() ? null : elements.get(index);
  }
  
  public E higher(E element)
  {
    int index = tailIndex(element, false);
    return index == size() ? null : elements.get(index);
  }
  
  ImmutableSortedSet<E> headSetImpl(E toElement, boolean inclusive)
  {
    return getSubSet(0, headIndex(toElement, inclusive));
  }
  
  int headIndex(E toElement, boolean inclusive)
  {
    return SortedLists.binarySearch(elements, Preconditions.checkNotNull(toElement), comparator(), inclusive ? SortedLists.KeyPresentBehavior.FIRST_AFTER : SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
  }
  
  ImmutableSortedSet<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
  {
    return tailSetImpl(fromElement, fromInclusive).headSetImpl(toElement, toInclusive);
  }
  
  ImmutableSortedSet<E> tailSetImpl(E fromElement, boolean inclusive)
  {
    return getSubSet(tailIndex(fromElement, inclusive), size());
  }
  
  int tailIndex(E fromElement, boolean inclusive)
  {
    return SortedLists.binarySearch(elements, Preconditions.checkNotNull(fromElement), comparator(), inclusive ? SortedLists.KeyPresentBehavior.FIRST_PRESENT : SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
  }
  
  Comparator<Object> unsafeComparator()
  {
    return comparator;
  }
  
  ImmutableSortedSet<E> getSubSet(int newFromIndex, int newToIndex)
  {
    if ((newFromIndex == 0) && (newToIndex == size())) {
      return this;
    }
    if (newFromIndex < newToIndex) {
      return new RegularImmutableSortedSet(elements.subList(newFromIndex, newToIndex), comparator);
    }
    return emptySet(comparator);
  }
  
  int indexOf(@Nullable Object target)
  {
    if (target == null) {
      return -1;
    }
    int position;
    try
    {
      position = SortedLists.binarySearch(elements, target, unsafeComparator(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.INVERTED_INSERTION_INDEX);
    }
    catch (ClassCastException e)
    {
      return -1;
    }
    return position >= 0 ? position : -1;
  }
  
  ImmutableList<E> createAsList()
  {
    return new ImmutableSortedAsList(this, elements);
  }
  
  ImmutableSortedSet<E> createDescendingSet()
  {
    return new RegularImmutableSortedSet(elements.reverse(), Ordering.from(comparator).reverse());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */