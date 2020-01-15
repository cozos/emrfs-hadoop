package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySet
  extends Sets.ImprovedAbstractSet<Map.Entry<R, V>>
{
  private StandardTable$Column$EntrySet(StandardTable.Column paramColumn) {}
  
  public Iterator<Map.Entry<R, V>> iterator()
  {
    return new StandardTable.Column.EntrySetIterator(this$1, null);
  }
  
  public int size()
  {
    int size = 0;
    for (Map<C, V> map : this$1.this$0.backingMap.values()) {
      if (map.containsKey(this$1.columnKey)) {
        size++;
      }
    }
    return size;
  }
  
  public boolean isEmpty()
  {
    return !this$1.this$0.containsColumn(this$1.columnKey);
  }
  
  public void clear()
  {
    this$1.removeFromColumnIf(Predicates.alwaysTrue());
  }
  
  public boolean contains(Object o)
  {
    if ((o instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)o;
      return StandardTable.access$400(this$1.this$0, entry.getKey(), this$1.columnKey, entry.getValue());
    }
    return false;
  }
  
  public boolean remove(Object obj)
  {
    if ((obj instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)obj;
      return StandardTable.access$500(this$1.this$0, entry.getKey(), this$1.columnKey, entry.getValue());
    }
    return false;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    return this$1.removeFromColumnIf(Predicates.not(Predicates.in(c)));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */