package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$TransformedEntriesMultimap<K, V1, V2>
  extends AbstractMultimap<K, V2>
{
  final Multimap<K, V1> fromMultimap;
  final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
  
  Multimaps$TransformedEntriesMultimap(Multimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    this.fromMultimap = ((Multimap)Preconditions.checkNotNull(fromMultimap));
    this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(transformer));
  }
  
  Collection<V2> transform(K key, Collection<V1> values)
  {
    Function<? super V1, V2> function = Maps.asValueToValueFunction(transformer, key);
    if ((values instanceof List)) {
      return Lists.transform((List)values, function);
    }
    return Collections2.transform(values, function);
  }
  
  Map<K, Collection<V2>> createAsMap()
  {
    Maps.transformEntries(fromMultimap.asMap(), new Maps.EntryTransformer()
    {
      public Collection<V2> transformEntry(K key, Collection<V1> value)
      {
        return transform(key, value);
      }
    });
  }
  
  public void clear()
  {
    fromMultimap.clear();
  }
  
  public boolean containsKey(Object key)
  {
    return fromMultimap.containsKey(key);
  }
  
  Iterator<Map.Entry<K, V2>> entryIterator()
  {
    return Iterators.transform(fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(transformer));
  }
  
  public Collection<V2> get(K key)
  {
    return transform(key, fromMultimap.get(key));
  }
  
  public boolean isEmpty()
  {
    return fromMultimap.isEmpty();
  }
  
  public Set<K> keySet()
  {
    return fromMultimap.keySet();
  }
  
  public Multiset<K> keys()
  {
    return fromMultimap.keys();
  }
  
  public boolean put(K key, V2 value)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(K key, Iterable<? extends V2> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V2> multimap)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object key, Object value)
  {
    return get(key).remove(value);
  }
  
  public Collection<V2> removeAll(Object key)
  {
    return transform(key, fromMultimap.removeAll(key));
  }
  
  public Collection<V2> replaceValues(K key, Iterable<? extends V2> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return fromMultimap.size();
  }
  
  Collection<V2> createValues()
  {
    return Collections2.transform(fromMultimap.entries(), Maps.asEntryToValueFunction(transformer));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.TransformedEntriesMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */