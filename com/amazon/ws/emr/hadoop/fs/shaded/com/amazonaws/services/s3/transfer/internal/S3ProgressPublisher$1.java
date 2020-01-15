package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableTransfer;

final class S3ProgressPublisher$1
  implements Runnable
{
  S3ProgressPublisher$1(S3ProgressListener paramS3ProgressListener, PersistableTransfer paramPersistableTransfer) {}
  
  public void run()
  {
    val$listener.onPersistableTransfer(val$persistableTransfer);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressPublisher.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */