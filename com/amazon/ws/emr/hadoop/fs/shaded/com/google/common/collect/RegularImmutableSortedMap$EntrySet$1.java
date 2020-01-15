package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableSortedMap$EntrySet$1
  extends ImmutableAsList<Map.Entry<K, V>>
{
  private final ImmutableList<K> keyList = this$1.this$0.keySet().asList();
  
  RegularImmutableSortedMap$EntrySet$1(RegularImmutableSortedMap.EntrySet paramEntrySet) {}
  
  public Map.Entry<K, V> get(int index)
  {
    return Maps.immutableEntry(keyList.get(index), RegularImmutableSortedMap.access$100(this$1.this$0).get(index));
  }
  
  ImmutableCollection<Map.Entry<K, V>> delegateCollection()
  {
    return this$1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableSortedMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */