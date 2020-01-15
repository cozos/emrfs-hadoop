package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedCollection
  extends AbstractCollection<V>
{
  final K key;
  Collection<V> delegate;
  final AbstractMapBasedMultimap<K, V>.WrappedCollection ancestor;
  final Collection<V> ancestorDelegate;
  
  AbstractMapBasedMultimap$WrappedCollection(@Nullable K arg1, Collection<V> key, @Nullable AbstractMapBasedMultimap<K, V>.WrappedCollection delegate)
  {
    this.key = key;
    this.delegate = delegate;
    this.ancestor = ancestor;
    ancestorDelegate = (ancestor == null ? null : ancestor.getDelegate());
  }
  
  void refreshIfEmpty()
  {
    if (ancestor != null)
    {
      ancestor.refreshIfEmpty();
      if (ancestor.getDelegate() != ancestorDelegate) {
        throw new ConcurrentModificationException();
      }
    }
    else if (delegate.isEmpty())
    {
      Collection<V> newDelegate = (Collection)AbstractMapBasedMultimap.access$000(this$0).get(key);
      if (newDelegate != null) {
        delegate = newDelegate;
      }
    }
  }
  
  void removeIfEmpty()
  {
    if (ancestor != null) {
      ancestor.removeIfEmpty();
    } else if (delegate.isEmpty()) {
      AbstractMapBasedMultimap.access$000(this$0).remove(key);
    }
  }
  
  K getKey()
  {
    return (K)key;
  }
  
  void addToMap()
  {
    if (ancestor != null) {
      ancestor.addToMap();
    } else {
      AbstractMapBasedMultimap.access$000(this$0).put(key, delegate);
    }
  }
  
  public int size()
  {
    refreshIfEmpty();
    return delegate.size();
  }
  
  public boolean equals(@Nullable Object object)
  {
    if (object == this) {
      return true;
    }
    refreshIfEmpty();
    return delegate.equals(object);
  }
  
  public int hashCode()
  {
    refreshIfEmpty();
    return delegate.hashCode();
  }
  
  public String toString()
  {
    refreshIfEmpty();
    return delegate.toString();
  }
  
  Collection<V> getDelegate()
  {
    return delegate;
  }
  
  public Iterator<V> iterator()
  {
    refreshIfEmpty();
    return new WrappedIterator();
  }
  
  class WrappedIterator
    implements Iterator<V>
  {
    final Iterator<V> delegateIterator;
    final Collection<V> originalDelegate = delegate;
    
    WrappedIterator()
    {
      delegateIterator = AbstractMapBasedMultimap.access$100(this$0, delegate);
    }
    
    WrappedIterator()
    {
      this.delegateIterator = delegateIterator;
    }
    
    void validateIterator()
    {
      refreshIfEmpty();
      if (delegate != originalDelegate) {
        throw new ConcurrentModificationException();
      }
    }
    
    public boolean hasNext()
    {
      validateIterator();
      return delegateIterator.hasNext();
    }
    
    public V next()
    {
      validateIterator();
      return (V)delegateIterator.next();
    }
    
    public void remove()
    {
      delegateIterator.remove();
      AbstractMapBasedMultimap.access$210(this$0);
      removeIfEmpty();
    }
    
    Iterator<V> getDelegateIterator()
    {
      validateIterator();
      return delegateIterator;
    }
  }
  
  public boolean add(V value)
  {
    refreshIfEmpty();
    boolean wasEmpty = delegate.isEmpty();
    boolean changed = delegate.add(value);
    if (changed)
    {
      AbstractMapBasedMultimap.access$208(this$0);
      if (wasEmpty) {
        addToMap();
      }
    }
    return changed;
  }
  
  AbstractMapBasedMultimap<K, V>.WrappedCollection getAncestor()
  {
    return ancestor;
  }
  
  public boolean addAll(Collection<? extends V> collection)
  {
    if (collection.isEmpty()) {
      return false;
    }
    int oldSize = size();
    boolean changed = delegate.addAll(collection);
    if (changed)
    {
      int newSize = delegate.size();
      AbstractMapBasedMultimap.access$212(this$0, newSize - oldSize);
      if (oldSize == 0) {
        addToMap();
      }
    }
    return changed;
  }
  
  public boolean contains(Object o)
  {
    refreshIfEmpty();
    return delegate.contains(o);
  }
  
  public boolean containsAll(Collection<?> c)
  {
    refreshIfEmpty();
    return delegate.containsAll(c);
  }
  
  public void clear()
  {
    int oldSize = size();
    if (oldSize == 0) {
      return;
    }
    delegate.clear();
    AbstractMapBasedMultimap.access$220(this$0, oldSize);
    removeIfEmpty();
  }
  
  public boolean remove(Object o)
  {
    refreshIfEmpty();
    boolean changed = delegate.remove(o);
    if (changed)
    {
      AbstractMapBasedMultimap.access$210(this$0);
      removeIfEmpty();
    }
    return changed;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    if (c.isEmpty()) {
      return false;
    }
    int oldSize = size();
    boolean changed = delegate.removeAll(c);
    if (changed)
    {
      int newSize = delegate.size();
      AbstractMapBasedMultimap.access$212(this$0, newSize - oldSize);
      removeIfEmpty();
    }
    return changed;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    int oldSize = size();
    boolean changed = delegate.retainAll(c);
    if (changed)
    {
      int newSize = delegate.size();
      AbstractMapBasedMultimap.access$212(this$0, newSize - oldSize);
      removeIfEmpty();
    }
    return changed;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */