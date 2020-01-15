package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;

class HashBiMap$Inverse$1$1$InverseEntry
  extends AbstractMapEntry<V, K>
{
  HashBiMap.BiEntry<K, V> delegate;
  
  HashBiMap$Inverse$1$1$InverseEntry(HashBiMap.BiEntry<K, V> arg1)
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
    Preconditions.checkArgument(HashBiMap.access$400(this$3.this$2.this$1.this$0, key, keyHash) == null, "value already present: %s", new Object[] { key });
    HashBiMap.access$200(this$3.this$2.this$1.this$0, delegate);
    HashBiMap.BiEntry<K, V> newEntry = new HashBiMap.BiEntry(key, keyHash, delegate.value, delegate.valueHash);
    
    HashBiMap.access$700(this$3.this$2.this$1.this$0, newEntry);
    this$3.expectedModCount = HashBiMap.access$000(this$3.this$2.this$1.this$0);
    
    return oldKey;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBiMap.Inverse.1.1.InverseEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */