package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Multimaps
{
  public static <K, V> Multimap<K, V> newMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> factory)
  {
    return new CustomMultimap(map, factory);
  }
  
  private static class CustomMultimap<K, V>
    extends AbstractMapBasedMultimap<K, V>
  {
    transient Supplier<? extends Collection<V>> factory;
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    
    CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> factory)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(factory));
    }
    
    protected Collection<V> createCollection()
    {
      return (Collection)factory.get();
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream)
      throws IOException
    {
      stream.defaultWriteObject();
      stream.writeObject(factory);
      stream.writeObject(backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      factory = ((Supplier)stream.readObject());
      Map<K, Collection<V>> map = (Map)stream.readObject();
      setMap(map);
    }
  }
  
  public static <K, V> ListMultimap<K, V> newListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> factory)
  {
    return new CustomListMultimap(map, factory);
  }
  
  private static class CustomListMultimap<K, V>
    extends AbstractListMultimap<K, V>
  {
    transient Supplier<? extends List<V>> factory;
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0L;
    
    CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> factory)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(factory));
    }
    
    protected List<V> createCollection()
    {
      return (List)factory.get();
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream)
      throws IOException
    {
      stream.defaultWriteObject();
      stream.writeObject(factory);
      stream.writeObject(backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      factory = ((Supplier)stream.readObject());
      Map<K, Collection<V>> map = (Map)stream.readObject();
      setMap(map);
    }
  }
  
  public static <K, V> SetMultimap<K, V> newSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> factory)
  {
    return new CustomSetMultimap(map, factory);
  }
  
  private static class CustomSetMultimap<K, V>
    extends AbstractSetMultimap<K, V>
  {
    transient Supplier<? extends Set<V>> factory;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> factory)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(factory));
    }
    
    protected Set<V> createCollection()
    {
      return (Set)factory.get();
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream)
      throws IOException
    {
      stream.defaultWriteObject();
      stream.writeObject(factory);
      stream.writeObject(backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      factory = ((Supplier)stream.readObject());
      Map<K, Collection<V>> map = (Map)stream.readObject();
      setMap(map);
    }
  }
  
  public static <K, V> SortedSetMultimap<K, V> newSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> factory)
  {
    return new CustomSortedSetMultimap(map, factory);
  }
  
  private static class CustomSortedSetMultimap<K, V>
    extends AbstractSortedSetMultimap<K, V>
  {
    transient Supplier<? extends SortedSet<V>> factory;
    transient Comparator<? super V> valueComparator;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 0L;
    
    CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> factory)
    {
      super();
      this.factory = ((Supplier)Preconditions.checkNotNull(factory));
      valueComparator = ((SortedSet)factory.get()).comparator();
    }
    
    protected SortedSet<V> createCollection()
    {
      return (SortedSet)factory.get();
    }
    
    public Comparator<? super V> valueComparator()
    {
      return valueComparator;
    }
    
    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream)
      throws IOException
    {
      stream.defaultWriteObject();
      stream.writeObject(factory);
      stream.writeObject(backingMap());
    }
    
    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream)
      throws IOException, ClassNotFoundException
    {
      stream.defaultReadObject();
      factory = ((Supplier)stream.readObject());
      valueComparator = ((SortedSet)factory.get()).comparator();
      Map<K, Collection<V>> map = (Map)stream.readObject();
      setMap(map);
    }
  }
  
  public static <K, V, M extends Multimap<K, V>> M invertFrom(Multimap<? extends V, ? extends K> source, M dest)
  {
    Preconditions.checkNotNull(dest);
    for (Map.Entry<? extends V, ? extends K> entry : source.entries()) {
      dest.put(entry.getValue(), entry.getKey());
    }
    return dest;
  }
  
  public static <K, V> Multimap<K, V> synchronizedMultimap(Multimap<K, V> multimap)
  {
    return Synchronized.multimap(multimap, null);
  }
  
  public static <K, V> Multimap<K, V> unmodifiableMultimap(Multimap<K, V> delegate)
  {
    if (((delegate instanceof UnmodifiableMultimap)) || ((delegate instanceof ImmutableMultimap))) {
      return delegate;
    }
    return new UnmodifiableMultimap(delegate);
  }
  
  @Deprecated
  public static <K, V> Multimap<K, V> unmodifiableMultimap(ImmutableMultimap<K, V> delegate)
  {
    return (Multimap)Preconditions.checkNotNull(delegate);
  }
  
  private static class UnmodifiableMultimap<K, V>
    extends ForwardingMultimap<K, V>
    implements Serializable
  {
    final Multimap<K, V> delegate;
    transient Collection<Map.Entry<K, V>> entries;
    transient Multiset<K> keys;
    transient Set<K> keySet;
    transient Collection<V> values;
    transient Map<K, Collection<V>> map;
    private static final long serialVersionUID = 0L;
    
    UnmodifiableMultimap(Multimap<K, V> delegate)
    {
      this.delegate = ((Multimap)Preconditions.checkNotNull(delegate));
    }
    
    protected Multimap<K, V> delegate()
    {
      return delegate;
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public Map<K, Collection<V>> asMap()
    {
      Map<K, Collection<V>> result = map;
      if (result == null) {
        result =  = Collections.unmodifiableMap(Maps.transformValues(delegate.asMap(), new Function()
        {
          public Collection<V> apply(Collection<V> collection)
          {
            return Multimaps.unmodifiableValueCollection(collection);
          }
        }));
      }
      return result;
    }
    
    public Collection<Map.Entry<K, V>> entries()
    {
      Collection<Map.Entry<K, V>> result = entries;
      if (result == null) {
        entries = (result = Multimaps.unmodifiableEntries(delegate.entries()));
      }
      return result;
    }
    
    public Collection<V> get(K key)
    {
      return Multimaps.unmodifiableValueCollection(delegate.get(key));
    }
    
    public Multiset<K> keys()
    {
      Multiset<K> result = keys;
      if (result == null) {
        keys = (result = Multisets.unmodifiableMultiset(delegate.keys()));
      }
      return result;
    }
    
    public Set<K> keySet()
    {
      Set<K> result = keySet;
      if (result == null) {
        keySet = (result = Collections.unmodifiableSet(delegate.keySet()));
      }
      return result;
    }
    
    public boolean put(K key, V value)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> multimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object key, Object value)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> removeAll(Object key)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> replaceValues(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public Collection<V> values()
    {
      Collection<V> result = values;
      if (result == null) {
        values = (result = Collections.unmodifiableCollection(delegate.values()));
      }
      return result;
    }
  }
  
  private static class UnmodifiableListMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements ListMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableListMultimap(ListMultimap<K, V> delegate)
    {
      super();
    }
    
    public ListMultimap<K, V> delegate()
    {
      return (ListMultimap)super.delegate();
    }
    
    public List<V> get(K key)
    {
      return Collections.unmodifiableList(delegate().get(key));
    }
    
    public List<V> removeAll(Object key)
    {
      throw new UnsupportedOperationException();
    }
    
    public List<V> replaceValues(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableSetMultimap<K, V>
    extends Multimaps.UnmodifiableMultimap<K, V>
    implements SetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSetMultimap(SetMultimap<K, V> delegate)
    {
      super();
    }
    
    public SetMultimap<K, V> delegate()
    {
      return (SetMultimap)super.delegate();
    }
    
    public Set<V> get(K key)
    {
      return Collections.unmodifiableSet(delegate().get(key));
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      return Maps.unmodifiableEntrySet(delegate().entries());
    }
    
    public Set<V> removeAll(Object key)
    {
      throw new UnsupportedOperationException();
    }
    
    public Set<V> replaceValues(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  private static class UnmodifiableSortedSetMultimap<K, V>
    extends Multimaps.UnmodifiableSetMultimap<K, V>
    implements SortedSetMultimap<K, V>
  {
    private static final long serialVersionUID = 0L;
    
    UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate)
    {
      super();
    }
    
    public SortedSetMultimap<K, V> delegate()
    {
      return (SortedSetMultimap)super.delegate();
    }
    
    public SortedSet<V> get(K key)
    {
      return Collections.unmodifiableSortedSet(delegate().get(key));
    }
    
    public SortedSet<V> removeAll(Object key)
    {
      throw new UnsupportedOperationException();
    }
    
    public SortedSet<V> replaceValues(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public Comparator<? super V> valueComparator()
    {
      return delegate().valueComparator();
    }
  }
  
  public static <K, V> SetMultimap<K, V> synchronizedSetMultimap(SetMultimap<K, V> multimap)
  {
    return Synchronized.setMultimap(multimap, null);
  }
  
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(SetMultimap<K, V> delegate)
  {
    if (((delegate instanceof UnmodifiableSetMultimap)) || ((delegate instanceof ImmutableSetMultimap))) {
      return delegate;
    }
    return new UnmodifiableSetMultimap(delegate);
  }
  
  @Deprecated
  public static <K, V> SetMultimap<K, V> unmodifiableSetMultimap(ImmutableSetMultimap<K, V> delegate)
  {
    return (SetMultimap)Preconditions.checkNotNull(delegate);
  }
  
  public static <K, V> SortedSetMultimap<K, V> synchronizedSortedSetMultimap(SortedSetMultimap<K, V> multimap)
  {
    return Synchronized.sortedSetMultimap(multimap, null);
  }
  
  public static <K, V> SortedSetMultimap<K, V> unmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate)
  {
    if ((delegate instanceof UnmodifiableSortedSetMultimap)) {
      return delegate;
    }
    return new UnmodifiableSortedSetMultimap(delegate);
  }
  
  public static <K, V> ListMultimap<K, V> synchronizedListMultimap(ListMultimap<K, V> multimap)
  {
    return Synchronized.listMultimap(multimap, null);
  }
  
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ListMultimap<K, V> delegate)
  {
    if (((delegate instanceof UnmodifiableListMultimap)) || ((delegate instanceof ImmutableListMultimap))) {
      return delegate;
    }
    return new UnmodifiableListMultimap(delegate);
  }
  
  @Deprecated
  public static <K, V> ListMultimap<K, V> unmodifiableListMultimap(ImmutableListMultimap<K, V> delegate)
  {
    return (ListMultimap)Preconditions.checkNotNull(delegate);
  }
  
  private static <V> Collection<V> unmodifiableValueCollection(Collection<V> collection)
  {
    if ((collection instanceof SortedSet)) {
      return Collections.unmodifiableSortedSet((SortedSet)collection);
    }
    if ((collection instanceof Set)) {
      return Collections.unmodifiableSet((Set)collection);
    }
    if ((collection instanceof List)) {
      return Collections.unmodifiableList((List)collection);
    }
    return Collections.unmodifiableCollection(collection);
  }
  
  private static <K, V> Collection<Map.Entry<K, V>> unmodifiableEntries(Collection<Map.Entry<K, V>> entries)
  {
    if ((entries instanceof Set)) {
      return Maps.unmodifiableEntrySet((Set)entries);
    }
    return new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(entries));
  }
  
  @Beta
  public static <K, V> Map<K, List<V>> asMap(ListMultimap<K, V> multimap)
  {
    return multimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Set<V>> asMap(SetMultimap<K, V> multimap)
  {
    return multimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, SortedSet<V>> asMap(SortedSetMultimap<K, V> multimap)
  {
    return multimap.asMap();
  }
  
  @Beta
  public static <K, V> Map<K, Collection<V>> asMap(Multimap<K, V> multimap)
  {
    return multimap.asMap();
  }
  
  public static <K, V> SetMultimap<K, V> forMap(Map<K, V> map)
  {
    return new MapMultimap(map);
  }
  
  private static class MapMultimap<K, V>
    extends AbstractMultimap<K, V>
    implements SetMultimap<K, V>, Serializable
  {
    final Map<K, V> map;
    private static final long serialVersionUID = 7845222491160860175L;
    
    MapMultimap(Map<K, V> map)
    {
      this.map = ((Map)Preconditions.checkNotNull(map));
    }
    
    public int size()
    {
      return map.size();
    }
    
    public boolean containsKey(Object key)
    {
      return map.containsKey(key);
    }
    
    public boolean containsValue(Object value)
    {
      return map.containsValue(value);
    }
    
    public boolean containsEntry(Object key, Object value)
    {
      return map.entrySet().contains(Maps.immutableEntry(key, value));
    }
    
    public Set<V> get(final K key)
    {
      new Sets.ImprovedAbstractSet()
      {
        public Iterator<V> iterator()
        {
          new Iterator()
          {
            int i;
            
            public boolean hasNext()
            {
              return (i == 0) && (map.containsKey(val$key));
            }
            
            public V next()
            {
              if (!hasNext()) {
                throw new NoSuchElementException();
              }
              i += 1;
              return (V)map.get(val$key);
            }
            
            public void remove()
            {
              CollectPreconditions.checkRemove(i == 1);
              i = -1;
              map.remove(val$key);
            }
          };
        }
        
        public int size()
        {
          return map.containsKey(key) ? 1 : 0;
        }
      };
    }
    
    public boolean put(K key, V value)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V> multimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public Set<V> replaceValues(K key, Iterable<? extends V> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object key, Object value)
    {
      return map.entrySet().remove(Maps.immutableEntry(key, value));
    }
    
    public Set<V> removeAll(Object key)
    {
      Set<V> values = new HashSet(2);
      if (!map.containsKey(key)) {
        return values;
      }
      values.add(map.remove(key));
      return values;
    }
    
    public void clear()
    {
      map.clear();
    }
    
    public Set<K> keySet()
    {
      return map.keySet();
    }
    
    public Collection<V> values()
    {
      return map.values();
    }
    
    public Set<Map.Entry<K, V>> entries()
    {
      return map.entrySet();
    }
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return map.entrySet().iterator();
    }
    
    Map<K, Collection<V>> createAsMap()
    {
      return new Multimaps.AsMap(this);
    }
    
    public int hashCode()
    {
      return map.hashCode();
    }
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformValues(Multimap<K, V1> fromMultimap, Function<? super V1, V2> function)
  {
    Preconditions.checkNotNull(function);
    Maps.EntryTransformer<K, V1, V2> transformer = Maps.asEntryTransformer(function);
    return transformEntries(fromMultimap, transformer);
  }
  
  public static <K, V1, V2> Multimap<K, V2> transformEntries(Multimap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    return new TransformedEntriesMultimap(fromMap, transformer);
  }
  
  private static class TransformedEntriesMultimap<K, V1, V2>
    extends AbstractMultimap<K, V2>
  {
    final Multimap<K, V1> fromMultimap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    TransformedEntriesMultimap(Multimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
    {
      this.fromMultimap = ((Multimap)Preconditions.checkNotNull(fromMultimap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(transformer));
    }
    
    Collection<V2> transform(K key, Collection<V1> values)
    {
      Function<? super V1, V2> function = Maps.asValueToValueFunction(transformer, key);
      if ((values instanceof List)) {
        return Lists.transform((List)values, function);
      }
      return Collections2.transform(values, function);
    }
    
    Map<K, Collection<V2>> createAsMap()
    {
      Maps.transformEntries(fromMultimap.asMap(), new Maps.EntryTransformer()
      {
        public Collection<V2> transformEntry(K key, Collection<V1> value)
        {
          return transform(key, value);
        }
      });
    }
    
    public void clear()
    {
      fromMultimap.clear();
    }
    
    public boolean containsKey(Object key)
    {
      return fromMultimap.containsKey(key);
    }
    
    Iterator<Map.Entry<K, V2>> entryIterator()
    {
      return Iterators.transform(fromMultimap.entries().iterator(), Maps.asEntryToEntryFunction(transformer));
    }
    
    public Collection<V2> get(K key)
    {
      return transform(key, fromMultimap.get(key));
    }
    
    public boolean isEmpty()
    {
      return fromMultimap.isEmpty();
    }
    
    public Set<K> keySet()
    {
      return fromMultimap.keySet();
    }
    
    public Multiset<K> keys()
    {
      return fromMultimap.keys();
    }
    
    public boolean put(K key, V2 value)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(K key, Iterable<? extends V2> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean putAll(Multimap<? extends K, ? extends V2> multimap)
    {
      throw new UnsupportedOperationException();
    }
    
    public boolean remove(Object key, Object value)
    {
      return get(key).remove(value);
    }
    
    public Collection<V2> removeAll(Object key)
    {
      return transform(key, fromMultimap.removeAll(key));
    }
    
    public Collection<V2> replaceValues(K key, Iterable<? extends V2> values)
    {
      throw new UnsupportedOperationException();
    }
    
    public int size()
    {
      return fromMultimap.size();
    }
    
    Collection<V2> createValues()
    {
      return Collections2.transform(fromMultimap.entries(), Maps.asEntryToValueFunction(transformer));
    }
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformValues(ListMultimap<K, V1> fromMultimap, Function<? super V1, V2> function)
  {
    Preconditions.checkNotNull(function);
    Maps.EntryTransformer<K, V1, V2> transformer = Maps.asEntryTransformer(function);
    return transformEntries(fromMultimap, transformer);
  }
  
  public static <K, V1, V2> ListMultimap<K, V2> transformEntries(ListMultimap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    return new TransformedEntriesListMultimap(fromMap, transformer);
  }
  
  private static final class TransformedEntriesListMultimap<K, V1, V2>
    extends Multimaps.TransformedEntriesMultimap<K, V1, V2>
    implements ListMultimap<K, V2>
  {
    TransformedEntriesListMultimap(ListMultimap<K, V1> fromMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
    {
      super(transformer);
    }
    
    List<V2> transform(K key, Collection<V1> values)
    {
      return Lists.transform((List)values, Maps.asValueToValueFunction(transformer, key));
    }
    
    public List<V2> get(K key)
    {
      return transform(key, fromMultimap.get(key));
    }
    
    public List<V2> removeAll(Object key)
    {
      return transform(key, fromMultimap.removeAll(key));
    }
    
    public List<V2> replaceValues(K key, Iterable<? extends V2> values)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterable<V> values, Function<? super V, K> keyFunction)
  {
    return index(values.iterator(), keyFunction);
  }
  
  public static <K, V> ImmutableListMultimap<K, V> index(Iterator<V> values, Function<? super V, K> keyFunction)
  {
    Preconditions.checkNotNull(keyFunction);
    ImmutableListMultimap.Builder<K, V> builder = ImmutableListMultimap.builder();
    while (values.hasNext())
    {
      V value = values.next();
      Preconditions.checkNotNull(value, values);
      builder.put(keyFunction.apply(value), value);
    }
    return builder.build();
  }
  
  static class Keys<K, V>
    extends AbstractMultiset<K>
  {
    final Multimap<K, V> multimap;
    
    Keys(Multimap<K, V> multimap)
    {
      this.multimap = multimap;
    }
    
    Iterator<Multiset.Entry<K>> entryIterator()
    {
      new TransformedIterator(multimap.asMap().entrySet().iterator())
      {
        Multiset.Entry<K> transform(final Map.Entry<K, Collection<V>> backingEntry)
        {
          new Multisets.AbstractEntry()
          {
            public K getElement()
            {
              return (K)backingEntry.getKey();
            }
            
            public int getCount()
            {
              return ((Collection)backingEntry.getValue()).size();
            }
          };
        }
      };
    }
    
    int distinctElements()
    {
      return multimap.asMap().size();
    }
    
    Set<Multiset.Entry<K>> createEntrySet()
    {
      return new KeysEntrySet();
    }
    
    class KeysEntrySet
      extends Multisets.EntrySet<K>
    {
      KeysEntrySet() {}
      
      Multiset<K> multiset()
      {
        return Multimaps.Keys.this;
      }
      
      public Iterator<Multiset.Entry<K>> iterator()
      {
        return entryIterator();
      }
      
      public int size()
      {
        return distinctElements();
      }
      
      public boolean isEmpty()
      {
        return multimap.isEmpty();
      }
      
      public boolean contains(@Nullable Object o)
      {
        if ((o instanceof Multiset.Entry))
        {
          Multiset.Entry<?> entry = (Multiset.Entry)o;
          Collection<V> collection = (Collection)multimap.asMap().get(entry.getElement());
          return (collection != null) && (collection.size() == entry.getCount());
        }
        return false;
      }
      
      public boolean remove(@Nullable Object o)
      {
        if ((o instanceof Multiset.Entry))
        {
          Multiset.Entry<?> entry = (Multiset.Entry)o;
          Collection<V> collection = (Collection)multimap.asMap().get(entry.getElement());
          if ((collection != null) && (collection.size() == entry.getCount()))
          {
            collection.clear();
            return true;
          }
        }
        return false;
      }
    }
    
    public boolean contains(@Nullable Object element)
    {
      return multimap.containsKey(element);
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(multimap.entries().iterator());
    }
    
    public int count(@Nullable Object element)
    {
      Collection<V> values = (Collection)Maps.safeGet(multimap.asMap(), element);
      return values == null ? 0 : values.size();
    }
    
    public int remove(@Nullable Object element, int occurrences)
    {
      CollectPreconditions.checkNonnegative(occurrences, "occurrences");
      if (occurrences == 0) {
        return count(element);
      }
      Collection<V> values = (Collection)Maps.safeGet(multimap.asMap(), element);
      if (values == null) {
        return 0;
      }
      int oldCount = values.size();
      if (occurrences >= oldCount)
      {
        values.clear();
      }
      else
      {
        Iterator<V> iterator = values.iterator();
        for (int i = 0; i < occurrences; i++)
        {
          iterator.next();
          iterator.remove();
        }
      }
      return oldCount;
    }
    
    public void clear()
    {
      multimap.clear();
    }
    
    public Set<K> elementSet()
    {
      return multimap.keySet();
    }
  }
  
  static abstract class Entries<K, V>
    extends AbstractCollection<Map.Entry<K, V>>
  {
    abstract Multimap<K, V> multimap();
    
    public int size()
    {
      return multimap().size();
    }
    
    public boolean contains(@Nullable Object o)
    {
      if ((o instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)o;
        return multimap().containsEntry(entry.getKey(), entry.getValue());
      }
      return false;
    }
    
    public boolean remove(@Nullable Object o)
    {
      if ((o instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)o;
        return multimap().remove(entry.getKey(), entry.getValue());
      }
      return false;
    }
    
    public void clear()
    {
      multimap().clear();
    }
  }
  
  static final class AsMap<K, V>
    extends Maps.ImprovedAbstractMap<K, Collection<V>>
  {
    private final Multimap<K, V> multimap;
    
    AsMap(Multimap<K, V> multimap)
    {
      this.multimap = ((Multimap)Preconditions.checkNotNull(multimap));
    }
    
    public int size()
    {
      return multimap.keySet().size();
    }
    
    protected Set<Map.Entry<K, Collection<V>>> createEntrySet()
    {
      return new EntrySet();
    }
    
    void removeValuesForKey(Object key)
    {
      multimap.keySet().remove(key);
    }
    
    class EntrySet
      extends Maps.EntrySet<K, Collection<V>>
    {
      EntrySet() {}
      
      Map<K, Collection<V>> map()
      {
        return Multimaps.AsMap.this;
      }
      
      public Iterator<Map.Entry<K, Collection<V>>> iterator()
      {
        Maps.asMapEntryIterator(multimap.keySet(), new Function()
        {
          public Collection<V> apply(K key)
          {
            return multimap.get(key);
          }
        });
      }
      
      public boolean remove(Object o)
      {
        if (!contains(o)) {
          return false;
        }
        Map.Entry<?, ?> entry = (Map.Entry)o;
        removeValuesForKey(entry.getKey());
        return true;
      }
    }
    
    public Collection<V> get(Object key)
    {
      return containsKey(key) ? multimap.get(key) : null;
    }
    
    public Collection<V> remove(Object key)
    {
      return containsKey(key) ? multimap.removeAll(key) : null;
    }
    
    public Set<K> keySet()
    {
      return multimap.keySet();
    }
    
    public boolean isEmpty()
    {
      return multimap.isEmpty();
    }
    
    public boolean containsKey(Object key)
    {
      return multimap.containsKey(key);
    }
    
    public void clear()
    {
      multimap.clear();
    }
  }
  
  public static <K, V> Multimap<K, V> filterKeys(Multimap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    if ((unfiltered instanceof SetMultimap)) {
      return filterKeys((SetMultimap)unfiltered, keyPredicate);
    }
    if ((unfiltered instanceof ListMultimap)) {
      return filterKeys((ListMultimap)unfiltered, keyPredicate);
    }
    if ((unfiltered instanceof FilteredKeyMultimap))
    {
      FilteredKeyMultimap<K, V> prev = (FilteredKeyMultimap)unfiltered;
      return new FilteredKeyMultimap(unfiltered, Predicates.and(keyPredicate, keyPredicate));
    }
    if ((unfiltered instanceof FilteredMultimap))
    {
      FilteredMultimap<K, V> prev = (FilteredMultimap)unfiltered;
      return filterFiltered(prev, Maps.keyPredicateOnEntries(keyPredicate));
    }
    return new FilteredKeyMultimap(unfiltered, keyPredicate);
  }
  
  public static <K, V> SetMultimap<K, V> filterKeys(SetMultimap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    if ((unfiltered instanceof FilteredKeySetMultimap))
    {
      FilteredKeySetMultimap<K, V> prev = (FilteredKeySetMultimap)unfiltered;
      return new FilteredKeySetMultimap(prev.unfiltered(), Predicates.and(keyPredicate, keyPredicate));
    }
    if ((unfiltered instanceof FilteredSetMultimap))
    {
      FilteredSetMultimap<K, V> prev = (FilteredSetMultimap)unfiltered;
      return filterFiltered(prev, Maps.keyPredicateOnEntries(keyPredicate));
    }
    return new FilteredKeySetMultimap(unfiltered, keyPredicate);
  }
  
  public static <K, V> ListMultimap<K, V> filterKeys(ListMultimap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    if ((unfiltered instanceof FilteredKeyListMultimap))
    {
      FilteredKeyListMultimap<K, V> prev = (FilteredKeyListMultimap)unfiltered;
      return new FilteredKeyListMultimap(prev.unfiltered(), Predicates.and(keyPredicate, keyPredicate));
    }
    return new FilteredKeyListMultimap(unfiltered, keyPredicate);
  }
  
  public static <K, V> Multimap<K, V> filterValues(Multimap<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    return filterEntries(unfiltered, Maps.valuePredicateOnEntries(valuePredicate));
  }
  
  public static <K, V> SetMultimap<K, V> filterValues(SetMultimap<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    return filterEntries(unfiltered, Maps.valuePredicateOnEntries(valuePredicate));
  }
  
  public static <K, V> Multimap<K, V> filterEntries(Multimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Preconditions.checkNotNull(entryPredicate);
    if ((unfiltered instanceof SetMultimap)) {
      return filterEntries((SetMultimap)unfiltered, entryPredicate);
    }
    return (unfiltered instanceof FilteredMultimap) ? filterFiltered((FilteredMultimap)unfiltered, entryPredicate) : new FilteredEntryMultimap((Multimap)Preconditions.checkNotNull(unfiltered), entryPredicate);
  }
  
  public static <K, V> SetMultimap<K, V> filterEntries(SetMultimap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Preconditions.checkNotNull(entryPredicate);
    return (unfiltered instanceof FilteredSetMultimap) ? filterFiltered((FilteredSetMultimap)unfiltered, entryPredicate) : new FilteredEntrySetMultimap((SetMultimap)Preconditions.checkNotNull(unfiltered), entryPredicate);
  }
  
  private static <K, V> Multimap<K, V> filterFiltered(FilteredMultimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Predicate<Map.Entry<K, V>> predicate = Predicates.and(multimap.entryPredicate(), entryPredicate);
    
    return new FilteredEntryMultimap(multimap.unfiltered(), predicate);
  }
  
  private static <K, V> SetMultimap<K, V> filterFiltered(FilteredSetMultimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Predicate<Map.Entry<K, V>> predicate = Predicates.and(multimap.entryPredicate(), entryPredicate);
    
    return new FilteredEntrySetMultimap(multimap.unfiltered(), predicate);
  }
  
  static boolean equalsImpl(Multimap<?, ?> multimap, @Nullable Object object)
  {
    if (object == multimap) {
      return true;
    }
    if ((object instanceof Multimap))
    {
      Multimap<?, ?> that = (Multimap)object;
      return multimap.asMap().equals(that.asMap());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */