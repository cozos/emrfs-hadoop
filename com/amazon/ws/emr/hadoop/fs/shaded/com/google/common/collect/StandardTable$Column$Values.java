package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;

class StandardTable$Column$Values
  extends Maps.Values<R, V>
{
  StandardTable$Column$Values(StandardTable.Column paramColumn)
  {
    super(paramColumn);
  }
  
  public boolean remove(Object obj)
  {
    return (obj != null) && (this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(obj))));
  }
  
  public boolean removeAll(Collection<?> c)
  {
    return this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(c)));
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(c))));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column.Values
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */