package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@Beta
@GwtCompatible
public final class MapConstraints
{
  public static MapConstraint<Object, Object> notNull()
  {
    return NotNullMapConstraint.INSTANCE;
  }
  
  private static enum NotNullMapConstraint
    implements MapConstraint<Object, Object>
  {
    INSTANCE;
    
    private NotNullMapConstraint() {}
    
    public void checkKeyValue(Object key, Object value)
    {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(value);
    }
    
    public String toString()
    {
      return "Not null";
    }
  }
  
  public static <K, V> Map<K, V> constrainedMap(Map<K, V> map, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedMap(map, constraint);
  }
  
  public static <K, V> Multimap<K, V> constrainedMultimap(Multimap<K, V> multimap, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedMultimap(multimap, constraint);
  }
  
  public static <K, V> ListMultimap<K, V> constrainedListMultimap(ListMultimap<K, V> multimap, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedListMultimap(multimap, constraint);
  }
  
  public static <K, V> SetMultimap<K, V> constrainedSetMultimap(SetMultimap<K, V> multimap, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedSetMultimap(multimap, constraint);
  }
  
  public static <K, V> SortedSetMultimap<K, V> constrainedSortedSetMultimap(SortedSetMultimap<K, V> multimap, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedSortedSetMultimap(multimap, constraint);
  }
  
  private static <K, V> Map.Entry<K, V> constrainedEntry(Map.Entry<K, V> entry, final MapConstraint<? super K, ? super V> constraint)
  {
    Preconditions.checkNotNull(entry);
    Preconditions.checkNotNull(constraint);
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, V> delegate()
      {
        return val$entry;
      }
      
      public V setValue(V value)
      {
        constraint.checkKeyValue(getKey(), value);
        return (V)val$entry.setValue(value);
      }
    };
  }
  
  private static <K, V> Map.Entry<K, Collection<V>> constrainedAsMapEntry(Map.Entry<K, Collection<V>> entry, final MapConstraint<? super K, ? super V> constraint)
  {
    Preconditions.checkNotNull(entry);
    Preconditions.checkNotNull(constraint);
    new ForwardingMapEntry()
    {
      protected Map.Entry<K, Collection<V>> delegate()
      {
        return val$entry;
      }
      
      public Collection<V> getValue()
      {
        Constraints.constrainedTypePreservingCollection((Collection)val$entry.getValue(), new Constraint()
        {
          public V checkElement(V value)
          {
            val$constraint.checkKeyValue(getKey(), value);
            return value;
          }
        });
      }
    };
  }
  
  private static <K, V> Set<Map.Entry<K, Collection<V>>> constrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedAsMapEntries(entries, constraint);
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> constrainedEntries(Collection<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    if ((entries instanceof Set)) {
      return constrainedEntrySet((Set)entries, constraint);
    }
    return new ConstrainedEntries(entries, constraint);
  }
  
  private static <K, V> Set<Map.Entry<K, V>> constrainedEntrySet(Set<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedEntrySet(entries, constraint);
  }
  
  static class ConstrainedMap<K, V>
    extends ForwardingMap<K, V>
  {
    private final Map<K, V> delegate;
    final MapConstraint<? super K, ? super V> constraint;
    private transient Set<Map.Entry<K, V>> entrySet;
    
    ConstrainedMap(Map<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
    {
      this.delegate = ((Map)Preconditions.checkNotNull(delegate));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
    }
    
    protected Map<K, V> delegate()
    {
      return delegate;
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set<Map.Entry<K, V>> result = entrySet;
      if (result == null) {
        entrySet = (result = MapConstraints.constrainedEntrySet(delegate.entrySet(), constraint));
      }
      return result;
    }
    
    public V put(K key, V value)
    {
      constraint.checkKeyValue(key, value);
      return (V)delegate.put(key, value);
    }
    
    public void putAll(Map<? extends K, ? extends V> map)
    {
      delegate.putAll(MapConstraints.checkMap(map, constraint));
    }
  }
  
  public static <K, V> BiMap<K, V> constrainedBiMap(BiMap<K, V> map, MapConstraint<? super K, ? super V> constraint)
  {
    return new ConstrainedBiMap(map, null, constraint);
  }
  
  private static class ConstrainedBiMap<K, V>
    extends MapConstraints.ConstrainedMap<K, V>
    implements BiMap<K, V>
  {
    volatile BiMap<V, K> inverse;
    
    ConstrainedBiMap(BiMap<K, V> delegate, @Nullable BiMap<V, K> inverse, MapConstraint<? super K, ? super V> constraint)
    {
      super(constraint);
      this.inverse = inverse;
    }
    
    protected BiMap<K, V> delegate()
    {
      return (BiMap)super.delegate();
    }
    
    public V forcePut(K key, V value)
    {
      constraint.checkKeyValue(key, value);
      return (V)delegate().forcePut(key, value);
    }
    
    public BiMap<V, K> inverse()
    {
      if (inverse == null) {
        inverse = new ConstrainedBiMap(delegate().inverse(), this, new MapConstraints.InverseConstraint(constraint));
      }
      return inverse;
    }
    
    public Set<V> values()
    {
      return delegate().values();
    }
  }
  
  private static class InverseConstraint<K, V>
    implements MapConstraint<K, V>
  {
    final MapConstraint<? super V, ? super K> constraint;
    
    public InverseConstraint(MapConstraint<? super V, ? super K> constraint)
    {
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
    }
    
    public void checkKeyValue(K key, V value)
    {
      constraint.checkKeyValue(value, key);
    }
  }
  
  private static class ConstrainedMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    final MapConstraint<? super K, ? super V> constraint;
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    transient Map<K, Collection<V>> asMap;
    
    public ConstrainedMultimap(Multimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(delegate));
      this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
    }
    
    protected Multimap<K, V> delegate()
    {
      return delegate;
    }
    
    public Map<K, Collection<V>> asMap()
    {
      Map<K, Collection<V>> result = asMap;
      if (result == null)
      {
        final Map<K, Collection<V>> asMapDelegate = delegate.asMap();
        
        asMap = ( = new ForwardingMap()
        {
          Set<Map.Entry<K, Collection<V>>> entrySet;
          Collection<Collection<V>> values;
          
          protected Map<K, Collection<V>> delegate()
          {
            return asMapDelegate;
          }
          
          public Set<Map.Entry<K, Collection<V>>> entrySet()
          {
            Set<Map.Entry<K, Collection<V>>> result = entrySet;
            if (result == null) {
              entrySet = (result = MapConstraints.constrainedAsMapEntries(asMapDelegate.entrySet(), constraint));
            }
            return result;
          }
          
          public Collection<V> get(Object key)
          {
            try
            {
              Collection<V> collection = MapConstraints.ConstrainedMultimap.this.get(key);
              return collection.isEmpty() ? null : collection;
            }
            catch (ClassCastException e) {}
            return null;
          }
          
          public Collection<Collection<V>> values()
          {
            Collection<Collection<V>> result = values;
            if (result == null) {
              values = (result = new MapConstraints.ConstrainedAsMapValues(delegate().values(), entrySet()));
            }
            return result;
          }
          
          public boolean containsValue(Object o)
          {
            return values().contains(o);
          }
        });
      }
      return result;
    }
    
    public Collection<Map.Entry<K, V>> entries()
    {
      Collection<Map.Entry<K, V>> result = entries;
      if (result == null) {
        entries = (result = MapConstraints.constrainedEntries(delegate.entries(), constraint));
      }
      return result;
    }
    
    public Collection<V> get(final K key)
    {
      Constraints.constrainedTypePreservingCollection(delegate.get(key), new Constraint()
      {
        public V checkElement(V value)
        {
          constraint.checkKeyValue(key, value);
          return value;
        }
      });
    }
    
    public boolean put(K key, V value)
    {
      constraint.checkKeyValue(key, value);
      return delegate.put(key, value);
    }
    
    public boolean putAll(K key, Iterable<? extends V> values)
    {
      return delegate.putAll(key, MapConstraints.checkValues(key, values, constraint));
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> multimap)
    {
      boolean changed = false;
      for (Map.Entry<? extends K, ? extends V> entry : multimap.entries()) {
        changed |= put(entry.getKey(), entry.getValue());
      }
      return changed;
    }
    
    public Collection<V> replaceValues(K key, Iterable<? extends V> values)
    {
      return delegate.replaceValues(key, MapConstraints.checkValues(key, values, constraint));
    }
  }
  
  private static class ConstrainedAsMapValues<K, V>
    extends ForwardingCollection<Collection<V>>
  {
    final Collection<Collection<V>> delegate;
    final Set<Map.Entry<K, Collection<V>>> entrySet;
    
    ConstrainedAsMapValues(Collection<Collection<V>> delegate, Set<Map.Entry<K, Collection<V>>> entrySet)
    {
      this.delegate = delegate;
      this.entrySet = entrySet;
    }
    
    protected Collection<Collection<V>> delegate()
    {
      return delegate;
    }
    
    public Iterator<Collection<V>> iterator()
    {
      final Iterator<Map.Entry<K, Collection<V>>> iterator = entrySet.iterator();
      new Iterator()
      {
        public boolean hasNext()
        {
          return iterator.hasNext();
        }
        
        public Collection<V> next()
        {
          return (Collection)((Map.Entry)iterator.next()).getValue();
        }
        
        public void remove()
        {
          iterator.remove();
        }
      };
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public boolean contains(Object o)
    {
      return standardContains(o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return standardContainsAll(c);
    }
    
    public boolean remove(Object o)
    {
      return standardRemove(o);
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return standardRemoveAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return standardRetainAll(c);
    }
  }
  
  private static class ConstrainedEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    final MapConstraint<? super K, ? super V> constraint;
    final Collection<Map.Entry<K, V>> entries;
    
    ConstrainedEntries(Collection<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
    {
      this.entries = entries;
      this.constraint = constraint;
    }
    
    protected Collection<Map.Entry<K, V>> delegate()
    {
      return entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      final Iterator<Map.Entry<K, V>> iterator = entries.iterator();
      new ForwardingIterator()
      {
        public Map.Entry<K, V> next()
        {
          return MapConstraints.constrainedEntry((Map.Entry)iterator.next(), constraint);
        }
        
        protected Iterator<Map.Entry<K, V>> delegate()
        {
          return iterator;
        }
      };
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public boolean contains(Object o)
    {
      return Maps.containsEntryImpl(delegate(), o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return standardContainsAll(c);
    }
    
    public boolean remove(Object o)
    {
      return Maps.removeEntryImpl(delegate(), o);
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return standardRemoveAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return standardRetainAll(c);
    }
  }
  
  static class ConstrainedEntrySet<K, V>
    extends MapConstraints.ConstrainedEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    ConstrainedEntrySet(Set<Map.Entry<K, V>> entries, MapConstraint<? super K, ? super V> constraint)
    {
      super(constraint);
    }
    
    public boolean equals(@Nullable Object object)
    {
      return Sets.equalsImpl(this, object);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
  
  static class ConstrainedAsMapEntries<K, V>
    extends ForwardingSet<Map.Entry<K, Collection<V>>>
  {
    private final MapConstraint<? super K, ? super V> constraint;
    private final Set<Map.Entry<K, Collection<V>>> entries;
    
    ConstrainedAsMapEntries(Set<Map.Entry<K, Collection<V>>> entries, MapConstraint<? super K, ? super V> constraint)
    {
      this.entries = entries;
      this.constraint = constraint;
    }
    
    protected Set<Map.Entry<K, Collection<V>>> delegate()
    {
      return entries;
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      final Iterator<Map.Entry<K, Collection<V>>> iterator = entries.iterator();
      new ForwardingIterator()
      {
        public Map.Entry<K, Collection<V>> next()
        {
          return MapConstraints.constrainedAsMapEntry((Map.Entry)iterator.next(), constraint);
        }
        
        protected Iterator<Map.Entry<K, Collection<V>>> delegate()
        {
          return iterator;
        }
      };
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return standardToArray(array);
    }
    
    public boolean contains(Object o)
    {
      return Maps.containsEntryImpl(delegate(), o);
    }
    
    public boolean containsAll(Collection<?> c)
    {
      return standardContainsAll(c);
    }
    
    public boolean equals(@Nullable Object object)
    {
      return standardEquals(object);
    }
    
    public int hashCode()
    {
      return standardHashCode();
    }
    
    public boolean remove(Object o)
    {
      return Maps.removeEntryImpl(delegate(), o);
    }
    
    public boolean removeAll(Collection<?> c)
    {
      return standardRemoveAll(c);
    }
    
    public boolean retainAll(Collection<?> c)
    {
      return standardRetainAll(c);
    }
  }
  
  private static class ConstrainedListMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements ListMultimap<K, V>
  {
    ConstrainedListMultimap(ListMultimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
    {
      super(constraint);
    }
    
    public List<V> get(K key)
    {
      return (List)super.get(key);
    }
    
    public List<V> removeAll(Object key)
    {
      return (List)super.removeAll(key);
    }
    
    public List<V> replaceValues(K key, Iterable<? extends V> values)
    {
      return (List)super.replaceValues(key, values);
    }
  }
  
  private static class ConstrainedSetMultimap<K, V>
    extends MapConstraints.ConstrainedMultimap<K, V>
    implements SetMultimap<K, V>
  {
    ConstrainedSetMultimap(SetMultimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
    {
      super(constraint);
    }
    
    public Set<V> get(K key)
    {
      return (Set)super.get(key);
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      return (Set)super.entries();
    }
    
    public Set<V> removeAll(Object key)
    {
      return (Set)super.removeAll(key);
    }
    
    public Set<V> replaceValues(K key, Iterable<? extends V> values)
    {
      return (Set)super.replaceValues(key, values);
    }
  }
  
  private static class ConstrainedSortedSetMultimap<K, V>
    extends MapConstraints.ConstrainedSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    ConstrainedSortedSetMultimap(SortedSetMultimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
    {
      super(constraint);
    }
    
    public SortedSet<V> get(K key)
    {
      return (SortedSet)super.get(key);
    }
    
    public SortedSet<V> removeAll(Object key)
    {
      return (SortedSet)super.removeAll(key);
    }
    
    public SortedSet<V> replaceValues(K key, Iterable<? extends V> values)
    {
      return (SortedSet)super.replaceValues(key, values);
    }
    
    public Comparator<? super V> valueComparator()
    {
      return ((SortedSetMultimap)delegate()).valueComparator();
    }
  }
  
  private static <K, V> Collection<V> checkValues(K key, Iterable<? extends V> values, MapConstraint<? super K, ? super V> constraint)
  {
    Collection<V> copy = Lists.newArrayList(values);
    for (V value : copy) {
      constraint.checkKeyValue(key, value);
    }
    return copy;
  }
  
  private static <K, V> Map<K, V> checkMap(Map<? extends K, ? extends V> map, MapConstraint<? super K, ? super V> constraint)
  {
    Map<K, V> copy = new LinkedHashMap(map);
    for (Map.Entry<K, V> entry : copy.entrySet()) {
      constraint.checkKeyValue(entry.getKey(), entry.getValue());
    }
    return copy;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */