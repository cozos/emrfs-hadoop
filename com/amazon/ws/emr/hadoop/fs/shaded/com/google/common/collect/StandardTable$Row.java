package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Row
  extends Maps.ImprovedAbstractMap<C, V>
{
  final R rowKey;
  Map<C, V> backingRowMap;
  
  StandardTable$Row(R arg1)
  {
    this.rowKey = Preconditions.checkNotNull(rowKey);
  }
  
  Map<C, V> backingRowMap()
  {
    return (backingRowMap == null) || ((backingRowMap.isEmpty()) && (this$0.backingMap.containsKey(rowKey))) ? (backingRowMap = computeBackingRowMap()) : backingRowMap;
  }
  
  Map<C, V> computeBackingRowMap()
  {
    return (Map)this$0.backingMap.get(rowKey);
  }
  
  void maintainEmptyInvariant()
  {
    if ((backingRowMap() != null) && (backingRowMap.isEmpty()))
    {
      this$0.backingMap.remove(rowKey);
      backingRowMap = null;
    }
  }
  
  public boolean containsKey(Object key)
  {
    Map<C, V> backingRowMap = backingRowMap();
    return (key != null) && (backingRowMap != null) && (Maps.safeContainsKey(backingRowMap, key));
  }
  
  public V get(Object key)
  {
    Map<C, V> backingRowMap = backingRowMap();
    return (V)((key != null) && (backingRowMap != null) ? Maps.safeGet(backingRowMap, key) : null);
  }
  
  public V put(C key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    if ((backingRowMap != null) && (!backingRowMap.isEmpty())) {
      return (V)backingRowMap.put(key, value);
    }
    return (V)this$0.put(rowKey, key, value);
  }
  
  public V remove(Object key)
  {
    Map<C, V> backingRowMap = backingRowMap();
    if (backingRowMap == null) {
      return null;
    }
    V result = Maps.safeRemove(backingRowMap, key);
    maintainEmptyInvariant();
    return result;
  }
  
  public void clear()
  {
    Map<C, V> backingRowMap = backingRowMap();
    if (backingRowMap != null) {
      backingRowMap.clear();
    }
    maintainEmptyInvariant();
  }
  
  protected Set<Map.Entry<C, V>> createEntrySet()
  {
    return new RowEntrySet(null);
  }
  
  private final class RowEntrySet
    extends Maps.EntrySet<C, V>
  {
    private RowEntrySet() {}
    
    Map<C, V> map()
    {
      return StandardTable.Row.this;
    }
    
    public int size()
    {
      Map<C, V> map = backingRowMap();
      return map == null ? 0 : map.size();
    }
    
    public Iterator<Map.Entry<C, V>> iterator()
    {
      Map<C, V> map = backingRowMap();
      if (map == null) {
        return Iterators.emptyModifiableIterator();
      }
      final Iterator<Map.Entry<C, V>> iterator = map.entrySet().iterator();
      new Iterator()
      {
        public boolean hasNext()
        {
          return iterator.hasNext();
        }
        
        public Map.Entry<C, V> next()
        {
          final Map.Entry<C, V> entry = (Map.Entry)iterator.next();
          new ForwardingMapEntry()
          {
            protected Map.Entry<C, V> delegate()
            {
              return entry;
            }
            
            public V setValue(V value)
            {
              return (V)super.setValue(Preconditions.checkNotNull(value));
            }
            
            public boolean equals(Object object)
            {
              return standardEquals(object);
            }
          };
        }
        
        public void remove()
        {
          iterator.remove();
          maintainEmptyInvariant();
        }
      };
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Row
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */