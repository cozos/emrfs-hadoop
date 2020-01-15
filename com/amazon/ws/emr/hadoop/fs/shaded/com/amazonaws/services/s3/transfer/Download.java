package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.PauseException;

public abstract interface Download
  extends AbortableTransfer
{
  public abstract ObjectMetadata getObjectMetadata();
  
  public abstract String getBucketName();
  
  public abstract String getKey();
  
  public abstract PersistableDownload pause()
    throws PauseException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Download
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */