package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("NavigableMap")
public class ImmutableRangeMap<K extends Comparable<?>, V>
  implements RangeMap<K, V>
{
  private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap(ImmutableList.of(), ImmutableList.of());
  private final ImmutableList<Range<K>> ranges;
  private final ImmutableList<V> values;
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of()
  {
    return EMPTY;
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V value)
  {
    return new ImmutableRangeMap(ImmutableList.of(range), ImmutableList.of(value));
  }
  
  public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap)
  {
    if ((rangeMap instanceof ImmutableRangeMap)) {
      return (ImmutableRangeMap)rangeMap;
    }
    Map<Range<K>, ? extends V> map = rangeMap.asMapOfRanges();
    ImmutableList.Builder<Range<K>> rangesBuilder = new ImmutableList.Builder(map.size());
    ImmutableList.Builder<V> valuesBuilder = new ImmutableList.Builder(map.size());
    for (Map.Entry<Range<K>, ? extends V> entry : map.entrySet())
    {
      rangesBuilder.add(entry.getKey());
      valuesBuilder.add(entry.getValue());
    }
    return new ImmutableRangeMap(rangesBuilder.build(), valuesBuilder.build());
  }
  
  public static <K extends Comparable<?>, V> Builder<K, V> builder()
  {
    return new Builder();
  }
  
  public static final class Builder<K extends Comparable<?>, V>
  {
    private final RangeSet<K> keyRanges;
    private final RangeMap<K, V> rangeMap;
    
    public Builder()
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
  
  ImmutableRangeMap(ImmutableList<Range<K>> ranges, ImmutableList<V> values)
  {
    this.ranges = ranges;
    this.values = values;
  }
  
  @Nullable
  public V get(K key)
  {
    int index = SortedLists.binarySearch(ranges, Range.lowerBoundFn(), Cut.belowValue(key), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (index == -1) {
      return null;
    }
    Range<K> range = (Range)ranges.get(index);
    return (V)(range.contains(key) ? values.get(index) : null);
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K key)
  {
    int index = SortedLists.binarySearch(ranges, Range.lowerBoundFn(), Cut.belowValue(key), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
    if (index == -1) {
      return null;
    }
    Range<K> range = (Range)ranges.get(index);
    return range.contains(key) ? Maps.immutableEntry(range, values.get(index)) : null;
  }
  
  public Range<K> span()
  {
    if (ranges.isEmpty()) {
      throw new NoSuchElementException();
    }
    Range<K> firstRange = (Range)ranges.get(0);
    Range<K> lastRange = (Range)ranges.get(ranges.size() - 1);
    return Range.create(lowerBound, upperBound);
  }
  
  public void put(Range<K> range, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(RangeMap<K, V> rangeMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public void remove(Range<K> range)
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableMap<Range<K>, V> asMapOfRanges()
  {
    if (ranges.isEmpty()) {
      return ImmutableMap.of();
    }
    RegularImmutableSortedSet<Range<K>> rangeSet = new RegularImmutableSortedSet(ranges, Range.RANGE_LEX_ORDERING);
    
    return new RegularImmutableSortedMap(rangeSet, values);
  }
  
  public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range)
  {
    if (((Range)Preconditions.checkNotNull(range)).isEmpty()) {
      return of();
    }
    if ((ranges.isEmpty()) || (range.encloses(span()))) {
      return this;
    }
    int lowerIndex = SortedLists.binarySearch(ranges, Range.upperBoundFn(), lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    
    int upperIndex = SortedLists.binarySearch(ranges, Range.lowerBoundFn(), upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
    if (lowerIndex >= upperIndex) {
      return of();
    }
    final int off = lowerIndex;
    final int len = upperIndex - lowerIndex;
    ImmutableList<Range<K>> subRanges = new ImmutableList()
    {
      public int size()
      {
        return len;
      }
      
      public Range<K> get(int index)
      {
        Preconditions.checkElementIndex(index, len);
        if ((index == 0) || (index == len - 1)) {
          return ((Range)ranges.get(index + off)).intersection(range);
        }
        return (Range)ranges.get(index + off);
      }
      
      boolean isPartialView()
      {
        return true;
      }
    };
    final ImmutableRangeMap<K, V> outer = this;
    new ImmutableRangeMap(subRanges, values.subList(lowerIndex, upperIndex))
    {
      public ImmutableRangeMap<K, V> subRangeMap(Range<K> subRange)
      {
        if (range.isConnected(subRange)) {
          return outer.subRangeMap(subRange.intersection(range));
        }
        return ImmutableRangeMap.of();
      }
    };
  }
  
  public int hashCode()
  {
    return asMapOfRanges().hashCode();
  }
  
  public boolean equals(@Nullable Object o)
  {
    if ((o instanceof RangeMap))
    {
      RangeMap<?, ?> rangeMap = (RangeMap)o;
      return asMapOfRanges().equals(rangeMap.asMapOfRanges());
    }
    return false;
  }
  
  public String toString()
  {
    return asMapOfRanges().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableRangeMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */