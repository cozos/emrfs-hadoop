package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class TreeRangeMap$RangeMapEntry<K extends Comparable, V>
  extends AbstractMapEntry<Range<K>, V>
{
  private final Range<K> range;
  private final V value;
  
  TreeRangeMap$RangeMapEntry(Cut<K> lowerBound, Cut<K> upperBound, V value)
  {
    this(Range.create(lowerBound, upperBound), value);
  }
  
  TreeRangeMap$RangeMapEntry(Range<K> range, V value)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.RangeMapEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */