package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1
  extends ForwardingIterator<Map.Entry<K, Collection<V>>>
{
  Synchronized$SynchronizedAsMapEntries$1(Synchronized.SynchronizedAsMapEntries paramSynchronizedAsMapEntries, Iterator paramIterator) {}
  
  protected Iterator<Map.Entry<K, Collection<V>>> delegate()
  {
    return val$iterator;
  }
  
  public Map.Entry<K, Collection<V>> next()
  {
    final Map.Entry<K, Collection<V>> entry = (Map.Entry)super.next();
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, Collection<V>> delegate()
      {
        return entry;
      }
      
      public Collection<V> getValue()
      {
        return Synchronized.access$400((Collection)entry.getValue(), this$0.mutex);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */