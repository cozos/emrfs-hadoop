package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class CopyMonitor
  implements Callable<CopyResult>, TransferMonitor
{
  private final AmazonS3 s3;
  private final ExecutorService threadPool;
  private final CopyObjectRequest origReq;
  private final CopyCallable multipartCopyCallable;
  private final CopyImpl transfer;
  private final ProgressListenerChain listener;
  private final List<Future<PartETag>> futures = new ArrayList();
  private boolean isCopyDone = false;
  private AtomicReference<Future<CopyResult>> futureReference = new AtomicReference(null);
  
  public Future<CopyResult> getFuture()
  {
    return (Future)futureReference.get();
  }
  
  public synchronized boolean isDone()
  {
    return isCopyDone;
  }
  
  private synchronized void markAllDone()
  {
    isCopyDone = true;
  }
  
  public static CopyMonitor create(TransferManager manager, CopyImpl transfer, ExecutorService threadPool, CopyCallable multipartCopyCallable, CopyObjectRequest copyObjectRequest, ProgressListenerChain progressListenerChain)
  {
    CopyMonitor copyMonitor = new CopyMonitor(manager, transfer, threadPool, multipartCopyCallable, copyObjectRequest, progressListenerChain);
    
    Future<CopyResult> thisFuture = threadPool.submit(copyMonitor);
    
    futureReference.compareAndSet(null, thisFuture);
    return copyMonitor;
  }
  
  private CopyMonitor(TransferManager manager, CopyImpl transfer, ExecutorService threadPool, CopyCallable multipartCopyCallable, CopyObjectRequest copyObjectRequest, ProgressListenerChain progressListenerChain)
  {
    s3 = manager.getAmazonS3Client();
    this.multipartCopyCallable = multipartCopyCallable;
    origReq = copyObjectRequest;
    listener = progressListenerChain;
    this.transfer = transfer;
    this.threadPool = threadPool;
  }
  
  public CopyResult call()
    throws Exception
  {
    try
    {
      CopyResult result = multipartCopyCallable.call();
      if (result == null)
      {
        futures.addAll(multipartCopyCallable.getFutures());
        futureReference.set(threadPool.submit(new CompleteMultipartCopy(multipartCopyCallable.getMultipartUploadId(), s3, origReq, futures, listener, this)));
      }
      else
      {
        copyComplete();
      }
      return result;
    }
    catch (CancellationException e)
    {
      transfer.setState(Transfer.TransferState.Canceled);
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_CANCELED_EVENT);
      throw new SdkClientException("Upload canceled");
    }
    catch (Exception e)
    {
      transfer.setState(Transfer.TransferState.Failed);
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_FAILED_EVENT);
      throw e;
    }
  }
  
  void copyComplete()
  {
    markAllDone();
    transfer.setState(Transfer.TransferState.Completed);
    
    transfer.getProgress().updateProgress(transfer.getProgress().getTotalBytesToTransfer());
    if (multipartCopyCallable.isMultipartCopy()) {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_COMPLETED_EVENT);
    }
  }
  
  void reportFailure()
  {
    transfer.setState(Transfer.TransferState.Failed);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */