package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Download;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableDownload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.PauseException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.Future;

public class DownloadImpl
  extends AbstractTransfer
  implements Download
{
  private S3Object s3Object;
  private PersistableDownload persistableDownload;
  private Integer lastFullyDownloadedPartNumber;
  private Long lastFullyDownloadedFilePosition;
  private final GetObjectRequest getObjectRequest;
  private final File file;
  private final ObjectMetadata objectMetadata;
  private final ProgressListenerChain progressListenerChain;
  
  @Deprecated
  public DownloadImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, S3Object s3Object, TransferStateChangeListener listener, GetObjectRequest getObjectRequest, File file)
  {
    this(description, transferProgress, progressListenerChain, s3Object, listener, getObjectRequest, file, null, false);
  }
  
  public DownloadImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, S3Object s3Object, TransferStateChangeListener listener, GetObjectRequest getObjectRequest, File file, ObjectMetadata objectMetadata, boolean isDownloadParallel)
  {
    super(description, transferProgress, progressListenerChain, listener);
    this.s3Object = s3Object;
    this.objectMetadata = objectMetadata;
    this.getObjectRequest = getObjectRequest;
    this.file = file;
    this.progressListenerChain = progressListenerChain;
    persistableDownload = captureDownloadState(getObjectRequest, file);
    S3ProgressPublisher.publishTransferPersistable(progressListenerChain, persistableDownload);
  }
  
  public synchronized ObjectMetadata getObjectMetadata()
  {
    if (s3Object != null) {
      return s3Object.getObjectMetadata();
    }
    return objectMetadata;
  }
  
  public String getBucketName()
  {
    return getObjectRequest.getBucketName();
  }
  
  public String getKey()
  {
    return getObjectRequest.getKey();
  }
  
  @SdkInternalApi
  void updatePersistableTransfer(Integer lastFullyDownloadedPartNumber)
  {
    synchronized (this)
    {
      this.lastFullyDownloadedPartNumber = lastFullyDownloadedPartNumber;
    }
    persistableDownload = captureDownloadState(getObjectRequest, file);
    S3ProgressPublisher.publishTransferPersistable(progressListenerChain, persistableDownload);
  }
  
  @SdkInternalApi
  void updatePersistableTransfer(Integer lastFullyDownloadedPartNumber, Long lastFullyDownloadedFilePosition)
  {
    synchronized (this)
    {
      this.lastFullyDownloadedPartNumber = lastFullyDownloadedPartNumber;
      this.lastFullyDownloadedFilePosition = lastFullyDownloadedFilePosition;
    }
    persistableDownload = captureDownloadState(getObjectRequest, file);
    S3ProgressPublisher.publishTransferPersistable(progressListenerChain, persistableDownload);
  }
  
  public synchronized Integer getLastFullyDownloadedPartNumber()
  {
    return lastFullyDownloadedPartNumber;
  }
  
  public synchronized Long getLastFullyDownloadedFilePosition()
  {
    return lastFullyDownloadedFilePosition;
  }
  
  public synchronized void abort()
    throws IOException
  {
    monitor.getFuture().cancel(true);
    if (s3Object != null) {
      s3Object.getObjectContent().abort();
    }
    setState(Transfer.TransferState.Canceled);
  }
  
  public synchronized void abortWithoutNotifyingStateChangeListener()
    throws IOException
  {
    monitor.getFuture().cancel(true);
    state = Transfer.TransferState.Canceled;
  }
  
  public synchronized void setS3Object(S3Object s3Object)
  {
    this.s3Object = s3Object;
  }
  
  public void setState(Transfer.TransferState state)
  {
    super.setState(state);
    switch (state)
    {
    case Completed: 
      fireProgressEvent(ProgressEventType.TRANSFER_COMPLETED_EVENT);
      break;
    case Canceled: 
      fireProgressEvent(ProgressEventType.TRANSFER_CANCELED_EVENT);
      break;
    case Failed: 
      fireProgressEvent(ProgressEventType.TRANSFER_FAILED_EVENT);
      break;
    }
  }
  
  private PersistableDownload captureDownloadState(GetObjectRequest getObjectRequest, File file)
  {
    if (getObjectRequest.getSSECustomerKey() == null) {
      return new PersistableDownload(getObjectRequest
        .getBucketName(), getObjectRequest.getKey(), getObjectRequest
        .getVersionId(), getObjectRequest.getRange(), getObjectRequest
        .getResponseHeaders(), getObjectRequest.isRequesterPays(), file
        .getAbsolutePath(), getLastFullyDownloadedPartNumber(), 
        getObjectMetadata().getLastModified().getTime(), 
        getLastFullyDownloadedFilePosition());
    }
    return null;
  }
  
  public PersistableDownload pause()
    throws PauseException
  {
    boolean forceCancel = true;
    Transfer.TransferState currentState = getState();
    monitor.getFuture().cancel(true);
    if (persistableDownload == null) {
      throw new PauseException(TransferManagerUtils.determinePauseStatus(currentState, forceCancel));
    }
    return persistableDownload;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.DownloadImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */