package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class ImmutableMultimap$Itr<T>
  extends UnmodifiableIterator<T>
{
  final Iterator<Map.Entry<K, Collection<V>>> mapIterator = this$0.asMap().entrySet().iterator();
  K key = null;
  Iterator<V> valueIterator = Iterators.emptyIterator();
  
  private ImmutableMultimap$Itr(ImmutableMultimap paramImmutableMultimap) {}
  
  abstract T output(K paramK, V paramV);
  
  public boolean hasNext()
  {
    return (mapIterator.hasNext()) || (valueIterator.hasNext());
  }
  
  public T next()
  {
    if (!valueIterator.hasNext())
    {
      Map.Entry<K, Collection<V>> mapEntry = (Map.Entry)mapIterator.next();
      key = mapEntry.getKey();
      valueIterator = ((Collection)mapEntry.getValue()).iterator();
    }
    return (T)output(key, valueIterator.next());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap.Itr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */