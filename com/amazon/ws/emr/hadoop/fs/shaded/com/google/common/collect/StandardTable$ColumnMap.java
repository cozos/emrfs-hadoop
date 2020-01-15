package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$ColumnMap
  extends Maps.ImprovedAbstractMap<C, Map<R, V>>
{
  private StandardTable$ColumnMap(StandardTable paramStandardTable) {}
  
  public Map<R, V> get(Object key)
  {
    return this$0.containsColumn(key) ? this$0.column(key) : null;
  }
  
  public boolean containsKey(Object key)
  {
    return this$0.containsColumn(key);
  }
  
  public Map<R, V> remove(Object key)
  {
    return this$0.containsColumn(key) ? StandardTable.access$1000(this$0, key) : null;
  }
  
  public Set<Map.Entry<C, Map<R, V>>> createEntrySet()
  {
    return new ColumnMapEntrySet();
  }
  
  public Set<C> keySet()
  {
    return this$0.columnKeySet();
  }
  
  Collection<Map<R, V>> createValues()
  {
    return new ColumnMapValues();
  }
  
  class ColumnMapEntrySet
    extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
  {
    ColumnMapEntrySet()
    {
      super(null);
    }
    
    public Iterator<Map.Entry<C, Map<R, V>>> iterator()
    {
      Maps.asMapEntryIterator(this$0.columnKeySet(), new Function()
      {
        public Map<R, V> apply(C columnKey)
        {
          return this$0.column(columnKey);
        }
      });
    }
    
    public int size()
    {
      return this$0.columnKeySet().size();
    }
    
    public boolean contains(Object obj)
    {
      if ((obj instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)obj;
        if (this$0.containsColumn(entry.getKey()))
        {
          C columnKey = entry.getKey();
          return get(columnKey).equals(entry.getValue());
        }
      }
      return false;
    }
    
    public boolean remove(Object obj)
    {
      if (contains(obj))
      {
        Map.Entry<?, ?> entry = (Map.Entry)obj;
        StandardTable.access$1000(this$0, entry.getKey());
        return true;
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> c)
    {
      Preconditions.checkNotNull(c);
      return Sets.removeAllImpl(this, c.iterator());
    }
    
    public boolean retainAll(Collection<?> c)
    {
      Preconditions.checkNotNull(c);
      boolean changed = false;
      for (C columnKey : Lists.newArrayList(this$0.columnKeySet().iterator())) {
        if (!c.contains(Maps.immutableEntry(columnKey, this$0.column(columnKey))))
        {
          StandardTable.access$1000(this$0, columnKey);
          changed = true;
        }
      }
      return changed;
    }
  }
  
  private class ColumnMapValues
    extends Maps.Values<C, Map<R, V>>
  {
    ColumnMapValues()
    {
      super();
    }
    
    public boolean remove(Object obj)
    {
      for (Map.Entry<C, Map<R, V>> entry : entrySet()) {
        if (((Map)entry.getValue()).equals(obj))
        {
          StandardTable.access$1000(this$0, entry.getKey());
          return true;
        }
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> c)
    {
      Preconditions.checkNotNull(c);
      boolean changed = false;
      for (C columnKey : Lists.newArrayList(this$0.columnKeySet().iterator())) {
        if (c.contains(this$0.column(columnKey)))
        {
          StandardTable.access$1000(this$0, columnKey);
          changed = true;
        }
      }
      return changed;
    }
    
    public boolean retainAll(Collection<?> c)
    {
      Preconditions.checkNotNull(c);
      boolean changed = false;
      for (C columnKey : Lists.newArrayList(this$0.columnKeySet().iterator())) {
        if (!c.contains(this$0.column(columnKey)))
        {
          StandardTable.access$1000(this$0, columnKey);
          changed = true;
        }
      }
      return changed;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.ColumnMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */