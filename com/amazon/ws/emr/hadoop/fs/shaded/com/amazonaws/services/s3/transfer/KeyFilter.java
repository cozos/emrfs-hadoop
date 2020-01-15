package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectSummary;

public abstract interface KeyFilter
{
  public static final KeyFilter INCLUDE_ALL = new KeyFilter()
  {
    public boolean shouldInclude(S3ObjectSummary objectSummary)
    {
      return true;
    }
  };
  
  public abstract boolean shouldInclude(S3ObjectSummary paramS3ObjectSummary);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.KeyFilter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */