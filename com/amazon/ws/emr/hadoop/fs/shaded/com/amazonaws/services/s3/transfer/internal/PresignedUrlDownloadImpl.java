package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEventType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PresignedUrlDownloadRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PresignedUrlDownload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.Future;

@SdkInternalApi
public class PresignedUrlDownloadImpl
  extends AbstractTransfer
  implements PresignedUrlDownload
{
  private final PresignedUrlDownloadRequest presignedUrlDownloadRequest;
  private S3Object s3Object;
  
  public PresignedUrlDownloadImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, PresignedUrlDownloadRequest presignedUrlDownloadRequest)
  {
    super(description, transferProgress, progressListenerChain);
    this.presignedUrlDownloadRequest = presignedUrlDownloadRequest;
  }
  
  public synchronized void setS3Object(S3Object s3Object)
  {
    this.s3Object = s3Object;
  }
  
  public URL getPresignedUrl()
  {
    return presignedUrlDownloadRequest.getPresignedUrl();
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.PresignedUrlDownloadImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */