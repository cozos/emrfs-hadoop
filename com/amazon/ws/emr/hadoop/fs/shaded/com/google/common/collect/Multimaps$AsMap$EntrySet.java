package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class Multimaps$AsMap$EntrySet
  extends Maps.EntrySet<K, Collection<V>>
{
  Multimaps$AsMap$EntrySet(Multimaps.AsMap paramAsMap) {}
  
  Map<K, Collection<V>> map()
  {
    return this$0;
  }
  
  public Iterator<Map.Entry<K, Collection<V>>> iterator()
  {
    Maps.asMapEntryIterator(Multimaps.AsMap.access$200(this$0).keySet(), new Function()
    {
      public Collection<V> apply(K key)
      {
        return Multimaps.AsMap.access$200(this$0).get(key);
      }
    });
  }
  
  public boolean remove(Object o)
  {
    if (!contains(o)) {
      return false;
    }
    Map.Entry<?, ?> entry = (Map.Entry)o;
    this$0.removeValuesForKey(entry.getKey());
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.AsMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */