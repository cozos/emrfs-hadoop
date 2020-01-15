package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Joiner.MapJoiner;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Maps
{
  private static abstract enum EntryFunction
    implements Function<Map.Entry<?, ?>, Object>
  {
    KEY,  VALUE;
    
    private EntryFunction() {}
  }
  
  static <K> Function<Map.Entry<K, ?>, K> keyFunction()
  {
    return EntryFunction.KEY;
  }
  
  static <V> Function<Map.Entry<?, V>, V> valueFunction()
  {
    return EntryFunction.VALUE;
  }
  
  static <K, V> Iterator<K> keyIterator(Iterator<Map.Entry<K, V>> entryIterator)
  {
    return Iterators.transform(entryIterator, keyFunction());
  }
  
  static <K, V> Iterator<V> valueIterator(Iterator<Map.Entry<K, V>> entryIterator)
  {
    return Iterators.transform(entryIterator, valueFunction());
  }
  
  static <K, V> UnmodifiableIterator<V> valueIterator(UnmodifiableIterator<Map.Entry<K, V>> entryIterator)
  {
    new UnmodifiableIterator()
    {
      public boolean hasNext()
      {
        return val$entryIterator.hasNext();
      }
      
      public V next()
      {
        return (V)((Map.Entry)val$entryIterator.next()).getValue();
      }
    };
  }
  
  @GwtCompatible(serializable=true)
  @Beta
  public static <K extends Enum<K>, V> ImmutableMap<K, V> immutableEnumMap(Map<K, ? extends V> map)
  {
    if ((map instanceof ImmutableEnumMap))
    {
      ImmutableEnumMap<K, V> result = (ImmutableEnumMap)map;
      return result;
    }
    if (map.isEmpty()) {
      return ImmutableMap.of();
    }
    for (Map.Entry<K, ? extends V> entry : map.entrySet())
    {
      Preconditions.checkNotNull(entry.getKey());
      Preconditions.checkNotNull(entry.getValue());
    }
    return ImmutableEnumMap.asImmutable(new EnumMap(map));
  }
  
  public static <K, V> HashMap<K, V> newHashMap()
  {
    return new HashMap();
  }
  
  public static <K, V> HashMap<K, V> newHashMapWithExpectedSize(int expectedSize)
  {
    return new HashMap(capacity(expectedSize));
  }
  
  static int capacity(int expectedSize)
  {
    if (expectedSize < 3)
    {
      CollectPreconditions.checkNonnegative(expectedSize, "expectedSize");
      return expectedSize + 1;
    }
    if (expectedSize < 1073741824) {
      return expectedSize + expectedSize / 3;
    }
    return Integer.MAX_VALUE;
  }
  
  public static <K, V> HashMap<K, V> newHashMap(Map<? extends K, ? extends V> map)
  {
    return new HashMap(map);
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap()
  {
    return new LinkedHashMap();
  }
  
  public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(Map<? extends K, ? extends V> map)
  {
    return new LinkedHashMap(map);
  }
  
  public static <K, V> ConcurrentMap<K, V> newConcurrentMap()
  {
    return new MapMaker().makeMap();
  }
  
  public static <K extends Comparable, V> TreeMap<K, V> newTreeMap()
  {
    return new TreeMap();
  }
  
  public static <K, V> TreeMap<K, V> newTreeMap(SortedMap<K, ? extends V> map)
  {
    return new TreeMap(map);
  }
  
  public static <C, K extends C, V> TreeMap<K, V> newTreeMap(@Nullable Comparator<C> comparator)
  {
    return new TreeMap(comparator);
  }
  
  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Class<K> type)
  {
    return new EnumMap((Class)Preconditions.checkNotNull(type));
  }
  
  public static <K extends Enum<K>, V> EnumMap<K, V> newEnumMap(Map<K, ? extends V> map)
  {
    return new EnumMap(map);
  }
  
  public static <K, V> IdentityHashMap<K, V> newIdentityHashMap()
  {
    return new IdentityHashMap();
  }
  
  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right)
  {
    if ((left instanceof SortedMap))
    {
      SortedMap<K, ? extends V> sortedLeft = (SortedMap)left;
      SortedMapDifference<K, V> result = difference(sortedLeft, right);
      return result;
    }
    return difference(left, right, Equivalence.equals());
  }
  
  @Beta
  public static <K, V> MapDifference<K, V> difference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence)
  {
    Preconditions.checkNotNull(valueEquivalence);
    
    Map<K, V> onlyOnLeft = newHashMap();
    Map<K, V> onlyOnRight = new HashMap(right);
    Map<K, V> onBoth = newHashMap();
    Map<K, MapDifference.ValueDifference<V>> differences = newHashMap();
    doDifference(left, right, valueEquivalence, onlyOnLeft, onlyOnRight, onBoth, differences);
    return new MapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
  }
  
  private static <K, V> void doDifference(Map<? extends K, ? extends V> left, Map<? extends K, ? extends V> right, Equivalence<? super V> valueEquivalence, Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences)
  {
    for (Map.Entry<? extends K, ? extends V> entry : left.entrySet())
    {
      K leftKey = entry.getKey();
      V leftValue = entry.getValue();
      if (right.containsKey(leftKey))
      {
        V rightValue = onlyOnRight.remove(leftKey);
        if (valueEquivalence.equivalent(leftValue, rightValue)) {
          onBoth.put(leftKey, leftValue);
        } else {
          differences.put(leftKey, ValueDifferenceImpl.create(leftValue, rightValue));
        }
      }
      else
      {
        onlyOnLeft.put(leftKey, leftValue);
      }
    }
  }
  
  private static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map)
  {
    if ((map instanceof SortedMap)) {
      return Collections.unmodifiableSortedMap((SortedMap)map);
    }
    return Collections.unmodifiableMap(map);
  }
  
  static class MapDifferenceImpl<K, V>
    implements MapDifference<K, V>
  {
    final Map<K, V> onlyOnLeft;
    final Map<K, V> onlyOnRight;
    final Map<K, V> onBoth;
    final Map<K, MapDifference.ValueDifference<V>> differences;
    
    MapDifferenceImpl(Map<K, V> onlyOnLeft, Map<K, V> onlyOnRight, Map<K, V> onBoth, Map<K, MapDifference.ValueDifference<V>> differences)
    {
      this.onlyOnLeft = Maps.unmodifiableMap(onlyOnLeft);
      this.onlyOnRight = Maps.unmodifiableMap(onlyOnRight);
      this.onBoth = Maps.unmodifiableMap(onBoth);
      this.differences = Maps.unmodifiableMap(differences);
    }
    
    public boolean areEqual()
    {
      return (onlyOnLeft.isEmpty()) && (onlyOnRight.isEmpty()) && (differences.isEmpty());
    }
    
    public Map<K, V> entriesOnlyOnLeft()
    {
      return onlyOnLeft;
    }
    
    public Map<K, V> entriesOnlyOnRight()
    {
      return onlyOnRight;
    }
    
    public Map<K, V> entriesInCommon()
    {
      return onBoth;
    }
    
    public Map<K, MapDifference.ValueDifference<V>> entriesDiffering()
    {
      return differences;
    }
    
    public boolean equals(Object object)
    {
      if (object == this) {
        return true;
      }
      if ((object instanceof MapDifference))
      {
        MapDifference<?, ?> other = (MapDifference)object;
        return (entriesOnlyOnLeft().equals(other.entriesOnlyOnLeft())) && (entriesOnlyOnRight().equals(other.entriesOnlyOnRight())) && (entriesInCommon().equals(other.entriesInCommon())) && (entriesDiffering().equals(other.entriesDiffering()));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { entriesOnlyOnLeft(), entriesOnlyOnRight(), entriesInCommon(), entriesDiffering() });
    }
    
    public String toString()
    {
      if (areEqual()) {
        return "equal";
      }
      StringBuilder result = new StringBuilder("not equal");
      if (!onlyOnLeft.isEmpty()) {
        result.append(": only on left=").append(onlyOnLeft);
      }
      if (!onlyOnRight.isEmpty()) {
        result.append(": only on right=").append(onlyOnRight);
      }
      if (!differences.isEmpty()) {
        result.append(": value differences=").append(differences);
      }
      return result.toString();
    }
  }
  
  static class ValueDifferenceImpl<V>
    implements MapDifference.ValueDifference<V>
  {
    private final V left;
    private final V right;
    
    static <V> MapDifference.ValueDifference<V> create(@Nullable V left, @Nullable V right)
    {
      return new ValueDifferenceImpl(left, right);
    }
    
    private ValueDifferenceImpl(@Nullable V left, @Nullable V right)
    {
      this.left = left;
      this.right = right;
    }
    
    public V leftValue()
    {
      return (V)left;
    }
    
    public V rightValue()
    {
      return (V)right;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof MapDifference.ValueDifference))
      {
        MapDifference.ValueDifference<?> that = (MapDifference.ValueDifference)object;
        
        return (Objects.equal(left, that.leftValue())) && (Objects.equal(right, that.rightValue()));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { left, right });
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(left));String str2 = String.valueOf(String.valueOf(right));return 4 + str1.length() + str2.length() + "(" + str1 + ", " + str2 + ")";
    }
  }
  
  public static <K, V> SortedMapDifference<K, V> difference(SortedMap<K, ? extends V> left, Map<? extends K, ? extends V> right)
  {
    Preconditions.checkNotNull(left);
    Preconditions.checkNotNull(right);
    Comparator<? super K> comparator = orNaturalOrder(left.comparator());
    SortedMap<K, V> onlyOnLeft = newTreeMap(comparator);
    SortedMap<K, V> onlyOnRight = newTreeMap(comparator);
    onlyOnRight.putAll(right);
    SortedMap<K, V> onBoth = newTreeMap(comparator);
    SortedMap<K, MapDifference.ValueDifference<V>> differences = newTreeMap(comparator);
    
    doDifference(left, right, Equivalence.equals(), onlyOnLeft, onlyOnRight, onBoth, differences);
    return new SortedMapDifferenceImpl(onlyOnLeft, onlyOnRight, onBoth, differences);
  }
  
  static class SortedMapDifferenceImpl<K, V>
    extends Maps.MapDifferenceImpl<K, V>
    implements SortedMapDifference<K, V>
  {
    SortedMapDifferenceImpl(SortedMap<K, V> onlyOnLeft, SortedMap<K, V> onlyOnRight, SortedMap<K, V> onBoth, SortedMap<K, MapDifference.ValueDifference<V>> differences)
    {
      super(onlyOnRight, onBoth, differences);
    }
    
    public SortedMap<K, MapDifference.ValueDifference<V>> entriesDiffering()
    {
      return (SortedMap)super.entriesDiffering();
    }
    
    public SortedMap<K, V> entriesInCommon()
    {
      return (SortedMap)super.entriesInCommon();
    }
    
    public SortedMap<K, V> entriesOnlyOnLeft()
    {
      return (SortedMap)super.entriesOnlyOnLeft();
    }
    
    public SortedMap<K, V> entriesOnlyOnRight()
    {
      return (SortedMap)super.entriesOnlyOnRight();
    }
  }
  
  static <E> Comparator<? super E> orNaturalOrder(@Nullable Comparator<? super E> comparator)
  {
    if (comparator != null) {
      return comparator;
    }
    return Ordering.natural();
  }
  
  @Beta
  public static <K, V> Map<K, V> asMap(Set<K> set, Function<? super K, V> function)
  {
    if ((set instanceof SortedSet)) {
      return asMap((SortedSet)set, function);
    }
    return new AsMapView(set, function);
  }
  
  @Beta
  public static <K, V> SortedMap<K, V> asMap(SortedSet<K> set, Function<? super K, V> function)
  {
    return Platform.mapsAsMapSortedSet(set, function);
  }
  
  static <K, V> SortedMap<K, V> asMapSortedIgnoreNavigable(SortedSet<K> set, Function<? super K, V> function)
  {
    return new SortedAsMapView(set, function);
  }
  
  @Beta
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> asMap(NavigableSet<K> set, Function<? super K, V> function)
  {
    return new NavigableAsMapView(set, function);
  }
  
  private static class AsMapView<K, V>
    extends Maps.ImprovedAbstractMap<K, V>
  {
    private final Set<K> set;
    final Function<? super K, V> function;
    
    Set<K> backingSet()
    {
      return set;
    }
    
    AsMapView(Set<K> set, Function<? super K, V> function)
    {
      this.set = ((Set)Preconditions.checkNotNull(set));
      this.function = ((Function)Preconditions.checkNotNull(function));
    }
    
    public Set<K> createKeySet()
    {
      return Maps.removeOnlySet(backingSet());
    }
    
    Collection<V> createValues()
    {
      return Collections2.transform(set, function);
    }
    
    public int size()
    {
      return backingSet().size();
    }
    
    public boolean containsKey(@Nullable Object key)
    {
      return backingSet().contains(key);
    }
    
    public V get(@Nullable Object key)
    {
      if (Collections2.safeContains(backingSet(), key))
      {
        K k = (K)key;
        return (V)function.apply(k);
      }
      return null;
    }
    
    public V remove(@Nullable Object key)
    {
      if (backingSet().remove(key))
      {
        K k = (K)key;
        return (V)function.apply(k);
      }
      return null;
    }
    
    public void clear()
    {
      backingSet().clear();
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      new Maps.EntrySet()
      {
        Map<K, V> map()
        {
          return Maps.AsMapView.this;
        }
        
        public Iterator<Map.Entry<K, V>> iterator()
        {
          return Maps.asMapEntryIterator(backingSet(), function);
        }
      };
    }
  }
  
  static <K, V> Iterator<Map.Entry<K, V>> asMapEntryIterator(Set<K> set, final Function<? super K, V> function)
  {
    new TransformedIterator(set.iterator())
    {
      Map.Entry<K, V> transform(K key)
      {
        return Maps.immutableEntry(key, function.apply(key));
      }
    };
  }
  
  private static class SortedAsMapView<K, V>
    extends Maps.AsMapView<K, V>
    implements SortedMap<K, V>
  {
    SortedAsMapView(SortedSet<K> set, Function<? super K, V> function)
    {
      super(function);
    }
    
    SortedSet<K> backingSet()
    {
      return (SortedSet)super.backingSet();
    }
    
    public Comparator<? super K> comparator()
    {
      return backingSet().comparator();
    }
    
    public Set<K> keySet()
    {
      return Maps.removeOnlySortedSet(backingSet());
    }
    
    public SortedMap<K, V> subMap(K fromKey, K toKey)
    {
      return Maps.asMap(backingSet().subSet(fromKey, toKey), function);
    }
    
    public SortedMap<K, V> headMap(K toKey)
    {
      return Maps.asMap(backingSet().headSet(toKey), function);
    }
    
    public SortedMap<K, V> tailMap(K fromKey)
    {
      return Maps.asMap(backingSet().tailSet(fromKey), function);
    }
    
    public K firstKey()
    {
      return (K)backingSet().first();
    }
    
    public K lastKey()
    {
      return (K)backingSet().last();
    }
  }
  
  @GwtIncompatible("NavigableMap")
  private static final class NavigableAsMapView<K, V>
    extends AbstractNavigableMap<K, V>
  {
    private final NavigableSet<K> set;
    private final Function<? super K, V> function;
    
    NavigableAsMapView(NavigableSet<K> ks, Function<? super K, V> vFunction)
    {
      set = ((NavigableSet)Preconditions.checkNotNull(ks));
      function = ((Function)Preconditions.checkNotNull(vFunction));
    }
    
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
    {
      return Maps.asMap(set.subSet(fromKey, fromInclusive, toKey, toInclusive), function);
    }
    
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
    {
      return Maps.asMap(set.headSet(toKey, inclusive), function);
    }
    
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
    {
      return Maps.asMap(set.tailSet(fromKey, inclusive), function);
    }
    
    public Comparator<? super K> comparator()
    {
      return set.comparator();
    }
    
    @Nullable
    public V get(@Nullable Object key)
    {
      if (Collections2.safeContains(set, key))
      {
        K k = (K)key;
        return (V)function.apply(k);
      }
      return null;
    }
    
    public void clear()
    {
      set.clear();
    }
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return Maps.asMapEntryIterator(set, function);
    }
    
    Iterator<Map.Entry<K, V>> descendingEntryIterator()
    {
      return descendingMap().entrySet().iterator();
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      return Maps.removeOnlyNavigableSet(set);
    }
    
    public int size()
    {
      return set.size();
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      return Maps.asMap(set.descendingSet(), function);
    }
  }
  
  private static <E> Set<E> removeOnlySet(Set<E> set)
  {
    new ForwardingSet()
    {
      protected Set<E> delegate()
      {
        return val$set;
      }
      
      public boolean add(E element)
      {
        throw new UnsupportedOperationException();
      }
      
      public boolean addAll(Collection<? extends E> es)
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  private static <E> SortedSet<E> removeOnlySortedSet(SortedSet<E> set)
  {
    new ForwardingSortedSet()
    {
      protected SortedSet<E> delegate()
      {
        return val$set;
      }
      
      public boolean add(E element)
      {
        throw new UnsupportedOperationException();
      }
      
      public boolean addAll(Collection<? extends E> es)
      {
        throw new UnsupportedOperationException();
      }
      
      public SortedSet<E> headSet(E toElement)
      {
        return Maps.removeOnlySortedSet(super.headSet(toElement));
      }
      
      public SortedSet<E> subSet(E fromElement, E toElement)
      {
        return Maps.removeOnlySortedSet(super.subSet(fromElement, toElement));
      }
      
      public SortedSet<E> tailSet(E fromElement)
      {
        return Maps.removeOnlySortedSet(super.tailSet(fromElement));
      }
    };
  }
  
  @GwtIncompatible("NavigableSet")
  private static <E> NavigableSet<E> removeOnlyNavigableSet(NavigableSet<E> set)
  {
    new ForwardingNavigableSet()
    {
      protected NavigableSet<E> delegate()
      {
        return val$set;
      }
      
      public boolean add(E element)
      {
        throw new UnsupportedOperationException();
      }
      
      public boolean addAll(Collection<? extends E> es)
      {
        throw new UnsupportedOperationException();
      }
      
      public SortedSet<E> headSet(E toElement)
      {
        return Maps.removeOnlySortedSet(super.headSet(toElement));
      }
      
      public SortedSet<E> subSet(E fromElement, E toElement)
      {
        return Maps.removeOnlySortedSet(super.subSet(fromElement, toElement));
      }
      
      public SortedSet<E> tailSet(E fromElement)
      {
        return Maps.removeOnlySortedSet(super.tailSet(fromElement));
      }
      
      public NavigableSet<E> headSet(E toElement, boolean inclusive)
      {
        return Maps.removeOnlyNavigableSet(super.headSet(toElement, inclusive));
      }
      
      public NavigableSet<E> tailSet(E fromElement, boolean inclusive)
      {
        return Maps.removeOnlyNavigableSet(super.tailSet(fromElement, inclusive));
      }
      
      public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive)
      {
        return Maps.removeOnlyNavigableSet(super.subSet(fromElement, fromInclusive, toElement, toInclusive));
      }
      
      public NavigableSet<E> descendingSet()
      {
        return Maps.removeOnlyNavigableSet(super.descendingSet());
      }
    };
  }
  
  @Beta
  public static <K, V> ImmutableMap<K, V> toMap(Iterable<K> keys, Function<? super K, V> valueFunction)
  {
    return toMap(keys.iterator(), valueFunction);
  }
  
  @Beta
  public static <K, V> ImmutableMap<K, V> toMap(Iterator<K> keys, Function<? super K, V> valueFunction)
  {
    Preconditions.checkNotNull(valueFunction);
    
    Map<K, V> builder = newLinkedHashMap();
    while (keys.hasNext())
    {
      K key = keys.next();
      builder.put(key, valueFunction.apply(key));
    }
    return ImmutableMap.copyOf(builder);
  }
  
  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterable<V> values, Function<? super V, K> keyFunction)
  {
    return uniqueIndex(values.iterator(), keyFunction);
  }
  
  public static <K, V> ImmutableMap<K, V> uniqueIndex(Iterator<V> values, Function<? super V, K> keyFunction)
  {
    Preconditions.checkNotNull(keyFunction);
    ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
    while (values.hasNext())
    {
      V value = values.next();
      builder.put(keyFunction.apply(value), value);
    }
    return builder.build();
  }
  
  @GwtIncompatible("java.util.Properties")
  public static ImmutableMap<String, String> fromProperties(Properties properties)
  {
    ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
    for (Enumeration<?> e = properties.propertyNames(); e.hasMoreElements();)
    {
      String key = (String)e.nextElement();
      builder.put(key, properties.getProperty(key));
    }
    return builder.build();
  }
  
  @GwtCompatible(serializable=true)
  public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K key, @Nullable V value)
  {
    return new ImmutableEntry(key, value);
  }
  
  static <K, V> Set<Map.Entry<K, V>> unmodifiableEntrySet(Set<Map.Entry<K, V>> entrySet)
  {
    return new UnmodifiableEntrySet(Collections.unmodifiableSet(entrySet));
  }
  
  static <K, V> Map.Entry<K, V> unmodifiableEntry(Map.Entry<? extends K, ? extends V> entry)
  {
    Preconditions.checkNotNull(entry);
    new AbstractMapEntry()
    {
      public K getKey()
      {
        return (K)val$entry.getKey();
      }
      
      public V getValue()
      {
        return (V)val$entry.getValue();
      }
    };
  }
  
  static class UnmodifiableEntries<K, V>
    extends ForwardingCollection<Map.Entry<K, V>>
  {
    private final Collection<Map.Entry<K, V>> entries;
    
    UnmodifiableEntries(Collection<Map.Entry<K, V>> entries)
    {
      this.entries = entries;
    }
    
    protected Collection<Map.Entry<K, V>> delegate()
    {
      return entries;
    }
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      final Iterator<Map.Entry<K, V>> delegate = super.iterator();
      new UnmodifiableIterator()
      {
        public boolean hasNext()
        {
          return delegate.hasNext();
        }
        
        public Map.Entry<K, V> next()
        {
          return Maps.unmodifiableEntry((Map.Entry)delegate.next());
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
  }
  
  static class UnmodifiableEntrySet<K, V>
    extends Maps.UnmodifiableEntries<K, V>
    implements Set<Map.Entry<K, V>>
  {
    UnmodifiableEntrySet(Set<Map.Entry<K, V>> entries)
    {
      super();
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
  
  @Beta
  public static <A, B> Converter<A, B> asConverter(BiMap<A, B> bimap)
  {
    return new BiMapConverter(bimap);
  }
  
  private static final class BiMapConverter<A, B>
    extends Converter<A, B>
    implements Serializable
  {
    private final BiMap<A, B> bimap;
    private static final long serialVersionUID = 0L;
    
    BiMapConverter(BiMap<A, B> bimap)
    {
      this.bimap = ((BiMap)Preconditions.checkNotNull(bimap));
    }
    
    protected B doForward(A a)
    {
      return (B)convert(bimap, a);
    }
    
    protected A doBackward(B b)
    {
      return (A)convert(bimap.inverse(), b);
    }
    
    private static <X, Y> Y convert(BiMap<X, Y> bimap, X input)
    {
      Y output = bimap.get(input);
      Preconditions.checkArgument(output != null, "No non-null mapping present for input: %s", new Object[] { input });
      return output;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof BiMapConverter))
      {
        BiMapConverter<?, ?> that = (BiMapConverter)object;
        return bimap.equals(bimap);
      }
      return false;
    }
    
    public int hashCode()
    {
      return bimap.hashCode();
    }
    
    public String toString()
    {
      String str = String.valueOf(String.valueOf(bimap));return 18 + str.length() + "Maps.asConverter(" + str + ")";
    }
  }
  
  public static <K, V> BiMap<K, V> synchronizedBiMap(BiMap<K, V> bimap)
  {
    return Synchronized.biMap(bimap, null);
  }
  
  public static <K, V> BiMap<K, V> unmodifiableBiMap(BiMap<? extends K, ? extends V> bimap)
  {
    return new UnmodifiableBiMap(bimap, null);
  }
  
  private static class UnmodifiableBiMap<K, V>
    extends ForwardingMap<K, V>
    implements BiMap<K, V>, Serializable
  {
    final Map<K, V> unmodifiableMap;
    final BiMap<? extends K, ? extends V> delegate;
    BiMap<V, K> inverse;
    transient Set<V> values;
    private static final long serialVersionUID = 0L;
    
    UnmodifiableBiMap(BiMap<? extends K, ? extends V> delegate, @Nullable BiMap<V, K> inverse)
    {
      unmodifiableMap = Collections.unmodifiableMap(delegate);
      this.delegate = delegate;
      this.inverse = inverse;
    }
    
    protected Map<K, V> delegate()
    {
      return unmodifiableMap;
    }
    
    public V forcePut(K key, V value)
    {
      throw new UnsupportedOperationException();
    }
    
    public BiMap<V, K> inverse()
    {
      BiMap<V, K> result = inverse;
      return result == null ? (inverse = new UnmodifiableBiMap(delegate.inverse(), this)) : result;
    }
    
    public Set<V> values()
    {
      Set<V> result = values;
      return result == null ? (values = Collections.unmodifiableSet(delegate.values())) : result;
    }
  }
  
  public static <K, V1, V2> Map<K, V2> transformValues(Map<K, V1> fromMap, Function<? super V1, V2> function)
  {
    return transformEntries(fromMap, asEntryTransformer(function));
  }
  
  public static <K, V1, V2> SortedMap<K, V2> transformValues(SortedMap<K, V1> fromMap, Function<? super V1, V2> function)
  {
    return transformEntries(fromMap, asEntryTransformer(function));
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V1, V2> NavigableMap<K, V2> transformValues(NavigableMap<K, V1> fromMap, Function<? super V1, V2> function)
  {
    return transformEntries(fromMap, asEntryTransformer(function));
  }
  
  public static <K, V1, V2> Map<K, V2> transformEntries(Map<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    if ((fromMap instanceof SortedMap)) {
      return transformEntries((SortedMap)fromMap, transformer);
    }
    return new TransformedEntriesMap(fromMap, transformer);
  }
  
  public static <K, V1, V2> SortedMap<K, V2> transformEntries(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    return Platform.mapsTransformEntriesSortedMap(fromMap, transformer);
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V1, V2> NavigableMap<K, V2> transformEntries(NavigableMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    return new TransformedEntriesNavigableMap(fromMap, transformer);
  }
  
  static <K, V1, V2> SortedMap<K, V2> transformEntriesIgnoreNavigable(SortedMap<K, V1> fromMap, EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    return new TransformedEntriesSortedMap(fromMap, transformer);
  }
  
  static <K, V1, V2> EntryTransformer<K, V1, V2> asEntryTransformer(Function<? super V1, V2> function)
  {
    Preconditions.checkNotNull(function);
    new EntryTransformer()
    {
      public V2 transformEntry(K key, V1 value)
      {
        return (V2)val$function.apply(value);
      }
    };
  }
  
  static <K, V1, V2> Function<V1, V2> asValueToValueFunction(EntryTransformer<? super K, V1, V2> transformer, final K key)
  {
    Preconditions.checkNotNull(transformer);
    new Function()
    {
      public V2 apply(@Nullable V1 v1)
      {
        return (V2)val$transformer.transformEntry(key, v1);
      }
    };
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, V2> asEntryToValueFunction(EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    Preconditions.checkNotNull(transformer);
    new Function()
    {
      public V2 apply(Map.Entry<K, V1> entry)
      {
        return (V2)val$transformer.transformEntry(entry.getKey(), entry.getValue());
      }
    };
  }
  
  static <V2, K, V1> Map.Entry<K, V2> transformEntry(final EntryTransformer<? super K, ? super V1, V2> transformer, Map.Entry<K, V1> entry)
  {
    Preconditions.checkNotNull(transformer);
    Preconditions.checkNotNull(entry);
    new AbstractMapEntry()
    {
      public K getKey()
      {
        return (K)val$entry.getKey();
      }
      
      public V2 getValue()
      {
        return (V2)transformer.transformEntry(val$entry.getKey(), val$entry.getValue());
      }
    };
  }
  
  static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> asEntryToEntryFunction(EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    Preconditions.checkNotNull(transformer);
    new Function()
    {
      public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry)
      {
        return Maps.transformEntry(val$transformer, entry);
      }
    };
  }
  
  public static abstract interface EntryTransformer<K, V1, V2>
  {
    public abstract V2 transformEntry(@Nullable K paramK, @Nullable V1 paramV1);
  }
  
  static class TransformedEntriesMap<K, V1, V2>
    extends Maps.ImprovedAbstractMap<K, V2>
  {
    final Map<K, V1> fromMap;
    final Maps.EntryTransformer<? super K, ? super V1, V2> transformer;
    
    TransformedEntriesMap(Map<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
    {
      this.fromMap = ((Map)Preconditions.checkNotNull(fromMap));
      this.transformer = ((Maps.EntryTransformer)Preconditions.checkNotNull(transformer));
    }
    
    public int size()
    {
      return fromMap.size();
    }
    
    public boolean containsKey(Object key)
    {
      return fromMap.containsKey(key);
    }
    
    public V2 get(Object key)
    {
      V1 value = fromMap.get(key);
      return (V2)((value != null) || (fromMap.containsKey(key)) ? transformer.transformEntry(key, value) : null);
    }
    
    public V2 remove(Object key)
    {
      return (V2)(fromMap.containsKey(key) ? transformer.transformEntry(key, fromMap.remove(key)) : null);
    }
    
    public void clear()
    {
      fromMap.clear();
    }
    
    public Set<K> keySet()
    {
      return fromMap.keySet();
    }
    
    protected Set<Map.Entry<K, V2>> createEntrySet()
    {
      new Maps.EntrySet()
      {
        Map<K, V2> map()
        {
          return Maps.TransformedEntriesMap.this;
        }
        
        public Iterator<Map.Entry<K, V2>> iterator()
        {
          return Iterators.transform(fromMap.entrySet().iterator(), Maps.asEntryToEntryFunction(transformer));
        }
      };
    }
  }
  
  static class TransformedEntriesSortedMap<K, V1, V2>
    extends Maps.TransformedEntriesMap<K, V1, V2>
    implements SortedMap<K, V2>
  {
    protected SortedMap<K, V1> fromMap()
    {
      return (SortedMap)fromMap;
    }
    
    TransformedEntriesSortedMap(SortedMap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
    {
      super(transformer);
    }
    
    public Comparator<? super K> comparator()
    {
      return fromMap().comparator();
    }
    
    public K firstKey()
    {
      return (K)fromMap().firstKey();
    }
    
    public SortedMap<K, V2> headMap(K toKey)
    {
      return Maps.transformEntries(fromMap().headMap(toKey), transformer);
    }
    
    public K lastKey()
    {
      return (K)fromMap().lastKey();
    }
    
    public SortedMap<K, V2> subMap(K fromKey, K toKey)
    {
      return Maps.transformEntries(fromMap().subMap(fromKey, toKey), transformer);
    }
    
    public SortedMap<K, V2> tailMap(K fromKey)
    {
      return Maps.transformEntries(fromMap().tailMap(fromKey), transformer);
    }
  }
  
  @GwtIncompatible("NavigableMap")
  private static class TransformedEntriesNavigableMap<K, V1, V2>
    extends Maps.TransformedEntriesSortedMap<K, V1, V2>
    implements NavigableMap<K, V2>
  {
    TransformedEntriesNavigableMap(NavigableMap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
    {
      super(transformer);
    }
    
    public Map.Entry<K, V2> ceilingEntry(K key)
    {
      return transformEntry(fromMap().ceilingEntry(key));
    }
    
    public K ceilingKey(K key)
    {
      return (K)fromMap().ceilingKey(key);
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return fromMap().descendingKeySet();
    }
    
    public NavigableMap<K, V2> descendingMap()
    {
      return Maps.transformEntries(fromMap().descendingMap(), transformer);
    }
    
    public Map.Entry<K, V2> firstEntry()
    {
      return transformEntry(fromMap().firstEntry());
    }
    
    public Map.Entry<K, V2> floorEntry(K key)
    {
      return transformEntry(fromMap().floorEntry(key));
    }
    
    public K floorKey(K key)
    {
      return (K)fromMap().floorKey(key);
    }
    
    public NavigableMap<K, V2> headMap(K toKey)
    {
      return headMap(toKey, false);
    }
    
    public NavigableMap<K, V2> headMap(K toKey, boolean inclusive)
    {
      return Maps.transformEntries(fromMap().headMap(toKey, inclusive), transformer);
    }
    
    public Map.Entry<K, V2> higherEntry(K key)
    {
      return transformEntry(fromMap().higherEntry(key));
    }
    
    public K higherKey(K key)
    {
      return (K)fromMap().higherKey(key);
    }
    
    public Map.Entry<K, V2> lastEntry()
    {
      return transformEntry(fromMap().lastEntry());
    }
    
    public Map.Entry<K, V2> lowerEntry(K key)
    {
      return transformEntry(fromMap().lowerEntry(key));
    }
    
    public K lowerKey(K key)
    {
      return (K)fromMap().lowerKey(key);
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      return fromMap().navigableKeySet();
    }
    
    public Map.Entry<K, V2> pollFirstEntry()
    {
      return transformEntry(fromMap().pollFirstEntry());
    }
    
    public Map.Entry<K, V2> pollLastEntry()
    {
      return transformEntry(fromMap().pollLastEntry());
    }
    
    public NavigableMap<K, V2> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
    {
      return Maps.transformEntries(fromMap().subMap(fromKey, fromInclusive, toKey, toInclusive), transformer);
    }
    
    public NavigableMap<K, V2> subMap(K fromKey, K toKey)
    {
      return subMap(fromKey, true, toKey, false);
    }
    
    public NavigableMap<K, V2> tailMap(K fromKey)
    {
      return tailMap(fromKey, true);
    }
    
    public NavigableMap<K, V2> tailMap(K fromKey, boolean inclusive)
    {
      return Maps.transformEntries(fromMap().tailMap(fromKey, inclusive), transformer);
    }
    
    @Nullable
    private Map.Entry<K, V2> transformEntry(@Nullable Map.Entry<K, V1> entry)
    {
      return entry == null ? null : Maps.transformEntry(transformer, entry);
    }
    
    protected NavigableMap<K, V1> fromMap()
    {
      return (NavigableMap)super.fromMap();
    }
  }
  
  static <K> Predicate<Map.Entry<K, ?>> keyPredicateOnEntries(Predicate<? super K> keyPredicate)
  {
    return Predicates.compose(keyPredicate, keyFunction());
  }
  
  static <V> Predicate<Map.Entry<?, V>> valuePredicateOnEntries(Predicate<? super V> valuePredicate)
  {
    return Predicates.compose(valuePredicate, valueFunction());
  }
  
  public static <K, V> Map<K, V> filterKeys(Map<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    if ((unfiltered instanceof SortedMap)) {
      return filterKeys((SortedMap)unfiltered, keyPredicate);
    }
    if ((unfiltered instanceof BiMap)) {
      return filterKeys((BiMap)unfiltered, keyPredicate);
    }
    Preconditions.checkNotNull(keyPredicate);
    Predicate<Map.Entry<K, ?>> entryPredicate = keyPredicateOnEntries(keyPredicate);
    return (unfiltered instanceof AbstractFilteredMap) ? filterFiltered((AbstractFilteredMap)unfiltered, entryPredicate) : new FilteredKeyMap((Map)Preconditions.checkNotNull(unfiltered), keyPredicate, entryPredicate);
  }
  
  public static <K, V> SortedMap<K, V> filterKeys(SortedMap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    return filterEntries(unfiltered, keyPredicateOnEntries(keyPredicate));
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterKeys(NavigableMap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    return filterEntries(unfiltered, keyPredicateOnEntries(keyPredicate));
  }
  
  public static <K, V> BiMap<K, V> filterKeys(BiMap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    Preconditions.checkNotNull(keyPredicate);
    return filterEntries(unfiltered, keyPredicateOnEntries(keyPredicate));
  }
  
  public static <K, V> Map<K, V> filterValues(Map<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    if ((unfiltered instanceof SortedMap)) {
      return filterValues((SortedMap)unfiltered, valuePredicate);
    }
    if ((unfiltered instanceof BiMap)) {
      return filterValues((BiMap)unfiltered, valuePredicate);
    }
    return filterEntries(unfiltered, valuePredicateOnEntries(valuePredicate));
  }
  
  public static <K, V> SortedMap<K, V> filterValues(SortedMap<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    return filterEntries(unfiltered, valuePredicateOnEntries(valuePredicate));
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterValues(NavigableMap<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    return filterEntries(unfiltered, valuePredicateOnEntries(valuePredicate));
  }
  
  public static <K, V> BiMap<K, V> filterValues(BiMap<K, V> unfiltered, Predicate<? super V> valuePredicate)
  {
    return filterEntries(unfiltered, valuePredicateOnEntries(valuePredicate));
  }
  
  public static <K, V> Map<K, V> filterEntries(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    if ((unfiltered instanceof SortedMap)) {
      return filterEntries((SortedMap)unfiltered, entryPredicate);
    }
    if ((unfiltered instanceof BiMap)) {
      return filterEntries((BiMap)unfiltered, entryPredicate);
    }
    Preconditions.checkNotNull(entryPredicate);
    return (unfiltered instanceof AbstractFilteredMap) ? filterFiltered((AbstractFilteredMap)unfiltered, entryPredicate) : new FilteredEntryMap((Map)Preconditions.checkNotNull(unfiltered), entryPredicate);
  }
  
  public static <K, V> SortedMap<K, V> filterEntries(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    return Platform.mapsFilterSortedMap(unfiltered, entryPredicate);
  }
  
  static <K, V> SortedMap<K, V> filterSortedIgnoreNavigable(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Preconditions.checkNotNull(entryPredicate);
    return (unfiltered instanceof FilteredEntrySortedMap) ? filterFiltered((FilteredEntrySortedMap)unfiltered, entryPredicate) : new FilteredEntrySortedMap((SortedMap)Preconditions.checkNotNull(unfiltered), entryPredicate);
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> filterEntries(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Preconditions.checkNotNull(entryPredicate);
    return (unfiltered instanceof FilteredEntryNavigableMap) ? filterFiltered((FilteredEntryNavigableMap)unfiltered, entryPredicate) : new FilteredEntryNavigableMap((NavigableMap)Preconditions.checkNotNull(unfiltered), entryPredicate);
  }
  
  public static <K, V> BiMap<K, V> filterEntries(BiMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Preconditions.checkNotNull(unfiltered);
    Preconditions.checkNotNull(entryPredicate);
    return (unfiltered instanceof FilteredEntryBiMap) ? filterFiltered((FilteredEntryBiMap)unfiltered, entryPredicate) : new FilteredEntryBiMap(unfiltered, entryPredicate);
  }
  
  private static <K, V> Map<K, V> filterFiltered(AbstractFilteredMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    return new FilteredEntryMap(unfiltered, Predicates.and(predicate, entryPredicate));
  }
  
  private static abstract class AbstractFilteredMap<K, V>
    extends Maps.ImprovedAbstractMap<K, V>
  {
    final Map<K, V> unfiltered;
    final Predicate<? super Map.Entry<K, V>> predicate;
    
    AbstractFilteredMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate)
    {
      this.unfiltered = unfiltered;
      this.predicate = predicate;
    }
    
    boolean apply(@Nullable Object key, @Nullable V value)
    {
      K k = (K)key;
      return predicate.apply(Maps.immutableEntry(k, value));
    }
    
    public V put(K key, V value)
    {
      Preconditions.checkArgument(apply(key, value));
      return (V)unfiltered.put(key, value);
    }
    
    public void putAll(Map<? extends K, ? extends V> map)
    {
      for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
        Preconditions.checkArgument(apply(entry.getKey(), entry.getValue()));
      }
      unfiltered.putAll(map);
    }
    
    public boolean containsKey(Object key)
    {
      return (unfiltered.containsKey(key)) && (apply(key, unfiltered.get(key)));
    }
    
    public V get(Object key)
    {
      V value = unfiltered.get(key);
      return (value != null) && (apply(key, value)) ? value : null;
    }
    
    public boolean isEmpty()
    {
      return entrySet().isEmpty();
    }
    
    public V remove(Object key)
    {
      return (V)(containsKey(key) ? unfiltered.remove(key) : null);
    }
    
    Collection<V> createValues()
    {
      return new Maps.FilteredMapValues(this, unfiltered, predicate);
    }
  }
  
  private static final class FilteredMapValues<K, V>
    extends Maps.Values<K, V>
  {
    Map<K, V> unfiltered;
    Predicate<? super Map.Entry<K, V>> predicate;
    
    FilteredMapValues(Map<K, V> filteredMap, Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> predicate)
    {
      super();
      this.unfiltered = unfiltered;
      this.predicate = predicate;
    }
    
    public boolean remove(Object o)
    {
      return Iterables.removeFirstMatching(unfiltered.entrySet(), Predicates.and(predicate, Maps.valuePredicateOnEntries(Predicates.equalTo(o)))) != null;
    }
    
    private boolean removeIf(Predicate<? super V> valuePredicate)
    {
      return Iterables.removeIf(unfiltered.entrySet(), Predicates.and(predicate, Maps.valuePredicateOnEntries(valuePredicate)));
    }
    
    public boolean removeAll(Collection<?> collection)
    {
      return removeIf(Predicates.in(collection));
    }
    
    public boolean retainAll(Collection<?> collection)
    {
      return removeIf(Predicates.not(Predicates.in(collection)));
    }
    
    public Object[] toArray()
    {
      return Lists.newArrayList(iterator()).toArray();
    }
    
    public <T> T[] toArray(T[] array)
    {
      return Lists.newArrayList(iterator()).toArray(array);
    }
  }
  
  private static class FilteredKeyMap<K, V>
    extends Maps.AbstractFilteredMap<K, V>
  {
    Predicate<? super K> keyPredicate;
    
    FilteredKeyMap(Map<K, V> unfiltered, Predicate<? super K> keyPredicate, Predicate<? super Map.Entry<K, V>> entryPredicate)
    {
      super(entryPredicate);
      this.keyPredicate = keyPredicate;
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      return Sets.filter(unfiltered.entrySet(), predicate);
    }
    
    Set<K> createKeySet()
    {
      return Sets.filter(unfiltered.keySet(), keyPredicate);
    }
    
    public boolean containsKey(Object key)
    {
      return (unfiltered.containsKey(key)) && (keyPredicate.apply(key));
    }
  }
  
  static class FilteredEntryMap<K, V>
    extends Maps.AbstractFilteredMap<K, V>
  {
    final Set<Map.Entry<K, V>> filteredEntrySet;
    
    FilteredEntryMap(Map<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
    {
      super(entryPredicate);
      filteredEntrySet = Sets.filter(unfiltered.entrySet(), predicate);
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      return new EntrySet(null);
    }
    
    private class EntrySet
      extends ForwardingSet<Map.Entry<K, V>>
    {
      private EntrySet() {}
      
      protected Set<Map.Entry<K, V>> delegate()
      {
        return filteredEntrySet;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        new TransformedIterator(filteredEntrySet.iterator())
        {
          Map.Entry<K, V> transform(final Map.Entry<K, V> entry)
          {
            new ForwardingMapEntry()
            {
              protected Map.Entry<K, V> delegate()
              {
                return entry;
              }
              
              public V setValue(V newValue)
              {
                Preconditions.checkArgument(apply(getKey(), newValue));
                return (V)super.setValue(newValue);
              }
            };
          }
        };
      }
    }
    
    Set<K> createKeySet()
    {
      return new KeySet();
    }
    
    class KeySet
      extends Maps.KeySet<K, V>
    {
      KeySet()
      {
        super();
      }
      
      public boolean remove(Object o)
      {
        if (containsKey(o))
        {
          unfiltered.remove(o);
          return true;
        }
        return false;
      }
      
      private boolean removeIf(Predicate<? super K> keyPredicate)
      {
        return Iterables.removeIf(unfiltered.entrySet(), Predicates.and(predicate, Maps.keyPredicateOnEntries(keyPredicate)));
      }
      
      public boolean removeAll(Collection<?> c)
      {
        return removeIf(Predicates.in(c));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return removeIf(Predicates.not(Predicates.in(c)));
      }
      
      public Object[] toArray()
      {
        return Lists.newArrayList(iterator()).toArray();
      }
      
      public <T> T[] toArray(T[] array)
      {
        return Lists.newArrayList(iterator()).toArray(array);
      }
    }
  }
  
  private static <K, V> SortedMap<K, V> filterFiltered(FilteredEntrySortedMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Predicate<Map.Entry<K, V>> predicate = Predicates.and(map.predicate, entryPredicate);
    
    return new FilteredEntrySortedMap(map.sortedMap(), predicate);
  }
  
  private static class FilteredEntrySortedMap<K, V>
    extends Maps.FilteredEntryMap<K, V>
    implements SortedMap<K, V>
  {
    FilteredEntrySortedMap(SortedMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
    {
      super(entryPredicate);
    }
    
    SortedMap<K, V> sortedMap()
    {
      return (SortedMap)unfiltered;
    }
    
    public SortedSet<K> keySet()
    {
      return (SortedSet)super.keySet();
    }
    
    SortedSet<K> createKeySet()
    {
      return new SortedKeySet();
    }
    
    class SortedKeySet
      extends Maps.FilteredEntryMap<K, V>.KeySet
      implements SortedSet<K>
    {
      SortedKeySet()
      {
        super();
      }
      
      public Comparator<? super K> comparator()
      {
        return sortedMap().comparator();
      }
      
      public SortedSet<K> subSet(K fromElement, K toElement)
      {
        return (SortedSet)subMap(fromElement, toElement).keySet();
      }
      
      public SortedSet<K> headSet(K toElement)
      {
        return (SortedSet)headMap(toElement).keySet();
      }
      
      public SortedSet<K> tailSet(K fromElement)
      {
        return (SortedSet)tailMap(fromElement).keySet();
      }
      
      public K first()
      {
        return (K)firstKey();
      }
      
      public K last()
      {
        return (K)lastKey();
      }
    }
    
    public Comparator<? super K> comparator()
    {
      return sortedMap().comparator();
    }
    
    public K firstKey()
    {
      return (K)keySet().iterator().next();
    }
    
    public K lastKey()
    {
      SortedMap<K, V> headMap = sortedMap();
      for (;;)
      {
        K key = headMap.lastKey();
        if (apply(key, unfiltered.get(key))) {
          return key;
        }
        headMap = sortedMap().headMap(key);
      }
    }
    
    public SortedMap<K, V> headMap(K toKey)
    {
      return new FilteredEntrySortedMap(sortedMap().headMap(toKey), predicate);
    }
    
    public SortedMap<K, V> subMap(K fromKey, K toKey)
    {
      return new FilteredEntrySortedMap(sortedMap().subMap(fromKey, toKey), predicate);
    }
    
    public SortedMap<K, V> tailMap(K fromKey)
    {
      return new FilteredEntrySortedMap(sortedMap().tailMap(fromKey), predicate);
    }
  }
  
  @GwtIncompatible("NavigableMap")
  private static <K, V> NavigableMap<K, V> filterFiltered(FilteredEntryNavigableMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Predicate<Map.Entry<K, V>> predicate = Predicates.and(map.entryPredicate, entryPredicate);
    
    return new FilteredEntryNavigableMap(unfiltered, predicate);
  }
  
  @GwtIncompatible("NavigableMap")
  private static class FilteredEntryNavigableMap<K, V>
    extends AbstractNavigableMap<K, V>
  {
    private final NavigableMap<K, V> unfiltered;
    private final Predicate<? super Map.Entry<K, V>> entryPredicate;
    private final Map<K, V> filteredDelegate;
    
    FilteredEntryNavigableMap(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
    {
      this.unfiltered = ((NavigableMap)Preconditions.checkNotNull(unfiltered));
      this.entryPredicate = entryPredicate;
      filteredDelegate = new Maps.FilteredEntryMap(unfiltered, entryPredicate);
    }
    
    public Comparator<? super K> comparator()
    {
      return unfiltered.comparator();
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      new Maps.NavigableKeySet(this)
      {
        public boolean removeAll(Collection<?> c)
        {
          return Iterators.removeIf(unfiltered.entrySet().iterator(), Predicates.and(entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(c))));
        }
        
        public boolean retainAll(Collection<?> c)
        {
          return Iterators.removeIf(unfiltered.entrySet().iterator(), Predicates.and(entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c)))));
        }
      };
    }
    
    public Collection<V> values()
    {
      return new Maps.FilteredMapValues(this, unfiltered, entryPredicate);
    }
    
    Iterator<Map.Entry<K, V>> entryIterator()
    {
      return Iterators.filter(unfiltered.entrySet().iterator(), entryPredicate);
    }
    
    Iterator<Map.Entry<K, V>> descendingEntryIterator()
    {
      return Iterators.filter(unfiltered.descendingMap().entrySet().iterator(), entryPredicate);
    }
    
    public int size()
    {
      return filteredDelegate.size();
    }
    
    public boolean isEmpty()
    {
      return !Iterables.any(unfiltered.entrySet(), entryPredicate);
    }
    
    @Nullable
    public V get(@Nullable Object key)
    {
      return (V)filteredDelegate.get(key);
    }
    
    public boolean containsKey(@Nullable Object key)
    {
      return filteredDelegate.containsKey(key);
    }
    
    public V put(K key, V value)
    {
      return (V)filteredDelegate.put(key, value);
    }
    
    public V remove(@Nullable Object key)
    {
      return (V)filteredDelegate.remove(key);
    }
    
    public void putAll(Map<? extends K, ? extends V> m)
    {
      filteredDelegate.putAll(m);
    }
    
    public void clear()
    {
      filteredDelegate.clear();
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      return filteredDelegate.entrySet();
    }
    
    public Map.Entry<K, V> pollFirstEntry()
    {
      return (Map.Entry)Iterables.removeFirstMatching(unfiltered.entrySet(), entryPredicate);
    }
    
    public Map.Entry<K, V> pollLastEntry()
    {
      return (Map.Entry)Iterables.removeFirstMatching(unfiltered.descendingMap().entrySet(), entryPredicate);
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      return Maps.filterEntries(unfiltered.descendingMap(), entryPredicate);
    }
    
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
    {
      return Maps.filterEntries(unfiltered.subMap(fromKey, fromInclusive, toKey, toInclusive), entryPredicate);
    }
    
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
    {
      return Maps.filterEntries(unfiltered.headMap(toKey, inclusive), entryPredicate);
    }
    
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
    {
      return Maps.filterEntries(unfiltered.tailMap(fromKey, inclusive), entryPredicate);
    }
  }
  
  private static <K, V> BiMap<K, V> filterFiltered(FilteredEntryBiMap<K, V> map, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    Predicate<Map.Entry<K, V>> predicate = Predicates.and(map.predicate, entryPredicate);
    return new FilteredEntryBiMap(map.unfiltered(), predicate);
  }
  
  static final class FilteredEntryBiMap<K, V>
    extends Maps.FilteredEntryMap<K, V>
    implements BiMap<K, V>
  {
    private final BiMap<V, K> inverse;
    
    private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(Predicate<? super Map.Entry<K, V>> forwardPredicate)
    {
      new Predicate()
      {
        public boolean apply(Map.Entry<V, K> input)
        {
          return val$forwardPredicate.apply(Maps.immutableEntry(input.getValue(), input.getKey()));
        }
      };
    }
    
    FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate)
    {
      super(predicate);
      inverse = new FilteredEntryBiMap(delegate.inverse(), inversePredicate(predicate), this);
    }
    
    private FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> inverse)
    {
      super(predicate);
      this.inverse = inverse;
    }
    
    BiMap<K, V> unfiltered()
    {
      return (BiMap)unfiltered;
    }
    
    public V forcePut(@Nullable K key, @Nullable V value)
    {
      Preconditions.checkArgument(apply(key, value));
      return (V)unfiltered().forcePut(key, value);
    }
    
    public BiMap<V, K> inverse()
    {
      return inverse;
    }
    
    public Set<V> values()
    {
      return inverse.keySet();
    }
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> unmodifiableNavigableMap(NavigableMap<K, V> map)
  {
    Preconditions.checkNotNull(map);
    if ((map instanceof UnmodifiableNavigableMap)) {
      return map;
    }
    return new UnmodifiableNavigableMap(map);
  }
  
  @Nullable
  private static <K, V> Map.Entry<K, V> unmodifiableOrNull(@Nullable Map.Entry<K, V> entry)
  {
    return entry == null ? null : unmodifiableEntry(entry);
  }
  
  @GwtIncompatible("NavigableMap")
  static class UnmodifiableNavigableMap<K, V>
    extends ForwardingSortedMap<K, V>
    implements NavigableMap<K, V>, Serializable
  {
    private final NavigableMap<K, V> delegate;
    private transient UnmodifiableNavigableMap<K, V> descendingMap;
    
    UnmodifiableNavigableMap(NavigableMap<K, V> delegate)
    {
      this.delegate = delegate;
    }
    
    UnmodifiableNavigableMap(NavigableMap<K, V> delegate, UnmodifiableNavigableMap<K, V> descendingMap)
    {
      this.delegate = delegate;
      this.descendingMap = descendingMap;
    }
    
    protected SortedMap<K, V> delegate()
    {
      return Collections.unmodifiableSortedMap(delegate);
    }
    
    public Map.Entry<K, V> lowerEntry(K key)
    {
      return Maps.unmodifiableOrNull(delegate.lowerEntry(key));
    }
    
    public K lowerKey(K key)
    {
      return (K)delegate.lowerKey(key);
    }
    
    public Map.Entry<K, V> floorEntry(K key)
    {
      return Maps.unmodifiableOrNull(delegate.floorEntry(key));
    }
    
    public K floorKey(K key)
    {
      return (K)delegate.floorKey(key);
    }
    
    public Map.Entry<K, V> ceilingEntry(K key)
    {
      return Maps.unmodifiableOrNull(delegate.ceilingEntry(key));
    }
    
    public K ceilingKey(K key)
    {
      return (K)delegate.ceilingKey(key);
    }
    
    public Map.Entry<K, V> higherEntry(K key)
    {
      return Maps.unmodifiableOrNull(delegate.higherEntry(key));
    }
    
    public K higherKey(K key)
    {
      return (K)delegate.higherKey(key);
    }
    
    public Map.Entry<K, V> firstEntry()
    {
      return Maps.unmodifiableOrNull(delegate.firstEntry());
    }
    
    public Map.Entry<K, V> lastEntry()
    {
      return Maps.unmodifiableOrNull(delegate.lastEntry());
    }
    
    public final Map.Entry<K, V> pollFirstEntry()
    {
      throw new UnsupportedOperationException();
    }
    
    public final Map.Entry<K, V> pollLastEntry()
    {
      throw new UnsupportedOperationException();
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      UnmodifiableNavigableMap<K, V> result = descendingMap;
      return result == null ? (descendingMap = new UnmodifiableNavigableMap(delegate.descendingMap(), this)) : result;
    }
    
    public Set<K> keySet()
    {
      return navigableKeySet();
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      return Sets.unmodifiableNavigableSet(delegate.navigableKeySet());
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return Sets.unmodifiableNavigableSet(delegate.descendingKeySet());
    }
    
    public SortedMap<K, V> subMap(K fromKey, K toKey)
    {
      return subMap(fromKey, true, toKey, false);
    }
    
    public SortedMap<K, V> headMap(K toKey)
    {
      return headMap(toKey, false);
    }
    
    public SortedMap<K, V> tailMap(K fromKey)
    {
      return tailMap(fromKey, true);
    }
    
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
    {
      return Maps.unmodifiableNavigableMap(delegate.subMap(fromKey, fromInclusive, toKey, toInclusive));
    }
    
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
    {
      return Maps.unmodifiableNavigableMap(delegate.headMap(toKey, inclusive));
    }
    
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
    {
      return Maps.unmodifiableNavigableMap(delegate.tailMap(fromKey, inclusive));
    }
  }
  
  @GwtIncompatible("NavigableMap")
  public static <K, V> NavigableMap<K, V> synchronizedNavigableMap(NavigableMap<K, V> navigableMap)
  {
    return Synchronized.navigableMap(navigableMap);
  }
  
  @GwtCompatible
  static abstract class ImprovedAbstractMap<K, V>
    extends AbstractMap<K, V>
  {
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient Set<K> keySet;
    private transient Collection<V> values;
    
    abstract Set<Map.Entry<K, V>> createEntrySet();
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set<Map.Entry<K, V>> result = entrySet;
      return result == null ? (entrySet = createEntrySet()) : result;
    }
    
    public Set<K> keySet()
    {
      Set<K> result = keySet;
      return result == null ? (keySet = createKeySet()) : result;
    }
    
    Set<K> createKeySet()
    {
      return new Maps.KeySet(this);
    }
    
    public Collection<V> values()
    {
      Collection<V> result = values;
      return result == null ? (values = createValues()) : result;
    }
    
    Collection<V> createValues()
    {
      return new Maps.Values(this);
    }
  }
  
  static <V> V safeGet(Map<?, V> map, @Nullable Object key)
  {
    Preconditions.checkNotNull(map);
    try
    {
      return (V)map.get(key);
    }
    catch (ClassCastException e)
    {
      return null;
    }
    catch (NullPointerException e) {}
    return null;
  }
  
  static boolean safeContainsKey(Map<?, ?> map, Object key)
  {
    Preconditions.checkNotNull(map);
    try
    {
      return map.containsKey(key);
    }
    catch (ClassCastException e)
    {
      return false;
    }
    catch (NullPointerException e) {}
    return false;
  }
  
  static <V> V safeRemove(Map<?, V> map, Object key)
  {
    Preconditions.checkNotNull(map);
    try
    {
      return (V)map.remove(key);
    }
    catch (ClassCastException e)
    {
      return null;
    }
    catch (NullPointerException e) {}
    return null;
  }
  
  static boolean containsKeyImpl(Map<?, ?> map, @Nullable Object key)
  {
    return Iterators.contains(keyIterator(map.entrySet().iterator()), key);
  }
  
  static boolean containsValueImpl(Map<?, ?> map, @Nullable Object value)
  {
    return Iterators.contains(valueIterator(map.entrySet().iterator()), value);
  }
  
  static <K, V> boolean containsEntryImpl(Collection<Map.Entry<K, V>> c, Object o)
  {
    if (!(o instanceof Map.Entry)) {
      return false;
    }
    return c.contains(unmodifiableEntry((Map.Entry)o));
  }
  
  static <K, V> boolean removeEntryImpl(Collection<Map.Entry<K, V>> c, Object o)
  {
    if (!(o instanceof Map.Entry)) {
      return false;
    }
    return c.remove(unmodifiableEntry((Map.Entry)o));
  }
  
  static boolean equalsImpl(Map<?, ?> map, Object object)
  {
    if (map == object) {
      return true;
    }
    if ((object instanceof Map))
    {
      Map<?, ?> o = (Map)object;
      return map.entrySet().equals(o.entrySet());
    }
    return false;
  }
  
  static final Joiner.MapJoiner STANDARD_JOINER = Collections2.STANDARD_JOINER.withKeyValueSeparator("=");
  
  static String toStringImpl(Map<?, ?> map)
  {
    StringBuilder sb = Collections2.newStringBuilderForCollection(map.size()).append('{');
    
    STANDARD_JOINER.appendTo(sb, map);
    return '}';
  }
  
  static <K, V> void putAllImpl(Map<K, V> self, Map<? extends K, ? extends V> map)
  {
    for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
      self.put(entry.getKey(), entry.getValue());
    }
  }
  
  static class KeySet<K, V>
    extends Sets.ImprovedAbstractSet<K>
  {
    final Map<K, V> map;
    
    KeySet(Map<K, V> map)
    {
      this.map = ((Map)Preconditions.checkNotNull(map));
    }
    
    Map<K, V> map()
    {
      return map;
    }
    
    public Iterator<K> iterator()
    {
      return Maps.keyIterator(map().entrySet().iterator());
    }
    
    public int size()
    {
      return map().size();
    }
    
    public boolean isEmpty()
    {
      return map().isEmpty();
    }
    
    public boolean contains(Object o)
    {
      return map().containsKey(o);
    }
    
    public boolean remove(Object o)
    {
      if (contains(o))
      {
        map().remove(o);
        return true;
      }
      return false;
    }
    
    public void clear()
    {
      map().clear();
    }
  }
  
  @Nullable
  static <K> K keyOrNull(@Nullable Map.Entry<K, ?> entry)
  {
    return entry == null ? null : entry.getKey();
  }
  
  @Nullable
  static <V> V valueOrNull(@Nullable Map.Entry<?, V> entry)
  {
    return entry == null ? null : entry.getValue();
  }
  
  static class SortedKeySet<K, V>
    extends Maps.KeySet<K, V>
    implements SortedSet<K>
  {
    SortedKeySet(SortedMap<K, V> map)
    {
      super();
    }
    
    SortedMap<K, V> map()
    {
      return (SortedMap)super.map();
    }
    
    public Comparator<? super K> comparator()
    {
      return map().comparator();
    }
    
    public SortedSet<K> subSet(K fromElement, K toElement)
    {
      return new SortedKeySet(map().subMap(fromElement, toElement));
    }
    
    public SortedSet<K> headSet(K toElement)
    {
      return new SortedKeySet(map().headMap(toElement));
    }
    
    public SortedSet<K> tailSet(K fromElement)
    {
      return new SortedKeySet(map().tailMap(fromElement));
    }
    
    public K first()
    {
      return (K)map().firstKey();
    }
    
    public K last()
    {
      return (K)map().lastKey();
    }
  }
  
  @GwtIncompatible("NavigableMap")
  static class NavigableKeySet<K, V>
    extends Maps.SortedKeySet<K, V>
    implements NavigableSet<K>
  {
    NavigableKeySet(NavigableMap<K, V> map)
    {
      super();
    }
    
    NavigableMap<K, V> map()
    {
      return (NavigableMap)map;
    }
    
    public K lower(K e)
    {
      return (K)map().lowerKey(e);
    }
    
    public K floor(K e)
    {
      return (K)map().floorKey(e);
    }
    
    public K ceiling(K e)
    {
      return (K)map().ceilingKey(e);
    }
    
    public K higher(K e)
    {
      return (K)map().higherKey(e);
    }
    
    public K pollFirst()
    {
      return (K)Maps.keyOrNull(map().pollFirstEntry());
    }
    
    public K pollLast()
    {
      return (K)Maps.keyOrNull(map().pollLastEntry());
    }
    
    public NavigableSet<K> descendingSet()
    {
      return map().descendingKeySet();
    }
    
    public Iterator<K> descendingIterator()
    {
      return descendingSet().iterator();
    }
    
    public NavigableSet<K> subSet(K fromElement, boolean fromInclusive, K toElement, boolean toInclusive)
    {
      return map().subMap(fromElement, fromInclusive, toElement, toInclusive).navigableKeySet();
    }
    
    public NavigableSet<K> headSet(K toElement, boolean inclusive)
    {
      return map().headMap(toElement, inclusive).navigableKeySet();
    }
    
    public NavigableSet<K> tailSet(K fromElement, boolean inclusive)
    {
      return map().tailMap(fromElement, inclusive).navigableKeySet();
    }
    
    public SortedSet<K> subSet(K fromElement, K toElement)
    {
      return subSet(fromElement, true, toElement, false);
    }
    
    public SortedSet<K> headSet(K toElement)
    {
      return headSet(toElement, false);
    }
    
    public SortedSet<K> tailSet(K fromElement)
    {
      return tailSet(fromElement, true);
    }
  }
  
  static class Values<K, V>
    extends AbstractCollection<V>
  {
    final Map<K, V> map;
    
    Values(Map<K, V> map)
    {
      this.map = ((Map)Preconditions.checkNotNull(map));
    }
    
    final Map<K, V> map()
    {
      return map;
    }
    
    public Iterator<V> iterator()
    {
      return Maps.valueIterator(map().entrySet().iterator());
    }
    
    public boolean remove(Object o)
    {
      try
      {
        return super.remove(o);
      }
      catch (UnsupportedOperationException e)
      {
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (Objects.equal(o, entry.getValue()))
          {
            map().remove(entry.getKey());
            return true;
          }
        }
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> c)
    {
      try
      {
        return super.removeAll((Collection)Preconditions.checkNotNull(c));
      }
      catch (UnsupportedOperationException e)
      {
        Set<K> toRemove = Sets.newHashSet();
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (c.contains(entry.getValue())) {
            toRemove.add(entry.getKey());
          }
        }
        return map().keySet().removeAll(toRemove);
      }
    }
    
    public boolean retainAll(Collection<?> c)
    {
      try
      {
        return super.retainAll((Collection)Preconditions.checkNotNull(c));
      }
      catch (UnsupportedOperationException e)
      {
        Set<K> toRetain = Sets.newHashSet();
        for (Map.Entry<K, V> entry : map().entrySet()) {
          if (c.contains(entry.getValue())) {
            toRetain.add(entry.getKey());
          }
        }
        return map().keySet().retainAll(toRetain);
      }
    }
    
    public int size()
    {
      return map().size();
    }
    
    public boolean isEmpty()
    {
      return map().isEmpty();
    }
    
    public boolean contains(@Nullable Object o)
    {
      return map().containsValue(o);
    }
    
    public void clear()
    {
      map().clear();
    }
  }
  
  static abstract class EntrySet<K, V>
    extends Sets.ImprovedAbstractSet<Map.Entry<K, V>>
  {
    abstract Map<K, V> map();
    
    public int size()
    {
      return map().size();
    }
    
    public void clear()
    {
      map().clear();
    }
    
    public boolean contains(Object o)
    {
      if ((o instanceof Map.Entry))
      {
        Map.Entry<?, ?> entry = (Map.Entry)o;
        Object key = entry.getKey();
        V value = Maps.safeGet(map(), key);
        return (Objects.equal(value, entry.getValue())) && ((value != null) || (map().containsKey(key)));
      }
      return false;
    }
    
    public boolean isEmpty()
    {
      return map().isEmpty();
    }
    
    public boolean remove(Object o)
    {
      if (contains(o))
      {
        Map.Entry<?, ?> entry = (Map.Entry)o;
        return map().keySet().remove(entry.getKey());
      }
      return false;
    }
    
    public boolean removeAll(Collection<?> c)
    {
      try
      {
        return super.removeAll((Collection)Preconditions.checkNotNull(c));
      }
      catch (UnsupportedOperationException e) {}
      return Sets.removeAllImpl(this, c.iterator());
    }
    
    public boolean retainAll(Collection<?> c)
    {
      try
      {
        return super.retainAll((Collection)Preconditions.checkNotNull(c));
      }
      catch (UnsupportedOperationException e)
      {
        Set<Object> keys = Sets.newHashSetWithExpectedSize(c.size());
        for (Object o : c) {
          if (contains(o))
          {
            Map.Entry<?, ?> entry = (Map.Entry)o;
            keys.add(entry.getKey());
          }
        }
        return map().keySet().retainAll(keys);
      }
    }
  }
  
  @GwtIncompatible("NavigableMap")
  static abstract class DescendingMap<K, V>
    extends ForwardingMap<K, V>
    implements NavigableMap<K, V>
  {
    private transient Comparator<? super K> comparator;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient NavigableSet<K> navigableKeySet;
    
    abstract NavigableMap<K, V> forward();
    
    protected final Map<K, V> delegate()
    {
      return forward();
    }
    
    public Comparator<? super K> comparator()
    {
      Comparator<? super K> result = comparator;
      if (result == null)
      {
        Comparator<? super K> forwardCmp = forward().comparator();
        if (forwardCmp == null) {
          forwardCmp = Ordering.natural();
        }
        result = comparator = reverse(forwardCmp);
      }
      return result;
    }
    
    private static <T> Ordering<T> reverse(Comparator<T> forward)
    {
      return Ordering.from(forward).reverse();
    }
    
    public K firstKey()
    {
      return (K)forward().lastKey();
    }
    
    public K lastKey()
    {
      return (K)forward().firstKey();
    }
    
    public Map.Entry<K, V> lowerEntry(K key)
    {
      return forward().higherEntry(key);
    }
    
    public K lowerKey(K key)
    {
      return (K)forward().higherKey(key);
    }
    
    public Map.Entry<K, V> floorEntry(K key)
    {
      return forward().ceilingEntry(key);
    }
    
    public K floorKey(K key)
    {
      return (K)forward().ceilingKey(key);
    }
    
    public Map.Entry<K, V> ceilingEntry(K key)
    {
      return forward().floorEntry(key);
    }
    
    public K ceilingKey(K key)
    {
      return (K)forward().floorKey(key);
    }
    
    public Map.Entry<K, V> higherEntry(K key)
    {
      return forward().lowerEntry(key);
    }
    
    public K higherKey(K key)
    {
      return (K)forward().lowerKey(key);
    }
    
    public Map.Entry<K, V> firstEntry()
    {
      return forward().lastEntry();
    }
    
    public Map.Entry<K, V> lastEntry()
    {
      return forward().firstEntry();
    }
    
    public Map.Entry<K, V> pollFirstEntry()
    {
      return forward().pollLastEntry();
    }
    
    public Map.Entry<K, V> pollLastEntry()
    {
      return forward().pollFirstEntry();
    }
    
    public NavigableMap<K, V> descendingMap()
    {
      return forward();
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set<Map.Entry<K, V>> result = entrySet;
      return result == null ? (entrySet = createEntrySet()) : result;
    }
    
    abstract Iterator<Map.Entry<K, V>> entryIterator();
    
    Set<Map.Entry<K, V>> createEntrySet()
    {
      new Maps.EntrySet()
      {
        Map<K, V> map()
        {
          return Maps.DescendingMap.this;
        }
        
        public Iterator<Map.Entry<K, V>> iterator()
        {
          return entryIterator();
        }
      };
    }
    
    public Set<K> keySet()
    {
      return navigableKeySet();
    }
    
    public NavigableSet<K> navigableKeySet()
    {
      NavigableSet<K> result = navigableKeySet;
      return result == null ? (navigableKeySet = new Maps.NavigableKeySet(this)) : result;
    }
    
    public NavigableSet<K> descendingKeySet()
    {
      return forward().navigableKeySet();
    }
    
    public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
    {
      return forward().subMap(toKey, toInclusive, fromKey, fromInclusive).descendingMap();
    }
    
    public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
    {
      return forward().tailMap(toKey, inclusive).descendingMap();
    }
    
    public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
    {
      return forward().headMap(fromKey, inclusive).descendingMap();
    }
    
    public SortedMap<K, V> subMap(K fromKey, K toKey)
    {
      return subMap(fromKey, true, toKey, false);
    }
    
    public SortedMap<K, V> headMap(K toKey)
    {
      return headMap(toKey, false);
    }
    
    public SortedMap<K, V> tailMap(K fromKey)
    {
      return tailMap(fromKey, true);
    }
    
    public Collection<V> values()
    {
      return new Maps.Values(this);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */