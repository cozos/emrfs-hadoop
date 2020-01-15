package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Column
  extends Maps.ImprovedAbstractMap<R, V>
{
  final C columnKey;
  
  StandardTable$Column(C arg1)
  {
    this.columnKey = Preconditions.checkNotNull(columnKey);
  }
  
  public V put(R key, V value)
  {
    return (V)this$0.put(key, columnKey, value);
  }
  
  public V get(Object key)
  {
    return (V)this$0.get(key, columnKey);
  }
  
  public boolean containsKey(Object key)
  {
    return this$0.contains(key, columnKey);
  }
  
  public V remove(Object key)
  {
    return (V)this$0.remove(key, columnKey);
  }
  
  boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> predicate)
  {
    boolean changed = false;
    Iterator<Map.Entry<R, Map<C, V>>> iterator = this$0.backingMap.entrySet().iterator();
    while (iterator.hasNext())
    {
      Map.Entry<R, Map<C, V>> entry = (Map.Entry)iterator.next();
      Map<C, V> map = (Map)entry.getValue();
      V value = map.get(columnKey);
      if ((value != null) && (predicate.apply(Maps.immutableEntry(entry.getKey(), value))))
      {
        map.remove(columnKey);
        changed = true;
        if (map.isEmpty()) {
          iterator.remove();
        }
      }
    }
    return changed;
  }
  
  Set<Map.Entry<R, V>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  private class EntrySet
    extends Sets.ImprovedAbstractSet<Map.Entry<R, V>>
  {
    private EntrySet() {}
    
    public Iterator<Map.Entry<R, V>> iterator()
    {
      return new StandardTable.Column.EntrySetIterator(StandardTable.Column.this, null);
    }
    
    public int size()
    {
      int size = 0;
      for (Map<C, V> map : this$0.backingMap.values()) {
        if (map.containsKey(columnKey)) {
          size++;
        }
      }
      return size;
    }
    
    public boolean isEmpty()
    {
      return !this$0.containsColumn(columnKey);
    }
    
    public void clear()
    {
      removeFromColumnIf(Predicates.alwaysTrue());
    }
    
    public boolean contains(Object o)
    {
      if ((o instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)o;
        return StandardTable.access$400(this$0, entry.getKey(), columnKey, entry.getValue());
      }
      return false;
    }
    
    public boolean remove(Object obj)
    {
      if ((obj instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)obj;
        return StandardTable.access$500(this$0, entry.getKey(), columnKey, entry.getValue());
      }
      return false;
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return removeFromColumnIf(Predicates.not(Predicates.in(c)));
    }
  }
  
  private class EntrySetIterator
    extends AbstractIterator<Map.Entry<R, V>>
  {
    final Iterator<Map.Entry<R, Map<C, V>>> iterator = this$0.backingMap.entrySet().iterator();
    
    private EntrySetIterator() {}
    
    protected Map.Entry<R, V> computeNext()
    {
      while (iterator.hasNext())
      {
        final Map.Entry<R, Map<C, V>> entry = (Map.Entry)iterator.next();
        if (((Map)entry.getValue()).containsKey(columnKey)) {
          new AbstractMapEntry()
          {
            public R getKey()
            {
              return (R)entry.getKey();
            }
            
            public V getValue()
            {
              return (V)((Map)entry.getValue()).get(columnKey);
            }
            
            public V setValue(V value)
            {
              return (V)((Map)entry.getValue()).put(columnKey, Preconditions.checkNotNull(value));
            }
          };
        }
      }
      return (Map.Entry)endOfData();
    }
  }
  
  Set<R> createKeySet()
  {
    return new KeySet();
  }
  
  private class KeySet
    extends Maps.KeySet<R, V>
  {
    KeySet()
    {
      super();
    }
    
    public boolean contains(Object obj)
    {
      return this$0.contains(obj, columnKey);
    }
    
    public boolean remove(Object obj)
    {
      return this$0.remove(obj, columnKey) != null;
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return removeFromColumnIf(Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c))));
    }
  }
  
  Collection<V> createValues()
  {
    return new Values();
  }
  
  private class Values
    extends Maps.Values<R, V>
  {
    Values()
    {
      super();
    }
    
    public boolean remove(Object obj)
    {
      return (obj != null) && (removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.equalTo(obj))));
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.in(c)));
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return removeFromColumnIf(Maps.valuePredicateOnEntries(Predicates.not(Predicates.in(c))));
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */