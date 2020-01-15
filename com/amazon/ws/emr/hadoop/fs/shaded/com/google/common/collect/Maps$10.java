package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

final class Maps$10
  extends AbstractMapEntry<K, V2>
{
  Maps$10(Map.Entry paramEntry, Maps.EntryTransformer paramEntryTransformer) {}
  
  public K getKey()
  {
    return (K)val$entry.getKey();
  }
  
  public V2 getValue()
  {
    return (V2)val$transformer.transformEntry(val$entry.getKey(), val$entry.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */