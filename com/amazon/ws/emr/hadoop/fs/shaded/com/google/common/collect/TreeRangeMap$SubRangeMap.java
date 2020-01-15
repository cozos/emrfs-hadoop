package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap
  implements RangeMap<K, V>
{
  private final Range<K> subRange;
  
  TreeRangeMap$SubRangeMap(Range<K> arg1)
  {
    this.subRange = subRange;
  }
  
  @Nullable
  public V get(K key)
  {
    return (V)(subRange.contains(key) ? this$0.get(key) : null);
  }
  
  @Nullable
  public Map.Entry<Range<K>, V> getEntry(K key)
  {
    if (subRange.contains(key))
    {
      Map.Entry<Range<K>, V> entry = this$0.getEntry(key);
      if (entry != null) {
        return Maps.immutableEntry(((Range)entry.getKey()).intersection(subRange), entry.getValue());
      }
    }
    return null;
  }
  
  public Range<K> span()
  {
    Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> lowerEntry = TreeRangeMap.access$100(this$0).floorEntry(subRange.lowerBound);
    Cut<K> lowerBound;
    Cut<K> lowerBound;
    if ((lowerEntry != null) && (((TreeRangeMap.RangeMapEntry)lowerEntry.getValue()).getUpperBound().compareTo(subRange.lowerBound) > 0))
    {
      lowerBound = subRange.lowerBound;
    }
    else
    {
      lowerBound = (Cut)TreeRangeMap.access$100(this$0).ceilingKey(subRange.lowerBound);
      if ((lowerBound == null) || (lowerBound.compareTo(subRange.upperBound) >= 0)) {
        throw new NoSuchElementException();
      }
    }
    Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> upperEntry = TreeRangeMap.access$100(this$0).lowerEntry(subRange.upperBound);
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
    
    this$0.put(range, value);
  }
  
  public void putAll(RangeMap<K, V> rangeMap)
  {
    if (rangeMap.asMapOfRanges().isEmpty()) {
      return;
    }
    Range<K> span = rangeMap.span();
    Preconditions.checkArgument(subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", new Object[] { span, subRange });
    
    this$0.putAll(rangeMap);
  }
  
  public void clear()
  {
    this$0.remove(subRange);
  }
  
  public void remove(Range<K> range)
  {
    if (range.isConnected(subRange)) {
      this$0.remove(range.intersection(subRange));
    }
  }
  
  public RangeMap<K, V> subRangeMap(Range<K> range)
  {
    if (!range.isConnected(subRange)) {
      return TreeRangeMap.access$200(this$0);
    }
    return this$0.subRangeMap(range.intersection(subRange));
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
            Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> entry = TreeRangeMap.access$100(this$0).floorEntry(lowerBound);
            if (entry != null) {
              candidate = (TreeRangeMap.RangeMapEntry)entry.getValue();
            }
          }
          else
          {
            candidate = (TreeRangeMap.RangeMapEntry)TreeRangeMap.access$100(this$0).get(lowerBound);
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
        this$0.remove(range);
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
        this$0.remove(range);
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
          Cut<K> cutToStart = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$100(this$0).floorKey(subRange.lowerBound), subRange.lowerBound);
          
          final Iterator<TreeRangeMap.RangeMapEntry<K, V>> backingItr = TreeRangeMap.access$100(this$0).tailMap(cutToStart, true).values().iterator();
          
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */