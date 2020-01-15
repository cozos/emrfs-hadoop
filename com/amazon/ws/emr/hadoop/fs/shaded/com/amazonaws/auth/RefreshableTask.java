package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AbortedException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkPredicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import java.io.Closeable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@ThreadSafe
@SdkInternalApi
class RefreshableTask<T>
  implements Closeable
{
  private static final long BLOCKING_REFRESH_MAX_WAIT_IN_SECONDS = 5L;
  private final Lock blockingRefreshLock = new ReentrantLock();
  private final AtomicReference<T> refreshableValueHolder = new AtomicReference();
  private final ExecutorService executor = Executors.newSingleThreadExecutor(new DaemonThreadFactory());
  private final AtomicBoolean asyncRefreshing = new AtomicBoolean(false);
  private final Callable<T> refreshCallable;
  private final SdkPredicate<T> shouldDoBlockingRefresh;
  private final SdkPredicate<T> shouldDoAsyncRefresh;
  
  private RefreshableTask(Callable<T> refreshCallable, SdkPredicate<T> shouldDoBlockingRefresh, SdkPredicate<T> shouldDoAsyncRefresh)
  {
    this.refreshCallable = ((Callable)ValidationUtils.assertNotNull(refreshCallable, "refreshCallable"));
    this.shouldDoBlockingRefresh = 
      ((SdkPredicate)ValidationUtils.assertNotNull(shouldDoBlockingRefresh, "shouldDoBlockingRefresh"));
    this.shouldDoAsyncRefresh = 
      ((SdkPredicate)ValidationUtils.assertNotNull(shouldDoAsyncRefresh, "shouldDoAsyncRefresh"));
  }
  
  public void close()
  {
    executor.shutdown();
  }
  
  @NotThreadSafe
  public static class Builder<T>
  {
    private Callable<T> refreshCallable;
    private SdkPredicate<T> shouldDoBlockingRefresh;
    private SdkPredicate<T> shouldDoAsyncRefresh;
    
    public Builder withRefreshCallable(Callable<T> refreshCallable)
    {
      this.refreshCallable = refreshCallable;
      return this;
    }
    
    public Builder withBlockingRefreshPredicate(SdkPredicate<T> shouldDoBlockingRefresh)
    {
      this.shouldDoBlockingRefresh = shouldDoBlockingRefresh;
      return this;
    }
    
    public Builder withAsyncRefreshPredicate(SdkPredicate<T> shouldDoAsyncRefresh)
    {
      this.shouldDoAsyncRefresh = shouldDoAsyncRefresh;
      return this;
    }
    
    public RefreshableTask<T> build()
    {
      return new RefreshableTask(refreshCallable, shouldDoBlockingRefresh, shouldDoAsyncRefresh, null);
    }
  }
  
  public T getValue()
    throws AmazonClientException, IllegalStateException
  {
    if (shouldDoBlockingRefresh()) {
      blockingRefresh();
    } else if (shouldDoAsyncRefresh()) {
      asyncRefresh();
    }
    return (T)getRefreshedValue();
  }
  
  public T forceGetValue()
  {
    refreshValue();
    return (T)getRefreshedValue();
  }
  
  private T getRefreshedValue()
    throws IllegalStateException
  {
    T refreshableValue = refreshableValueHolder.get();
    if (refreshableValue != null) {
      return refreshableValue;
    }
    throw new IllegalStateException("Refreshed value should never be null.");
  }
  
  private boolean shouldDoBlockingRefresh()
  {
    return shouldDoBlockingRefresh.test(refreshableValueHolder.get());
  }
  
  private boolean shouldDoAsyncRefresh()
  {
    return shouldDoAsyncRefresh.test(refreshableValueHolder.get());
  }
  
  private void blockingRefresh()
  {
    try
    {
      if (blockingRefreshLock.tryLock(5L, TimeUnit.SECONDS)) {
        try
        {
          if (!shouldDoBlockingRefresh()) {
            return;
          }
          refreshValue();
          return;
        }
        finally
        {
          blockingRefreshLock.unlock();
        }
      }
    }
    catch (InterruptedException ex)
    {
      handleInterruptedException("Interrupted waiting to refresh the value.", ex);
    }
    refreshValue();
  }
  
  private void asyncRefresh()
  {
    if (asyncRefreshing.compareAndSet(false, true)) {
      try
      {
        executor.submit(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: aload_0
            //   1: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
            //   4: invokestatic 26	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$100	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)V
            //   7: aload_0
            //   8: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
            //   11: invokestatic 30	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$200	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)Ljava/util/concurrent/atomic/AtomicBoolean;
            //   14: iconst_0
            //   15: invokevirtual 36	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
            //   18: goto +17 -> 35
            //   21: astore_1
            //   22: aload_0
            //   23: getfield 18	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask$1:this$0	Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;
            //   26: invokestatic 30	com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask:access$200	(Lcom/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/auth/RefreshableTask;)Ljava/util/concurrent/atomic/AtomicBoolean;
            //   29: iconst_0
            //   30: invokevirtual 36	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
            //   33: aload_1
            //   34: athrow
            //   35: return
            // Line number table:
            //   Java source line #238	-> byte code offset #0
            //   Java source line #240	-> byte code offset #7
            //   Java source line #241	-> byte code offset #18
            //   Java source line #240	-> byte code offset #21
            //   Java source line #241	-> byte code offset #33
            //   Java source line #242	-> byte code offset #35
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	36	0	this	1
            //   21	13	1	localObject	Object
            // Exception table:
            //   from	to	target	type
            //   0	7	21	finally
          }
        });
      }
      catch (RuntimeException ex)
      {
        asyncRefreshing.set(false);
        throw ex;
      }
    }
  }
  
  private void refreshValue()
  {
    try
    {
      refreshableValueHolder.compareAndSet(refreshableValueHolder.get(), refreshCallable.call());
    }
    catch (AmazonServiceException ase)
    {
      throw ase;
    }
    catch (AmazonClientException ace)
    {
      throw ace;
    }
    catch (Exception e)
    {
      throw new AmazonClientException(e);
    }
  }
  
  private void handleInterruptedException(String message, InterruptedException cause)
  {
    Thread.currentThread().interrupt();
    throw new AbortedException(message, cause);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.RefreshableTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */