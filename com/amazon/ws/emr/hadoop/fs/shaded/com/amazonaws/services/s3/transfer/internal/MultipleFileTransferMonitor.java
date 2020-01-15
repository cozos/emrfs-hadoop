package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MultipleFileTransferMonitor
  implements TransferMonitor
{
  private final Collection<? extends AbstractTransfer> subTransfers;
  private final AbstractTransfer transfer;
  private final Future<?> future;
  
  public MultipleFileTransferMonitor(AbstractTransfer transfer, Collection<? extends AbstractTransfer> subTransfers)
  {
    this.subTransfers = subTransfers;
    this.transfer = transfer;
    
    future = new Future()
    {
      public boolean cancel(boolean mayInterruptIfRunning)
      {
        return true;
      }
      
      public Object get()
        throws InterruptedException, ExecutionException
      {
        Object result = null;
        for (AbstractTransfer download : subTransfers) {
          result = download.getMonitor().getFuture().get();
        }
        return result;
      }
      
      public Object get(long timeout, TimeUnit unit)
        throws InterruptedException, ExecutionException, TimeoutException
      {
        Object result = null;
        for (AbstractTransfer subTransfer : subTransfers) {
          result = subTransfer.getMonitor().getFuture().get(timeout, unit);
        }
        return result;
      }
      
      public boolean isCancelled()
      {
        return transfer.getState() == Transfer.TransferState.Canceled;
      }
      
      public boolean isDone()
      {
        return MultipleFileTransferMonitor.this.isDone();
      }
    };
  }
  
  public Future<?> getFuture()
  {
    return future;
  }
  
  public synchronized boolean isDone()
  {
    for (Transfer subTransfer : subTransfers) {
      if (!subTransfer.isDone()) {
        return false;
      }
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileTransferMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */