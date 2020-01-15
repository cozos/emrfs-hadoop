package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.List;
import java.util.ListIterator;

class AbstractMapBasedMultimap$WrappedList$WrappedListIterator
  extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator
  implements ListIterator<V>
{
  AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap.WrappedList paramWrappedList)
  {
    super(paramWrappedList);
  }
  
  public AbstractMapBasedMultimap$WrappedList$WrappedListIterator(AbstractMapBasedMultimap.WrappedList paramWrappedList, int index)
  {
    super(paramWrappedList, paramWrappedList.getListDelegate().listIterator(index));
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
    boolean wasEmpty = this$1.isEmpty();
    getDelegateListIterator().add(value);
    AbstractMapBasedMultimap.access$208(this$1.this$0);
    if (wasEmpty) {
      this$1.addToMap();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedList.WrappedListIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */