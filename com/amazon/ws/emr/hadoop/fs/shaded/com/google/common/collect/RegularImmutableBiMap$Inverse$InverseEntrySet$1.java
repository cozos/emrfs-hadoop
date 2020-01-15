package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableBiMap$Inverse$InverseEntrySet$1
  extends ImmutableAsList<Map.Entry<V, K>>
{
  RegularImmutableBiMap$Inverse$InverseEntrySet$1(RegularImmutableBiMap.Inverse.InverseEntrySet paramInverseEntrySet) {}
  
  public Map.Entry<V, K> get(int index)
  {
    Map.Entry<K, V> entry = RegularImmutableBiMap.access$000(this$2.this$1.this$0)[index];
    return Maps.immutableEntry(entry.getValue(), entry.getKey());
  }
  
  ImmutableCollection<Map.Entry<V, K>> delegateCollection()
  {
    return this$2;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.Inverse.InverseEntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */