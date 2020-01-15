package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListenerChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.MultipleFileUpload;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferProgress;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.Upload;
import java.util.Collection;
import java.util.Collections;

public class MultipleFileUploadImpl
  extends MultipleFileTransfer<Upload>
  implements MultipleFileUpload
{
  private final String keyPrefix;
  private final String bucketName;
  
  public MultipleFileUploadImpl(String description, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, String keyPrefix, String bucketName, Collection<? extends Upload> subTransfers)
  {
    super(description, transferProgress, progressListenerChain, subTransfers);
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
  
  public Collection<? extends Upload> getSubTransfers()
  {
    return Collections.unmodifiableCollection(subTransfers);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.MultipleFileUploadImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */