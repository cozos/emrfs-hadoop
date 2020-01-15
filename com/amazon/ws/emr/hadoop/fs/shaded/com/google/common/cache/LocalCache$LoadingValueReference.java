package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Stopwatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.SettableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class LocalCache$LoadingValueReference<K, V>
  implements LocalCache.ValueReference<K, V>
{
  volatile LocalCache.ValueReference<K, V> oldValue;
  final SettableFuture<V> futureValue = SettableFuture.create();
  final Stopwatch stopwatch = Stopwatch.createUnstarted();
  
  public LocalCache$LoadingValueReference()
  {
    this(LocalCache.unset());
  }
  
  public LocalCache$LoadingValueReference(LocalCache.ValueReference<K, V> oldValue)
  {
    this.oldValue = oldValue;
  }
  
  public boolean isLoading()
  {
    return true;
  }
  
  public boolean isActive()
  {
    return oldValue.isActive();
  }
  
  public int getWeight()
  {
    return oldValue.getWeight();
  }
  
  public boolean set(@Nullable V newValue)
  {
    return futureValue.set(newValue);
  }
  
  public boolean setException(Throwable t)
  {
    return futureValue.setException(t);
  }
  
  private ListenableFuture<V> fullyFailedFuture(Throwable t)
  {
    return Futures.immediateFailedFuture(t);
  }
  
  public void notifyNewValue(@Nullable V newValue)
  {
    if (newValue != null) {
      set(newValue);
    } else {
      oldValue = LocalCache.unset();
    }
  }
  
  public ListenableFuture<V> loadFuture(K key, CacheLoader<? super K, V> loader)
  {
    stopwatch.start();
    V previousValue = oldValue.get();
    try
    {
      if (previousValue == null)
      {
        V newValue = loader.load(key);
        return set(newValue) ? futureValue : Futures.immediateFuture(newValue);
      }
      ListenableFuture<V> newValue = loader.reload(key, previousValue);
      if (newValue == null) {
        return Futures.immediateFuture(null);
      }
      Futures.transform(newValue, new Function()
      {
        public V apply(V newValue)
        {
          set(newValue);
          return newValue;
        }
      });
    }
    catch (Throwable t)
    {
      if ((t instanceof InterruptedException)) {
        Thread.currentThread().interrupt();
      }
      return setException(t) ? futureValue : fullyFailedFuture(t);
    }
  }
  
  public long elapsedNanos()
  {
    return stopwatch.elapsed(TimeUnit.NANOSECONDS);
  }
  
  public V waitForValue()
    throws ExecutionException
  {
    return (V)Uninterruptibles.getUninterruptibly(futureValue);
  }
  
  public V get()
  {
    return (V)oldValue.get();
  }
  
  public LocalCache.ValueReference<K, V> getOldValue()
  {
    return oldValue;
  }
  
  public LocalCache.ReferenceEntry<K, V> getEntry()
  {
    return null;
  }
  
  public LocalCache.ValueReference<K, V> copyFor(ReferenceQueue<V> queue, @Nullable V value, LocalCache.ReferenceEntry<K, V> entry)
  {
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LoadingValueReference
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */