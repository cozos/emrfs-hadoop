package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Iterator;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$WrappedNavigableSet
  extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet
  implements NavigableSet<V>
{
  AbstractMapBasedMultimap$WrappedNavigableSet(@Nullable K arg1, NavigableSet<V> key, @Nullable AbstractMapBasedMultimap<K, V>.WrappedCollection delegate)
  {
    super(???, key, delegate, ancestor);
  }
  
  NavigableSet<V> getSortedSetDelegate()
  {
    return (NavigableSet)super.getSortedSetDelegate();
  }
  
  public V lower(V v)
  {
    return (V)getSortedSetDelegate().lower(v);
  }
  
  public V floor(V v)
  {
    return (V)getSortedSetDelegate().floor(v);
  }
  
  public V ceiling(V v)
  {
    return (V)getSortedSetDelegate().ceiling(v);
  }
  
  public V higher(V v)
  {
    return (V)getSortedSetDelegate().higher(v);
  }
  
  public V pollFirst()
  {
    return (V)Iterators.pollNext(iterator());
  }
  
  public V pollLast()
  {
    return (V)Iterators.pollNext(descendingIterator());
  }
  
  private NavigableSet<V> wrap(NavigableSet<V> wrapped)
  {
    return new WrappedNavigableSet(this$0, key, wrapped, getAncestor() == null ? this : getAncestor());
  }
  
  public NavigableSet<V> descendingSet()
  {
    return wrap(getSortedSetDelegate().descendingSet());
  }
  
  public Iterator<V> descendingIterator()
  {
    return new AbstractMapBasedMultimap.WrappedCollection.WrappedIterator(this, getSortedSetDelegate().descendingIterator());
  }
  
  public NavigableSet<V> subSet(V fromElement, boolean fromInclusive, V toElement, boolean toInclusive)
  {
    return wrap(getSortedSetDelegate().subSet(fromElement, fromInclusive, toElement, toInclusive));
  }
  
  public NavigableSet<V> headSet(V toElement, boolean inclusive)
  {
    return wrap(getSortedSetDelegate().headSet(toElement, inclusive));
  }
  
  public NavigableSet<V> tailSet(V fromElement, boolean inclusive)
  {
    return wrap(getSortedSetDelegate().tailSet(fromElement, inclusive));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedNavigableSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */