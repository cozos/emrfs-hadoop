package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

final class TreeRangeMap$1
  implements RangeMap
{
  @Nullable
  public Object get(Comparable key)
  {
    return null;
  }
  
  @Nullable
  public Map.Entry<Range, Object> getEntry(Comparable key)
  {
    return null;
  }
  
  public Range span()
  {
    throw new NoSuchElementException();
  }
  
  public void put(Range range, Object value)
  {
    Preconditions.checkNotNull(range);
    String str = String.valueOf(String.valueOf(range));throw new IllegalArgumentException(46 + str.length() + "Cannot insert range " + str + " into an empty subRangeMap");
  }
  
  public void putAll(RangeMap rangeMap)
  {
    if (!rangeMap.asMapOfRanges().isEmpty()) {
      throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
    }
  }
  
  public void clear() {}
  
  public void remove(Range range)
  {
    Preconditions.checkNotNull(range);
  }
  
  public Map<Range, Object> asMapOfRanges()
  {
    return Collections.emptyMap();
  }
  
  public RangeMap subRangeMap(Range range)
  {
    Preconditions.checkNotNull(range);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */