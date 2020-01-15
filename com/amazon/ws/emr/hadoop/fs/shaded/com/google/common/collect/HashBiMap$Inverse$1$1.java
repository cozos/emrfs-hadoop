package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map.Entry;

class HashBiMap$Inverse$1$1
  extends HashBiMap<K, V>.Itr<Map.Entry<V, K>>
{
  HashBiMap$Inverse$1$1(HashBiMap.Inverse.1 param1)
  {
    super(this$1.this$0);
  }
  
  Map.Entry<V, K> output(HashBiMap.BiEntry<K, V> entry)
  {
    return new InverseEntry(entry);
  }
  
  class InverseEntry
    extends AbstractMapEntry<V, K>
  {
    HashBiMap.BiEntry<K, V> delegate;
    
    InverseEntry()
    {
      delegate = entry;
    }
    
    public V getKey()
    {
      return (V)delegate.value;
    }
    
    public K getValue()
    {
      return (K)delegate.key;
    }
    
    public K setValue(K key)
    {
      K oldKey = delegate.key;
      int keyHash = HashBiMap.access$300(key);
      if ((keyHash == delegate.keyHash) && (Objects.equal(key, oldKey))) {
        return key;
      }
      Preconditions.checkArgument(HashBiMap.access$400(this$2.this$1.this$0, key, keyHash) == null, "value already present: %s", new Object[] { key });
      HashBiMap.access$200(this$2.this$1.this$0, delegate);
      HashBiMap.BiEntry<K, V> newEntry = new HashBiMap.BiEntry(key, keyHash, delegate.value, delegate.valueHash);
      
      HashBiMap.access$700(this$2.this$1.this$0, newEntry);
      expectedModCount = HashBiMap.access$000(this$2.this$1.this$0);
      
      return oldKey;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBiMap.Inverse.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */