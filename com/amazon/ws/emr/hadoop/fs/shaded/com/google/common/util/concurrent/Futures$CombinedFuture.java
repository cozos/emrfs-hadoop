package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Optional;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableCollection;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Lists;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Sets;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

class Futures$CombinedFuture<V, C>
  extends AbstractFuture<C>
{
  private static final Logger logger = Logger.getLogger(CombinedFuture.class.getName());
  ImmutableCollection<? extends ListenableFuture<? extends V>> futures;
  final boolean allMustSucceed;
  final AtomicInteger remaining;
  Futures.FutureCombiner<V, C> combiner;
  List<Optional<V>> values;
  final Object seenExceptionsLock = new Object();
  Set<Throwable> seenExceptions;
  
  Futures$CombinedFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor, Futures.FutureCombiner<V, C> combiner)
  {
    this.futures = futures;
    this.allMustSucceed = allMustSucceed;
    remaining = new AtomicInteger(futures.size());
    this.combiner = combiner;
    values = Lists.newArrayListWithCapacity(futures.size());
    init(listenerExecutor);
  }
  
  protected void init(Executor listenerExecutor)
  {
    addListener(new Runnable()
    {
      public void run()
      {
        if (isCancelled()) {
          for (ListenableFuture<?> future : futures) {
            future.cancel(wasInterrupted());
          }
        }
        futures = null;
        
        values = null;
        
        combiner = null;
      }
    }, MoreExecutors.directExecutor());
    if (futures.isEmpty())
    {
      set(combiner.combine(ImmutableList.of()));
      return;
    }
    for (int i = 0; i < futures.size(); i++) {
      values.add(null);
    }
    int i = 0;
    for (final ListenableFuture<? extends V> listenable : futures)
    {
      final int index = i++;
      listenable.addListener(new Runnable()
      {
        public void run()
        {
          Futures.CombinedFuture.this.setOneValue(index, listenable);
        }
      }, listenerExecutor);
    }
  }
  
  private void setExceptionAndMaybeLog(Throwable throwable)
  {
    boolean visibleFromOutputFuture = false;
    boolean firstTimeSeeingThisException = true;
    if (allMustSucceed)
    {
      visibleFromOutputFuture = super.setException(throwable);
      synchronized (seenExceptionsLock)
      {
        if (seenExceptions == null) {
          seenExceptions = Sets.newHashSet();
        }
        firstTimeSeeingThisException = seenExceptions.add(throwable);
      }
    }
    if (((throwable instanceof Error)) || ((allMustSucceed) && (!visibleFromOutputFuture) && (firstTimeSeeingThisException))) {
      logger.log(Level.SEVERE, "input future failed.", throwable);
    }
  }
  
  private void setOneValue(int index, Future<? extends V> future)
  {
    List<Optional<V>> localValues = values;
    if ((isDone()) || (localValues == null)) {
      Preconditions.checkState((allMustSucceed) || (isCancelled()), "Future was done before all dependencies completed");
    }
    try
    {
      Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
      
      V returnValue = Uninterruptibles.getUninterruptibly(future);
      if (localValues != null) {
        localValues.set(index, Optional.fromNullable(returnValue));
      }
    }
    catch (CancellationException e)
    {
      int newRemaining;
      Futures.FutureCombiner<V, C> localCombiner;
      if (allMustSucceed) {
        cancel(false);
      }
    }
    catch (ExecutionException e)
    {
      int newRemaining;
      Futures.FutureCombiner<V, C> localCombiner;
      setExceptionAndMaybeLog(e.getCause());
    }
    catch (Throwable t)
    {
      int newRemaining;
      Futures.FutureCombiner<V, C> localCombiner;
      setExceptionAndMaybeLog(t);
    }
    finally
    {
      int newRemaining;
      Futures.FutureCombiner<V, C> localCombiner;
      int newRemaining = remaining.decrementAndGet();
      Preconditions.checkState(newRemaining >= 0, "Less than 0 remaining futures");
      if (newRemaining == 0)
      {
        Futures.FutureCombiner<V, C> localCombiner = combiner;
        if ((localCombiner != null) && (localValues != null)) {
          set(localCombiner.combine(localValues));
        } else {
          Preconditions.checkState(isDone());
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.CombinedFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */