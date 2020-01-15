package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap
  extends AbstractMap<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap(TreeRangeMap.SubRangeMap paramSubRangeMap) {}
  
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
        if ((!TreeRangeMap.SubRangeMap.access$300(this$1).encloses(r)) || (r.isEmpty())) {
          return null;
        }
        TreeRangeMap.RangeMapEntry<K, V> candidate = null;
        if (lowerBound.compareTo(access$300this$1).lowerBound) == 0)
        {
          Map.Entry<Cut<K>, TreeRangeMap.RangeMapEntry<K, V>> entry = TreeRangeMap.access$100(this$1.this$0).floorEntry(lowerBound);
          if (entry != null) {
            candidate = (TreeRangeMap.RangeMapEntry)entry.getValue();
          }
        }
        else
        {
          candidate = (TreeRangeMap.RangeMapEntry)TreeRangeMap.access$100(this$1.this$0).get(lowerBound);
        }
        if ((candidate != null) && (candidate.getKey().isConnected(TreeRangeMap.SubRangeMap.access$300(this$1))) && (candidate.getKey().intersection(TreeRangeMap.SubRangeMap.access$300(this$1)).equals(r))) {
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
      this$1.this$0.remove(range);
      return value;
    }
    return null;
  }
  
  public void clear()
  {
    this$1.clear();
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
      this$1.this$0.remove(range);
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
        if (TreeRangeMap.SubRangeMap.access$300(this$1).isEmpty()) {
          return Iterators.emptyIterator();
        }
        Cut<K> cutToStart = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$100(this$1.this$0).floorKey(access$300this$1).lowerBound), access$300this$1).lowerBound);
        
        final Iterator<TreeRangeMap.RangeMapEntry<K, V>> backingItr = TreeRangeMap.access$100(this$1.this$0).tailMap(cutToStart, true).values().iterator();
        
        new AbstractIterator()
        {
          protected Map.Entry<Range<K>, V> computeNext()
          {
            while (backingItr.hasNext())
            {
              TreeRangeMap.RangeMapEntry<K, V> entry = (TreeRangeMap.RangeMapEntry)backingItr.next();
              if (entry.getLowerBound().compareTo(access$300this$1).upperBound) >= 0) {
                break;
              }
              if (entry.getUpperBound().compareTo(access$300this$1).lowerBound) > 0) {
                return Maps.immutableEntry(entry.getKey().intersection(TreeRangeMap.SubRangeMap.access$300(this$1)), entry.getValue());
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */