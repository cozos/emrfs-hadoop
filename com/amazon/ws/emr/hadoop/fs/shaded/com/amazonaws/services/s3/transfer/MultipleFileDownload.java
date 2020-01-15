package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import java.io.IOException;

public abstract interface MultipleFileDownload
  extends Transfer
{
  public abstract String getKeyPrefix();
  
  public abstract String getBucketName();
  
  public abstract void abort()
    throws IOException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileDownload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */