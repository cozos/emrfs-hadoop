package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;
import javax.annotation.Nullable;

final class RegularImmutableBiMap$Inverse
  extends ImmutableBiMap<V, K>
{
  private RegularImmutableBiMap$Inverse(RegularImmutableBiMap paramRegularImmutableBiMap) {}
  
  public int size()
  {
    return inverse().size();
  }
  
  public ImmutableBiMap<K, V> inverse()
  {
    return this$0;
  }
  
  public K get(@Nullable Object value)
  {
    if (value == null) {
      return null;
    }
    int bucket = Hashing.smear(value.hashCode()) & RegularImmutableBiMap.access$300(this$0);
    for (ImmutableMapEntry<K, V> entry = RegularImmutableBiMap.access$400(this$0)[bucket]; entry != null; entry = entry.getNextInValueBucket()) {
      if (value.equals(entry.getValue())) {
        return (K)entry.getKey();
      }
    }
    return null;
  }
  
  ImmutableSet<Map.Entry<V, K>> createEntrySet()
  {
    return new InverseEntrySet();
  }
  
  final class InverseEntrySet
    extends ImmutableMapEntrySet<V, K>
  {
    InverseEntrySet() {}
    
    ImmutableMap<V, K> map()
    {
      return RegularImmutableBiMap.Inverse.this;
    }
    
    boolean isHashCodeFast()
    {
      return true;
    }
    
    public int hashCode()
    {
      return RegularImmutableBiMap.access$100(this$0);
    }
    
    public UnmodifiableIterator<Map.Entry<V, K>> iterator()
    {
      return asList().iterator();
    }
    
    ImmutableList<Map.Entry<V, K>> createAsList()
    {
      new ImmutableAsList()
      {
        public Map.Entry<V, K> get(int index)
        {
          Map.Entry<K, V> entry = RegularImmutableBiMap.access$000(this$0)[index];
          return Maps.immutableEntry(entry.getValue(), entry.getKey());
        }
        
        ImmutableCollection<Map.Entry<V, K>> delegateCollection()
        {
          return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
        }
      };
    }
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  Object writeReplace()
  {
    return new RegularImmutableBiMap.InverseSerializedForm(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.Inverse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */