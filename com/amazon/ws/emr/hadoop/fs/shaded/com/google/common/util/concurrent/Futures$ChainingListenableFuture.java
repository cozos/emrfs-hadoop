package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

class Futures$ChainingListenableFuture<I, O>
  extends AbstractFuture<O>
  implements Runnable
{
  private AsyncFunction<? super I, ? extends O> function;
  private ListenableFuture<? extends I> inputFuture;
  private volatile ListenableFuture<? extends O> outputFuture;
  
  private Futures$ChainingListenableFuture(AsyncFunction<? super I, ? extends O> function, ListenableFuture<? extends I> inputFuture)
  {
    this.function = ((AsyncFunction)Preconditions.checkNotNull(function));
    this.inputFuture = ((ListenableFuture)Preconditions.checkNotNull(inputFuture));
  }
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    if (super.cancel(mayInterruptIfRunning))
    {
      cancel(inputFuture, mayInterruptIfRunning);
      cancel(outputFuture, mayInterruptIfRunning);
      return true;
    }
    return false;
  }
  
  private void cancel(@Nullable Future<?> future, boolean mayInterruptIfRunning)
  {
    if (future != null) {
      future.cancel(mayInterruptIfRunning);
    }
  }
  
  public void run()
  {
    try
    {
      I sourceResult;
      try
      {
        sourceResult = Uninterruptibles.getUninterruptibly(inputFuture);
      }
      catch (CancellationException e)
      {
        cancel(false); return;
      }
      catch (ExecutionException e)
      {
        setException(e.getCause()); return;
      }
      final ListenableFuture<? extends O> outputFuture = this.outputFuture = (ListenableFuture)Preconditions.checkNotNull(function.apply(sourceResult), "AsyncFunction may not return null.");
      if (isCancelled())
      {
        outputFuture.cancel(wasInterrupted());
        this.outputFuture = null;
      }
      else
      {
        outputFuture.addListener(new Runnable()
        {
          public void run()
          {
            try
            {
              set(Uninterruptibles.getUninterruptibly(outputFuture));
            }
            catch (CancellationException e)
            {
              cancel(false);
            }
            catch (ExecutionException e)
            {
              setException(e.getCause());
            }
            finally
            {
              outputFuture = null;
            }
          }
        }, MoreExecutors.directExecutor());
      }
    }
    catch (UndeclaredThrowableException e)
    {
      setException(e.getCause());
    }
    catch (Throwable t)
    {
      setException(t);
    }
    finally
    {
      function = null;
      inputFuture = null;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Futures.ChainingListenableFuture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */