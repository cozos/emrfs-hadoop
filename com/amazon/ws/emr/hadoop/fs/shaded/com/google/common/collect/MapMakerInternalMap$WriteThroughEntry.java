package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class MapMakerInternalMap$WriteThroughEntry
  extends AbstractMapEntry<K, V>
{
  final K key;
  V value;
  
  MapMakerInternalMap$WriteThroughEntry(K arg1, V key)
  {
    this.key = key;
    this.value = value;
  }
  
  public K getKey()
  {
    return (K)key;
  }
  
  public V getValue()
  {
    return (V)value;
  }
  
  public boolean equals(@Nullable Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> that = (Map.Entry)object;
      return (key.equals(that.getKey())) && (value.equals(that.getValue()));
    }
    return false;
  }
  
  public int hashCode()
  {
    return key.hashCode() ^ value.hashCode();
  }
  
  public V setValue(V newValue)
  {
    V oldValue = this$0.put(key, newValue);
    value = newValue;
    return oldValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.WriteThroughEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */