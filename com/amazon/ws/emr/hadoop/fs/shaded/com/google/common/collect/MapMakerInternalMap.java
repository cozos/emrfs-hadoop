package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class MapMakerInternalMap<K, V>
  extends AbstractMap<K, V>
  implements ConcurrentMap<K, V>, Serializable
{
  static final int MAXIMUM_CAPACITY = 1073741824;
  static final int MAX_SEGMENTS = 65536;
  static final int CONTAINS_VALUE_RETRIES = 3;
  static final int DRAIN_THRESHOLD = 63;
  static final int DRAIN_MAX = 16;
  static final long CLEANUP_EXECUTOR_DELAY_SECS = 60L;
  private static final Logger logger = Logger.getLogger(MapMakerInternalMap.class.getName());
  final transient int segmentMask;
  final transient int segmentShift;
  final transient Segment<K, V>[] segments;
  final int concurrencyLevel;
  final Equivalence<Object> keyEquivalence;
  final Equivalence<Object> valueEquivalence;
  final Strength keyStrength;
  final Strength valueStrength;
  final int maximumSize;
  final long expireAfterAccessNanos;
  final long expireAfterWriteNanos;
  final Queue<MapMaker.RemovalNotification<K, V>> removalNotificationQueue;
  final MapMaker.RemovalListener<K, V> removalListener;
  final transient EntryFactory entryFactory;
  final Ticker ticker;
  
  MapMakerInternalMap(MapMaker builder)
  {
    concurrencyLevel = Math.min(builder.getConcurrencyLevel(), 65536);
    
    keyStrength = builder.getKeyStrength();
    valueStrength = builder.getValueStrength();
    
    keyEquivalence = builder.getKeyEquivalence();
    valueEquivalence = valueStrength.defaultEquivalence();
    
    maximumSize = maximumSize;
    expireAfterAccessNanos = builder.getExpireAfterAccessNanos();
    expireAfterWriteNanos = builder.getExpireAfterWriteNanos();
    
    entryFactory = EntryFactory.getFactory(keyStrength, expires(), evictsBySize());
    ticker = builder.getTicker();
    
    removalListener = builder.getRemovalListener();
    removalNotificationQueue = (removalListener == GenericMapMaker.NullListener.INSTANCE ? discardingQueue() : new ConcurrentLinkedQueue());
    
    int initialCapacity = Math.min(builder.getInitialCapacity(), 1073741824);
    if (evictsBySize()) {
      initialCapacity = Math.min(initialCapacity, maximumSize);
    }
    int segmentShift = 0;
    int segmentCount = 1;
    while ((segmentCount < concurrencyLevel) && ((!evictsBySize()) || (segmentCount * 2 <= maximumSize)))
    {
      segmentShift++;
      segmentCount <<= 1;
    }
    this.segmentShift = (32 - segmentShift);
    segmentMask = (segmentCount - 1);
    
    segments = newSegmentArray(segmentCount);
    
    int segmentCapacity = initialCapacity / segmentCount;
    if (segmentCapacity * segmentCount < initialCapacity) {
      segmentCapacity++;
    }
    int segmentSize = 1;
    while (segmentSize < segmentCapacity) {
      segmentSize <<= 1;
    }
    if (evictsBySize())
    {
      int maximumSegmentSize = maximumSize / segmentCount + 1;
      int remainder = maximumSize % segmentCount;
      for (int i = 0; i < segments.length; i++)
      {
        if (i == remainder) {
          maximumSegmentSize--;
        }
        segments[i] = createSegment(segmentSize, maximumSegmentSize);
      }
    }
    else
    {
      for (int i = 0; i < segments.length; i++) {
        segments[i] = createSegment(segmentSize, -1);
      }
    }
  }
  
  boolean evictsBySize()
  {
    return maximumSize != -1;
  }
  
  boolean expires()
  {
    return (expiresAfterWrite()) || (expiresAfterAccess());
  }
  
  boolean expiresAfterWrite()
  {
    return expireAfterWriteNanos > 0L;
  }
  
  boolean expiresAfterAccess()
  {
    return expireAfterAccessNanos > 0L;
  }
  
  boolean usesKeyReferences()
  {
    return keyStrength != Strength.STRONG;
  }
  
  boolean usesValueReferences()
  {
    return valueStrength != Strength.STRONG;
  }
  
  static abstract enum Strength
  {
    STRONG,  SOFT,  WEAK;
    
    private Strength() {}
    
    abstract <K, V> MapMakerInternalMap.ValueReference<K, V> referenceValue(MapMakerInternalMap.Segment<K, V> paramSegment, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry, V paramV);
    
    abstract Equivalence<Object> defaultEquivalence();
  }
  
  static abstract enum EntryFactory
  {
    STRONG,  STRONG_EXPIRABLE,  STRONG_EVICTABLE,  STRONG_EXPIRABLE_EVICTABLE,  WEAK,  WEAK_EXPIRABLE,  WEAK_EVICTABLE,  WEAK_EXPIRABLE_EVICTABLE;
    
    static final int EXPIRABLE_MASK = 1;
    static final int EVICTABLE_MASK = 2;
    static final EntryFactory[][] factories = { { STRONG, STRONG_EXPIRABLE, STRONG_EVICTABLE, STRONG_EXPIRABLE_EVICTABLE }, new EntryFactory[0], { WEAK, WEAK_EXPIRABLE, WEAK_EVICTABLE, WEAK_EXPIRABLE_EVICTABLE } };
    
    private EntryFactory() {}
    
    static EntryFactory getFactory(MapMakerInternalMap.Strength keyStrength, boolean expireAfterWrite, boolean evictsBySize)
    {
      int flags = (expireAfterWrite ? 1 : 0) | (evictsBySize ? 2 : 0);
      return factories[keyStrength.ordinal()][flags];
    }
    
    abstract <K, V> MapMakerInternalMap.ReferenceEntry<K, V> newEntry(MapMakerInternalMap.Segment<K, V> paramSegment, K paramK, int paramInt, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    <K, V> MapMakerInternalMap.ReferenceEntry<K, V> copyEntry(MapMakerInternalMap.Segment<K, V> segment, MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newNext)
    {
      return newEntry(segment, original.getKey(), original.getHash(), newNext);
    }
    
    <K, V> void copyExpirableEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newEntry)
    {
      newEntry.setExpirationTime(original.getExpirationTime());
      
      MapMakerInternalMap.connectExpirables(original.getPreviousExpirable(), newEntry);
      MapMakerInternalMap.connectExpirables(newEntry, original.getNextExpirable());
      
      MapMakerInternalMap.nullifyExpirable(original);
    }
    
    <K, V> void copyEvictableEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newEntry)
    {
      MapMakerInternalMap.connectEvictables(original.getPreviousEvictable(), newEntry);
      MapMakerInternalMap.connectEvictables(newEntry, original.getNextEvictable());
      
      MapMakerInternalMap.nullifyEvictable(original);
    }
  }
  
  static final ValueReference<Object, Object> UNSET = new ValueReference()
  {
    public Object get()
    {
      return null;
    }
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getEntry()
    {
      return null;
    }
    
    public MapMakerInternalMap.ValueReference<Object, Object> copyFor(ReferenceQueue<Object> queue, @Nullable Object value, MapMakerInternalMap.ReferenceEntry<Object, Object> entry)
    {
      return this;
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public Object waitForValue()
    {
      return null;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<Object, Object> newValue) {}
  };
  
  static <K, V> ValueReference<K, V> unset()
  {
    return UNSET;
  }
  
  static abstract interface ValueReference<K, V>
  {
    public abstract V get();
    
    public abstract V waitForValue()
      throws ExecutionException;
    
    public abstract MapMakerInternalMap.ReferenceEntry<K, V> getEntry();
    
    public abstract ValueReference<K, V> copyFor(ReferenceQueue<V> paramReferenceQueue, @Nullable V paramV, MapMakerInternalMap.ReferenceEntry<K, V> paramReferenceEntry);
    
    public abstract void clear(@Nullable ValueReference<K, V> paramValueReference);
    
    public abstract boolean isComputingReference();
  }
  
  static abstract interface ReferenceEntry<K, V>
  {
    public abstract MapMakerInternalMap.ValueReference<K, V> getValueReference();
    
    public abstract void setValueReference(MapMakerInternalMap.ValueReference<K, V> paramValueReference);
    
    public abstract ReferenceEntry<K, V> getNext();
    
    public abstract int getHash();
    
    public abstract K getKey();
    
    public abstract long getExpirationTime();
    
    public abstract void setExpirationTime(long paramLong);
    
    public abstract ReferenceEntry<K, V> getNextExpirable();
    
    public abstract void setNextExpirable(ReferenceEntry<K, V> paramReferenceEntry);
    
    public abstract ReferenceEntry<K, V> getPreviousExpirable();
    
    public abstract void setPreviousExpirable(ReferenceEntry<K, V> paramReferenceEntry);
    
    public abstract ReferenceEntry<K, V> getNextEvictable();
    
    public abstract void setNextEvictable(ReferenceEntry<K, V> paramReferenceEntry);
    
    public abstract ReferenceEntry<K, V> getPreviousEvictable();
    
    public abstract void setPreviousEvictable(ReferenceEntry<K, V> paramReferenceEntry);
  }
  
  private static enum NullEntry
    implements MapMakerInternalMap.ReferenceEntry<Object, Object>
  {
    INSTANCE;
    
    private NullEntry() {}
    
    public MapMakerInternalMap.ValueReference<Object, Object> getValueReference()
    {
      return null;
    }
    
    public void setValueReference(MapMakerInternalMap.ValueReference<Object, Object> valueReference) {}
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getNext()
    {
      return null;
    }
    
    public int getHash()
    {
      return 0;
    }
    
    public Object getKey()
    {
      return null;
    }
    
    public long getExpirationTime()
    {
      return 0L;
    }
    
    public void setExpirationTime(long time) {}
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getNextExpirable()
    {
      return this;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<Object, Object> next) {}
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getPreviousExpirable()
    {
      return this;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<Object, Object> previous) {}
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getNextEvictable()
    {
      return this;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<Object, Object> next) {}
    
    public MapMakerInternalMap.ReferenceEntry<Object, Object> getPreviousEvictable()
    {
      return this;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<Object, Object> previous) {}
  }
  
  static abstract class AbstractReferenceEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    public MapMakerInternalMap.ValueReference<K, V> getValueReference()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNext()
    {
      throw new UnsupportedOperationException();
    }
    
    public int getHash()
    {
      throw new UnsupportedOperationException();
    }
    
    public K getKey()
    {
      throw new UnsupportedOperationException();
    }
    
    public long getExpirationTime()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setExpirationTime(long time)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static <K, V> ReferenceEntry<K, V> nullEntry()
  {
    return NullEntry.INSTANCE;
  }
  
  static final Queue<? extends Object> DISCARDING_QUEUE = new AbstractQueue()
  {
    public boolean offer(Object o)
    {
      return true;
    }
    
    public Object peek()
    {
      return null;
    }
    
    public Object poll()
    {
      return null;
    }
    
    public int size()
    {
      return 0;
    }
    
    public Iterator<Object> iterator()
    {
      return Iterators.emptyIterator();
    }
  };
  transient Set<K> keySet;
  transient Collection<V> values;
  transient Set<Map.Entry<K, V>> entrySet;
  private static final long serialVersionUID = 5L;
  
  static <E> Queue<E> discardingQueue()
  {
    return DISCARDING_QUEUE;
  }
  
  static class StrongEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    final K key;
    final int hash;
    final MapMakerInternalMap.ReferenceEntry<K, V> next;
    
    StrongEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      this.key = key;
      this.hash = hash;
      this.next = next;
    }
    
    public K getKey()
    {
      return (K)key;
    }
    
    public long getExpirationTime()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setExpirationTime(long time)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    volatile MapMakerInternalMap.ValueReference<K, V> valueReference = MapMakerInternalMap.unset();
    
    public MapMakerInternalMap.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      MapMakerInternalMap.ValueReference<K, V> previous = this.valueReference;
      this.valueReference = valueReference;
      previous.clear(valueReference);
    }
    
    public int getHash()
    {
      return hash;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  static final class StrongExpirableEntry<K, V>
    extends MapMakerInternalMap.StrongEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    StrongExpirableEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
  }
  
  static final class StrongEvictableEntry<K, V>
    extends MapMakerInternalMap.StrongEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    StrongEvictableEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(hash, next);
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static final class StrongExpirableEvictableEntry<K, V>
    extends MapMakerInternalMap.StrongEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    StrongExpirableEvictableEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static class SoftEntry<K, V>
    extends SoftReference<K>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    final int hash;
    final MapMakerInternalMap.ReferenceEntry<K, V> next;
    
    SoftEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(queue);
      this.hash = hash;
      this.next = next;
    }
    
    public K getKey()
    {
      return (K)get();
    }
    
    public long getExpirationTime()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setExpirationTime(long time)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    volatile MapMakerInternalMap.ValueReference<K, V> valueReference = MapMakerInternalMap.unset();
    
    public MapMakerInternalMap.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      MapMakerInternalMap.ValueReference<K, V> previous = this.valueReference;
      this.valueReference = valueReference;
      previous.clear(valueReference);
    }
    
    public int getHash()
    {
      return hash;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  static final class SoftExpirableEntry<K, V>
    extends MapMakerInternalMap.SoftEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    SoftExpirableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
  }
  
  static final class SoftEvictableEntry<K, V>
    extends MapMakerInternalMap.SoftEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    SoftEvictableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static final class SoftExpirableEvictableEntry<K, V>
    extends MapMakerInternalMap.SoftEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    SoftExpirableEvictableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static class WeakEntry<K, V>
    extends WeakReference<K>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    final int hash;
    final MapMakerInternalMap.ReferenceEntry<K, V> next;
    
    WeakEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(queue);
      this.hash = hash;
      this.next = next;
    }
    
    public K getKey()
    {
      return (K)get();
    }
    
    public long getExpirationTime()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setExpirationTime(long time)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      throw new UnsupportedOperationException();
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      throw new UnsupportedOperationException();
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      throw new UnsupportedOperationException();
    }
    
    volatile MapMakerInternalMap.ValueReference<K, V> valueReference = MapMakerInternalMap.unset();
    
    public MapMakerInternalMap.ValueReference<K, V> getValueReference()
    {
      return valueReference;
    }
    
    public void setValueReference(MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      MapMakerInternalMap.ValueReference<K, V> previous = this.valueReference;
      this.valueReference = valueReference;
      previous.clear(valueReference);
    }
    
    public int getHash()
    {
      return hash;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNext()
    {
      return next;
    }
  }
  
  static final class WeakExpirableEntry<K, V>
    extends MapMakerInternalMap.WeakEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    WeakExpirableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
  }
  
  static final class WeakEvictableEntry<K, V>
    extends MapMakerInternalMap.WeakEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    WeakEvictableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static final class WeakExpirableEvictableEntry<K, V>
    extends MapMakerInternalMap.WeakEntry<K, V>
    implements MapMakerInternalMap.ReferenceEntry<K, V>
  {
    WeakExpirableEvictableEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      super(key, hash, next);
    }
    
    volatile long time = Long.MAX_VALUE;
    
    public long getExpirationTime()
    {
      return time;
    }
    
    public void setExpirationTime(long time)
    {
      this.time = time;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = MapMakerInternalMap.nullEntry();
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  }
  
  static final class WeakValueReference<K, V>
    extends WeakReference<V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final MapMakerInternalMap.ReferenceEntry<K, V> entry;
    
    WeakValueReference(ReferenceQueue<V> queue, V referent, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      super(queue);
      this.entry = entry;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return entry;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> newValue)
    {
      clear();
    }
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      return new WeakValueReference(queue, value, entry);
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
  }
  
  static final class SoftValueReference<K, V>
    extends SoftReference<V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final MapMakerInternalMap.ReferenceEntry<K, V> entry;
    
    SoftValueReference(ReferenceQueue<V> queue, V referent, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      super(queue);
      this.entry = entry;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return entry;
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> newValue)
    {
      clear();
    }
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      return new SoftValueReference(queue, value, entry);
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
  }
  
  static final class StrongValueReference<K, V>
    implements MapMakerInternalMap.ValueReference<K, V>
  {
    final V referent;
    
    StrongValueReference(V referent)
    {
      this.referent = referent;
    }
    
    public V get()
    {
      return (V)referent;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getEntry()
    {
      return null;
    }
    
    public MapMakerInternalMap.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, V value, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      return this;
    }
    
    public boolean isComputingReference()
    {
      return false;
    }
    
    public V waitForValue()
    {
      return (V)get();
    }
    
    public void clear(MapMakerInternalMap.ValueReference<K, V> newValue) {}
  }
  
  static int rehash(int h)
  {
    h += (h << 15 ^ 0xCD7D);
    h ^= h >>> 10;
    h += (h << 3);
    h ^= h >>> 6;
    h += (h << 2) + (h << 14);
    return h ^ h >>> 16;
  }
  
  @VisibleForTesting
  ReferenceEntry<K, V> newEntry(K key, int hash, @Nullable ReferenceEntry<K, V> next)
  {
    return segmentFor(hash).newEntry(key, hash, next);
  }
  
  @VisibleForTesting
  ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> original, ReferenceEntry<K, V> newNext)
  {
    int hash = original.getHash();
    return segmentFor(hash).copyEntry(original, newNext);
  }
  
  @VisibleForTesting
  ValueReference<K, V> newValueReference(ReferenceEntry<K, V> entry, V value)
  {
    int hash = entry.getHash();
    return valueStrength.referenceValue(segmentFor(hash), entry, value);
  }
  
  int hash(Object key)
  {
    int h = keyEquivalence.hash(key);
    return rehash(h);
  }
  
  void reclaimValue(ValueReference<K, V> valueReference)
  {
    ReferenceEntry<K, V> entry = valueReference.getEntry();
    int hash = entry.getHash();
    segmentFor(hash).reclaimValue(entry.getKey(), hash, valueReference);
  }
  
  void reclaimKey(ReferenceEntry<K, V> entry)
  {
    int hash = entry.getHash();
    segmentFor(hash).reclaimKey(entry, hash);
  }
  
  @VisibleForTesting
  boolean isLive(ReferenceEntry<K, V> entry)
  {
    return segmentFor(entry.getHash()).getLiveValue(entry) != null;
  }
  
  Segment<K, V> segmentFor(int hash)
  {
    return segments[(hash >>> segmentShift & segmentMask)];
  }
  
  Segment<K, V> createSegment(int initialCapacity, int maxSegmentSize)
  {
    return new Segment(this, initialCapacity, maxSegmentSize);
  }
  
  V getLiveValue(ReferenceEntry<K, V> entry)
  {
    if (entry.getKey() == null) {
      return null;
    }
    V value = entry.getValueReference().get();
    if (value == null) {
      return null;
    }
    if ((expires()) && (isExpired(entry))) {
      return null;
    }
    return value;
  }
  
  boolean isExpired(ReferenceEntry<K, V> entry)
  {
    return isExpired(entry, ticker.read());
  }
  
  boolean isExpired(ReferenceEntry<K, V> entry, long now)
  {
    return now - entry.getExpirationTime() > 0L;
  }
  
  static <K, V> void connectExpirables(ReferenceEntry<K, V> previous, ReferenceEntry<K, V> next)
  {
    previous.setNextExpirable(next);
    next.setPreviousExpirable(previous);
  }
  
  static <K, V> void nullifyExpirable(ReferenceEntry<K, V> nulled)
  {
    ReferenceEntry<K, V> nullEntry = nullEntry();
    nulled.setNextExpirable(nullEntry);
    nulled.setPreviousExpirable(nullEntry);
  }
  
  void processPendingNotifications()
  {
    MapMaker.RemovalNotification<K, V> notification;
    while ((notification = (MapMaker.RemovalNotification)removalNotificationQueue.poll()) != null) {
      try
      {
        removalListener.onRemoval(notification);
      }
      catch (Exception e)
      {
        logger.log(Level.WARNING, "Exception thrown by removal listener", e);
      }
    }
  }
  
  static <K, V> void connectEvictables(ReferenceEntry<K, V> previous, ReferenceEntry<K, V> next)
  {
    previous.setNextEvictable(next);
    next.setPreviousEvictable(previous);
  }
  
  static <K, V> void nullifyEvictable(ReferenceEntry<K, V> nulled)
  {
    ReferenceEntry<K, V> nullEntry = nullEntry();
    nulled.setNextEvictable(nullEntry);
    nulled.setPreviousEvictable(nullEntry);
  }
  
  final Segment<K, V>[] newSegmentArray(int ssize)
  {
    return new Segment[ssize];
  }
  
  static class Segment<K, V>
    extends ReentrantLock
  {
    final MapMakerInternalMap<K, V> map;
    volatile int count;
    int modCount;
    int threshold;
    volatile AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table;
    final int maxSegmentSize;
    final ReferenceQueue<K> keyReferenceQueue;
    final ReferenceQueue<V> valueReferenceQueue;
    final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> recencyQueue;
    final AtomicInteger readCount = new AtomicInteger();
    @GuardedBy("Segment.this")
    final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> evictionQueue;
    @GuardedBy("Segment.this")
    final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> expirationQueue;
    
    Segment(MapMakerInternalMap<K, V> map, int initialCapacity, int maxSegmentSize)
    {
      this.map = map;
      this.maxSegmentSize = maxSegmentSize;
      initTable(newEntryArray(initialCapacity));
      
      keyReferenceQueue = (map.usesKeyReferences() ? new ReferenceQueue() : null);
      
      valueReferenceQueue = (map.usesValueReferences() ? new ReferenceQueue() : null);
      
      recencyQueue = ((map.evictsBySize()) || (map.expiresAfterAccess()) ? new ConcurrentLinkedQueue() : MapMakerInternalMap.discardingQueue());
      
      evictionQueue = (map.evictsBySize() ? new MapMakerInternalMap.EvictionQueue() : MapMakerInternalMap.discardingQueue());
      
      expirationQueue = (map.expires() ? new MapMakerInternalMap.ExpirationQueue() : MapMakerInternalMap.discardingQueue());
    }
    
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newEntryArray(int size)
    {
      return new AtomicReferenceArray(size);
    }
    
    void initTable(AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newTable)
    {
      threshold = (newTable.length() * 3 / 4);
      if (threshold == maxSegmentSize) {
        threshold += 1;
      }
      table = newTable;
    }
    
    @GuardedBy("Segment.this")
    MapMakerInternalMap.ReferenceEntry<K, V> newEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      return map.entryFactory.newEntry(this, key, hash, next);
    }
    
    @GuardedBy("Segment.this")
    MapMakerInternalMap.ReferenceEntry<K, V> copyEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newNext)
    {
      if (original.getKey() == null) {
        return null;
      }
      MapMakerInternalMap.ValueReference<K, V> valueReference = original.getValueReference();
      V value = valueReference.get();
      if ((value == null) && (!valueReference.isComputingReference())) {
        return null;
      }
      MapMakerInternalMap.ReferenceEntry<K, V> newEntry = map.entryFactory.copyEntry(this, original, newNext);
      newEntry.setValueReference(valueReference.copyFor(valueReferenceQueue, value, newEntry));
      return newEntry;
    }
    
    @GuardedBy("Segment.this")
    void setValue(MapMakerInternalMap.ReferenceEntry<K, V> entry, V value)
    {
      MapMakerInternalMap.ValueReference<K, V> valueReference = map.valueStrength.referenceValue(this, entry, value);
      entry.setValueReference(valueReference);
      recordWrite(entry);
    }
    
    void tryDrainReferenceQueues()
    {
      if (tryLock()) {
        try
        {
          drainReferenceQueues();
        }
        finally
        {
          unlock();
        }
      }
    }
    
    @GuardedBy("Segment.this")
    void drainReferenceQueues()
    {
      if (map.usesKeyReferences()) {
        drainKeyReferenceQueue();
      }
      if (map.usesValueReferences()) {
        drainValueReferenceQueue();
      }
    }
    
    @GuardedBy("Segment.this")
    void drainKeyReferenceQueue()
    {
      int i = 0;
      Reference<? extends K> ref;
      for (; (ref = keyReferenceQueue.poll()) != null; i == 16)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> entry = (MapMakerInternalMap.ReferenceEntry)ref;
        map.reclaimKey(entry);
        i++;
      }
    }
    
    @GuardedBy("Segment.this")
    void drainValueReferenceQueue()
    {
      int i = 0;
      Reference<? extends V> ref;
      for (; (ref = valueReferenceQueue.poll()) != null; i == 16)
      {
        MapMakerInternalMap.ValueReference<K, V> valueReference = (MapMakerInternalMap.ValueReference)ref;
        map.reclaimValue(valueReference);
        i++;
      }
    }
    
    void clearReferenceQueues()
    {
      if (map.usesKeyReferences()) {
        clearKeyReferenceQueue();
      }
      if (map.usesValueReferences()) {
        clearValueReferenceQueue();
      }
    }
    
    void clearKeyReferenceQueue()
    {
      while (keyReferenceQueue.poll() != null) {}
    }
    
    void clearValueReferenceQueue()
    {
      while (valueReferenceQueue.poll() != null) {}
    }
    
    void recordRead(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      if (map.expiresAfterAccess()) {
        recordExpirationTime(entry, map.expireAfterAccessNanos);
      }
      recencyQueue.add(entry);
    }
    
    @GuardedBy("Segment.this")
    void recordLockedRead(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      evictionQueue.add(entry);
      if (map.expiresAfterAccess())
      {
        recordExpirationTime(entry, map.expireAfterAccessNanos);
        expirationQueue.add(entry);
      }
    }
    
    @GuardedBy("Segment.this")
    void recordWrite(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      drainRecencyQueue();
      evictionQueue.add(entry);
      if (map.expires())
      {
        long expiration = map.expiresAfterAccess() ? map.expireAfterAccessNanos : map.expireAfterWriteNanos;
        
        recordExpirationTime(entry, expiration);
        expirationQueue.add(entry);
      }
    }
    
    @GuardedBy("Segment.this")
    void drainRecencyQueue()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e;
      while ((e = (MapMakerInternalMap.ReferenceEntry)recencyQueue.poll()) != null)
      {
        if (evictionQueue.contains(e)) {
          evictionQueue.add(e);
        }
        if ((map.expiresAfterAccess()) && (expirationQueue.contains(e))) {
          expirationQueue.add(e);
        }
      }
    }
    
    void recordExpirationTime(MapMakerInternalMap.ReferenceEntry<K, V> entry, long expirationNanos)
    {
      entry.setExpirationTime(map.ticker.read() + expirationNanos);
    }
    
    void tryExpireEntries()
    {
      if (tryLock()) {
        try
        {
          expireEntries();
        }
        finally
        {
          unlock();
        }
      }
    }
    
    @GuardedBy("Segment.this")
    void expireEntries()
    {
      drainRecencyQueue();
      if (expirationQueue.isEmpty()) {
        return;
      }
      long now = map.ticker.read();
      MapMakerInternalMap.ReferenceEntry<K, V> e;
      while (((e = (MapMakerInternalMap.ReferenceEntry)expirationQueue.peek()) != null) && (map.isExpired(e, now))) {
        if (!removeEntry(e, e.getHash(), MapMaker.RemovalCause.EXPIRED)) {
          throw new AssertionError();
        }
      }
    }
    
    void enqueueNotification(MapMakerInternalMap.ReferenceEntry<K, V> entry, MapMaker.RemovalCause cause)
    {
      enqueueNotification(entry.getKey(), entry.getHash(), entry.getValueReference().get(), cause);
    }
    
    void enqueueNotification(@Nullable K key, int hash, @Nullable V value, MapMaker.RemovalCause cause)
    {
      if (map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE)
      {
        MapMaker.RemovalNotification<K, V> notification = new MapMaker.RemovalNotification(key, value, cause);
        map.removalNotificationQueue.offer(notification);
      }
    }
    
    @GuardedBy("Segment.this")
    boolean evictEntries()
    {
      if ((map.evictsBySize()) && (count >= maxSegmentSize))
      {
        drainRecencyQueue();
        
        MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)evictionQueue.remove();
        if (!removeEntry(e, e.getHash(), MapMaker.RemovalCause.SIZE)) {
          throw new AssertionError();
        }
        return true;
      }
      return false;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> getFirst(int hash)
    {
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      return (MapMakerInternalMap.ReferenceEntry)table.get(hash & table.length() - 1);
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> getEntry(Object key, int hash)
    {
      if (count != 0) {
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = getFirst(hash); e != null; e = e.getNext()) {
          if (e.getHash() == hash)
          {
            K entryKey = e.getKey();
            if (entryKey == null) {
              tryDrainReferenceQueues();
            } else if (map.keyEquivalence.equivalent(key, entryKey)) {
              return e;
            }
          }
        }
      }
      return null;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> getLiveEntry(Object key, int hash)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = getEntry(key, hash);
      if (e == null) {
        return null;
      }
      if ((map.expires()) && (map.isExpired(e)))
      {
        tryExpireEntries();
        return null;
      }
      return e;
    }
    
    V get(Object key, int hash)
    {
      try
      {
        MapMakerInternalMap.ReferenceEntry<K, V> e = getLiveEntry(key, hash);
        if (e == null) {
          return null;
        }
        Object value = e.getValueReference().get();
        if (value != null) {
          recordRead(e);
        } else {
          tryDrainReferenceQueues();
        }
        return (V)value;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    boolean containsKey(Object key, int hash)
    {
      try
      {
        MapMakerInternalMap.ReferenceEntry<K, V> e;
        if (count != 0)
        {
          e = getLiveEntry(key, hash);
          boolean bool;
          if (e == null) {
            return false;
          }
          return e.getValueReference().get() != null;
        }
        return 0;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    @VisibleForTesting
    boolean containsValue(Object value)
    {
      try
      {
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table;
        if (count != 0)
        {
          table = this.table;
          int length = table.length();
          for (int i = 0; i < length; i++) {
            for (MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)table.get(i); e != null; e = e.getNext())
            {
              V entryValue = getLiveValue(e);
              if (entryValue != null) {
                if (map.valueEquivalence.equivalent(value, entryValue)) {
                  return true;
                }
              }
            }
          }
        }
        return 0;
      }
      finally
      {
        postReadCleanup();
      }
    }
    
    V put(K key, int hash, V value, boolean onlyIfAbsent)
    {
      lock();
      try
      {
        preWriteCleanup();
        
        int newCount = count + 1;
        if (newCount > threshold)
        {
          expand();
          newCount = count + 1;
        }
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        K entryKey;
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
            V entryValue = valueReference.get();
            V ?;
            if (entryValue == null)
            {
              modCount += 1;
              setValue(e, value);
              if (!valueReference.isComputingReference())
              {
                enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
                newCount = count;
              }
              else if (evictEntries())
              {
                newCount = count + 1;
              }
              count = newCount;
              return null;
            }
            if (onlyIfAbsent)
            {
              recordLockedRead(e);
              return entryValue;
            }
            modCount += 1;
            enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
            setValue(e, value);
            return entryValue;
          }
        }
        modCount += 1;
        MapMakerInternalMap.ReferenceEntry<K, V> newEntry = newEntry(key, hash, first);
        setValue(newEntry, value);
        table.set(index, newEntry);
        if (evictEntries()) {
          newCount = count + 1;
        }
        count = newCount;
        return null;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    @GuardedBy("Segment.this")
    void expand()
    {
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> oldTable = table;
      int oldCapacity = oldTable.length();
      if (oldCapacity >= 1073741824) {
        return;
      }
      int newCount = count;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newTable = newEntryArray(oldCapacity << 1);
      threshold = (newTable.length() * 3 / 4);
      int newMask = newTable.length() - 1;
      for (int oldIndex = 0; oldIndex < oldCapacity; oldIndex++)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> head = (MapMakerInternalMap.ReferenceEntry)oldTable.get(oldIndex);
        if (head != null)
        {
          MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNext();
          int headIndex = head.getHash() & newMask;
          if (next == null)
          {
            newTable.set(headIndex, head);
          }
          else
          {
            MapMakerInternalMap.ReferenceEntry<K, V> tail = head;
            int tailIndex = headIndex;
            for (MapMakerInternalMap.ReferenceEntry<K, V> e = next; e != null; e = e.getNext())
            {
              int newIndex = e.getHash() & newMask;
              if (newIndex != tailIndex)
              {
                tailIndex = newIndex;
                tail = e;
              }
            }
            newTable.set(tailIndex, tail);
            for (MapMakerInternalMap.ReferenceEntry<K, V> e = head; e != tail; e = e.getNext())
            {
              int newIndex = e.getHash() & newMask;
              MapMakerInternalMap.ReferenceEntry<K, V> newNext = (MapMakerInternalMap.ReferenceEntry)newTable.get(newIndex);
              MapMakerInternalMap.ReferenceEntry<K, V> newFirst = copyEntry(e, newNext);
              if (newFirst != null)
              {
                newTable.set(newIndex, newFirst);
              }
              else
              {
                removeCollectedEntry(e);
                newCount--;
              }
            }
          }
        }
      }
      table = newTable;
      count = newCount;
    }
    
    boolean replace(K key, int hash, V oldValue, V newValue)
    {
      lock();
      try
      {
        preWriteCleanup();
        
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
            V entryValue = valueReference.get();
            int newCount;
            if (entryValue == null)
            {
              if (isCollected(valueReference))
              {
                newCount = count - 1;
                modCount += 1;
                enqueueNotification(entryKey, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
                MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
                newCount = count - 1;
                table.set(index, newFirst);
                count = newCount;
              }
              return 0;
            }
            if (map.valueEquivalence.equivalent(oldValue, entryValue))
            {
              modCount += 1;
              enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
              setValue(e, newValue);
              return 1;
            }
            recordLockedRead(e);
            return 0;
          }
        }
        return 0;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    V replace(K key, int hash, V newValue)
    {
      lock();
      try
      {
        preWriteCleanup();
        
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
            V entryValue = valueReference.get();
            int newCount;
            if (entryValue == null)
            {
              if (isCollected(valueReference))
              {
                newCount = count - 1;
                modCount += 1;
                enqueueNotification(entryKey, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
                MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
                newCount = count - 1;
                table.set(index, newFirst);
                count = newCount;
              }
              return null;
            }
            modCount += 1;
            enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
            setValue(e, newValue);
            return entryValue;
          }
        }
        return null;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    V remove(Object key, int hash)
    {
      lock();
      try
      {
        preWriteCleanup();
        
        int newCount = count - 1;
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
            V entryValue = valueReference.get();
            MapMaker.RemovalCause cause;
            if (entryValue != null)
            {
              cause = MapMaker.RemovalCause.EXPLICIT;
            }
            else
            {
              MapMaker.RemovalCause cause;
              if (isCollected(valueReference)) {
                cause = MapMaker.RemovalCause.COLLECTED;
              } else {
                return null;
              }
            }
            MapMaker.RemovalCause cause;
            modCount += 1;
            enqueueNotification(entryKey, hash, entryValue, cause);
            Object newFirst = removeFromChain(first, e);
            newCount = count - 1;
            table.set(index, newFirst);
            count = newCount;
            return entryValue;
          }
        }
        return null;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    boolean remove(Object key, int hash, Object value)
    {
      lock();
      try
      {
        preWriteCleanup();
        
        int newCount = count - 1;
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
            V entryValue = valueReference.get();
            MapMaker.RemovalCause cause;
            if (map.valueEquivalence.equivalent(value, entryValue))
            {
              cause = MapMaker.RemovalCause.EXPLICIT;
            }
            else
            {
              MapMaker.RemovalCause cause;
              if (isCollected(valueReference)) {
                cause = MapMaker.RemovalCause.COLLECTED;
              } else {
                return false;
              }
            }
            MapMaker.RemovalCause cause;
            modCount += 1;
            enqueueNotification(entryKey, hash, entryValue, cause);
            Object newFirst = removeFromChain(first, e);
            newCount = count - 1;
            table.set(index, newFirst);
            count = newCount;
            return cause == MapMaker.RemovalCause.EXPLICIT;
          }
        }
        return 0;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    void clear()
    {
      if (count != 0)
      {
        lock();
        try
        {
          AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
          if (map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
            for (int i = 0; i < table.length(); i++) {
              for (MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)table.get(i); e != null; e = e.getNext()) {
                if (!e.getValueReference().isComputingReference()) {
                  enqueueNotification(e, MapMaker.RemovalCause.EXPLICIT);
                }
              }
            }
          }
          for (int i = 0; i < table.length(); i++) {
            table.set(i, null);
          }
          clearReferenceQueues();
          evictionQueue.clear();
          expirationQueue.clear();
          readCount.set(0);
          
          modCount += 1;
          count = 0;
        }
        finally
        {
          unlock();
          postWriteCleanup();
        }
      }
    }
    
    @GuardedBy("Segment.this")
    MapMakerInternalMap.ReferenceEntry<K, V> removeFromChain(MapMakerInternalMap.ReferenceEntry<K, V> first, MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      evictionQueue.remove(entry);
      expirationQueue.remove(entry);
      
      int newCount = count;
      MapMakerInternalMap.ReferenceEntry<K, V> newFirst = entry.getNext();
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != entry; e = e.getNext())
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = copyEntry(e, newFirst);
        if (next != null)
        {
          newFirst = next;
        }
        else
        {
          removeCollectedEntry(e);
          newCount--;
        }
      }
      count = newCount;
      return newFirst;
    }
    
    void removeCollectedEntry(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      enqueueNotification(entry, MapMaker.RemovalCause.COLLECTED);
      evictionQueue.remove(entry);
      expirationQueue.remove(entry);
    }
    
    boolean reclaimKey(MapMakerInternalMap.ReferenceEntry<K, V> entry, int hash)
    {
      lock();
      try
      {
        int newCount = count - 1;
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
          if (e == entry)
          {
            modCount += 1;
            enqueueNotification(e.getKey(), hash, e.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
            
            MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
            newCount = count - 1;
            table.set(index, newFirst);
            count = newCount;
            return true;
          }
        }
        return 0;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    boolean reclaimValue(K key, int hash, MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      lock();
      try
      {
        int newCount = count - 1;
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> v = e.getValueReference();
            MapMakerInternalMap.ReferenceEntry<K, V> newFirst;
            if (v == valueReference)
            {
              modCount += 1;
              enqueueNotification(key, hash, valueReference.get(), MapMaker.RemovalCause.COLLECTED);
              newFirst = removeFromChain(first, e);
              newCount = count - 1;
              table.set(index, newFirst);
              count = newCount;
              return true;
            }
            return 0;
          }
        }
        return 0;
      }
      finally
      {
        unlock();
        if (!isHeldByCurrentThread()) {
          postWriteCleanup();
        }
      }
    }
    
    boolean clearValue(K key, int hash, MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      lock();
      try
      {
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        int index = hash & table.length() - 1;
        MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
        for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
        {
          K entryKey = e.getKey();
          if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
          {
            MapMakerInternalMap.ValueReference<K, V> v = e.getValueReference();
            MapMakerInternalMap.ReferenceEntry<K, V> newFirst;
            if (v == valueReference)
            {
              newFirst = removeFromChain(first, e);
              table.set(index, newFirst);
              return true;
            }
            return 0;
          }
        }
        return 0;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
    
    @GuardedBy("Segment.this")
    boolean removeEntry(MapMakerInternalMap.ReferenceEntry<K, V> entry, int hash, MapMaker.RemovalCause cause)
    {
      int newCount = count - 1;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
        if (e == entry)
        {
          modCount += 1;
          enqueueNotification(e.getKey(), hash, e.getValueReference().get(), cause);
          MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
          newCount = count - 1;
          table.set(index, newFirst);
          count = newCount;
          return true;
        }
      }
      return false;
    }
    
    boolean isCollected(MapMakerInternalMap.ValueReference<K, V> valueReference)
    {
      if (valueReference.isComputingReference()) {
        return false;
      }
      return valueReference.get() == null;
    }
    
    V getLiveValue(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      if (entry.getKey() == null)
      {
        tryDrainReferenceQueues();
        return null;
      }
      V value = entry.getValueReference().get();
      if (value == null)
      {
        tryDrainReferenceQueues();
        return null;
      }
      if ((map.expires()) && (map.isExpired(entry)))
      {
        tryExpireEntries();
        return null;
      }
      return value;
    }
    
    void postReadCleanup()
    {
      if ((readCount.incrementAndGet() & 0x3F) == 0) {
        runCleanup();
      }
    }
    
    @GuardedBy("Segment.this")
    void preWriteCleanup()
    {
      runLockedCleanup();
    }
    
    void postWriteCleanup()
    {
      runUnlockedCleanup();
    }
    
    void runCleanup()
    {
      runLockedCleanup();
      runUnlockedCleanup();
    }
    
    void runLockedCleanup()
    {
      if (tryLock()) {
        try
        {
          drainReferenceQueues();
          expireEntries();
          readCount.set(0);
        }
        finally
        {
          unlock();
        }
      }
    }
    
    void runUnlockedCleanup()
    {
      if (!isHeldByCurrentThread()) {
        map.processPendingNotifications();
      }
    }
  }
  
  static final class EvictionQueue<K, V>
    extends AbstractQueue<MapMakerInternalMap.ReferenceEntry<K, V>>
  {
    final MapMakerInternalMap.ReferenceEntry<K, V> head = new MapMakerInternalMap.AbstractReferenceEntry()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = this;
      
      public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
      {
        return nextEvictable;
      }
      
      public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
      {
        nextEvictable = next;
      }
      
      MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = this;
      
      public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
      {
        return previousEvictable;
      }
      
      public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
      {
        previousEvictable = previous;
      }
    };
    
    public boolean offer(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      MapMakerInternalMap.connectEvictables(entry.getPreviousEvictable(), entry.getNextEvictable());
      
      MapMakerInternalMap.connectEvictables(head.getPreviousEvictable(), entry);
      MapMakerInternalMap.connectEvictables(entry, head);
      
      return true;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> peek()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextEvictable();
      return next == head ? null : next;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> poll()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextEvictable();
      if (next == head) {
        return null;
      }
      remove(next);
      return next;
    }
    
    public boolean remove(Object o)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
      MapMakerInternalMap.ReferenceEntry<K, V> previous = e.getPreviousEvictable();
      MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextEvictable();
      MapMakerInternalMap.connectEvictables(previous, next);
      MapMakerInternalMap.nullifyEvictable(e);
      
      return next != MapMakerInternalMap.NullEntry.INSTANCE;
    }
    
    public boolean contains(Object o)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
      return e.getNextEvictable() != MapMakerInternalMap.NullEntry.INSTANCE;
    }
    
    public boolean isEmpty()
    {
      return head.getNextEvictable() == head;
    }
    
    public int size()
    {
      int size = 0;
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextEvictable(); e != head; e = e.getNextEvictable()) {
        size++;
      }
      return size;
    }
    
    public void clear()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextEvictable();
      while (e != head)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextEvictable();
        MapMakerInternalMap.nullifyEvictable(e);
        e = next;
      }
      head.setNextEvictable(head);
      head.setPreviousEvictable(head);
    }
    
    public Iterator<MapMakerInternalMap.ReferenceEntry<K, V>> iterator()
    {
      new AbstractSequentialIterator(peek())
      {
        protected MapMakerInternalMap.ReferenceEntry<K, V> computeNext(MapMakerInternalMap.ReferenceEntry<K, V> previous)
        {
          MapMakerInternalMap.ReferenceEntry<K, V> next = previous.getNextEvictable();
          return next == head ? null : next;
        }
      };
    }
  }
  
  static final class ExpirationQueue<K, V>
    extends AbstractQueue<MapMakerInternalMap.ReferenceEntry<K, V>>
  {
    final MapMakerInternalMap.ReferenceEntry<K, V> head = new MapMakerInternalMap.AbstractReferenceEntry()
    {
      public long getExpirationTime()
      {
        return Long.MAX_VALUE;
      }
      
      MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = this;
      
      public void setExpirationTime(long time) {}
      
      public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
      {
        return nextExpirable;
      }
      
      public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
      {
        nextExpirable = next;
      }
      
      MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = this;
      
      public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
      {
        return previousExpirable;
      }
      
      public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
      {
        previousExpirable = previous;
      }
    };
    
    public boolean offer(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      MapMakerInternalMap.connectExpirables(entry.getPreviousExpirable(), entry.getNextExpirable());
      
      MapMakerInternalMap.connectExpirables(head.getPreviousExpirable(), entry);
      MapMakerInternalMap.connectExpirables(entry, head);
      
      return true;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> peek()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextExpirable();
      return next == head ? null : next;
    }
    
    public MapMakerInternalMap.ReferenceEntry<K, V> poll()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextExpirable();
      if (next == head) {
        return null;
      }
      remove(next);
      return next;
    }
    
    public boolean remove(Object o)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
      MapMakerInternalMap.ReferenceEntry<K, V> previous = e.getPreviousExpirable();
      MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextExpirable();
      MapMakerInternalMap.connectExpirables(previous, next);
      MapMakerInternalMap.nullifyExpirable(e);
      
      return next != MapMakerInternalMap.NullEntry.INSTANCE;
    }
    
    public boolean contains(Object o)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
      return e.getNextExpirable() != MapMakerInternalMap.NullEntry.INSTANCE;
    }
    
    public boolean isEmpty()
    {
      return head.getNextExpirable() == head;
    }
    
    public int size()
    {
      int size = 0;
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextExpirable(); e != head; e = e.getNextExpirable()) {
        size++;
      }
      return size;
    }
    
    public void clear()
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextExpirable();
      while (e != head)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextExpirable();
        MapMakerInternalMap.nullifyExpirable(e);
        e = next;
      }
      head.setNextExpirable(head);
      head.setPreviousExpirable(head);
    }
    
    public Iterator<MapMakerInternalMap.ReferenceEntry<K, V>> iterator()
    {
      new AbstractSequentialIterator(peek())
      {
        protected MapMakerInternalMap.ReferenceEntry<K, V> computeNext(MapMakerInternalMap.ReferenceEntry<K, V> previous)
        {
          MapMakerInternalMap.ReferenceEntry<K, V> next = previous.getNextExpirable();
          return next == head ? null : next;
        }
      };
    }
  }
  
  static final class CleanupMapTask
    implements Runnable
  {
    final WeakReference<MapMakerInternalMap<?, ?>> mapReference;
    
    public CleanupMapTask(MapMakerInternalMap<?, ?> map)
    {
      mapReference = new WeakReference(map);
    }
    
    public void run()
    {
      MapMakerInternalMap<?, ?> map = (MapMakerInternalMap)mapReference.get();
      if (map == null) {
        throw new CancellationException();
      }
      for (MapMakerInternalMap.Segment<?, ?> segment : segments) {
        segment.runCleanup();
      }
    }
  }
  
  public boolean isEmpty()
  {
    long sum = 0L;
    Segment<K, V>[] segments = this.segments;
    for (int i = 0; i < segments.length; i++)
    {
      if (count != 0) {
        return false;
      }
      sum += modCount;
    }
    if (sum != 0L)
    {
      for (int i = 0; i < segments.length; i++)
      {
        if (count != 0) {
          return false;
        }
        sum -= modCount;
      }
      if (sum != 0L) {
        return false;
      }
    }
    return true;
  }
  
  public int size()
  {
    Segment<K, V>[] segments = this.segments;
    long sum = 0L;
    for (int i = 0; i < segments.length; i++) {
      sum += count;
    }
    return Ints.saturatedCast(sum);
  }
  
  public V get(@Nullable Object key)
  {
    if (key == null) {
      return null;
    }
    int hash = hash(key);
    return (V)segmentFor(hash).get(key, hash);
  }
  
  ReferenceEntry<K, V> getEntry(@Nullable Object key)
  {
    if (key == null) {
      return null;
    }
    int hash = hash(key);
    return segmentFor(hash).getEntry(key, hash);
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    if (key == null) {
      return false;
    }
    int hash = hash(key);
    return segmentFor(hash).containsKey(key, hash);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    if (value == null) {
      return false;
    }
    Segment<K, V>[] segments = this.segments;
    long last = -1L;
    for (int i = 0; i < 3; i++)
    {
      long sum = 0L;
      for (Segment<K, V> segment : segments)
      {
        int c = count;
        
        AtomicReferenceArray<ReferenceEntry<K, V>> table = table;
        for (int j = 0; j < table.length(); j++) {
          for (ReferenceEntry<K, V> e = (ReferenceEntry)table.get(j); e != null; e = e.getNext())
          {
            V v = segment.getLiveValue(e);
            if ((v != null) && (valueEquivalence.equivalent(value, v))) {
              return true;
            }
          }
        }
        sum += modCount;
      }
      if (sum == last) {
        break;
      }
      last = sum;
    }
    return false;
  }
  
  public V put(K key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    int hash = hash(key);
    return (V)segmentFor(hash).put(key, hash, value, false);
  }
  
  public V putIfAbsent(K key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    int hash = hash(key);
    return (V)segmentFor(hash).put(key, hash, value, true);
  }
  
  public void putAll(Map<? extends K, ? extends V> m)
  {
    for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
      put(e.getKey(), e.getValue());
    }
  }
  
  public V remove(@Nullable Object key)
  {
    if (key == null) {
      return null;
    }
    int hash = hash(key);
    return (V)segmentFor(hash).remove(key, hash);
  }
  
  public boolean remove(@Nullable Object key, @Nullable Object value)
  {
    if ((key == null) || (value == null)) {
      return false;
    }
    int hash = hash(key);
    return segmentFor(hash).remove(key, hash, value);
  }
  
  public boolean replace(K key, @Nullable V oldValue, V newValue)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(newValue);
    if (oldValue == null) {
      return false;
    }
    int hash = hash(key);
    return segmentFor(hash).replace(key, hash, oldValue, newValue);
  }
  
  public V replace(K key, V value)
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(value);
    int hash = hash(key);
    return (V)segmentFor(hash).replace(key, hash, value);
  }
  
  public void clear()
  {
    for (Segment<K, V> segment : segments) {
      segment.clear();
    }
  }
  
  public Set<K> keySet()
  {
    Set<K> ks = keySet;
    return ks != null ? ks : (keySet = new KeySet());
  }
  
  public Collection<V> values()
  {
    Collection<V> vs = values;
    return vs != null ? vs : (values = new Values());
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set<Map.Entry<K, V>> es = entrySet;
    return es != null ? es : (entrySet = new EntrySet());
  }
  
  abstract class HashIterator<E>
    implements Iterator<E>
  {
    int nextSegmentIndex;
    int nextTableIndex;
    MapMakerInternalMap.Segment<K, V> currentSegment;
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> currentTable;
    MapMakerInternalMap.ReferenceEntry<K, V> nextEntry;
    MapMakerInternalMap<K, V>.WriteThroughEntry nextExternal;
    MapMakerInternalMap<K, V>.WriteThroughEntry lastReturned;
    
    HashIterator()
    {
      nextSegmentIndex = (segments.length - 1);
      nextTableIndex = -1;
      advance();
    }
    
    public abstract E next();
    
    final void advance()
    {
      nextExternal = null;
      if (nextInChain()) {
        return;
      }
      if (nextInTable()) {
        return;
      }
      while (nextSegmentIndex >= 0)
      {
        currentSegment = segments[(nextSegmentIndex--)];
        if (currentSegment.count != 0)
        {
          currentTable = currentSegment.table;
          nextTableIndex = (currentTable.length() - 1);
          if (nextInTable()) {}
        }
      }
    }
    
    boolean nextInChain()
    {
      if (nextEntry != null) {
        for (nextEntry = nextEntry.getNext(); nextEntry != null; nextEntry = nextEntry.getNext()) {
          if (advanceTo(nextEntry)) {
            return true;
          }
        }
      }
      return false;
    }
    
    boolean nextInTable()
    {
      while (nextTableIndex >= 0) {
        if (((nextEntry = (MapMakerInternalMap.ReferenceEntry)currentTable.get(nextTableIndex--)) != null) && (
          (advanceTo(nextEntry)) || (nextInChain()))) {
          return true;
        }
      }
      return false;
    }
    
    boolean advanceTo(MapMakerInternalMap.ReferenceEntry<K, V> entry)
    {
      try
      {
        K key = entry.getKey();
        V value = getLiveValue(entry);
        boolean bool;
        if (value != null)
        {
          nextExternal = new MapMakerInternalMap.WriteThroughEntry(MapMakerInternalMap.this, key, value);
          return true;
        }
        return false;
      }
      finally
      {
        currentSegment.postReadCleanup();
      }
    }
    
    public boolean hasNext()
    {
      return nextExternal != null;
    }
    
    MapMakerInternalMap<K, V>.WriteThroughEntry nextEntry()
    {
      if (nextExternal == null) {
        throw new NoSuchElementException();
      }
      lastReturned = nextExternal;
      advance();
      return lastReturned;
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(lastReturned != null);
      remove(lastReturned.getKey());
      lastReturned = null;
    }
  }
  
  final class KeyIterator
    extends MapMakerInternalMap<K, V>.HashIterator<K>
  {
    KeyIterator()
    {
      super();
    }
    
    public K next()
    {
      return (K)nextEntry().getKey();
    }
  }
  
  final class ValueIterator
    extends MapMakerInternalMap<K, V>.HashIterator<V>
  {
    ValueIterator()
    {
      super();
    }
    
    public V next()
    {
      return (V)nextEntry().getValue();
    }
  }
  
  final class WriteThroughEntry
    extends AbstractMapEntry<K, V>
  {
    final K key;
    V value;
    
    WriteThroughEntry(V key)
    {
      this.key = key;
      this.value = value;
    }
    
    public K getKey()
    {
      return (K)key;
    }
    
    public V getValue()
    {
      return (V)value;
    }
    
    public boolean equals(@Nullable Object object)
    {
      if ((object instanceof Map.Entry))
      {
        Map.Entry<?, ?> that = (Map.Entry)object;
        return (key.equals(that.getKey())) && (value.equals(that.getValue()));
      }
      return false;
    }
    
    public int hashCode()
    {
      return key.hashCode() ^ value.hashCode();
    }
    
    public V setValue(V newValue)
    {
      V oldValue = put(key, newValue);
      value = newValue;
      return oldValue;
    }
  }
  
  final class EntryIterator
    extends MapMakerInternalMap<K, V>.HashIterator<Map.Entry<K, V>>
  {
    EntryIterator()
    {
      super();
    }
    
    public Map.Entry<K, V> next()
    {
      return nextEntry();
    }
  }
  
  final class KeySet
    extends AbstractSet<K>
  {
    KeySet() {}
    
    public Iterator<K> iterator()
    {
      return new MapMakerInternalMap.KeyIterator(MapMakerInternalMap.this);
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public boolean contains(Object o)
    {
      return containsKey(o);
    }
    
    public boolean remove(Object o)
    {
      return remove(o) != null;
    }
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
  }
  
  final class Values
    extends AbstractCollection<V>
  {
    Values() {}
    
    public Iterator<V> iterator()
    {
      return new MapMakerInternalMap.ValueIterator(MapMakerInternalMap.this);
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public boolean contains(Object o)
    {
      return containsValue(o);
    }
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
  }
  
  final class EntrySet
    extends AbstractSet<Map.Entry<K, V>>
  {
    EntrySet() {}
    
    public Iterator<Map.Entry<K, V>> iterator()
    {
      return new MapMakerInternalMap.EntryIterator(MapMakerInternalMap.this);
    }
    
    public boolean contains(Object o)
    {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      Map.Entry<?, ?> e = (Map.Entry)o;
      Object key = e.getKey();
      if (key == null) {
        return false;
      }
      V v = get(key);
      
      return (v != null) && (valueEquivalence.equivalent(e.getValue(), v));
    }
    
    public boolean remove(Object o)
    {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      Map.Entry<?, ?> e = (Map.Entry)o;
      Object key = e.getKey();
      return (key != null) && (remove(key, e.getValue()));
    }
    
    public int size()
    {
      return MapMakerInternalMap.this.size();
    }
    
    public boolean isEmpty()
    {
      return MapMakerInternalMap.this.isEmpty();
    }
    
    public void clear()
    {
      MapMakerInternalMap.this.clear();
    }
  }
  
  Object writeReplace()
  {
    return new SerializationProxy(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, this);
  }
  
  static abstract class AbstractSerializationProxy<K, V>
    extends ForwardingConcurrentMap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 3L;
    final MapMakerInternalMap.Strength keyStrength;
    final MapMakerInternalMap.Strength valueStrength;
    final Equivalence<Object> keyEquivalence;
    final Equivalence<Object> valueEquivalence;
    final long expireAfterWriteNanos;
    final long expireAfterAccessNanos;
    final int maximumSize;
    final int concurrencyLevel;
    final MapMaker.RemovalListener<? super K, ? super V> removalListener;
    transient ConcurrentMap<K, V> delegate;
    
    AbstractSerializationProxy(MapMakerInternalMap.Strength keyStrength, MapMakerInternalMap.Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, int maximumSize, int concurrencyLevel, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> delegate)
    {
      this.keyStrength = keyStrength;
      this.valueStrength = valueStrength;
      this.keyEquivalence = keyEquivalence;
      this.valueEquivalence = valueEquivalence;
      this.expireAfterWriteNanos = expireAfterWriteNanos;
      this.expireAfterAccessNanos = expireAfterAccessNanos;
      this.maximumSize = maximumSize;
      this.concurrencyLevel = concurrencyLevel;
      this.removalListener = removalListener;
      this.delegate = delegate;
    }
    
    protected ConcurrentMap<K, V> delegate()
    {
      return delegate;
    }
    
    void writeMapTo(ObjectOutputStream out)
      throws IOException
    {
      out.writeInt(delegate.size());
      for (Map.Entry<K, V> entry : delegate.entrySet())
      {
        out.writeObject(entry.getKey());
        out.writeObject(entry.getValue());
      }
      out.writeObject(null);
    }
    
    MapMaker readMapMaker(ObjectInputStream in)
      throws IOException
    {
      int size = in.readInt();
      MapMaker mapMaker = new MapMaker().initialCapacity(size).setKeyStrength(keyStrength).setValueStrength(valueStrength).keyEquivalence(keyEquivalence).concurrencyLevel(concurrencyLevel);
      
      mapMaker.removalListener(removalListener);
      if (expireAfterWriteNanos > 0L) {
        mapMaker.expireAfterWrite(expireAfterWriteNanos, TimeUnit.NANOSECONDS);
      }
      if (expireAfterAccessNanos > 0L) {
        mapMaker.expireAfterAccess(expireAfterAccessNanos, TimeUnit.NANOSECONDS);
      }
      if (maximumSize != -1) {
        mapMaker.maximumSize(maximumSize);
      }
      return mapMaker;
    }
    
    void readEntries(ObjectInputStream in)
      throws IOException, ClassNotFoundException
    {
      for (;;)
      {
        K key = in.readObject();
        if (key == null) {
          break;
        }
        V value = in.readObject();
        delegate.put(key, value);
      }
    }
  }
  
  private static final class SerializationProxy<K, V>
    extends MapMakerInternalMap.AbstractSerializationProxy<K, V>
  {
    private static final long serialVersionUID = 3L;
    
    SerializationProxy(MapMakerInternalMap.Strength keyStrength, MapMakerInternalMap.Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, int maximumSize, int concurrencyLevel, MapMaker.RemovalListener<? super K, ? super V> removalListener, ConcurrentMap<K, V> delegate)
    {
      super(valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maximumSize, concurrencyLevel, removalListener, delegate);
    }
    
    private void writeObject(ObjectOutputStream out)
      throws IOException
    {
      out.defaultWriteObject();
      writeMapTo(out);
    }
    
    private void readObject(ObjectInputStream in)
      throws IOException, ClassNotFoundException
    {
      in.defaultReadObject();
      MapMaker mapMaker = readMapMaker(in);
      delegate = mapMaker.makeMap();
      readEntries(in);
    }
    
    private Object readResolve()
    {
      return delegate;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */