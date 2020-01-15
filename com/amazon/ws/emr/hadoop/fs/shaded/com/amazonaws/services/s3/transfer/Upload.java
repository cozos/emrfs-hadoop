package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.exception.PauseException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.model.UploadResult;

public abstract interface Upload
  extends Transfer
{
  public abstract UploadResult waitForUploadResult()
    throws AmazonClientException, AmazonServiceException, InterruptedException;
  
  public abstract PersistableUpload pause()
    throws PauseException;
  
  public abstract PauseResult<PersistableUpload> tryPause(boolean paramBoolean);
  
  public abstract void abort();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Upload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */