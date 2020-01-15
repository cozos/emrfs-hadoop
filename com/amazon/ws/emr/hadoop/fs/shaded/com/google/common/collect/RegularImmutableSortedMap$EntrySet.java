package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableSortedMap$EntrySet
  extends ImmutableMapEntrySet<K, V>
{
  private RegularImmutableSortedMap$EntrySet(RegularImmutableSortedMap paramRegularImmutableSortedMap) {}
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return asList().iterator();
  }
  
  ImmutableList<Map.Entry<K, V>> createAsList()
  {
    new ImmutableAsList()
    {
      private final ImmutableList<K> keyList = this$0.keySet().asList();
      
      public Map.Entry<K, V> get(int index)
      {
        return Maps.immutableEntry(keyList.get(index), RegularImmutableSortedMap.access$100(this$0).get(index));
      }
      
      ImmutableCollection<Map.Entry<K, V>> delegateCollection()
      {
        return RegularImmutableSortedMap.EntrySet.this;
      }
    };
  }
  
  ImmutableMap<K, V> map()
  {
    return this$0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableSortedMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */