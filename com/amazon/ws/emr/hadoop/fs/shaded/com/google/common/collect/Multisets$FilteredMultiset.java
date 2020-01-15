package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$FilteredMultiset<E>
  extends AbstractMultiset<E>
{
  final Multiset<E> unfiltered;
  final Predicate<? super E> predicate;
  
  Multisets$FilteredMultiset(Multiset<E> unfiltered, Predicate<? super E> predicate)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.FilteredMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */