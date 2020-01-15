package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;

public abstract interface Transfer
{
  public abstract boolean isDone();
  
  public abstract void waitForCompletion()
    throws AmazonClientException, AmazonServiceException, InterruptedException;
  
  public abstract AmazonClientException waitForException()
    throws InterruptedException;
  
  public abstract String getDescription();
  
  public abstract TransferState getState();
  
  public abstract void addProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener paramProgressListener);
  
  public abstract void removeProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener paramProgressListener);
  
  public abstract TransferProgress getProgress();
  
  @Deprecated
  public abstract void addProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ProgressListener paramProgressListener);
  
  @Deprecated
  public abstract void removeProgressListener(com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ProgressListener paramProgressListener);
  
  public static enum TransferState
  {
    Waiting,  InProgress,  Completed,  Canceled,  Failed;
    
    private TransferState() {}
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */