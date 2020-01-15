package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public final class Multisets
{
  public static <E> Multiset<E> unmodifiableMultiset(Multiset<? extends E> multiset)
  {
    if (((multiset instanceof UnmodifiableMultiset)) || ((multiset instanceof ImmutableMultiset)))
    {
      Multiset<E> result = multiset;
      return result;
    }
    return new UnmodifiableMultiset((Multiset)Preconditions.checkNotNull(multiset));
  }
  
  @Deprecated
  public static <E> Multiset<E> unmodifiableMultiset(ImmutableMultiset<E> multiset)
  {
    return (Multiset)Preconditions.checkNotNull(multiset);
  }
  
  static class UnmodifiableMultiset<E>
    extends ForwardingMultiset<E>
    implements Serializable
  {
    final Multiset<? extends E> delegate;
    transient Set<E> elementSet;
    transient Set<Multiset.Entry<E>> entrySet;
    private static final long serialVersionUID = 0L;
    
    UnmodifiableMultiset(Multiset<? extends E> delegate)
    {
      this.delegate = delegate;
    }
    
    protected Multiset<E> delegate()
    {
      return delegate;
    }
    
    Set<E> createElementSet()
    {
      return Collections.unmodifiableSet(delegate.elementSet());
    }
    
    public Set<E> elementSet()
    {
      Set<E> es = elementSet;
      return es == null ? (elementSet = createElementSet()) : es;
    }
    
    public Set<Multiset.Entry<E>> entrySet()
    {
      Set<Multiset.Entry<E>> es = entrySet;
      return es == null ? (entrySet = Collections.unmodifiableSet(delegate.entrySet())) : es;
    }
    
    public Iterator<E> iterator()
    {
      return Iterators.unmodifiableIterator(delegate.iterator());
    }
    
    public boolean add(E element)
    {
      throw new UnsupportedOperationException();
    }
    
    public int add(E element, int occurences)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean addAll(Collection<? extends E> elementsToAdd)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object element)
    {
      throw new UnsupportedOperationException();
    }
    
    public int remove(Object element, int occurrences)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean removeAll(Collection<?> elementsToRemove)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean retainAll(Collection<?> elementsToRetain)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public int setCount(E element, int count)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean setCount(E element, int oldCount, int newCount)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  @Beta
  public static <E> SortedMultiset<E> unmodifiableSortedMultiset(SortedMultiset<E> sortedMultiset)
  {
    return new UnmodifiableSortedMultiset((SortedMultiset)Preconditions.checkNotNull(sortedMultiset));
  }
  
  public static <E> Multiset.Entry<E> immutableEntry(@Nullable E e, int n)
  {
    return new ImmutableEntry(e, n);
  }
  
  static final class ImmutableEntry<E>
    extends Multisets.AbstractEntry<E>
    implements Serializable
  {
    @Nullable
    final E element;
    final int count;
    private static final long serialVersionUID = 0L;
    
    ImmutableEntry(@Nullable E element, int count)
    {
      this.element = element;
      this.count = count;
      CollectPreconditions.checkNonnegative(count, "count");
    }
    
    @Nullable
    public E getElement()
    {
      return (E)element;
    }
    
    public int getCount()
    {
      return count;
    }
  }
  
  @Beta
  public static <E> Multiset<E> filter(Multiset<E> unfiltered, Predicate<? super E> predicate)
  {
    if ((unfiltered instanceof FilteredMultiset))
    {
      FilteredMultiset<E> filtered = (FilteredMultiset)unfiltered;
      Predicate<E> combinedPredicate = Predicates.and(predicate, predicate);
      
      return new FilteredMultiset(unfiltered, combinedPredicate);
    }
    return new FilteredMultiset(unfiltered, predicate);
  }
  
  private static final class FilteredMultiset<E>
    extends AbstractMultiset<E>
  {
    final Multiset<E> unfiltered;
    final Predicate<? super E> predicate;
    
    FilteredMultiset(Multiset<E> unfiltered, Predicate<? super E> predicate)
    {
      this.unfiltered = ((Multiset)Preconditions.checkNotNull(unfiltered));
      this.predicate = ((Predicate)Preconditions.checkNotNull(predicate));
    }
    
    public UnmodifiableIterator<E> iterator()
    {
      return Iterators.filter(unfiltered.iterator(), predicate);
    }
    
    Set<E> createElementSet()
    {
      return Sets.filter(unfiltered.elementSet(), predicate);
    }
    
    Set<Multiset.Entry<E>> createEntrySet()
    {
      Sets.filter(unfiltered.entrySet(), new Predicate()
      {
        public boolean apply(Multiset.Entry<E> entry)
        {
          return predicate.apply(entry.getElement());
        }
      });
    }
    
    Iterator<Multiset.Entry<E>> entryIterator()
    {
      throw new AssertionError("should never be called");
    }
    
    int distinctElements()
    {
      return elementSet().size();
    }
    
    public int count(@Nullable Object element)
    {
      int count = unfiltered.count(element);
      if (count > 0)
      {
        E e = (E)element;
        return predicate.apply(e) ? count : 0;
      }
      return 0;
    }
    
    public int add(@Nullable E element, int occurrences)
    {
      Preconditions.checkArgument(predicate.apply(element), "Element %s does not match predicate %s", new Object[] { element, predicate });
      
      return unfiltered.add(element, occurrences);
    }
    
    public int remove(@Nullable Object element, int occurrences)
    {
      CollectPreconditions.checkNonnegative(occurrences, "occurrences");
      if (occurrences == 0) {
        return count(element);
      }
      return contains(element) ? unfiltered.remove(element, occurrences) : 0;
    }
    
    public void clear()
    {
      elementSet().clear();
    }
  }
  
  static int inferDistinctElements(Iterable<?> elements)
  {
    if ((elements instanceof Multiset)) {
      return ((Multiset)elements).elementSet().size();
    }
    return 11;
  }
  
  @Beta
  public static <E> Multiset<E> union(Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2)
  {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    
    new AbstractMultiset()
    {
      public boolean contains(@Nullable Object element)
      {
        return (val$multiset1.contains(element)) || (multiset2.contains(element));
      }
      
      public boolean isEmpty()
      {
        return (val$multiset1.isEmpty()) && (multiset2.isEmpty());
      }
      
      public int count(Object element)
      {
        return Math.max(val$multiset1.count(element), multiset2.count(element));
      }
      
      Set<E> createElementSet()
      {
        return Sets.union(val$multiset1.elementSet(), multiset2.elementSet());
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        final Iterator<? extends Multiset.Entry<? extends E>> iterator1 = val$multiset1.entrySet().iterator();
        
        final Iterator<? extends Multiset.Entry<? extends E>> iterator2 = multiset2.entrySet().iterator();
        
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            if (iterator1.hasNext())
            {
              Multiset.Entry<? extends E> entry1 = (Multiset.Entry)iterator1.next();
              E element = entry1.getElement();
              int count = Math.max(entry1.getCount(), val$multiset2.count(element));
              return Multisets.immutableEntry(element, count);
            }
            while (iterator2.hasNext())
            {
              Multiset.Entry<? extends E> entry2 = (Multiset.Entry)iterator2.next();
              E element = entry2.getElement();
              if (!val$multiset1.contains(element)) {
                return Multisets.immutableEntry(element, entry2.getCount());
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
    };
  }
  
  public static <E> Multiset<E> intersection(Multiset<E> multiset1, final Multiset<?> multiset2)
  {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    
    new AbstractMultiset()
    {
      public int count(Object element)
      {
        int count1 = val$multiset1.count(element);
        return count1 == 0 ? 0 : Math.min(count1, multiset2.count(element));
      }
      
      Set<E> createElementSet()
      {
        return Sets.intersection(val$multiset1.elementSet(), multiset2.elementSet());
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        final Iterator<Multiset.Entry<E>> iterator1 = val$multiset1.entrySet().iterator();
        
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            while (iterator1.hasNext())
            {
              Multiset.Entry<E> entry1 = (Multiset.Entry)iterator1.next();
              E element = entry1.getElement();
              int count = Math.min(entry1.getCount(), val$multiset2.count(element));
              if (count > 0) {
                return Multisets.immutableEntry(element, count);
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
    };
  }
  
  @Beta
  public static <E> Multiset<E> sum(Multiset<? extends E> multiset1, final Multiset<? extends E> multiset2)
  {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    
    new AbstractMultiset()
    {
      public boolean contains(@Nullable Object element)
      {
        return (val$multiset1.contains(element)) || (multiset2.contains(element));
      }
      
      public boolean isEmpty()
      {
        return (val$multiset1.isEmpty()) && (multiset2.isEmpty());
      }
      
      public int size()
      {
        return val$multiset1.size() + multiset2.size();
      }
      
      public int count(Object element)
      {
        return val$multiset1.count(element) + multiset2.count(element);
      }
      
      Set<E> createElementSet()
      {
        return Sets.union(val$multiset1.elementSet(), multiset2.elementSet());
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        final Iterator<? extends Multiset.Entry<? extends E>> iterator1 = val$multiset1.entrySet().iterator();
        
        final Iterator<? extends Multiset.Entry<? extends E>> iterator2 = multiset2.entrySet().iterator();
        
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            if (iterator1.hasNext())
            {
              Multiset.Entry<? extends E> entry1 = (Multiset.Entry)iterator1.next();
              E element = entry1.getElement();
              int count = entry1.getCount() + val$multiset2.count(element);
              return Multisets.immutableEntry(element, count);
            }
            while (iterator2.hasNext())
            {
              Multiset.Entry<? extends E> entry2 = (Multiset.Entry)iterator2.next();
              E element = entry2.getElement();
              if (!val$multiset1.contains(element)) {
                return Multisets.immutableEntry(element, entry2.getCount());
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      int distinctElements()
      {
        return elementSet().size();
      }
    };
  }
  
  @Beta
  public static <E> Multiset<E> difference(Multiset<E> multiset1, final Multiset<?> multiset2)
  {
    Preconditions.checkNotNull(multiset1);
    Preconditions.checkNotNull(multiset2);
    
    new AbstractMultiset()
    {
      public int count(@Nullable Object element)
      {
        int count1 = val$multiset1.count(element);
        return count1 == 0 ? 0 : Math.max(0, count1 - multiset2.count(element));
      }
      
      Iterator<Multiset.Entry<E>> entryIterator()
      {
        final Iterator<Multiset.Entry<E>> iterator1 = val$multiset1.entrySet().iterator();
        new AbstractIterator()
        {
          protected Multiset.Entry<E> computeNext()
          {
            while (iterator1.hasNext())
            {
              Multiset.Entry<E> entry1 = (Multiset.Entry)iterator1.next();
              E element = entry1.getElement();
              int count = entry1.getCount() - val$multiset2.count(element);
              if (count > 0) {
                return Multisets.immutableEntry(element, count);
              }
            }
            return (Multiset.Entry)endOfData();
          }
        };
      }
      
      int distinctElements()
      {
        return Iterators.size(entryIterator());
      }
    };
  }
  
  public static boolean containsOccurrences(Multiset<?> superMultiset, Multiset<?> subMultiset)
  {
    Preconditions.checkNotNull(superMultiset);
    Preconditions.checkNotNull(subMultiset);
    for (Multiset.Entry<?> entry : subMultiset.entrySet())
    {
      int superCount = superMultiset.count(entry.getElement());
      if (superCount < entry.getCount()) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean retainOccurrences(Multiset<?> multisetToModify, Multiset<?> multisetToRetain)
  {
    return retainOccurrencesImpl(multisetToModify, multisetToRetain);
  }
  
  private static <E> boolean retainOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRetain)
  {
    Preconditions.checkNotNull(multisetToModify);
    Preconditions.checkNotNull(occurrencesToRetain);
    
    Iterator<Multiset.Entry<E>> entryIterator = multisetToModify.entrySet().iterator();
    boolean changed = false;
    while (entryIterator.hasNext())
    {
      Multiset.Entry<E> entry = (Multiset.Entry)entryIterator.next();
      int retainCount = occurrencesToRetain.count(entry.getElement());
      if (retainCount == 0)
      {
        entryIterator.remove();
        changed = true;
      }
      else if (retainCount < entry.getCount())
      {
        multisetToModify.setCount(entry.getElement(), retainCount);
        changed = true;
      }
    }
    return changed;
  }
  
  public static boolean removeOccurrences(Multiset<?> multisetToModify, Iterable<?> occurrencesToRemove)
  {
    if ((occurrencesToRemove instanceof Multiset)) {
      return removeOccurrencesImpl(multisetToModify, (Multiset)occurrencesToRemove);
    }
    return removeOccurrencesImpl(multisetToModify, occurrencesToRemove);
  }
  
  private static boolean removeOccurrencesImpl(Multiset<?> multisetToModify, Iterable<?> occurrencesToRemove)
  {
    Preconditions.checkNotNull(multisetToModify);
    Preconditions.checkNotNull(occurrencesToRemove);
    boolean changed = false;
    for (Object o : occurrencesToRemove) {
      changed |= multisetToModify.remove(o);
    }
    return changed;
  }
  
  private static <E> boolean removeOccurrencesImpl(Multiset<E> multisetToModify, Multiset<?> occurrencesToRemove)
  {
    Preconditions.checkNotNull(multisetToModify);
    Preconditions.checkNotNull(occurrencesToRemove);
    
    boolean changed = false;
    Iterator<Multiset.Entry<E>> entryIterator = multisetToModify.entrySet().iterator();
    while (entryIterator.hasNext())
    {
      Multiset.Entry<E> entry = (Multiset.Entry)entryIterator.next();
      int removeCount = occurrencesToRemove.count(entry.getElement());
      if (removeCount >= entry.getCount())
      {
        entryIterator.remove();
        changed = true;
      }
      else if (removeCount > 0)
      {
        multisetToModify.remove(entry.getElement(), removeCount);
        changed = true;
      }
    }
    return changed;
  }
  
  static abstract class AbstractEntry<E>
    implements Multiset.Entry<E>
  {
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof Multiset.Entry))
      {
        Multiset.Entry<?> that = (Multiset.Entry)object;
        return (getCount() == that.getCount()) && (Objects.equal(getElement(), that.getElement()));
      }
      return false;
    }
    
    public int hashCode()
    {
      E e = getElement();
      return (e == null ? 0 : e.hashCode()) ^ getCount();
    }
    
    public String toString()
    {
      String text = String.valueOf(getElement());
      int n = getCount();
      String str1 = String.valueOf(String.valueOf(text));int i = n;return 14 + str1.length() + str1 + " x " + i;
    }
  }
  
  static boolean equalsImpl(Multiset<?> multiset, @Nullable Object object)
  {
    if (object == multiset) {
      return true;
    }
    if ((object instanceof Multiset))
    {
      Multiset<?> that = (Multiset)object;
      if ((multiset.size() != that.size()) || (multiset.entrySet().size() != that.entrySet().size())) {
        return false;
      }
      for (Multiset.Entry<?> entry : that.entrySet()) {
        if (multiset.count(entry.getElement()) != entry.getCount()) {
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  static <E> boolean addAllImpl(Multiset<E> self, Collection<? extends E> elements)
  {
    if (elements.isEmpty()) {
      return false;
    }
    if ((elements instanceof Multiset))
    {
      Multiset<? extends E> that = cast(elements);
      for (Multiset.Entry<? extends E> entry : that.entrySet()) {
        self.add(entry.getElement(), entry.getCount());
      }
    }
    else
    {
      Iterators.addAll(self, elements.iterator());
    }
    return true;
  }
  
  static boolean removeAllImpl(Multiset<?> self, Collection<?> elementsToRemove)
  {
    Collection<?> collection = (elementsToRemove instanceof Multiset) ? ((Multiset)elementsToRemove).elementSet() : elementsToRemove;
    
    return self.elementSet().removeAll(collection);
  }
  
  static boolean retainAllImpl(Multiset<?> self, Collection<?> elementsToRetain)
  {
    Preconditions.checkNotNull(elementsToRetain);
    Collection<?> collection = (elementsToRetain instanceof Multiset) ? ((Multiset)elementsToRetain).elementSet() : elementsToRetain;
    
    return self.elementSet().retainAll(collection);
  }
  
  static <E> int setCountImpl(Multiset<E> self, E element, int count)
  {
    CollectPreconditions.checkNonnegative(count, "count");
    
    int oldCount = self.count(element);
    
    int delta = count - oldCount;
    if (delta > 0) {
      self.add(element, delta);
    } else if (delta < 0) {
      self.remove(element, -delta);
    }
    return oldCount;
  }
  
  static <E> boolean setCountImpl(Multiset<E> self, E element, int oldCount, int newCount)
  {
    CollectPreconditions.checkNonnegative(oldCount, "oldCount");
    CollectPreconditions.checkNonnegative(newCount, "newCount");
    if (self.count(element) == oldCount)
    {
      self.setCount(element, newCount);
      return true;
    }
    return false;
  }
  
  static abstract class ElementSet<E>
    extends Sets.ImprovedAbstractSet<E>
  {
    abstract Multiset<E> multiset();
    
    public void clear()
    {
      multiset().clear();
    }
    
    public boolean contains(Object o)
    {
      return multiset().contains(o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return multiset().containsAll(c);
    }
    
    public boolean isEmpty()
    {
      return multiset().isEmpty();
    }
    
    public Iterator<E> iterator()
    {
      new TransformedIterator(multiset().entrySet().iterator())
      {
        E transform(Multiset.Entry<E> entry)
        {
          return (E)entry.getElement();
        }
      };
    }
    
    public boolean remove(Object o)
    {
      int count = multiset().count(o);
      if (count > 0)
      {
        multiset().remove(o, count);
        return true;
      }
      return false;
    }
    
    public int size()
    {
      return multiset().entrySet().size();
    }
  }
  
  static abstract class EntrySet<E>
    extends Sets.ImprovedAbstractSet<Multiset.Entry<E>>
  {
    abstract Multiset<E> multiset();
    
    public boolean contains(@Nullable Object o)
    {
      if ((o instanceof Multiset.Entry))
      {
        Multiset.Entry<?> entry = (Multiset.Entry)o;
        if (entry.getCount() <= 0) {
          return false;
        }
        int count = multiset().count(entry.getElement());
        return count == entry.getCount();
      }
      return false;
    }
    
    public boolean remove(Object object)
    {
      if ((object instanceof Multiset.Entry))
      {
        Multiset.Entry<?> entry = (Multiset.Entry)object;
        Object element = entry.getElement();
        int entryCount = entry.getCount();
        if (entryCount != 0)
        {
          Multiset<Object> multiset = multiset();
          return multiset.setCount(element, entryCount, 0);
        }
      }
      return false;
    }
    
    public void clear()
    {
      multiset().clear();
    }
  }
  
  static <E> Iterator<E> iteratorImpl(Multiset<E> multiset)
  {
    return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
  }
  
  static final class MultisetIteratorImpl<E>
    implements Iterator<E>
  {
    private final Multiset<E> multiset;
    private final Iterator<Multiset.Entry<E>> entryIterator;
    private Multiset.Entry<E> currentEntry;
    private int laterCount;
    private int totalCount;
    private boolean canRemove;
    
    MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> entryIterator)
    {
      this.multiset = multiset;
      this.entryIterator = entryIterator;
    }
    
    public boolean hasNext()
    {
      return (laterCount > 0) || (entryIterator.hasNext());
    }
    
    public E next()
    {
      if (!hasNext()) {
        throw new NoSuchElementException();
      }
      if (laterCount == 0)
      {
        currentEntry = ((Multiset.Entry)entryIterator.next());
        totalCount = (laterCount = currentEntry.getCount());
      }
      laterCount -= 1;
      canRemove = true;
      return (E)currentEntry.getElement();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(canRemove);
      if (totalCount == 1) {
        entryIterator.remove();
      } else {
        multiset.remove(currentEntry.getElement());
      }
      totalCount -= 1;
      canRemove = false;
    }
  }
  
  static int sizeImpl(Multiset<?> multiset)
  {
    long size = 0L;
    for (Multiset.Entry<?> entry : multiset.entrySet()) {
      size += entry.getCount();
    }
    return Ints.saturatedCast(size);
  }
  
  static <T> Multiset<T> cast(Iterable<T> iterable)
  {
    return (Multiset)iterable;
  }
  
  private static final Ordering<Multiset.Entry<?>> DECREASING_COUNT_ORDERING = new Ordering()
  {
    public int compare(Multiset.Entry<?> entry1, Multiset.Entry<?> entry2)
    {
      return Ints.compare(entry2.getCount(), entry1.getCount());
    }
  };
  
  @Beta
  public static <E> ImmutableMultiset<E> copyHighestCountFirst(Multiset<E> multiset)
  {
    List<Multiset.Entry<E>> sortedEntries = DECREASING_COUNT_ORDERING.immutableSortedCopy(multiset.entrySet());
    
    return ImmutableMultiset.copyFromEntries(sortedEntries);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */