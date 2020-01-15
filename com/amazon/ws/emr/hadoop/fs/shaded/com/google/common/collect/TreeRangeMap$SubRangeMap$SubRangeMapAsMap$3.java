package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3
  extends Maps.Values<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap, Map x0)
  {
    super(x0);
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$400(this$2, Predicates.compose(Predicates.in(c), Maps.valueFunction()));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$400(this$2, Predicates.compose(Predicates.not(Predicates.in(c)), Maps.valueFunction()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */