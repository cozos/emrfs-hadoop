package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Copy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CopyImpl
  extends AbstractTransfer
  implements Copy
{
  public CopyImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, TransferStateChangeListener stateChangeListener)
  {
    super(description, transferProgress, progressListenerChain, stateChangeListener);
  }
  
  public CopyResult waitForCopyResult()
    throws AmazonClientException, AmazonServiceException, InterruptedException
  {
    try
    {
      CopyResult result = null;
      while ((!monitor.isDone()) || (result == null))
      {
        Future<?> f = monitor.getFuture();
        result = (CopyResult)f.get();
      }
      return result;
    }
    catch (ExecutionException e)
    {
      rethrowExecutionException(e);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */