package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

class Synchronized$SynchronizedAsMapEntries$1$1
  extends ForwardingMapEntry<K, Collection<V>>
{
  Synchronized$SynchronizedAsMapEntries$1$1(Synchronized.SynchronizedAsMapEntries.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<K, Collection<V>> delegate()
  {
    return val$entry;
  }
  
  public Collection<V> getValue()
  {
    return Synchronized.access$400((Collection)val$entry.getValue(), this$1.this$0.mutex);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */