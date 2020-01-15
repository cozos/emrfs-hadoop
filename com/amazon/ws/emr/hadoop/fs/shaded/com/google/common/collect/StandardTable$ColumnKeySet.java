package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class StandardTable$ColumnKeySet
  extends StandardTable<R, C, V>.TableSet<C>
{
  private StandardTable$ColumnKeySet(StandardTable paramStandardTable)
  {
    super(paramStandardTable, null);
  }
  
  public Iterator<C> iterator()
  {
    return this$0.createColumnKeyIterator();
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
  
  public boolean remove(Object obj)
  {
    if (obj == null) {
      return false;
    }
    boolean changed = false;
    Iterator<Map<C, V>> iterator = this$0.backingMap.values().iterator();
    while (iterator.hasNext())
    {
      Map<C, V> map = (Map)iterator.next();
      if (map.keySet().remove(obj))
      {
        changed = true;
        if (map.isEmpty()) {
          iterator.remove();
        }
      }
    }
    return changed;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    boolean changed = false;
    Iterator<Map<C, V>> iterator = this$0.backingMap.values().iterator();
    while (iterator.hasNext())
    {
      Map<C, V> map = (Map)iterator.next();
      if (Iterators.removeAll(map.keySet().iterator(), c))
      {
        changed = true;
        if (map.isEmpty()) {
          iterator.remove();
        }
      }
    }
    return changed;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    boolean changed = false;
    Iterator<Map<C, V>> iterator = this$0.backingMap.values().iterator();
    while (iterator.hasNext())
    {
      Map<C, V> map = (Map)iterator.next();
      if (map.keySet().retainAll(c))
      {
        changed = true;
        if (map.isEmpty()) {
          iterator.remove();
        }
      }
    }
    return changed;
  }
  
  public boolean contains(Object obj)
  {
    return this$0.containsColumn(obj);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.ColumnKeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */