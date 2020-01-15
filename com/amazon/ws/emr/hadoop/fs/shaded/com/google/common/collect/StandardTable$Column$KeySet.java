package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;

class StandardTable$Column$KeySet
  extends Maps.KeySet<R, V>
{
  StandardTable$Column$KeySet(StandardTable.Column paramColumn)
  {
    super(paramColumn);
  }
  
  public boolean contains(Object obj)
  {
    return this$1.this$0.contains(obj, this$1.columnKey);
  }
  
  public boolean remove(Object obj)
  {
    return this$1.this$0.remove(obj, this$1.columnKey) != null;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c))));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */