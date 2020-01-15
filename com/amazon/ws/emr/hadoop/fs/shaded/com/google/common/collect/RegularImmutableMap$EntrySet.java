package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableMap$EntrySet
  extends ImmutableMapEntrySet<K, V>
{
  private RegularImmutableMap$EntrySet(RegularImmutableMap paramRegularImmutableMap) {}
  
  ImmutableMap<K, V> map()
  {
    return this$0;
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return asList().iterator();
  }
  
  ImmutableList<Map.Entry<K, V>> createAsList()
  {
    return new RegularImmutableAsList(this, RegularImmutableMap.access$100(this$0));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */