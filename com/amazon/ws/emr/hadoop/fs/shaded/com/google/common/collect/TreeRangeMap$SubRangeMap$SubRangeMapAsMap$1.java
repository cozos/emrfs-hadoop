package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1
  extends Maps.KeySet<Range<K>, V>
{
  TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(TreeRangeMap.SubRangeMap.SubRangeMapAsMap paramSubRangeMapAsMap, Map x0)
  {
    super(x0);
  }
  
  public boolean remove(@Nullable Object o)
  {
    return this$2.remove(o) != null;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return TreeRangeMap.SubRangeMap.SubRangeMapAsMap.access$400(this$2, Predicates.compose(Predicates.not(Predicates.in(c)), Maps.keyFunction()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */