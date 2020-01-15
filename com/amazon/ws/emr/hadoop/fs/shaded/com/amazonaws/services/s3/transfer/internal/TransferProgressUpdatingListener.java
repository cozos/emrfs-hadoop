package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SyncProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;

public class TransferProgressUpdatingListener
  extends SyncProgressListener
{
  private final TransferProgress transferProgress;
  
  public TransferProgressUpdatingListener(TransferProgress transferProgress)
  {
    this.transferProgress = transferProgress;
  }
  
  public void progressChanged(ProgressEvent progressEvent)
  {
    long bytes = progressEvent.getBytesTransferred();
    if (bytes == 0L) {
      return;
    }
    transferProgress.updateProgress(bytes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.TransferProgressUpdatingListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */