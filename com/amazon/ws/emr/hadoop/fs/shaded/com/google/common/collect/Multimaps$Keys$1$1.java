package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map.Entry;

class Multimaps$Keys$1$1
  extends Multisets.AbstractEntry<K>
{
  Multimaps$Keys$1$1(Multimaps.Keys.1 param1, Map.Entry paramEntry) {}
  
  public K getElement()
  {
    return (K)val$backingEntry.getKey();
  }
  
  public int getCount()
  {
    return ((Collection)val$backingEntry.getValue()).size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.Keys.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */