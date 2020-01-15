package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

class AbstractMapBasedMultimap$WrappedCollection$WrappedIterator
  implements Iterator<V>
{
  final Iterator<V> delegateIterator;
  final Collection<V> originalDelegate = this$1.delegate;
  
  AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(AbstractMapBasedMultimap.WrappedCollection paramWrappedCollection)
  {
    delegateIterator = AbstractMapBasedMultimap.access$100(this$0, delegate);
  }
  
  AbstractMapBasedMultimap$WrappedCollection$WrappedIterator(Iterator<V> arg1)
  {
    this.delegateIterator = delegateIterator;
  }
  
  void validateIterator()
  {
    this$1.refreshIfEmpty();
    if (this$1.delegate != originalDelegate) {
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
    AbstractMapBasedMultimap.access$210(this$1.this$0);
    this$1.removeIfEmpty();
  }
  
  Iterator<V> getDelegateIterator()
  {
    validateIterator();
    return delegateIterator;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection.WrappedIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */