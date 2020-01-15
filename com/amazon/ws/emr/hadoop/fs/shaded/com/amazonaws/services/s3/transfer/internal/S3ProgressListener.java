package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.PersistableTransfer;

public abstract interface S3ProgressListener
  extends ProgressListener
{
  public abstract void onPersistableTransfer(PersistableTransfer paramPersistableTransfer);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.S3ProgressListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */