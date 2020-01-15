package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class AbstractMapBasedMultimap$2
  extends AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>
{
  AbstractMapBasedMultimap$2(AbstractMapBasedMultimap paramAbstractMapBasedMultimap)
  {
    super(paramAbstractMapBasedMultimap);
  }
  
  Map.Entry<K, V> output(K key, V value)
  {
    return Maps.immutableEntry(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */