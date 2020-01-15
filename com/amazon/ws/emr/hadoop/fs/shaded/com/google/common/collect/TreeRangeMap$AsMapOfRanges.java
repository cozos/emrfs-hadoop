package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import javax.annotation.Nullable;

final class TreeRangeMap$AsMapOfRanges
  extends AbstractMap<Range<K>, V>
{
  private TreeRangeMap$AsMapOfRanges(TreeRangeMap paramTreeRangeMap) {}
  
  public boolean containsKey(@Nullable Object key)
  {
    return get(key) != null;
  }
  
  public V get(@Nullable Object key)
  {
    if ((key instanceof Range))
    {
      Range<?> range = (Range)key;
      TreeRangeMap.RangeMapEntry<K, V> rangeMapEntry = (TreeRangeMap.RangeMapEntry)TreeRangeMap.access$100(this$0).get(lowerBound);
      if ((rangeMapEntry != null) && (rangeMapEntry.getKey().equals(range))) {
        return (V)rangeMapEntry.getValue();
      }
    }
    return null;
  }
  
  public Set<Map.Entry<Range<K>, V>> entrySet()
  {
    new AbstractSet()
    {
      public Iterator<Map.Entry<Range<K>, V>> iterator()
      {
        return TreeRangeMap.access$100(this$0).values().iterator();
      }
      
      public int size()
      {
        return TreeRangeMap.access$100(this$0).size();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.AsMapOfRanges
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */