package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map.Entry;

class HashBiMap$EntrySet$1
  extends HashBiMap<K, V>.Itr<Map.Entry<K, V>>
{
  HashBiMap$EntrySet$1(HashBiMap.EntrySet paramEntrySet)
  {
    super(this$0);
  }
  
  Map.Entry<K, V> output(HashBiMap.BiEntry<K, V> entry)
  {
    return new MapEntry(entry);
  }
  
  class MapEntry
    extends AbstractMapEntry<K, V>
  {
    HashBiMap.BiEntry<K, V> delegate;
    
    MapEntry()
    {
      delegate = entry;
    }
    
    public K getKey()
    {
      return (K)delegate.key;
    }
    
    public V getValue()
    {
      return (V)delegate.value;
    }
    
    public V setValue(V value)
    {
      V oldValue = delegate.value;
      int valueHash = HashBiMap.access$300(value);
      if ((valueHash == delegate.valueHash) && (Objects.equal(value, oldValue))) {
        return value;
      }
      Preconditions.checkArgument(HashBiMap.access$600(this$1.this$0, value, valueHash) == null, "value already present: %s", new Object[] { value });
      
      HashBiMap.access$200(this$1.this$0, delegate);
      HashBiMap.BiEntry<K, V> newEntry = new HashBiMap.BiEntry(delegate.key, delegate.keyHash, value, valueHash);
      
      HashBiMap.access$700(this$1.this$0, newEntry);
      expectedModCount = HashBiMap.access$000(this$1.this$0);
      if (toRemove == delegate) {
        toRemove = newEntry;
      }
      delegate = newEntry;
      return oldValue;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBiMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */