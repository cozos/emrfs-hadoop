package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class RegularImmutableBiMap$1
  extends ImmutableMapEntrySet<K, V>
{
  RegularImmutableBiMap$1(RegularImmutableBiMap paramRegularImmutableBiMap) {}
  
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
    return new RegularImmutableAsList(this, RegularImmutableBiMap.access$000(this$0));
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  public int hashCode()
  {
    return RegularImmutableBiMap.access$100(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */