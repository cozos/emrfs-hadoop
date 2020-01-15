package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedSortedSet
  extends AbstractMapBasedMultimap<K, V>.WrappedCollection
  implements SortedSet<V>
{
  AbstractMapBasedMultimap$WrappedSortedSet(@Nullable K arg1, SortedSet<V> key, @Nullable AbstractMapBasedMultimap<K, V>.WrappedCollection delegate)
  {
    super(???, key, delegate, ancestor);
  }
  
  SortedSet<V> getSortedSetDelegate()
  {
    return (SortedSet)getDelegate();
  }
  
  public Comparator<? super V> comparator()
  {
    return getSortedSetDelegate().comparator();
  }
  
  public V first()
  {
    refreshIfEmpty();
    return (V)getSortedSetDelegate().first();
  }
  
  public V last()
  {
    refreshIfEmpty();
    return (V)getSortedSetDelegate().last();
  }
  
  public SortedSet<V> headSet(V toElement)
  {
    refreshIfEmpty();
    return new WrappedSortedSet(this$0, getKey(), getSortedSetDelegate().headSet(toElement), getAncestor() == null ? this : getAncestor());
  }
  
  public SortedSet<V> subSet(V fromElement, V toElement)
  {
    refreshIfEmpty();
    return new WrappedSortedSet(this$0, getKey(), getSortedSetDelegate().subSet(fromElement, toElement), getAncestor() == null ? this : getAncestor());
  }
  
  public SortedSet<V> tailSet(V fromElement)
  {
    refreshIfEmpty();
    return new WrappedSortedSet(this$0, getKey(), getSortedSetDelegate().tailSet(fromElement), getAncestor() == null ? this : getAncestor());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */