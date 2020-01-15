package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Collections2$FilteredCollection<E>
  extends AbstractCollection<E>
{
  final Collection<E> unfiltered;
  final Predicate<? super E> predicate;
  
  Collections2$FilteredCollection(Collection<E> unfiltered, Predicate<? super E> predicate)
  {
    this.unfiltered = unfiltered;
    this.predicate = predicate;
  }
  
  FilteredCollection<E> createCombined(Predicate<? super E> newPredicate)
  {
    return new FilteredCollection(unfiltered, Predicates.and(predicate, newPredicate));
  }
  
  public boolean add(E element)
  {
    Preconditions.checkArgument(predicate.apply(element));
    return unfiltered.add(element);
  }
  
  public boolean addAll(Collection<? extends E> collection)
  {
    for (E element : collection) {
      Preconditions.checkArgument(predicate.apply(element));
    }
    return unfiltered.addAll(collection);
  }
  
  public void clear()
  {
    Iterables.removeIf(unfiltered, predicate);
  }
  
  public boolean contains(@Nullable Object element)
  {
    if (Collections2.safeContains(unfiltered, element))
    {
      E e = (E)element;
      return predicate.apply(e);
    }
    return false;
  }
  
  public boolean containsAll(Collection<?> collection)
  {
    return Collections2.containsAllImpl(this, collection);
  }
  
  public boolean isEmpty()
  {
    return !Iterables.any(unfiltered, predicate);
  }
  
  public Iterator<E> iterator()
  {
    return Iterators.filter(unfiltered.iterator(), predicate);
  }
  
  public boolean remove(Object element)
  {
    return (contains(element)) && (unfiltered.remove(element));
  }
  
  public boolean removeAll(Collection<?> collection)
  {
    return Iterables.removeIf(unfiltered, Predicates.and(predicate, Predicates.in(collection)));
  }
  
  public boolean retainAll(Collection<?> collection)
  {
    return Iterables.removeIf(unfiltered, Predicates.and(predicate, Predicates.not(Predicates.in(collection))));
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
  
  public Object[] toArray()
  {
    return Lists.newArrayList(iterator()).toArray();
  }
  
  public <T> T[] toArray(T[] array)
  {
    return Lists.newArrayList(iterator()).toArray(array);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Collections2.FilteredCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */