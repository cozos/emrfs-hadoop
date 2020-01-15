package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMapValues$1
  extends ImmutableAsList<V>
{
  ImmutableMapValues$1(ImmutableMapValues paramImmutableMapValues, ImmutableList paramImmutableList) {}
  
  public V get(int index)
  {
    return (V)((Map.Entry)val$entryList.get(index)).getValue();
  }
  
  ImmutableCollection<V> delegateCollection()
  {
    return this$0;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMapValues.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */