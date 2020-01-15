package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

class LocalCache$ManualSerializationProxy<K, V>
  extends ForwardingCache<K, V>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  final LocalCache.Strength keyStrength;
  final LocalCache.Strength valueStrength;
  final Equivalence<Object> keyEquivalence;
  final Equivalence<Object> valueEquivalence;
  final long expireAfterWriteNanos;
  final long expireAfterAccessNanos;
  final long maxWeight;
  final Weigher<K, V> weigher;
  final int concurrencyLevel;
  final RemovalListener<? super K, ? super V> removalListener;
  final Ticker ticker;
  final CacheLoader<? super K, V> loader;
  transient Cache<K, V> delegate;
  
  LocalCache$ManualSerializationProxy(LocalCache<K, V> cache)
  {
    this(keyStrength, valueStrength, keyEquivalence, valueEquivalence, expireAfterWriteNanos, expireAfterAccessNanos, maxWeight, weigher, concurrencyLevel, removalListener, ticker, defaultLoader);
  }
  
  private LocalCache$ManualSerializationProxy(LocalCache.Strength keyStrength, LocalCache.Strength valueStrength, Equivalence<Object> keyEquivalence, Equivalence<Object> valueEquivalence, long expireAfterWriteNanos, long expireAfterAccessNanos, long maxWeight, Weigher<K, V> weigher, int concurrencyLevel, RemovalListener<? super K, ? super V> removalListener, Ticker ticker, CacheLoader<? super K, V> loader)
  {
    this.keyStrength = keyStrength;
    this.valueStrength = valueStrength;
    this.keyEquivalence = keyEquivalence;
    this.valueEquivalence = valueEquivalence;
    this.expireAfterWriteNanos = expireAfterWriteNanos;
    this.expireAfterAccessNanos = expireAfterAccessNanos;
    this.maxWeight = maxWeight;
    this.weigher = weigher;
    this.concurrencyLevel = concurrencyLevel;
    this.removalListener = removalListener;
    this.ticker = ((ticker == Ticker.systemTicker()) || (ticker == CacheBuilder.NULL_TICKER) ? null : ticker);
    
    this.loader = loader;
  }
  
  CacheBuilder<K, V> recreateCacheBuilder()
  {
    CacheBuilder<K, V> builder = CacheBuilder.newBuilder().setKeyStrength(keyStrength).setValueStrength(valueStrength).keyEquivalence(keyEquivalence).valueEquivalence(valueEquivalence).concurrencyLevel(concurrencyLevel).removalListener(removalListener);
    
    strictParsing = false;
    if (expireAfterWriteNanos > 0L) {
      builder.expireAfterWrite(expireAfterWriteNanos, TimeUnit.NANOSECONDS);
    }
    if (expireAfterAccessNanos > 0L) {
      builder.expireAfterAccess(expireAfterAccessNanos, TimeUnit.NANOSECONDS);
    }
    if (weigher != CacheBuilder.OneWeigher.INSTANCE)
    {
      builder.weigher(weigher);
      if (maxWeight != -1L) {
        builder.maximumWeight(maxWeight);
      }
    }
    else if (maxWeight != -1L)
    {
      builder.maximumSize(maxWeight);
    }
    if (ticker != null) {
      builder.ticker(ticker);
    }
    return builder;
  }
  
  private void readObject(ObjectInputStream in)
    throws IOException, ClassNotFoundException
  {
    in.defaultReadObject();
    CacheBuilder<K, V> builder = recreateCacheBuilder();
    delegate = builder.build();
  }
  
  private Object readResolve()
  {
    return delegate;
  }
  
  protected Cache<K, V> delegate()
  {
    return delegate;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.ManualSerializationProxy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */