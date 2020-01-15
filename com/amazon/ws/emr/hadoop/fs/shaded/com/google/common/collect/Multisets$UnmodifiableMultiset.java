package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

class Multisets$UnmodifiableMultiset<E>
  extends ForwardingMultiset<E>
  implements Serializable
{
  final Multiset<? extends E> delegate;
  transient Set<E> elementSet;
  transient Set<Multiset.Entry<E>> entrySet;
  private static final long serialVersionUID = 0L;
  
  Multisets$UnmodifiableMultiset(Multiset<? extends E> delegate)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multisets.UnmodifiableMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */