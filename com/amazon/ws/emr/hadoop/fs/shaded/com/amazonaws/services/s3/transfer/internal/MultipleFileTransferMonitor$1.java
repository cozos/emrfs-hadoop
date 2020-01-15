package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

class MultipleFileTransferMonitor$1
  implements Future<Object>
{
  MultipleFileTransferMonitor$1(MultipleFileTransferMonitor this$0) {}
  
  public boolean cancel(boolean mayInterruptIfRunning)
  {
    return true;
  }
  
  public Object get()
    throws InterruptedException, ExecutionException
  {
    Object result = null;
    for (AbstractTransfer download : MultipleFileTransferMonitor.access$000(this$0)) {
      result = download.getMonitor().getFuture().get();
    }
    return result;
  }
  
  public Object get(long timeout, TimeUnit unit)
    throws InterruptedException, ExecutionException, TimeoutException
  {
    Object result = null;
    for (AbstractTransfer subTransfer : MultipleFileTransferMonitor.access$000(this$0)) {
      result = subTransfer.getMonitor().getFuture().get(timeout, unit);
    }
    return result;
  }
  
  public boolean isCancelled()
  {
    return MultipleFileTransferMonitor.access$100(this$0).getState() == Transfer.TransferState.Canceled;
  }
  
  public boolean isDone()
  {
    return this$0.isDone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileTransferMonitor.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */