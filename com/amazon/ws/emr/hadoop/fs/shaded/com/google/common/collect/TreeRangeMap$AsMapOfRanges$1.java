package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;

class TreeRangeMap$AsMapOfRanges$1
  extends AbstractSet<Map.Entry<Range<K>, V>>
{
  TreeRangeMap$AsMapOfRanges$1(TreeRangeMap.AsMapOfRanges paramAsMapOfRanges) {}
  
  public Iterator<Map.Entry<Range<K>, V>> iterator()
  {
    return TreeRangeMap.access$100(this$1.this$0).values().iterator();
  }
  
  public int size()
  {
    return TreeRangeMap.access$100(this$1.this$0).size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.AsMapOfRanges.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */