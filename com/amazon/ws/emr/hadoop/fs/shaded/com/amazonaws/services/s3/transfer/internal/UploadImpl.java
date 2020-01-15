package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Upload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.PauseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class UploadImpl
  extends AbstractTransfer
  implements Upload
{
  public UploadImpl(String description, TransferProgress transferProgressInternalState, ProgressListenerChain progressListenerChain, TransferStateChangeListener listener)
  {
    super(description, transferProgressInternalState, progressListenerChain, listener);
  }
  
  public UploadResult waitForUploadResult()
    throws AmazonClientException, AmazonServiceException, InterruptedException
  {
    try
    {
      UploadResult result = null;
      while ((!monitor.isDone()) || (result == null))
      {
        Future<?> f = monitor.getFuture();
        result = (UploadResult)f.get();
      }
      return result;
    }
    catch (ExecutionException e)
    {
      rethrowExecutionException(e);
    }
    return null;
  }
  
  public PersistableUpload pause()
    throws PauseException
  {
    PauseResult<PersistableUpload> pauseResult = pause(true);
    if (pauseResult.getPauseStatus() != PauseStatus.SUCCESS) {
      throw new PauseException(pauseResult.getPauseStatus());
    }
    return (PersistableUpload)pauseResult.getInfoToResume();
  }
  
  private PauseResult<PersistableUpload> pause(boolean forceCancelTransfers)
    throws AmazonClientException
  {
    UploadMonitor uploadMonitor = (UploadMonitor)monitor;
    return uploadMonitor.pause(forceCancelTransfers);
  }
  
  public PauseResult<PersistableUpload> tryPause(boolean forceCancelTransfers)
  {
    return pause(forceCancelTransfers);
  }
  
  public void abort()
  {
    UploadMonitor uploadMonitor = (UploadMonitor)monitor;
    uploadMonitor.performAbort();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */