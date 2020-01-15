package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class RegularImmutableSortedMap<K, V>
  extends ImmutableSortedMap<K, V>
{
  private final transient RegularImmutableSortedSet<K> keySet;
  private final transient ImmutableList<V> valueList;
  
  RegularImmutableSortedMap(RegularImmutableSortedSet<K> keySet, ImmutableList<V> valueList)
  {
    this.keySet = keySet;
    this.valueList = valueList;
  }
  
  RegularImmutableSortedMap(RegularImmutableSortedSet<K> keySet, ImmutableList<V> valueList, ImmutableSortedMap<K, V> descendingMap)
  {
    super(descendingMap);
    this.keySet = keySet;
    this.valueList = valueList;
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  private class EntrySet
    extends ImmutableMapEntrySet<K, V>
  {
    private EntrySet() {}
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return asList().iterator();
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      new ImmutableAsList()
      {
        private final ImmutableList<K> keyList = keySet().asList();
        
        public Map.Entry<K, V> get(int index)
        {
          return Maps.immutableEntry(keyList.get(index), valueList.get(index));
        }
        
        ImmutableCollection<Map.Entry<K, V>> delegateCollection()
        {
          return RegularImmutableSortedMap.EntrySet.this;
        }
      };
    }
    
    ImmutableMap<K, V> map()
    {
      return RegularImmutableSortedMap.this;
    }
  }
  
  public ImmutableSortedSet<K> keySet()
  {
    return keySet;
  }
  
  public ImmutableCollection<V> values()
  {
    return valueList;
  }
  
  public V get(@Nullable Object key)
  {
    int index = keySet.indexOf(key);
    return index == -1 ? null : valueList.get(index);
  }
  
  private ImmutableSortedMap<K, V> getSubMap(int fromIndex, int toIndex)
  {
    if ((fromIndex == 0) && (toIndex == size())) {
      return this;
    }
    if (fromIndex == toIndex) {
      return emptyMap(comparator());
    }
    return from(keySet.getSubSet(fromIndex, toIndex), valueList.subList(fromIndex, toIndex));
  }
  
  public ImmutableSortedMap<K, V> headMap(K toKey, boolean inclusive)
  {
    return getSubMap(0, keySet.headIndex(Preconditions.checkNotNull(toKey), inclusive));
  }
  
  public ImmutableSortedMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    return getSubMap(keySet.tailIndex(Preconditions.checkNotNull(fromKey), inclusive), size());
  }
  
  ImmutableSortedMap<K, V> createDescendingMap()
  {
    return new RegularImmutableSortedMap((RegularImmutableSortedSet)keySet.descendingSet(), valueList.reverse(), this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */