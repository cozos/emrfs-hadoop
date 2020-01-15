package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ascii;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.MoreObjects.ToStringHelper;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Throwables;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class MapMaker
  extends GenericMapMaker<Object, Object>
{
  private static final int DEFAULT_INITIAL_CAPACITY = 16;
  private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
  private static final int DEFAULT_EXPIRATION_NANOS = 0;
  static final int UNSET_INT = -1;
  boolean useCustomMap;
  int initialCapacity = -1;
  int concurrencyLevel = -1;
  int maximumSize = -1;
  MapMakerInternalMap.Strength keyStrength;
  MapMakerInternalMap.Strength valueStrength;
  long expireAfterWriteNanos = -1L;
  long expireAfterAccessNanos = -1L;
  RemovalCause nullRemovalCause;
  Equivalence<Object> keyEquivalence;
  Ticker ticker;
  
  @GwtIncompatible("To be supported")
  MapMaker keyEquivalence(Equivalence<Object> equivalence)
  {
    Preconditions.checkState(keyEquivalence == null, "key equivalence was already set to %s", new Object[] { keyEquivalence });
    keyEquivalence = ((Equivalence)Preconditions.checkNotNull(equivalence));
    useCustomMap = true;
    return this;
  }
  
  Equivalence<Object> getKeyEquivalence()
  {
    return (Equivalence)MoreObjects.firstNonNull(keyEquivalence, getKeyStrength().defaultEquivalence());
  }
  
  public MapMaker initialCapacity(int initialCapacity)
  {
    Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", new Object[] { Integer.valueOf(this.initialCapacity) });
    
    Preconditions.checkArgument(initialCapacity >= 0);
    this.initialCapacity = initialCapacity;
    return this;
  }
  
  int getInitialCapacity()
  {
    return initialCapacity == -1 ? 16 : initialCapacity;
  }
  
  @Deprecated
  MapMaker maximumSize(int size)
  {
    Preconditions.checkState(maximumSize == -1, "maximum size was already set to %s", new Object[] { Integer.valueOf(maximumSize) });
    
    Preconditions.checkArgument(size >= 0, "maximum size must not be negative");
    maximumSize = size;
    useCustomMap = true;
    if (maximumSize == 0) {
      nullRemovalCause = RemovalCause.SIZE;
    }
    return this;
  }
  
  public MapMaker concurrencyLevel(int concurrencyLevel)
  {
    Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", new Object[] { Integer.valueOf(this.concurrencyLevel) });
    
    Preconditions.checkArgument(concurrencyLevel > 0);
    this.concurrencyLevel = concurrencyLevel;
    return this;
  }
  
  int getConcurrencyLevel()
  {
    return concurrencyLevel == -1 ? 4 : concurrencyLevel;
  }
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public MapMaker weakKeys()
  {
    return setKeyStrength(MapMakerInternalMap.Strength.WEAK);
  }
  
  MapMaker setKeyStrength(MapMakerInternalMap.Strength strength)
  {
    Preconditions.checkState(keyStrength == null, "Key strength was already set to %s", new Object[] { keyStrength });
    keyStrength = ((MapMakerInternalMap.Strength)Preconditions.checkNotNull(strength));
    Preconditions.checkArgument(keyStrength != MapMakerInternalMap.Strength.SOFT, "Soft keys are not supported");
    if (strength != MapMakerInternalMap.Strength.STRONG) {
      useCustomMap = true;
    }
    return this;
  }
  
  MapMakerInternalMap.Strength getKeyStrength()
  {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(keyStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  @GwtIncompatible("java.lang.ref.WeakReference")
  public MapMaker weakValues()
  {
    return setValueStrength(MapMakerInternalMap.Strength.WEAK);
  }
  
  @Deprecated
  @GwtIncompatible("java.lang.ref.SoftReference")
  public MapMaker softValues()
  {
    return setValueStrength(MapMakerInternalMap.Strength.SOFT);
  }
  
  MapMaker setValueStrength(MapMakerInternalMap.Strength strength)
  {
    Preconditions.checkState(valueStrength == null, "Value strength was already set to %s", new Object[] { valueStrength });
    valueStrength = ((MapMakerInternalMap.Strength)Preconditions.checkNotNull(strength));
    if (strength != MapMakerInternalMap.Strength.STRONG) {
      useCustomMap = true;
    }
    return this;
  }
  
  MapMakerInternalMap.Strength getValueStrength()
  {
    return (MapMakerInternalMap.Strength)MoreObjects.firstNonNull(valueStrength, MapMakerInternalMap.Strength.STRONG);
  }
  
  @Deprecated
  MapMaker expireAfterWrite(long duration, TimeUnit unit)
  {
    checkExpiration(duration, unit);
    expireAfterWriteNanos = unit.toNanos(duration);
    if ((duration == 0L) && (nullRemovalCause == null)) {
      nullRemovalCause = RemovalCause.EXPIRED;
    }
    useCustomMap = true;
    return this;
  }
  
  private void checkExpiration(long duration, TimeUnit unit)
  {
    Preconditions.checkState(expireAfterWriteNanos == -1L, "expireAfterWrite was already set to %s ns", new Object[] { Long.valueOf(expireAfterWriteNanos) });
    
    Preconditions.checkState(expireAfterAccessNanos == -1L, "expireAfterAccess was already set to %s ns", new Object[] { Long.valueOf(expireAfterAccessNanos) });
    
    Preconditions.checkArgument(duration >= 0L, "duration cannot be negative: %s %s", new Object[] { Long.valueOf(duration), unit });
  }
  
  long getExpireAfterWriteNanos()
  {
    return expireAfterWriteNanos == -1L ? 0L : expireAfterWriteNanos;
  }
  
  @Deprecated
  @GwtIncompatible("To be supported")
  MapMaker expireAfterAccess(long duration, TimeUnit unit)
  {
    checkExpiration(duration, unit);
    expireAfterAccessNanos = unit.toNanos(duration);
    if ((duration == 0L) && (nullRemovalCause == null)) {
      nullRemovalCause = RemovalCause.EXPIRED;
    }
    useCustomMap = true;
    return this;
  }
  
  long getExpireAfterAccessNanos()
  {
    return expireAfterAccessNanos == -1L ? 0L : expireAfterAccessNanos;
  }
  
  Ticker getTicker()
  {
    return (Ticker)MoreObjects.firstNonNull(ticker, Ticker.systemTicker());
  }
  
  @Deprecated
  @GwtIncompatible("To be supported")
  <K, V> GenericMapMaker<K, V> removalListener(RemovalListener<K, V> listener)
  {
    Preconditions.checkState(removalListener == null);
    
    GenericMapMaker<K, V> me = this;
    removalListener = ((RemovalListener)Preconditions.checkNotNull(listener));
    useCustomMap = true;
    return me;
  }
  
  public <K, V> ConcurrentMap<K, V> makeMap()
  {
    if (!useCustomMap) {
      return new ConcurrentHashMap(getInitialCapacity(), 0.75F, getConcurrencyLevel());
    }
    return (ConcurrentMap)(nullRemovalCause == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this));
  }
  
  @GwtIncompatible("MapMakerInternalMap")
  <K, V> MapMakerInternalMap<K, V> makeCustomMap()
  {
    return new MapMakerInternalMap(this);
  }
  
  @Deprecated
  <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> computingFunction)
  {
    return (ConcurrentMap)(nullRemovalCause == null ? new ComputingMapAdapter(this, computingFunction) : new NullComputingConcurrentMap(this, computingFunction));
  }
  
  public String toString()
  {
    MoreObjects.ToStringHelper s = MoreObjects.toStringHelper(this);
    if (initialCapacity != -1) {
      s.add("initialCapacity", initialCapacity);
    }
    if (concurrencyLevel != -1) {
      s.add("concurrencyLevel", concurrencyLevel);
    }
    if (maximumSize != -1) {
      s.add("maximumSize", maximumSize);
    }
    long l;
    if (expireAfterWriteNanos != -1L)
    {
      l = expireAfterWriteNanos;s.add("expireAfterWrite", 22 + l + "ns");
    }
    if (expireAfterAccessNanos != -1L)
    {
      l = expireAfterAccessNanos;s.add("expireAfterAccess", 22 + l + "ns");
    }
    if (keyStrength != null) {
      s.add("keyStrength", Ascii.toLowerCase(keyStrength.toString()));
    }
    if (valueStrength != null) {
      s.add("valueStrength", Ascii.toLowerCase(valueStrength.toString()));
    }
    if (keyEquivalence != null) {
      s.addValue("keyEquivalence");
    }
    if (removalListener != null) {
      s.addValue("removalListener");
    }
    return s.toString();
  }
  
  static abstract interface RemovalListener<K, V>
  {
    public abstract void onRemoval(MapMaker.RemovalNotification<K, V> paramRemovalNotification);
  }
  
  static final class RemovalNotification<K, V>
    extends ImmutableEntry<K, V>
  {
    private static final long serialVersionUID = 0L;
    private final MapMaker.RemovalCause cause;
    
    RemovalNotification(@Nullable K key, @Nullable V value, MapMaker.RemovalCause cause)
    {
      super(value);
      this.cause = cause;
    }
    
    public MapMaker.RemovalCause getCause()
    {
      return cause;
    }
    
    public boolean wasEvicted()
    {
      return cause.wasEvicted();
    }
  }
  
  static abstract enum RemovalCause
  {
    EXPLICIT,  REPLACED,  COLLECTED,  EXPIRED,  SIZE;
    
    private RemovalCause() {}
    
    abstract boolean wasEvicted();
  }
  
  static class NullConcurrentMap<K, V>
    extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>, Serializable
  {
    private static final long serialVersionUID = 0L;
    private final MapMaker.RemovalListener<K, V> removalListener;
    private final MapMaker.RemovalCause removalCause;
    
    NullConcurrentMap(MapMaker mapMaker)
    {
      removalListener = mapMaker.getRemovalListener();
      removalCause = nullRemovalCause;
    }
    
    public boolean containsKey(@Nullable Object key)
    {
      return false;
    }
    
    public boolean containsValue(@Nullable Object value)
    {
      return false;
    }
    
    public V get(@Nullable Object key)
    {
      return null;
    }
    
    void notifyRemoval(K key, V value)
    {
      MapMaker.RemovalNotification<K, V> notification = new MapMaker.RemovalNotification(key, value, removalCause);
      
      removalListener.onRemoval(notification);
    }
    
    public V put(K key, V value)
    {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(value);
      notifyRemoval(key, value);
      return null;
    }
    
    public V putIfAbsent(K key, V value)
    {
      return (V)put(key, value);
    }
    
    public V remove(@Nullable Object key)
    {
      return null;
    }
    
    public boolean remove(@Nullable Object key, @Nullable Object value)
    {
      return false;
    }
    
    public V replace(K key, V value)
    {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(value);
      return null;
    }
    
    public boolean replace(K key, @Nullable V oldValue, V newValue)
    {
      Preconditions.checkNotNull(key);
      Preconditions.checkNotNull(newValue);
      return false;
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      return Collections.emptySet();
    }
  }
  
  static final class NullComputingConcurrentMap<K, V>
    extends MapMaker.NullConcurrentMap<K, V>
  {
    private static final long serialVersionUID = 0L;
    final Function<? super K, ? extends V> computingFunction;
    
    NullComputingConcurrentMap(MapMaker mapMaker, Function<? super K, ? extends V> computingFunction)
    {
      super();
      this.computingFunction = ((Function)Preconditions.checkNotNull(computingFunction));
    }
    
    public V get(Object k)
    {
      K key = (K)k;
      V value = compute(key);
      Preconditions.checkNotNull(value, "%s returned null for key %s.", new Object[] { computingFunction, key });
      notifyRemoval(key, value);
      return value;
    }
    
    private V compute(K key)
    {
      Preconditions.checkNotNull(key);
      try
      {
        return (V)computingFunction.apply(key);
      }
      catch (ComputationException e)
      {
        throw e;
      }
      catch (Throwable t)
      {
        throw new ComputationException(t);
      }
    }
  }
  
  static final class ComputingMapAdapter<K, V>
    extends ComputingConcurrentHashMap<K, V>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    
    ComputingMapAdapter(MapMaker mapMaker, Function<? super K, ? extends V> computingFunction)
    {
      super(computingFunction);
    }
    
    public V get(Object key)
    {
      V value;
      Throwable cause;
      try
      {
        value = getOrCompute(key);
      }
      catch (ExecutionException e)
      {
        cause = e.getCause();
        Throwables.propagateIfInstanceOf(cause, ComputationException.class);
        throw new ComputationException(cause);
      }
      if (value == null)
      {
        e = String.valueOf(String.valueOf(computingFunction));cause = String.valueOf(String.valueOf(key));throw new NullPointerException(24 + e.length() + cause.length() + e + " returned null for key " + cause + ".");
      }
      return value;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMaker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */