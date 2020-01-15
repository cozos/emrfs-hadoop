package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.Nullable;

@VisibleForTesting
final class LinkedHashMultimap$ValueSet
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
  
  LinkedHashMultimap$ValueSet(K arg1, int key)
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
    LinkedHashMultimap.access$200(lastEntry, newEntry);
    LinkedHashMultimap.access$200(newEntry, this);
    LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this$0).getPredecessorInMultimap(), newEntry);
    LinkedHashMultimap.access$400(newEntry, LinkedHashMultimap.access$300(this$0));
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
        LinkedHashMultimap.access$500(entry);
        LinkedHashMultimap.access$600(entry);
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
      LinkedHashMultimap.access$600(valueEntry);
    }
    LinkedHashMultimap.access$200(this, this);
    modCount += 1;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.LinkedHashMultimap.ValueSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */