package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2
  extends Maps.EntrySet<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap) {}
  
  Map<Range<K>, V> map()
  {
    return this$2;
  }
  
  public Iterator<Map.Entry<Range<K>, V>> iterator()
  {
    if (TreeRangeMap.SubRangeMap.access$300(this$2.this$1).isEmpty()) {
      return Iterators.emptyIterator();
    }
    Cut<K> cutToStart = (Cut)MoreObjects.firstNonNull(TreeRangeMap.access$100(this$2.this$1.this$0).floorKey(access$300this$2.this$1).lowerBound), access$300this$2.this$1).lowerBound);
    
    final Iterator<TreeRangeMap.RangeMapEntry<K, V>> backingItr = TreeRangeMap.access$100(this$2.this$1.this$0).tailMap(cutToStart, true).values().iterator();
    
    new AbstractIterator()
    {
      protected Map.Entry<Range<K>, V> computeNext()
      {
        while (backingItr.hasNext())
        {
          TreeRangeMap.RangeMapEntry<K, V> entry = (TreeRangeMap.RangeMapEntry)backingItr.next();
          if (entry.getLowerBound().compareTo(access$300this$2.this$1).upperBound) >= 0) {
            break;
          }
          if (entry.getUpperBound().compareTo(access$300this$2.this$1).lowerBound) > 0) {
            return Maps.immutableEntry(entry.getKey().intersection(TreeRangeMap.SubRangeMap.access$300(this$2.this$1)), entry.getValue());
          }
        }
        return (Map.Entry)endOfData();
      }
    };
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$400(this$2, Predicates.not(Predicates.in(c)));
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
  
  public boolean isEmpty()
  {
    return !iterator().hasNext();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */