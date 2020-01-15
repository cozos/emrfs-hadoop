package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

class Synchronized$SynchronizedAsMapValues$1
  extends ForwardingIterator<Collection<V>>
{
  Synchronized$SynchronizedAsMapValues$1(Synchronized.SynchronizedAsMapValues paramSynchronizedAsMapValues, Iterator paramIterator) {}
  
  protected Iterator<Collection<V>> delegate()
  {
    return val$iterator;
  }
  
  public Collection<V> next()
  {
    return Synchronized.access$400((Collection)super.next(), this$0.mutex);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */