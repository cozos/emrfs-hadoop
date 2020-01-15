package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class Multimaps$Keys$1
  extends TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>
{
  Multimaps$Keys$1(Multimaps.Keys paramKeys, Iterator x0)
  {
    super(x0);
  }
  
  Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry)
  {
    new Multisets.AbstractEntry()
    {
      public K getElement()
      {
        return (K)backingEntry.getKey();
      }
      
      public int getCount()
      {
        return ((Collection)backingEntry.getValue()).size();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.Keys.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */