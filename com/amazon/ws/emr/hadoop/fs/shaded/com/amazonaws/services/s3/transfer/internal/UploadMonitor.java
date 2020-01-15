package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SDKProgressPublisher;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PartETag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PauseStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

public class UploadMonitor
  implements Callable<UploadResult>, TransferMonitor
{
  private final AmazonS3 s3;
  private final PutObjectRequest origReq;
  private final ProgressListenerChain listener;
  private final UploadCallable multipartUploadCallable;
  private final UploadImpl transfer;
  private final ExecutorService threadPool;
  private final List<Future<PartETag>> futures = Collections.synchronizedList(new ArrayList());
  private boolean isUploadDone = false;
  private AtomicReference<Future<UploadResult>> futureReference = new AtomicReference(null);
  
  public Future<UploadResult> getFuture()
  {
    return (Future)futureReference.get();
  }
  
  private synchronized void cancelFuture()
  {
    ((Future)futureReference.get()).cancel(true);
  }
  
  public synchronized boolean isDone()
  {
    return isUploadDone;
  }
  
  private synchronized void markAllDone()
  {
    isUploadDone = true;
  }
  
  public static UploadMonitor create(TransferManager manager, UploadImpl transfer, ExecutorService threadPool, UploadCallable multipartUploadCallable, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain)
  {
    UploadMonitor uploadMonitor = new UploadMonitor(manager, transfer, threadPool, multipartUploadCallable, putObjectRequest, progressListenerChain);
    
    Future<UploadResult> thisFuture = threadPool.submit(uploadMonitor);
    
    futureReference.compareAndSet(null, thisFuture);
    return uploadMonitor;
  }
  
  private UploadMonitor(TransferManager manager, UploadImpl transfer, ExecutorService threadPool, UploadCallable multipartUploadCallable, PutObjectRequest putObjectRequest, ProgressListenerChain progressListenerChain)
  {
    s3 = manager.getAmazonS3Client();
    this.multipartUploadCallable = multipartUploadCallable;
    origReq = putObjectRequest;
    listener = progressListenerChain;
    this.transfer = transfer;
    this.threadPool = threadPool;
  }
  
  public UploadResult call()
    throws Exception
  {
    try
    {
      UploadResult result = multipartUploadCallable.call();
      if (result == null)
      {
        futures.addAll(multipartUploadCallable.getFutures());
        futureReference.set(threadPool.submit(new CompleteMultipartUpload(multipartUploadCallable
          .getMultipartUploadId(), s3, origReq, futures, multipartUploadCallable
          
          .getETags(), listener, this)));
      }
      else
      {
        uploadComplete();
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
      throw e;
    }
  }
  
  void uploadComplete()
  {
    markAllDone();
    transfer.setState(Transfer.TransferState.Completed);
    if (multipartUploadCallable.isMultipartUpload()) {
      SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_COMPLETED_EVENT);
    }
  }
  
  void uploadFailure()
  {
    transfer.setState(Transfer.TransferState.Failed);
  }
  
  PauseResult<PersistableUpload> pause(boolean forceCancel)
  {
    PersistableUpload persistableUpload = multipartUploadCallable.getPersistableUpload();
    if (persistableUpload == null)
    {
      PauseStatus pauseStatus = TransferManagerUtils.determinePauseStatus(transfer.getState(), forceCancel);
      if (forceCancel)
      {
        cancelFutures();
        multipartUploadCallable.performAbortMultipartUpload();
      }
      return new PauseResult(pauseStatus);
    }
    cancelFutures();
    return new PauseResult(PauseStatus.SUCCESS, persistableUpload);
  }
  
  private void cancelFutures()
  {
    cancelFuture();
    for (Future<PartETag> f : futures) {
      f.cancel(true);
    }
    multipartUploadCallable.getFutures().clear();
    futures.clear();
  }
  
  void performAbort()
  {
    cancelFutures();
    multipartUploadCallable.performAbortMultipartUpload();
    SDKProgressPublisher.publishProgress(listener, ProgressEventType.TRANSFER_CANCELED_EVENT);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadMonitor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */