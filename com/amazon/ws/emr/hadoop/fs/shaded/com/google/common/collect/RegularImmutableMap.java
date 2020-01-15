package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
final class RegularImmutableMap<K, V>
  extends ImmutableMap<K, V>
{
  private final transient ImmutableMapEntry<K, V>[] entries;
  private final transient ImmutableMapEntry<K, V>[] table;
  private final transient int mask;
  private static final double MAX_LOAD_FACTOR = 1.2D;
  private static final long serialVersionUID = 0L;
  
  RegularImmutableMap(ImmutableMapEntry.TerminalEntry<?, ?>... theEntries)
  {
    this(theEntries.length, theEntries);
  }
  
  RegularImmutableMap(int size, ImmutableMapEntry.TerminalEntry<?, ?>[] theEntries)
  {
    entries = createEntryArray(size);
    int tableSize = Hashing.closedTableSize(size, 1.2D);
    table = createEntryArray(tableSize);
    mask = (tableSize - 1);
    for (int entryIndex = 0; entryIndex < size; entryIndex++)
    {
      ImmutableMapEntry.TerminalEntry<K, V> entry = theEntries[entryIndex];
      K key = entry.getKey();
      int tableIndex = Hashing.smear(key.hashCode()) & mask;
      ImmutableMapEntry<K, V> existing = table[tableIndex];
      
      ImmutableMapEntry<K, V> newEntry = existing == null ? entry : new NonTerminalMapEntry(entry, existing);
      
      table[tableIndex] = newEntry;
      entries[entryIndex] = newEntry;
      checkNoConflictInBucket(key, newEntry, existing);
    }
  }
  
  RegularImmutableMap(Map.Entry<?, ?>[] theEntries)
  {
    int size = theEntries.length;
    entries = createEntryArray(size);
    int tableSize = Hashing.closedTableSize(size, 1.2D);
    table = createEntryArray(tableSize);
    mask = (tableSize - 1);
    for (int entryIndex = 0; entryIndex < size; entryIndex++)
    {
      Map.Entry<K, V> entry = theEntries[entryIndex];
      K key = entry.getKey();
      V value = entry.getValue();
      CollectPreconditions.checkEntryNotNull(key, value);
      int tableIndex = Hashing.smear(key.hashCode()) & mask;
      ImmutableMapEntry<K, V> existing = table[tableIndex];
      
      ImmutableMapEntry<K, V> newEntry = existing == null ? new ImmutableMapEntry.TerminalEntry(key, value) : new NonTerminalMapEntry(key, value, existing);
      
      table[tableIndex] = newEntry;
      entries[entryIndex] = newEntry;
      checkNoConflictInBucket(key, newEntry, existing);
    }
  }
  
  private void checkNoConflictInBucket(K key, ImmutableMapEntry<K, V> entry, ImmutableMapEntry<K, V> bucketHead)
  {
    for (; bucketHead != null; bucketHead = bucketHead.getNextInKeyBucket()) {
      checkNoConflict(!key.equals(bucketHead.getKey()), "key", entry, bucketHead);
    }
  }
  
  private static final class NonTerminalMapEntry<K, V>
    extends ImmutableMapEntry<K, V>
  {
    private final ImmutableMapEntry<K, V> nextInKeyBucket;
    
    NonTerminalMapEntry(K key, V value, ImmutableMapEntry<K, V> nextInKeyBucket)
    {
      super(value);
      this.nextInKeyBucket = nextInKeyBucket;
    }
    
    NonTerminalMapEntry(ImmutableMapEntry<K, V> contents, ImmutableMapEntry<K, V> nextInKeyBucket)
    {
      super();
      this.nextInKeyBucket = nextInKeyBucket;
    }
    
    ImmutableMapEntry<K, V> getNextInKeyBucket()
    {
      return nextInKeyBucket;
    }
    
    @Nullable
    ImmutableMapEntry<K, V> getNextInValueBucket()
    {
      return null;
    }
  }
  
  private ImmutableMapEntry<K, V>[] createEntryArray(int size)
  {
    return new ImmutableMapEntry[size];
  }
  
  public V get(@Nullable Object key)
  {
    if (key == null) {
      return null;
    }
    int index = Hashing.smear(key.hashCode()) & mask;
    for (ImmutableMapEntry<K, V> entry = table[index]; entry != null; entry = entry.getNextInKeyBucket())
    {
      K candidateKey = entry.getKey();
      if (key.equals(candidateKey)) {
        return (V)entry.getValue();
      }
    }
    return null;
  }
  
  public int size()
  {
    return entries.length;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  private class EntrySet
    extends ImmutableMapEntrySet<K, V>
  {
    private EntrySet() {}
    
    ImmutableMap<K, V> map()
    {
      return RegularImmutableMap.this;
    }
    
    public UnmodifiableIterator<Map.Entry<K, V>> iterator()
    {
      return asList().iterator();
    }
    
    ImmutableList<Map.Entry<K, V>> createAsList()
    {
      return new RegularImmutableAsList(this, entries);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */