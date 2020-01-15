package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.EnumMap;
import java.util.Set;

class ImmutableEnumMap$1
  extends ImmutableSet<K>
{
  ImmutableEnumMap$1(ImmutableEnumMap paramImmutableEnumMap) {}
  
  public boolean contains(Object object)
  {
    return ImmutableEnumMap.access$000(this$0).containsKey(object);
  }
  
  public int size()
  {
    return this$0.size();
  }
  
  public UnmodifiableIterator<K> iterator()
  {
    return Iterators.unmodifiableIterator(ImmutableEnumMap.access$000(this$0).keySet().iterator());
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableEnumMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */