package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$WrappedList
  extends AbstractMapBasedMultimap<K, V>.WrappedCollection
  implements List<V>
{
  AbstractMapBasedMultimap$WrappedList(@Nullable K arg1, List<V> key, @Nullable AbstractMapBasedMultimap<K, V>.WrappedCollection delegate)
  {
    super(???, key, delegate, ancestor);
  }
  
  List<V> getListDelegate()
  {
    return (List)getDelegate();
  }
  
  public boolean addAll(int index, Collection<? extends V> c)
  {
    if (c.isEmpty()) {
      return false;
    }
    int oldSize = size();
    boolean changed = getListDelegate().addAll(index, c);
    if (changed)
    {
      int newSize = getDelegate().size();
      AbstractMapBasedMultimap.access$212(this$0, newSize - oldSize);
      if (oldSize == 0) {
        addToMap();
      }
    }
    return changed;
  }
  
  public V get(int index)
  {
    refreshIfEmpty();
    return (V)getListDelegate().get(index);
  }
  
  public V set(int index, V element)
  {
    refreshIfEmpty();
    return (V)getListDelegate().set(index, element);
  }
  
  public void add(int index, V element)
  {
    refreshIfEmpty();
    boolean wasEmpty = getDelegate().isEmpty();
    getListDelegate().add(index, element);
    AbstractMapBasedMultimap.access$208(this$0);
    if (wasEmpty) {
      addToMap();
    }
  }
  
  public V remove(int index)
  {
    refreshIfEmpty();
    V value = getListDelegate().remove(index);
    AbstractMapBasedMultimap.access$210(this$0);
    removeIfEmpty();
    return value;
  }
  
  public int indexOf(Object o)
  {
    refreshIfEmpty();
    return getListDelegate().indexOf(o);
  }
  
  public int lastIndexOf(Object o)
  {
    refreshIfEmpty();
    return getListDelegate().lastIndexOf(o);
  }
  
  public ListIterator<V> listIterator()
  {
    refreshIfEmpty();
    return new WrappedListIterator();
  }
  
  public ListIterator<V> listIterator(int index)
  {
    refreshIfEmpty();
    return new WrappedListIterator(index);
  }
  
  public List<V> subList(int fromIndex, int toIndex)
  {
    refreshIfEmpty();
    return AbstractMapBasedMultimap.access$300(this$0, getKey(), getListDelegate().subList(fromIndex, toIndex), getAncestor() == null ? this : getAncestor());
  }
  
  private class WrappedListIterator
    extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator
    implements ListIterator<V>
  {
    WrappedListIterator()
    {
      super();
    }
    
    public WrappedListIterator(int index)
    {
      super(getListDelegate().listIterator(index));
    }
    
    private ListIterator<V> getDelegateListIterator()
    {
      return (ListIterator)getDelegateIterator();
    }
    
    public boolean hasPrevious()
    {
      return getDelegateListIterator().hasPrevious();
    }
    
    public V previous()
    {
      return (V)getDelegateListIterator().previous();
    }
    
    public int nextIndex()
    {
      return getDelegateListIterator().nextIndex();
    }
    
    public int previousIndex()
    {
      return getDelegateListIterator().previousIndex();
    }
    
    public void set(V value)
    {
      getDelegateListIterator().set(value);
    }
    
    public void add(V value)
    {
      boolean wasEmpty = isEmpty();
      getDelegateListIterator().add(value);
      AbstractMapBasedMultimap.access$208(this$0);
      if (wasEmpty) {
        addToMap();
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedList
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */