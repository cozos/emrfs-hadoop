package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;

class Multimaps$TransformedEntriesMultimap$1
  implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>>
{
  Multimaps$TransformedEntriesMultimap$1(Multimaps.TransformedEntriesMultimap paramTransformedEntriesMultimap) {}
  
  public Collection<V2> transformEntry(K key, Collection<V1> value)
  {
    return this$0.transform(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.TransformedEntriesMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */