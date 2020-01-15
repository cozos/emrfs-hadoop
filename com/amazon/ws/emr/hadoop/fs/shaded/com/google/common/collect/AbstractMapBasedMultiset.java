package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractMapBasedMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  private transient Map<E, Count> backingMap;
  private transient long size;
  @GwtIncompatible("not needed in emulated source.")
  private static final long serialVersionUID = -2250766705698539974L;
  
  protected AbstractMapBasedMultiset(Map<E, Count> backingMap)
  {
    this.backingMap = ((Map)Preconditions.checkNotNull(backingMap));
    size = super.size();
  }
  
  void setBackingMap(Map<E, Count> backingMap)
  {
    this.backingMap = backingMap;
  }
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    return super.entrySet();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    final Iterator<Map.Entry<E, Count>> backingEntries = backingMap.entrySet().iterator();
    
    new Iterator()
    {
      Map.Entry<E, Count> toRemove;
      
      public boolean hasNext()
      {
        return backingEntries.hasNext();
      }
      
      public Multiset.Entry<E> next()
      {
        final Map.Entry<E, Count> mapEntry = (Map.Entry)backingEntries.next();
        toRemove = mapEntry;
        new Multisets.AbstractEntry()
        {
          public E getElement()
          {
            return (E)mapEntry.getKey();
          }
          
          public int getCount()
          {
            Count count = (Count)mapEntry.getValue();
            if ((count == null) || (count.get() == 0))
            {
              Count frequency = (Count)backingMap.get(getElement());
              if (frequency != null) {
                return frequency.get();
              }
            }
            return count == null ? 0 : count.get();
          }
        };
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(toRemove != null);
        AbstractMapBasedMultiset.access$122(AbstractMapBasedMultiset.this, ((Count)toRemove.getValue()).getAndSet(0));
        backingEntries.remove();
        toRemove = null;
      }
    };
  }
  
  public void clear()
  {
    for (Count frequency : backingMap.values()) {
      frequency.set(0);
    }
    backingMap.clear();
    size = 0L;
  }
  
  int distinctElements()
  {
    return backingMap.size();
  }
  
  public int size()
  {
    return Ints.saturatedCast(size);
  }
  
  public Iterator<E> iterator()
  {
    return new MapBasedMultisetIterator();
  }
  
  private class MapBasedMultisetIterator
    implements Iterator<E>
  {
    final Iterator<Map.Entry<E, Count>> entryIterator;
    Map.Entry<E, Count> currentEntry;
    int occurrencesLeft;
    boolean canRemove;
    
    MapBasedMultisetIterator()
    {
      entryIterator = backingMap.entrySet().iterator();
    }
    
    public boolean hasNext()
    {
      return (occurrencesLeft > 0) || (entryIterator.hasNext());
    }
    
    public E next()
    {
      if (occurrencesLeft == 0)
      {
        currentEntry = ((Map.Entry)entryIterator.next());
        occurrencesLeft = ((Count)currentEntry.getValue()).get();
      }
      occurrencesLeft -= 1;
      canRemove = true;
      return (E)currentEntry.getKey();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(canRemove);
      int frequency = ((Count)currentEntry.getValue()).get();
      if (frequency <= 0) {
        throw new ConcurrentModificationException();
      }
      if (((Count)currentEntry.getValue()).addAndGet(-1) == 0) {
        entryIterator.remove();
      }
      AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
      canRemove = false;
    }
  }
  
  public int count(@Nullable Object element)
  {
    Count frequency = (Count)Maps.safeGet(backingMap, element);
    return frequency == null ? 0 : frequency.get();
  }
  
  public int add(@Nullable E element, int occurrences)
  {
    if (occurrences == 0) {
      return count(element);
    }
    Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(occurrences) });
    
    Count frequency = (Count)backingMap.get(element);
    int oldCount;
    if (frequency == null)
    {
      int oldCount = 0;
      backingMap.put(element, new Count(occurrences));
    }
    else
    {
      oldCount = frequency.get();
      long newCount = oldCount + occurrences;
      Preconditions.checkArgument(newCount <= 2147483647L, "too many occurrences: %s", new Object[] { Long.valueOf(newCount) });
      
      frequency.getAndAdd(occurrences);
    }
    size += occurrences;
    return oldCount;
  }
  
  public int remove(@Nullable Object element, int occurrences)
  {
    if (occurrences == 0) {
      return count(element);
    }
    Preconditions.checkArgument(occurrences > 0, "occurrences cannot be negative: %s", new Object[] { Integer.valueOf(occurrences) });
    
    Count frequency = (Count)backingMap.get(element);
    if (frequency == null) {
      return 0;
    }
    int oldCount = frequency.get();
    int numberRemoved;
    int numberRemoved;
    if (oldCount > occurrences)
    {
      numberRemoved = occurrences;
    }
    else
    {
      numberRemoved = oldCount;
      backingMap.remove(element);
    }
    frequency.addAndGet(-numberRemoved);
    size -= numberRemoved;
    return oldCount;
  }
  
  public int setCount(@Nullable E element, int count)
  {
    CollectPreconditions.checkNonnegative(count, "count");
    int oldCount;
    int oldCount;
    if (count == 0)
    {
      Count existingCounter = (Count)backingMap.remove(element);
      oldCount = getAndSet(existingCounter, count);
    }
    else
    {
      Count existingCounter = (Count)backingMap.get(element);
      oldCount = getAndSet(existingCounter, count);
      if (existingCounter == null) {
        backingMap.put(element, new Count(count));
      }
    }
    size += count - oldCount;
    return oldCount;
  }
  
  private static int getAndSet(Count i, int count)
  {
    if (i == null) {
      return 0;
    }
    return i.getAndSet(count);
  }
  
  @GwtIncompatible("java.io.ObjectStreamException")
  private void readObjectNoData()
    throws ObjectStreamException
  {
    throw new InvalidObjectException("Stream data required");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultiset
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */