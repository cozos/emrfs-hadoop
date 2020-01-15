package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.CopyResult;

public abstract interface Copy
  extends Transfer
{
  public abstract CopyResult waitForCopyResult()
    throws AmazonClientException, AmazonServiceException, InterruptedException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Copy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */