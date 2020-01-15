package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMapValues<V>
  extends Synchronized.SynchronizedCollection<Collection<V>>
{
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedAsMapValues(Collection<Collection<V>> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex, null);
  }
  
  public Iterator<Collection<V>> iterator()
  {
    final Iterator<Collection<V>> iterator = super.iterator();
    new ForwardingIterator()
    {
      protected Iterator<Collection<V>> delegate()
      {
        return iterator;
      }
      
      public Collection<V> next()
      {
        return Synchronized.access$400((Collection)super.next(), mutex);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMapValues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */