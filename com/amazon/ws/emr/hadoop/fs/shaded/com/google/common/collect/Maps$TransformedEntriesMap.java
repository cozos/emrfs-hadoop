package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Maps$TransformedEntriesMap<K, V1, V2>
  extends Maps.ImprovedAbstractMap<K, V2>
{
  final Map<K, V1> fromMap;
  final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
  
  Maps$TransformedEntriesMap(Map<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    this.fromMap = ((Map)Preconditions.checkNotNull(fromMap));
    this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(transformer));
  }
  
  public int size()
  {
    return fromMap.size();
  }
  
  public boolean containsKey(Object key)
  {
    return fromMap.containsKey(key);
  }
  
  public V2 get(Object key)
  {
    V1 value = fromMap.get(key);
    return (V2)((value != null) || (fromMap.containsKey(key)) ? transformer.transformEntry(key, value) : null);
  }
  
  public V2 remove(Object key)
  {
    return (V2)(fromMap.containsKey(key) ? transformer.transformEntry(key, fromMap.remove(key)) : null);
  }
  
  public void clear()
  {
    fromMap.clear();
  }
  
  public Set<K> keySet()
  {
    return fromMap.keySet();
  }
  
  protected Set<Map.Entry<K, V2>> createEntrySet()
  {
    new Maps.EntrySet()
    {
      Map<K, V2> map()
      {
        return Maps.TransformedEntriesMap.this;
      }
      
      public Iterator<Map.Entry<K, V2>> iterator()
      {
        return Iterators.transform(fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(transformer));
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.TransformedEntriesMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */