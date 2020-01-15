package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class ImmutableEnumMap$2
  extends ImmutableMapEntrySet<K, V>
{
  ImmutableEnumMap$2(ImmutableEnumMap paramImmutableEnumMap) {}
  
  ImmutableMap<K, V> map()
  {
    return this$0;
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    new UnmodifiableIterator()
    {
      private final Iterator<Map.Entry<K, V>> backingIterator = ImmutableEnumMap.access$000(this$0).entrySet().iterator();
      
      public boolean hasNext()
      {
        return backingIterator.hasNext();
      }
      
      public Map.Entry<K, V> next()
      {
        Map.Entry<K, V> entry = (Map.Entry)backingIterator.next();
        return Maps.immutableEntry(entry.getKey(), entry.getValue());
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */