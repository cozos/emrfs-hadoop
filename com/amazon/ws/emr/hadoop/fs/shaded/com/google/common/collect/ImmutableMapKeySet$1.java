package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMapKeySet$1
  extends ImmutableAsList<K>
{
  ImmutableMapKeySet$1(ImmutableMapKeySet paramImmutableMapKeySet, ImmutableList paramImmutableList) {}
  
  public K get(int index)
  {
    return (K)((Map.Entry)val$entryList.get(index)).getKey();
  }
  
  ImmutableCollection<K> delegateCollection()
  {
    return this$0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapKeySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */