package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
class RegularImmutableBiMap<K, V>
  extends ImmutableBiMap<K, V>
{
  static final double MAX_LOAD_FACTOR = 1.2D;
  private final transient ImmutableMapEntry<K, V>[] keyTable;
  private final transient ImmutableMapEntry<K, V>[] valueTable;
  private final transient ImmutableMapEntry<K, V>[] entries;
  private final transient int mask;
  private final transient int hashCode;
  private transient ImmutableBiMap<V, K> inverse;
  
  RegularImmutableBiMap(ImmutableMapEntry.TerminalEntry<?, ?>... entriesToAdd)
  {
    this(entriesToAdd.length, entriesToAdd);
  }
  
  RegularImmutableBiMap(int n, ImmutableMapEntry.TerminalEntry<?, ?>[] entriesToAdd)
  {
    int tableSize = Hashing.closedTableSize(n, 1.2D);
    mask = (tableSize - 1);
    ImmutableMapEntry<K, V>[] keyTable = createEntryArray(tableSize);
    ImmutableMapEntry<K, V>[] valueTable = createEntryArray(tableSize);
    ImmutableMapEntry<K, V>[] entries = createEntryArray(n);
    int hashCode = 0;
    for (int i = 0; i < n; i++)
    {
      ImmutableMapEntry.TerminalEntry<K, V> entry = entriesToAdd[i];
      K key = entry.getKey();
      V value = entry.getValue();
      
      int keyHash = key.hashCode();
      int valueHash = value.hashCode();
      int keyBucket = Hashing.smear(keyHash) & mask;
      int valueBucket = Hashing.smear(valueHash) & mask;
      
      ImmutableMapEntry<K, V> nextInKeyBucket = keyTable[keyBucket];
      for (ImmutableMapEntry<K, V> keyEntry = nextInKeyBucket; keyEntry != null; keyEntry = keyEntry.getNextInKeyBucket()) {
        checkNoConflict(!key.equals(keyEntry.getKey()), "key", entry, keyEntry);
      }
      ImmutableMapEntry<K, V> nextInValueBucket = valueTable[valueBucket];
      for (ImmutableMapEntry<K, V> valueEntry = nextInValueBucket; valueEntry != null; valueEntry = valueEntry.getNextInValueBucket()) {
        checkNoConflict(!value.equals(valueEntry.getValue()), "value", entry, valueEntry);
      }
      ImmutableMapEntry<K, V> newEntry = (nextInKeyBucket == null) && (nextInValueBucket == null) ? entry : new NonTerminalBiMapEntry(entry, nextInKeyBucket, nextInValueBucket);
      
      keyTable[keyBucket] = newEntry;
      valueTable[valueBucket] = newEntry;
      entries[i] = newEntry;
      hashCode += (keyHash ^ valueHash);
    }
    this.keyTable = keyTable;
    this.valueTable = valueTable;
    this.entries = entries;
    this.hashCode = hashCode;
  }
  
  RegularImmutableBiMap(Map.Entry<?, ?>[] entriesToAdd)
  {
    int n = entriesToAdd.length;
    int tableSize = Hashing.closedTableSize(n, 1.2D);
    mask = (tableSize - 1);
    ImmutableMapEntry<K, V>[] keyTable = createEntryArray(tableSize);
    ImmutableMapEntry<K, V>[] valueTable = createEntryArray(tableSize);
    ImmutableMapEntry<K, V>[] entries = createEntryArray(n);
    int hashCode = 0;
    for (int i = 0; i < n; i++)
    {
      Map.Entry<K, V> entry = entriesToAdd[i];
      K key = entry.getKey();
      V value = entry.getValue();
      CollectPreconditions.checkEntryNotNull(key, value);
      int keyHash = key.hashCode();
      int valueHash = value.hashCode();
      int keyBucket = Hashing.smear(keyHash) & mask;
      int valueBucket = Hashing.smear(valueHash) & mask;
      
      ImmutableMapEntry<K, V> nextInKeyBucket = keyTable[keyBucket];
      for (ImmutableMapEntry<K, V> keyEntry = nextInKeyBucket; keyEntry != null; keyEntry = keyEntry.getNextInKeyBucket()) {
        checkNoConflict(!key.equals(keyEntry.getKey()), "key", entry, keyEntry);
      }
      ImmutableMapEntry<K, V> nextInValueBucket = valueTable[valueBucket];
      for (ImmutableMapEntry<K, V> valueEntry = nextInValueBucket; valueEntry != null; valueEntry = valueEntry.getNextInValueBucket()) {
        checkNoConflict(!value.equals(valueEntry.getValue()), "value", entry, valueEntry);
      }
      ImmutableMapEntry<K, V> newEntry = (nextInKeyBucket == null) && (nextInValueBucket == null) ? new ImmutableMapEntry.TerminalEntry(key, value) : new NonTerminalBiMapEntry(key, value, nextInKeyBucket, nextInValueBucket);
      
      keyTable[keyBucket] = newEntry;
      valueTable[valueBucket] = newEntry;
      entries[i] = newEntry;
      hashCode += (keyHash ^ valueHash);
    }
    this.keyTable = keyTable;
    this.valueTable = valueTable;
    this.entries = entries;
    this.hashCode = hashCode;
  }
  
  private static final class NonTerminalBiMapEntry<K, V>
    extends ImmutableMapEntry<K, V>
  {
    @Nullable
    private final ImmutableMapEntry<K, V> nextInKeyBucket;
    @Nullable
    private final ImmutableMapEntry<K, V> nextInValueBucket;
    
    NonTerminalBiMapEntry(K key, V value, @Nullable ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable ImmutableMapEntry<K, V> nextInValueBucket)
    {
      super(value);
      this.nextInKeyBucket = nextInKeyBucket;
      this.nextInValueBucket = nextInValueBucket;
    }
    
    NonTerminalBiMapEntry(ImmutableMapEntry<K, V> contents, @Nullable ImmutableMapEntry<K, V> nextInKeyBucket, @Nullable ImmutableMapEntry<K, V> nextInValueBucket)
    {
      super();
      this.nextInKeyBucket = nextInKeyBucket;
      this.nextInValueBucket = nextInValueBucket;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInKeyBucket()
    {
      return nextInKeyBucket;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInValueBucket()
    {
      return nextInValueBucket;
    }
  }
  
  private static <K, V> ImmutableMapEntry<K, V>[] createEntryArray(int length)
  {
    return new ImmutableMapEntry[length];
  }
  
  @Nullable
  public V get(@Nullable Object key)
  {
    if (key == null) {
      return null;
    }
    int bucket = Hashing.smear(key.hashCode()) & mask;
    for (ImmutableMapEntry<K, V> entry = keyTable[bucket]; entry != null; entry = entry.getNextInKeyBucket()) {
      if (key.equals(entry.getKey())) {
        return (V)entry.getValue();
      }
    }
    return null;
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    new ImmutableMapEntrySet()
    {
      ImmutableMap<K, V> map()
      {
        return RegularImmutableBiMap.this;
      }
      
      public UnmodifiableIterator<Map.Entry<K, V>> iterator()
      {
        return asList().iterator();
      }
      
      ImmutableList<Map.Entry<K, V>> createAsList()
      {
        return new RegularImmutableAsList(this, entries);
      }
      
      boolean isHashCodeFast()
      {
        return true;
      }
      
      public int hashCode()
      {
        return hashCode;
      }
    };
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return entries.length;
  }
  
  public ImmutableBiMap<V, K> inverse()
  {
    ImmutableBiMap<V, K> result = inverse;
    return result == null ? (inverse = new Inverse(null)) : result;
  }
  
  private final class Inverse
    extends ImmutableBiMap<V, K>
  {
    private Inverse() {}
    
    public int size()
    {
      return inverse().size();
    }
    
    public ImmutableBiMap<K, V> inverse()
    {
      return RegularImmutableBiMap.this;
    }
    
    public K get(@Nullable Object value)
    {
      if (value == null) {
        return null;
      }
      int bucket = Hashing.smear(value.hashCode()) & mask;
      for (ImmutableMapEntry<K, V> entry = valueTable[bucket]; entry != null; entry = entry.getNextInValueBucket()) {
        if (value.equals(entry.getValue())) {
          return (K)entry.getKey();
        }
      }
      return null;
    }
    
    ImmutableSet<Map.Entry<V, K>> createEntrySet()
    {
      return new InverseEntrySet();
    }
    
    final class InverseEntrySet
      extends ImmutableMapEntrySet<V, K>
    {
      InverseEntrySet() {}
      
      ImmutableMap<V, K> map()
      {
        return RegularImmutableBiMap.Inverse.this;
      }
      
      boolean isHashCodeFast()
      {
        return true;
      }
      
      public int hashCode()
      {
        return hashCode;
      }
      
      public UnmodifiableIterator<Map.Entry<V, K>> iterator()
      {
        return asList().iterator();
      }
      
      ImmutableList<Map.Entry<V, K>> createAsList()
      {
        new ImmutableAsList()
        {
          public Map.Entry<V, K> get(int index)
          {
            Map.Entry<K, V> entry = entries[index];
            return Maps.immutableEntry(entry.getValue(), entry.getKey());
          }
          
          ImmutableCollection<Map.Entry<V, K>> delegateCollection()
          {
            return RegularImmutableBiMap.Inverse.InverseEntrySet.this;
          }
        };
      }
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    Object writeReplace()
    {
      return new RegularImmutableBiMap.InverseSerializedForm(RegularImmutableBiMap.this);
    }
  }
  
  private static class InverseSerializedForm<K, V>
    implements Serializable
  {
    private final ImmutableBiMap<K, V> forward;
    private static final long serialVersionUID = 1L;
    
    InverseSerializedForm(ImmutableBiMap<K, V> forward)
    {
      this.forward = forward;
    }
    
    Object readResolve()
    {
      return forward.inverse();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */