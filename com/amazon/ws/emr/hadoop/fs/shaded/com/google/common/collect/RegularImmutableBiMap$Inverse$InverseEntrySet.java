package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

final class RegularImmutableBiMap$Inverse$InverseEntrySet
  extends ImmutableMapEntrySet<V, K>
{
  RegularImmutableBiMap$Inverse$InverseEntrySet(RegularImmutableBiMap.Inverse paramInverse) {}
  
  ImmutableMap<V, K> map()
  {
    return this$1;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  public int hashCode()
  {
    return RegularImmutableBiMap.access$100(this$1.this$0);
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
        Map.Entry<K, V> entry = RegularImmutableBiMap.access$000(this$1.this$0)[index];
        return Maps.immutableEntry(entry.getValue(), entry.getKey());
      }
      
      ImmutableCollection<Map.Entry<V, K>> delegateCollection()
      {
        return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */