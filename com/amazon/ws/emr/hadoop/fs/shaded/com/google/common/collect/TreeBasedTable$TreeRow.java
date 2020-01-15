package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

class TreeBasedTable$TreeRow
  extends StandardTable<R, C, V>.Row
  implements SortedMap<C, V>
{
  @Nullable
  final C lowerBound;
  @Nullable
  final C upperBound;
  transient SortedMap<C, V> wholeRow;
  
  TreeBasedTable$TreeRow(R arg1)
  {
    this(???, rowKey, null, null);
  }
  
  TreeBasedTable$TreeRow(R arg1, @Nullable C rowKey, @Nullable C lowerBound)
  {
    super(???, rowKey);
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    Preconditions.checkArgument((lowerBound == null) || (upperBound == null) || (compare(lowerBound, upperBound) <= 0));
  }
  
  public SortedSet<C> keySet()
  {
    return new Maps.SortedKeySet(this);
  }
  
  public Comparator<? super C> comparator()
  {
    return this$0.columnComparator();
  }
  
  int compare(Object a, Object b)
  {
    Comparator<Object> cmp = comparator();
    return cmp.compare(a, b);
  }
  
  boolean rangeContains(@Nullable Object o)
  {
    return (o != null) && ((lowerBound == null) || (compare(lowerBound, o) <= 0)) && ((upperBound == null) || (compare(upperBound, o) > 0));
  }
  
  public SortedMap<C, V> subMap(C fromKey, C toKey)
  {
    Preconditions.checkArgument((rangeContains(Preconditions.checkNotNull(fromKey))) && (rangeContains(Preconditions.checkNotNull(toKey))));
    
    return new TreeRow(this$0, rowKey, fromKey, toKey);
  }
  
  public SortedMap<C, V> headMap(C toKey)
  {
    Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(toKey)));
    return new TreeRow(this$0, rowKey, lowerBound, toKey);
  }
  
  public SortedMap<C, V> tailMap(C fromKey)
  {
    Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(fromKey)));
    return new TreeRow(this$0, rowKey, fromKey, upperBound);
  }
  
  public C firstKey()
  {
    SortedMap<C, V> backing = backingRowMap();
    if (backing == null) {
      throw new NoSuchElementException();
    }
    return (C)backingRowMap().firstKey();
  }
  
  public C lastKey()
  {
    SortedMap<C, V> backing = backingRowMap();
    if (backing == null) {
      throw new NoSuchElementException();
    }
    return (C)backingRowMap().lastKey();
  }
  
  SortedMap<C, V> wholeRow()
  {
    if ((wholeRow == null) || ((wholeRow.isEmpty()) && (this$0.backingMap.containsKey(rowKey)))) {
      wholeRow = ((SortedMap)this$0.backingMap.get(rowKey));
    }
    return wholeRow;
  }
  
  SortedMap<C, V> backingRowMap()
  {
    return (SortedMap)super.backingRowMap();
  }
  
  SortedMap<C, V> computeBackingRowMap()
  {
    SortedMap<C, V> map = wholeRow();
    if (map != null)
    {
      if (lowerBound != null) {
        map = map.tailMap(lowerBound);
      }
      if (upperBound != null) {
        map = map.headMap(upperBound);
      }
      return map;
    }
    return null;
  }
  
  void maintainEmptyInvariant()
  {
    if ((wholeRow() != null) && (wholeRow.isEmpty()))
    {
      this$0.backingMap.remove(rowKey);
      wholeRow = null;
      backingRowMap = null;
    }
  }
  
  public boolean containsKey(Object key)
  {
    return (rangeContains(key)) && (super.containsKey(key));
  }
  
  public V put(C key, V value)
  {
    Preconditions.checkArgument(rangeContains(Preconditions.checkNotNull(key)));
    return (V)super.put(key, value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeBasedTable.TreeRow
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */