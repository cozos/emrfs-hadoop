package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true, emulated=true)
public final class LinkedHashMultimap<K, V>
  extends AbstractSetMultimap<K, V>
{
  private static final int DEFAULT_KEY_CAPACITY = 16;
  private static final int DEFAULT_VALUE_SET_CAPACITY = 2;
  @VisibleForTesting
  static final double VALUE_SET_LOAD_FACTOR = 1.0D;
  
  public static <K, V> LinkedHashMultimap<K, V> create()
  {
    return new LinkedHashMultimap(16, 2);
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(int expectedKeys, int expectedValuesPerKey)
  {
    return new LinkedHashMultimap(Maps.capacity(expectedKeys), Maps.capacity(expectedValuesPerKey));
  }
  
  public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap)
  {
    LinkedHashMultimap<K, V> result = create(multimap.keySet().size(), 2);
    result.putAll(multimap);
    return result;
  }
  
  private static <K, V> void succeedsInValueSet(ValueSetLink<K, V> pred, ValueSetLink<K, V> succ)
  {
    pred.setSuccessorInValueSet(succ);
    succ.setPredecessorInValueSet(pred);
  }
  
  private static <K, V> void succeedsInMultimap(ValueEntry<K, V> pred, ValueEntry<K, V> succ)
  {
    pred.setSuccessorInMultimap(succ);
    succ.setPredecessorInMultimap(pred);
  }
  
  private static <K, V> void deleteFromValueSet(ValueSetLink<K, V> entry)
  {
    succeedsInValueSet(entry.getPredecessorInValueSet(), entry.getSuccessorInValueSet());
  }
  
  private static <K, V> void deleteFromMultimap(ValueEntry<K, V> entry)
  {
    succeedsInMultimap(entry.getPredecessorInMultimap(), entry.getSuccessorInMultimap());
  }
  
  private static abstract interface ValueSetLink<K, V>
  {
    public abstract ValueSetLink<K, V> getPredecessorInValueSet();
    
    public abstract ValueSetLink<K, V> getSuccessorInValueSet();
    
    public abstract void setPredecessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
    
    public abstract void setSuccessorInValueSet(ValueSetLink<K, V> paramValueSetLink);
  }
  
  @VisibleForTesting
  static final class ValueEntry<K, V>
    extends ImmutableEntry<K, V>
    implements LinkedHashMultimap.ValueSetLink<K, V>
  {
    final int smearedValueHash;
    @Nullable
    ValueEntry<K, V> nextInValueBucket;
    LinkedHashMultimap.ValueSetLink<K, V> predecessorInValueSet;
    LinkedHashMultimap.ValueSetLink<K, V> successorInValueSet;
    ValueEntry<K, V> predecessorInMultimap;
    ValueEntry<K, V> successorInMultimap;
    
    ValueEntry(@Nullable K key, @Nullable V value, int smearedValueHash, @Nullable ValueEntry<K, V> nextInValueBucket)
    {
      super(value);
      this.smearedValueHash = smearedValueHash;
      this.nextInValueBucket = nextInValueBucket;
    }
    
    boolean matchesValue(@Nullable Object v, int smearedVHash)
    {
      return (smearedValueHash == smearedVHash) && (Objects.equal(getValue(), v));
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet()
    {
      return predecessorInValueSet;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet()
    {
      return successorInValueSet;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
    {
      predecessorInValueSet = entry;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
    {
      successorInValueSet = entry;
    }
    
    public ValueEntry<K, V> getPredecessorInMultimap()
    {
      return predecessorInMultimap;
    }
    
    public ValueEntry<K, V> getSuccessorInMultimap()
    {
      return successorInMultimap;
    }
    
    public void setSuccessorInMultimap(ValueEntry<K, V> multimapSuccessor)
    {
      successorInMultimap = multimapSuccessor;
    }
    
    public void setPredecessorInMultimap(ValueEntry<K, V> multimapPredecessor)
    {
      predecessorInMultimap = multimapPredecessor;
    }
  }
  
  @VisibleForTesting
  transient int valueSetCapacity = 2;
  private transient ValueEntry<K, V> multimapHeaderEntry;
  @GwtIncompatible("java serialization not supported")
  private static final long serialVersionUID = 1L;
  
  private LinkedHashMultimap(int keyCapacity, int valueSetCapacity)
  {
    super(new LinkedHashMap(keyCapacity));
    CollectPreconditions.checkNonnegative(valueSetCapacity, "expectedValuesPerKey");
    
    this.valueSetCapacity = valueSetCapacity;
    multimapHeaderEntry = new ValueEntry(null, null, 0, null);
    succeedsInMultimap(multimapHeaderEntry, multimapHeaderEntry);
  }
  
  Set<V> createCollection()
  {
    return new LinkedHashSet(valueSetCapacity);
  }
  
  Collection<V> createCollection(K key)
  {
    return new ValueSet(key, valueSetCapacity);
  }
  
  public Set<V> replaceValues(@Nullable K key, Iterable<? extends V> values)
  {
    return super.replaceValues(key, values);
  }
  
  public Set<Map.Entry<K, V>> entries()
  {
    return super.entries();
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
  
  @VisibleForTesting
  final class ValueSet
    extends Sets.ImprovedAbstractSet<V>
    implements LinkedHashMultimap.ValueSetLink<K, V>
  {
    private final K key;
    @VisibleForTesting
    LinkedHashMultimap.ValueEntry<K, V>[] hashTable;
    private int size = 0;
    private int modCount = 0;
    private LinkedHashMultimap.ValueSetLink<K, V> firstEntry;
    private LinkedHashMultimap.ValueSetLink<K, V> lastEntry;
    
    ValueSet(int key)
    {
      this.key = key;
      firstEntry = this;
      lastEntry = this;
      
      int tableSize = Hashing.closedTableSize(expectedValues, 1.0D);
      
      LinkedHashMultimap.ValueEntry<K, V>[] hashTable = new LinkedHashMultimap.ValueEntry[tableSize];
      this.hashTable = hashTable;
    }
    
    private int mask()
    {
      return hashTable.length - 1;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getPredecessorInValueSet()
    {
      return lastEntry;
    }
    
    public LinkedHashMultimap.ValueSetLink<K, V> getSuccessorInValueSet()
    {
      return firstEntry;
    }
    
    public void setPredecessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
    {
      lastEntry = entry;
    }
    
    public void setSuccessorInValueSet(LinkedHashMultimap.ValueSetLink<K, V> entry)
    {
      firstEntry = entry;
    }
    
    public Iterator<V> iterator()
    {
      new Iterator()
      {
        LinkedHashMultimap.ValueSetLink<K, V> nextEntry = firstEntry;
        LinkedHashMultimap.ValueEntry<K, V> toRemove;
        int expectedModCount = modCount;
        
        private void checkForComodification()
        {
          if (modCount != expectedModCount) {
            throw new ConcurrentModificationException();
          }
        }
        
        public boolean hasNext()
        {
          checkForComodification();
          return nextEntry != LinkedHashMultimap.ValueSet.this;
        }
        
        public V next()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          LinkedHashMultimap.ValueEntry<K, V> entry = (LinkedHashMultimap.ValueEntry)nextEntry;
          V result = entry.getValue();
          toRemove = entry;
          nextEntry = entry.getSuccessorInValueSet();
          return result;
        }
        
        public void remove()
        {
          checkForComodification();
          CollectPreconditions.checkRemove(toRemove != null);
          remove(toRemove.getValue());
          expectedModCount = modCount;
          toRemove = null;
        }
      };
    }
    
    public int size()
    {
      return size;
    }
    
    public boolean contains(@Nullable Object o)
    {
      int smearedHash = Hashing.smearedHash(o);
      for (LinkedHashMultimap.ValueEntry<K, V> entry = hashTable[(smearedHash & mask())]; entry != null; entry = nextInValueBucket) {
        if (entry.matchesValue(o, smearedHash)) {
          return true;
        }
      }
      return false;
    }
    
    public boolean add(@Nullable V value)
    {
      int smearedHash = Hashing.smearedHash(value);
      int bucket = smearedHash & mask();
      LinkedHashMultimap.ValueEntry<K, V> rowHead = hashTable[bucket];
      for (LinkedHashMultimap.ValueEntry<K, V> entry = rowHead; entry != null; entry = nextInValueBucket) {
        if (entry.matchesValue(value, smearedHash)) {
          return false;
        }
      }
      LinkedHashMultimap.ValueEntry<K, V> newEntry = new LinkedHashMultimap.ValueEntry(key, value, smearedHash, rowHead);
      LinkedHashMultimap.succeedsInValueSet(lastEntry, newEntry);
      LinkedHashMultimap.succeedsInValueSet(newEntry, this);
      LinkedHashMultimap.succeedsInMultimap(multimapHeaderEntry.getPredecessorInMultimap(), newEntry);
      LinkedHashMultimap.succeedsInMultimap(newEntry, multimapHeaderEntry);
      hashTable[bucket] = newEntry;
      size += 1;
      modCount += 1;
      rehashIfNecessary();
      return true;
    }
    
    private void rehashIfNecessary()
    {
      if (Hashing.needsResizing(size, this.hashTable.length, 1.0D))
      {
        LinkedHashMultimap.ValueEntry<K, V>[] hashTable = new LinkedHashMultimap.ValueEntry[this.hashTable.length * 2];
        this.hashTable = hashTable;
        int mask = hashTable.length - 1;
        for (LinkedHashMultimap.ValueSetLink<K, V> entry = firstEntry; entry != this; entry = entry.getSuccessorInValueSet())
        {
          LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)entry;
          int bucket = smearedValueHash & mask;
          nextInValueBucket = hashTable[bucket];
          hashTable[bucket] = valueEntry;
        }
      }
    }
    
    public boolean remove(@Nullable Object o)
    {
      int smearedHash = Hashing.smearedHash(o);
      int bucket = smearedHash & mask();
      LinkedHashMultimap.ValueEntry<K, V> prev = null;
      for (LinkedHashMultimap.ValueEntry<K, V> entry = hashTable[bucket]; entry != null; entry = nextInValueBucket)
      {
        if (entry.matchesValue(o, smearedHash))
        {
          if (prev == null) {
            hashTable[bucket] = nextInValueBucket;
          } else {
            nextInValueBucket = nextInValueBucket;
          }
          LinkedHashMultimap.deleteFromValueSet(entry);
          LinkedHashMultimap.deleteFromMultimap(entry);
          size -= 1;
          modCount += 1;
          return true;
        }
        prev = entry;
      }
      return false;
    }
    
    public void clear()
    {
      Arrays.fill(hashTable, null);
      size = 0;
      for (LinkedHashMultimap.ValueSetLink<K, V> entry = firstEntry; entry != this; entry = entry.getSuccessorInValueSet())
      {
        LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry)entry;
        LinkedHashMultimap.deleteFromMultimap(valueEntry);
      }
      LinkedHashMultimap.succeedsInValueSet(this, this);
      modCount += 1;
    }
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    new Iterator()
    {
      LinkedHashMultimap.ValueEntry<K, V> nextEntry = multimapHeaderEntry.successorInMultimap;
      LinkedHashMultimap.ValueEntry<K, V> toRemove;
      
      public boolean hasNext()
      {
        return nextEntry != multimapHeaderEntry;
      }
      
      public Map.Entry<K, V> next()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        LinkedHashMultimap.ValueEntry<K, V> result = nextEntry;
        toRemove = result;
        nextEntry = nextEntry.successorInMultimap;
        return result;
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(toRemove != null);
        remove(toRemove.getKey(), toRemove.getValue());
        toRemove = null;
      }
    };
  }
  
  Iterator<V> valueIterator()
  {
    return Maps.valueIterator(entryIterator());
  }
  
  public void clear()
  {
    super.clear();
    succeedsInMultimap(multimapHeaderEntry, multimapHeaderEntry);
  }
  
  @GwtIncompatible("java.io.ObjectOutputStream")
  private void writeObject(ObjectOutputStream stream)
    throws IOException
  {
    stream.defaultWriteObject();
    stream.writeInt(valueSetCapacity);
    stream.writeInt(keySet().size());
    for (K key : keySet()) {
      stream.writeObject(key);
    }
    stream.writeInt(size());
    for (Map.Entry<K, V> entry : entries())
    {
      stream.writeObject(entry.getKey());
      stream.writeObject(entry.getValue());
    }
  }
  
  @GwtIncompatible("java.io.ObjectInputStream")
  private void readObject(ObjectInputStream stream)
    throws IOException, ClassNotFoundException
  {
    stream.defaultReadObject();
    multimapHeaderEntry = new ValueEntry(null, null, 0, null);
    succeedsInMultimap(multimapHeaderEntry, multimapHeaderEntry);
    valueSetCapacity = stream.readInt();
    int distinctKeys = stream.readInt();
    Map<K, Collection<V>> map = new LinkedHashMap(Maps.capacity(distinctKeys));
    for (int i = 0; i < distinctKeys; i++)
    {
      K key = stream.readObject();
      map.put(key, createCollection(key));
    }
    int entries = stream.readInt();
    for (int i = 0; i < entries; i++)
    {
      K key = stream.readObject();
      
      V value = stream.readObject();
      ((Collection)map.get(key)).add(value);
    }
    setMap(map);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */