package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
class StandardTable<R, C, V>
  extends AbstractTable<R, C, V>
  implements Serializable
{
  @GwtTransient
  final Map<R, Map<C, V>> backingMap;
  @GwtTransient
  final Supplier<? extends Map<C, V>> factory;
  private transient Set<C> columnKeySet;
  private transient Map<R, Map<C, V>> rowMap;
  private transient StandardTable<R, C, V>.ColumnMap columnMap;
  private static final long serialVersionUID = 0L;
  
  StandardTable(Map<R, Map<C, V>> backingMap, Supplier<? extends Map<C, V>> factory)
  {
    this.backingMap = backingMap;
    this.factory = factory;
  }
  
  public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (rowKey != null) && (columnKey != null) && (super.contains(rowKey, columnKey));
  }
  
  public boolean containsColumn(@Nullable Object columnKey)
  {
    if (columnKey == null) {
      return false;
    }
    for (Map<C, V> map : backingMap.values()) {
      if (Maps.safeContainsKey(map, columnKey)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean containsRow(@Nullable Object rowKey)
  {
    return (rowKey != null) && (Maps.safeContainsKey(backingMap, rowKey));
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return (value != null) && (super.containsValue(value));
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (rowKey == null) || (columnKey == null) ? null : super.get(rowKey, columnKey);
  }
  
  public boolean isEmpty()
  {
    return backingMap.isEmpty();
  }
  
  public int size()
  {
    int size = 0;
    for (Map<C, V> map : backingMap.values()) {
      size += map.size();
    }
    return size;
  }
  
  public void clear()
  {
    backingMap.clear();
  }
  
  private Map<C, V> getOrCreate(R rowKey)
  {
    Map<C, V> map = (Map)backingMap.get(rowKey);
    if (map == null)
    {
      map = (Map)factory.get();
      backingMap.put(rowKey, map);
    }
    return map;
  }
  
  public V put(R rowKey, C columnKey, V value)
  {
    Preconditions.checkNotNull(rowKey);
    Preconditions.checkNotNull(columnKey);
    Preconditions.checkNotNull(value);
    return (V)getOrCreate(rowKey).put(columnKey, value);
  }
  
  public V remove(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    if ((rowKey == null) || (columnKey == null)) {
      return null;
    }
    Map<C, V> map = (Map)Maps.safeGet(backingMap, rowKey);
    if (map == null) {
      return null;
    }
    V value = map.remove(columnKey);
    if (map.isEmpty()) {
      backingMap.remove(rowKey);
    }
    return value;
  }
  
  private Map<R, V> removeColumn(Object column)
  {
    Map<R, V> output = new LinkedHashMap();
    Iterator<Map.Entry<R, Map<C, V>>> iterator = backingMap.entrySet().iterator();
    while (iterator.hasNext())
    {
      Map.Entry<R, Map<C, V>> entry = (Map.Entry)iterator.next();
      V value = ((Map)entry.getValue()).remove(column);
      if (value != null)
      {
        output.put(entry.getKey(), value);
        if (((Map)entry.getValue()).isEmpty()) {
          iterator.remove();
        }
      }
    }
    return output;
  }
  
  private boolean containsMapping(Object rowKey, Object columnKey, Object value)
  {
    return (value != null) && (value.equals(get(rowKey, columnKey)));
  }
  
  private boolean removeMapping(Object rowKey, Object columnKey, Object value)
  {
    if (containsMapping(rowKey, columnKey, value))
    {
      remove(rowKey, columnKey);
      return true;
    }
    return false;
  }
  
  private abstract class TableSet<T>
    extends Sets.ImprovedAbstractSet<T>
  {
    private TableSet() {}
    
    public boolean isEmpty()
    {
      return backingMap.isEmpty();
    }
    
    public void clear()
    {
      backingMap.clear();
    }
  }
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator()
  {
    return new CellIterator(null);
  }
  
  private class CellIterator
    implements Iterator<Table.Cell<R, C, V>>
  {
    final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = backingMap.entrySet().iterator();
    Map.Entry<R, Map<C, V>> rowEntry;
    Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
    
    private CellIterator() {}
    
    public boolean hasNext()
    {
      return (rowIterator.hasNext()) || (columnIterator.hasNext());
    }
    
    public Table.Cell<R, C, V> next()
    {
      if (!columnIterator.hasNext())
      {
        rowEntry = ((Map.Entry)rowIterator.next());
        columnIterator = ((Map)rowEntry.getValue()).entrySet().iterator();
      }
      Map.Entry<C, V> columnEntry = (Map.Entry)columnIterator.next();
      return Tables.immutableCell(rowEntry.getKey(), columnEntry.getKey(), columnEntry.getValue());
    }
    
    public void remove()
    {
      columnIterator.remove();
      if (((Map)rowEntry.getValue()).isEmpty()) {
        rowIterator.remove();
      }
    }
  }
  
  public Map<C, V> row(R rowKey)
  {
    return new Row(rowKey);
  }
  
  class Row
    extends Maps.ImprovedAbstractMap<C, V>
  {
    final R rowKey;
    Map<C, V> backingRowMap;
    
    Row()
    {
      this.rowKey = Preconditions.checkNotNull(rowKey);
    }
    
    Map<C, V> backingRowMap()
    {
      return (backingRowMap == null) || ((backingRowMap.isEmpty()) && (backingMap.containsKey(rowKey))) ? (backingRowMap = computeBackingRowMap()) : backingRowMap;
    }
    
    Map<C, V> computeBackingRowMap()
    {
      return (Map)backingMap.get(rowKey);
    }
    
    void maintainEmptyInvariant()
    {
      if ((backingRowMap() != null) && (backingRowMap.isEmpty()))
      {
        backingMap.remove(rowKey);
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
      return (V)put(rowKey, key, value);
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
  
  public Map<R, V> column(C columnKey)
  {
    return new Column(columnKey);
  }
  
  private class Column
    extends Maps.ImprovedAbstractMap<R, V>
  {
    final C columnKey;
    
    Column()
    {
      this.columnKey = Preconditions.checkNotNull(columnKey);
    }
    
    public V put(R key, V value)
    {
      return (V)put(key, columnKey, value);
    }
    
    public V get(Object key)
    {
      return (V)get(key, columnKey);
    }
    
    public boolean containsKey(Object key)
    {
      return contains(key, columnKey);
    }
    
    public V remove(Object key)
    {
      return (V)remove(key, columnKey);
    }
    
    boolean removeFromColumnIf(Predicate<? super Map.Entry<R, V>> predicate)
    {
      boolean changed = false;
      Iterator<Map.Entry<R, Map<C, V>>> iterator = backingMap.entrySet().iterator();
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
        for (Map<C, V> map : backingMap.values()) {
          if (map.containsKey(columnKey)) {
            size++;
          }
        }
        return size;
      }
      
      public boolean isEmpty()
      {
        return !containsColumn(columnKey);
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
          return StandardTable.this.containsMapping(entry.getKey(), columnKey, entry.getValue());
        }
        return false;
      }
      
      public boolean remove(Object obj)
      {
        if ((obj instanceof Map.Entry))
        {
          Map.Entry<?, ?> entry = (Map.Entry)obj;
          return StandardTable.this.removeMapping(entry.getKey(), columnKey, entry.getValue());
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
      final Iterator<Map.Entry<R, Map<C, V>>> iterator = backingMap.entrySet().iterator();
      
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
        return contains(obj, columnKey);
      }
      
      public boolean remove(Object obj)
      {
        return remove(obj, columnKey) != null;
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
  
  public Set<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public Set<C> columnKeySet()
  {
    Set<C> result = columnKeySet;
    return result == null ? (columnKeySet = new ColumnKeySet(null)) : result;
  }
  
  private class ColumnKeySet
    extends StandardTable<R, C, V>.TableSet<C>
  {
    private ColumnKeySet()
    {
      super(null);
    }
    
    public Iterator<C> iterator()
    {
      return createColumnKeyIterator();
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
      Iterator<Map<C, V>> iterator = backingMap.values().iterator();
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
      Iterator<Map<C, V>> iterator = backingMap.values().iterator();
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
      Iterator<Map<C, V>> iterator = backingMap.values().iterator();
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
      return containsColumn(obj);
    }
  }
  
  Iterator<C> createColumnKeyIterator()
  {
    return new ColumnKeyIterator(null);
  }
  
  private class ColumnKeyIterator
    extends AbstractIterator<C>
  {
    final Map<C, V> seen = (Map)factory.get();
    final Iterator<Map<C, V>> mapIterator = backingMap.values().iterator();
    Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
    
    private ColumnKeyIterator() {}
    
    protected C computeNext()
    {
      for (;;)
      {
        if (entryIterator.hasNext())
        {
          Map.Entry<C, V> entry = (Map.Entry)entryIterator.next();
          if (!seen.containsKey(entry.getKey()))
          {
            seen.put(entry.getKey(), entry.getValue());
            return (C)entry.getKey();
          }
        }
        else
        {
          if (!mapIterator.hasNext()) {
            break;
          }
          entryIterator = ((Map)mapIterator.next()).entrySet().iterator();
        }
      }
      return (C)endOfData();
    }
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    Map<R, Map<C, V>> result = rowMap;
    return result == null ? (rowMap = createRowMap()) : result;
  }
  
  Map<R, Map<C, V>> createRowMap()
  {
    return new RowMap();
  }
  
  class RowMap
    extends Maps.ImprovedAbstractMap<R, Map<C, V>>
  {
    RowMap() {}
    
    public boolean containsKey(Object key)
    {
      return containsRow(key);
    }
    
    public Map<C, V> get(Object key)
    {
      return containsRow(key) ? row(key) : null;
    }
    
    public Map<C, V> remove(Object key)
    {
      return key == null ? null : (Map)backingMap.remove(key);
    }
    
    protected Set<Map.Entry<R, Map<C, V>>> createEntrySet()
    {
      return new EntrySet();
    }
    
    class EntrySet
      extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
    {
      EntrySet()
      {
        super(null);
      }
      
      public Iterator<Map.Entry<R, Map<C, V>>> iterator()
      {
        Maps.asMapEntryIterator(backingMap.keySet(), new Function()
        {
          public Map<C, V> apply(R rowKey)
          {
            return row(rowKey);
          }
        });
      }
      
      public int size()
      {
        return backingMap.size();
      }
      
      public boolean contains(Object obj)
      {
        if ((obj instanceof Map.Entry))
        {
          Map.Entry<?, ?> entry = (Map.Entry)obj;
          return (entry.getKey() != null) && ((entry.getValue() instanceof Map)) && (Collections2.safeContains(backingMap.entrySet(), entry));
        }
        return false;
      }
      
      public boolean remove(Object obj)
      {
        if ((obj instanceof Map.Entry))
        {
          Map.Entry<?, ?> entry = (Map.Entry)obj;
          return (entry.getKey() != null) && ((entry.getValue() instanceof Map)) && (backingMap.entrySet().remove(entry));
        }
        return false;
      }
    }
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    StandardTable<R, C, V>.ColumnMap result = columnMap;
    return result == null ? (columnMap = new ColumnMap(null)) : result;
  }
  
  private class ColumnMap
    extends Maps.ImprovedAbstractMap<C, Map<R, V>>
  {
    private ColumnMap() {}
    
    public Map<R, V> get(Object key)
    {
      return containsColumn(key) ? column(key) : null;
    }
    
    public boolean containsKey(Object key)
    {
      return containsColumn(key);
    }
    
    public Map<R, V> remove(Object key)
    {
      return containsColumn(key) ? StandardTable.this.removeColumn(key) : null;
    }
    
    public Set<Map.Entry<C, Map<R, V>>> createEntrySet()
    {
      return new ColumnMapEntrySet();
    }
    
    public Set<C> keySet()
    {
      return columnKeySet();
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
        Maps.asMapEntryIterator(columnKeySet(), new Function()
        {
          public Map<R, V> apply(C columnKey)
          {
            return column(columnKey);
          }
        });
      }
      
      public int size()
      {
        return columnKeySet().size();
      }
      
      public boolean contains(Object obj)
      {
        if ((obj instanceof Map.Entry))
        {
          Map.Entry<?, ?> entry = (Map.Entry)obj;
          if (containsColumn(entry.getKey()))
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
          StandardTable.this.removeColumn(entry.getKey());
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
        for (C columnKey : Lists.newArrayList(columnKeySet().iterator())) {
          if (!c.contains(Maps.immutableEntry(columnKey, column(columnKey))))
          {
            StandardTable.this.removeColumn(columnKey);
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
            StandardTable.this.removeColumn(entry.getKey());
            return true;
          }
        }
        return false;
      }
      
      public boolean removeAll(Collection<?> c)
      {
        Preconditions.checkNotNull(c);
        boolean changed = false;
        for (C columnKey : Lists.newArrayList(columnKeySet().iterator())) {
          if (c.contains(column(columnKey)))
          {
            StandardTable.this.removeColumn(columnKey);
            changed = true;
          }
        }
        return changed;
      }
      
      public boolean retainAll(Collection<?> c)
      {
        Preconditions.checkNotNull(c);
        boolean changed = false;
        for (C columnKey : Lists.newArrayList(columnKeySet().iterator())) {
          if (!c.contains(column(columnKey)))
          {
            StandardTable.this.removeColumn(columnKey);
            changed = true;
          }
        }
        return changed;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */