package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressEvent;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.SyncProgressListener;

public abstract class S3SyncProgressListener
  extends SyncProgressListener
  implements S3ProgressListener
{
  public void progressChanged(ProgressEvent progressEvent) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3SyncProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */