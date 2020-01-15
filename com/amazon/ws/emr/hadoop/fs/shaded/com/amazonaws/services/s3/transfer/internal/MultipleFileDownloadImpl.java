package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Download;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import java.io.IOException;
import java.util.Collection;

public class MultipleFileDownloadImpl
  extends MultipleFileTransfer<Download>
  implements MultipleFileDownload
{
  private final String keyPrefix;
  private final String bucketName;
  
  public MultipleFileDownloadImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String keyPrefix, String bucketName, Collection<? extends Download> downloads)
  {
    super(description, transferProgress, progressListenerChain, downloads);
    this.keyPrefix = keyPrefix;
    this.bucketName = bucketName;
  }
  
  public String getKeyPrefix()
  {
    return keyPrefix;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void waitForCompletion()
    throws AmazonClientException, AmazonServiceException, InterruptedException
  {
    if (subTransfers.isEmpty()) {
      return;
    }
    super.waitForCompletion();
  }
  
  public void abort()
    throws IOException
  {
    for (Transfer fileDownload : subTransfers) {
      ((DownloadImpl)fileDownload).abortWithoutNotifyingStateChangeListener();
    }
    for (Transfer fileDownload : subTransfers) {
      ((DownloadImpl)fileDownload).notifyStateChangeListeners(Transfer.TransferState.Canceled);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileDownloadImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */