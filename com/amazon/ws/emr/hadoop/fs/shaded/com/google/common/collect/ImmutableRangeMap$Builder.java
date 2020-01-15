package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class ImmutableRangeMap$Builder<K extends Comparable<?>, V>
{
  private final RangeSet<K> keyRanges;
  private final RangeMap<K, V> rangeMap;
  
  public ImmutableRangeMap$Builder()
  {
    keyRanges = TreeRangeSet.create();
    rangeMap = TreeRangeMap.create();
  }
  
  public Builder<K, V> put(Range<K> range, V value)
  {
    Preconditions.checkNotNull(range);
    Preconditions.checkNotNull(value);
    Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", new Object[] { range });
    if (!keyRanges.complement().encloses(range))
    {
      String str1;
      String str2;
      for (Iterator i$ = rangeMap.asMapOfRanges().entrySet().iterator(); i$.hasNext(); throw new IllegalArgumentException(47 + str1.length() + str2.length() + "Overlapping ranges: range " + str1 + " overlaps with entry " + str2))
      {
        Map.Entry<Range<K>, V> entry = (Map.Entry)i$.next();
        Range<K> key = (Range)entry.getKey();
        if ((key.isConnected(range)) && (!key.intersection(range).isEmpty()))
        {
          str1 = String.valueOf(String.valueOf(range));str2 = String.valueOf(String.valueOf(entry));
        }
      }
    }
    keyRanges.add(range);
    rangeMap.put(range, value);
    return this;
  }
  
  public Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap)
  {
    for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
      put((Range)entry.getKey(), entry.getValue());
    }
    return this;
  }
  
  public ImmutableRangeMap<K, V> build()
  {
    Map<Range<K>, V> map = rangeMap.asMapOfRanges();
    ImmutableList.Builder<Range<K>> rangesBuilder = new ImmutableList.Builder(map.size());
    
    ImmutableList.Builder<V> valuesBuilder = new ImmutableList.Builder(map.size());
    for (Map.Entry<Range<K>, V> entry : map.entrySet())
    {
      rangesBuilder.add(entry.getKey());
      valuesBuilder.add(entry.getValue());
    }
    return new ImmutableRangeMap(rangesBuilder.build(), valuesBuilder.build());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */