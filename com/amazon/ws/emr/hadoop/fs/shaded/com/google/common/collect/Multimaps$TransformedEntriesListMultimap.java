package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.List;

final class Multimaps$TransformedEntriesListMultimap<K, V1, V2>
  extends Multimaps.TransformedEntriesMultimap<K, V1, V2>
  implements ListMultimap<K, V2>
{
  Multimaps$TransformedEntriesListMultimap(ListMultimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    super(fromMultimap, transformer);
  }
  
  List<V2> transform(K key, Collection<V1> values)
  {
    return Lists.transform((List)values, Maps.asValueToValueFunction(transformer, key));
  }
  
  public List<V2> get(K key)
  {
    return transform(key, fromMultimap.get(key));
  }
  
  public List<V2> removeAll(Object key)
  {
    return transform(key, fromMultimap.removeAll(key));
  }
  
  public List<V2> replaceValues(K key, Iterable<? extends V2> values)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.TransformedEntriesListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */