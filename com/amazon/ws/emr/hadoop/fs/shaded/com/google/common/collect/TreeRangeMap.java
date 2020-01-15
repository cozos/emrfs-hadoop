package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.Nullable;

@Beta
@GwtIncompatible("NavigableMap")
public final class TreeRangeMap<K extends Comparable, V>
  implements RangeMap<K, V>
{
  private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound;
  
  public static <K extends Comparable, V> TreeRangeMap<K, V> create()
  {
    return new TreeRangeMap();
  }
  
  private TreeRangeMap()
  {
    entriesByLowerBound = Maps.newTreeMap();
  }
  
  private static final class RangeMapEntry<K extends Comparable, V>
    extends AbstractMapEntry<Range<K>, V>
  {
    private final Range<K> range;
    private final V value;
    
    RangeMapEntry(Cut<K> lowerBound, Cut<K> upperBound, V value)
    {
      this(Range.create(lowerBound, upperBound), value);
    }
    
    RangeMapEntry(Range<K> range, V value)
    {
      this.range = range;
      this.value = value;
    }
    
    public Range<K> getKey()
    {
      return range;
    }
    
    public V getValue()
    {
      return (V)value;
    }
    
    public boolean contains(K value)
    {
      return range.contains(value);
    }
    
    Cut<K> getLowerBound()
    {
      return range.lowerBound;
    }
    
    Cut<K> getUpperBound()
    {
      return range.upperBound;
    }
  }
  
  @Nullable
  public V get(K key)
  {
    Map.Entry<Range<K>, V> entry = getEntry(key);
    return entry == null ? null : entry.getValue();
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K key)
  {
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> mapEntry = entriesByLowerBound.floorEntry(Cut.belowValue(key));
    if ((mapEntry != null) && (((RangeMapEntry)mapEntry.getValue()).contains(key))) {
      return (Map.Entry)mapEntry.getValue();
    }
    return null;
  }
  
  public void put(Range<K> range, V value)
  {
    if (!range.isEmpty())
    {
      Preconditions.checkNotNull(value);
      remove(range);
      entriesByLowerBound.put(lowerBound, new RangeMapEntry(range, value));
    }
  }
  
  public void putAll(RangeMap<K, V> rangeMap)
  {
    for (Map.Entry<Range<K>, V> entry : rangeMap.asMapOfRanges().entrySet()) {
      put((Range)entry.getKey(), entry.getValue());
    }
  }
  
  public void clear()
  {
    entriesByLowerBound.clear();
  }
  
  public Range<K> span()
  {
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = entriesByLowerBound.firstEntry();
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = entriesByLowerBound.lastEntry();
    if (firstEntry == null) {
      throw new NoSuchElementException();
    }
    return Range.create(getValuegetKeylowerBound, getValuegetKeyupperBound);
  }
  
  private void putRangeMapEntry(Cut<K> lowerBound, Cut<K> upperBound, V value)
  {
    entriesByLowerBound.put(lowerBound, new RangeMapEntry(lowerBound, upperBound, value));
  }
  
  public void remove(Range<K> rangeToRemove)
  {
    if (rangeToRemove.isEmpty()) {
      return;
    }
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> mapEntryBelowToTruncate = entriesByLowerBound.lowerEntry(lowerBound);
    if (mapEntryBelowToTruncate != null)
    {
      RangeMapEntry<K, V> rangeMapEntry = (RangeMapEntry)mapEntryBelowToTruncate.getValue();
      if (rangeMapEntry.getUpperBound().compareTo(lowerBound) > 0)
      {
        if (rangeMapEntry.getUpperBound().compareTo(upperBound) > 0) {
          putRangeMapEntry(upperBound, rangeMapEntry.getUpperBound(), ((RangeMapEntry)mapEntryBelowToTruncate.getValue()).getValue());
        }
        putRangeMapEntry(rangeMapEntry.getLowerBound(), lowerBound, ((RangeMapEntry)mapEntryBelowToTruncate.getValue()).getValue());
      }
    }
    Map.Entry<Cut<K>, RangeMapEntry<K, V>> mapEntryAboveToTruncate = entriesByLowerBound.lowerEntry(upperBound);
    if (mapEntryAboveToTruncate != null)
    {
      RangeMapEntry<K, V> rangeMapEntry = (RangeMapEntry)mapEntryAboveToTruncate.getValue();
      if (rangeMapEntry.getUpperBound().compareTo(upperBound) > 0)
      {
        putRangeMapEntry(upperBound, rangeMapEntry.getUpperBound(), ((RangeMapEntry)mapEntryAboveToTruncate.getValue()).getValue());
        
        entriesByLowerBound.remove(lowerBound);
      }
    }
    entriesByLowerBound.subMap(lowerBound, upperBound).clear();
  }
  
  public Map<Range<K>, V> asMapOfRanges()
  {
    return new AsMapOfRanges(null);
  }
  
  private final class AsMapOfRanges
    extends AbstractMap<Range<K>, V>
  {
    private AsMapOfRanges() {}
    
    public boolean containsKey(@Nullable Object key)
    {
      return get(key) != null;
    }
    
    public V get(@Nullable Object key)
    {
      if ((key instanceof Range))
      {
        Range<?> range = (Range)key;
        TreeRangeMap.RangeMapEntry<K, V> rangeMapEntry = (TreeRangeMap.RangeMapEntry)entriesByLowerBound.get(lowerBound);
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
          return entriesByLowerBound.values().iterator();
        }
        
        public int size()
        {
          return entriesByLowerBound.size();
        }
      };
    }
  }
  
  public RangeMap<K, V> subRangeMap(Range<K> subRange)
  {
    if (subRange.equals(Range.all())) {
      return this;
    }
    return new SubRangeMap(subRange);
  }
  
  private RangeMap<K, V> emptySubRangeMap()
  {
    return EMPTY_SUB_RANGE_MAP;
  }
  
  private static final RangeMap EMPTY_SUB_RANGE_MAP = new RangeMap()
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
  };
  
  private class SubRangeMap
    implements RangeMap<K, V>
  {
    private final Range<K> subRange;
    
    SubRangeMap()
    {
      this.subRange = subRange;
    }
    
    @Nullable
    public V get(K key)
    {
      return (V)(subRange.contains(key) ? TreeRangeMap.this.get(key) : null);
    }
    
    @Nullable
    public Map.Entry<Range<K>, V> getEntry(K key)
    {
      if (subRange.contains(key))
      {
        Map.Entry<Range<K>, V> entry = TreeRangeMap.this.getEntry(key);
        if (entry != null) {
          return Maps.immutableEntry(((Range)entry.getKey()).intersection(subRange), entry.getValue());
        }
      }
      return null;
    }
    
    public Range<K> span()
    {
      Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> lowerEntry = entriesByLowerBound.floorEntry(subRange.lowerBound);
      Cut<K> lowerBound;
      Cut<K> lowerBound;
      if ((lowerEntry != null) && (((TreeRangeMap.RangeMapEntry)lowerEntry.getValue()).getUpperBound().compareTo(subRange.lowerBound) > 0))
      {
        lowerBound = subRange.lowerBound;
      }
      else
      {
        lowerBound = (Cut)entriesByLowerBound.ceilingKey(subRange.lowerBound);
        if ((lowerBound == null) || (lowerBound.compareTo(subRange.upperBound) >= 0)) {
          throw new NoSuchElementException();
        }
      }
      Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> upperEntry = entriesByLowerBound.lowerEntry(subRange.upperBound);
      if (upperEntry == null) {
        throw new NoSuchElementException();
      }
      Cut<K> upperBound;
      Cut<K> upperBound;
      if (((TreeRangeMap.RangeMapEntry)upperEntry.getValue()).getUpperBound().compareTo(subRange.upperBound) >= 0) {
        upperBound = subRange.upperBound;
      } else {
        upperBound = ((TreeRangeMap.RangeMapEntry)upperEntry.getValue()).getUpperBound();
      }
      return Range.create(lowerBound, upperBound);
    }
    
    public void put(Range<K> range, V value)
    {
      Preconditions.checkArgument(subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", new Object[] { range, subRange });
      
      TreeRangeMap.this.put(range, value);
    }
    
    public void putAll(RangeMap<K, V> rangeMap)
    {
      if (rangeMap.asMapOfRanges().isEmpty()) {
        return;
      }
      Range<K> span = rangeMap.span();
      Preconditions.checkArgument(subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", new Object[] { span, subRange });
      
      TreeRangeMap.this.putAll(rangeMap);
    }
    
    public void clear()
    {
      TreeRangeMap.this.remove(subRange);
    }
    
    public void remove(Range<K> range)
    {
      if (range.isConnected(subRange)) {
        TreeRangeMap.this.remove(range.intersection(subRange));
      }
    }
    
    public RangeMap<K, V> subRangeMap(Range<K> range)
    {
      if (!range.isConnected(subRange)) {
        return TreeRangeMap.this.emptySubRangeMap();
      }
      return TreeRangeMap.this.subRangeMap(range.intersection(subRange));
    }
    
    public Map<Range<K>, V> asMapOfRanges()
    {
      return new SubRangeMapAsMap();
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
    
    public int hashCode()
    {
      return asMapOfRanges().hashCode();
    }
    
    public String toString()
    {
      return asMapOfRanges().toString();
    }
    
    class SubRangeMapAsMap
      extends AbstractMap<Range<K>, V>
    {
      SubRangeMapAsMap() {}
      
      public boolean containsKey(Object key)
      {
        return get(key) != null;
      }
      
      public V get(Object key)
      {
        try
        {
          if ((key instanceof Range))
          {
            Range<K> r = (Range)key;
            if ((!subRange.encloses(r)) || (r.isEmpty())) {
              return null;
            }
            TreeRangeMap.RangeMapEntry<K, V> candidate = null;
            if (lowerBound.compareTo(subRange.lowerBound) == 0)
            {
              Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> entry = entriesByLowerBound.floorEntry(lowerBound);
              if (entry != null) {
                candidate = (TreeRangeMap.RangeMapEntry)entry.getValue();
              }
            }
            else
            {
              candidate = (TreeRangeMap.RangeMapEntry)entriesByLowerBound.get(lowerBound);
            }
            if ((candidate != null) && (candidate.getKey().isConnected(subRange)) && (candidate.getKey().intersection(subRange).equals(r))) {
              return (V)candidate.getValue();
            }
          }
        }
        catch (ClassCastException e)
        {
          return null;
        }
        return null;
      }
      
      public V remove(Object key)
      {
        V value = get(key);
        if (value != null)
        {
          Range<K> range = (Range)key;
          TreeRangeMap.this.remove(range);
          return value;
        }
        return null;
      }
      
      public void clear()
      {
        TreeRangeMap.SubRangeMap.this.clear();
      }
      
      private boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> predicate)
      {
        List<Range<K>> toRemove = Lists.newArrayList();
        for (Map.Entry<Range<K>, V> entry : entrySet()) {
          if (predicate.apply(entry)) {
            toRemove.add(entry.getKey());
          }
        }
        for (Range<K> range : toRemove) {
          TreeRangeMap.this.remove(range);
        }
        return !toRemove.isEmpty();
      }
      
      public Set<Range<K>> keySet()
      {
        new Maps.KeySet(this)
        {
          public boolean remove(@Nullable Object o)
          {
            return remove(o) != null;
          }
          
          public boolean retainAll(Collection<?> c)
          {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.keyFunction()));
          }
        };
      }
      
      public Set<Map.Entry<Range<K>, V>> entrySet()
      {
        new Maps.EntrySet()
        {
          Map<Range<K>, V> map()
          {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this;
          }
          
          public Iterator<Map.Entry<Range<K>, V>> iterator()
          {
            if (subRange.isEmpty()) {
              return Iterators.emptyIterator();
            }
            Cut<K> cutToStart = (Cut)MoreObjects.firstNonNull(entriesByLowerBound.floorKey(subRange.lowerBound), subRange.lowerBound);
            
            final Iterator<TreeRangeMap.RangeMapEntry<K, V>> backingItr = entriesByLowerBound.tailMap(cutToStart, true).values().iterator();
            
            new AbstractIterator()
            {
              protected Map.Entry<Range<K>, V> computeNext()
              {
                while (backingItr.hasNext())
                {
                  TreeRangeMap.RangeMapEntry<K, V> entry = (TreeRangeMap.RangeMapEntry)backingItr.next();
                  if (entry.getLowerBound().compareTo(subRange.upperBound) >= 0) {
                    break;
                  }
                  if (entry.getUpperBound().compareTo(subRange.lowerBound) > 0) {
                    return Maps.immutableEntry(entry.getKey().intersection(subRange), entry.getValue());
                  }
                }
                return (Map.Entry)endOfData();
              }
            };
          }
          
          public boolean retainAll(Collection<?> c)
          {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(c)));
          }
          
          public int size()
          {
            return Iterators.size(iterator());
          }
          
          public boolean isEmpty()
          {
            return !iterator().hasNext();
          }
        };
      }
      
      public Collection<V> values()
      {
        new Maps.Values(this)
        {
          public boolean removeAll(Collection<?> c)
          {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(c), Maps.valueFunction()));
          }
          
          public boolean retainAll(Collection<?> c)
          {
            return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.valueFunction()));
          }
        };
      }
    }
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
  
  public int hashCode()
  {
    return asMapOfRanges().hashCode();
  }
  
  public String toString()
  {
    return entriesByLowerBound.values().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */