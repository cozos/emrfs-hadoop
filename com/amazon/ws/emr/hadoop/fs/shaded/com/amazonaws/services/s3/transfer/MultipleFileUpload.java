package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import java.util.Collection;

public abstract interface MultipleFileUpload
  extends Transfer
{
  public abstract String getKeyPrefix();
  
  public abstract String getBucketName();
  
  public abstract Collection<? extends Upload> getSubTransfers();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */