package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.RequestClientOptions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ReleasableInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.InputSubstream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SSECustomerKey;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.UploadPartRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import java.io.File;

public class UploadPartRequestFactory
{
  private final String bucketName;
  private final String key;
  private final String uploadId;
  private final long optimalPartSize;
  private final File file;
  private final PutObjectRequest origReq;
  private int partNumber = 1;
  private long offset = 0L;
  private long remainingBytes;
  private SSECustomerKey sseCustomerKey;
  private final int totalNumberOfParts;
  private ReleasableInputStream wrappedStream;
  
  public UploadPartRequestFactory(PutObjectRequest origReq, String uploadId, long optimalPartSize)
  {
    this.origReq = origReq;
    this.uploadId = uploadId;
    this.optimalPartSize = optimalPartSize;
    bucketName = origReq.getBucketName();
    key = origReq.getKey();
    file = TransferManagerUtils.getRequestFile(origReq);
    remainingBytes = TransferManagerUtils.getContentLength(origReq);
    sseCustomerKey = origReq.getSSECustomerKey();
    totalNumberOfParts = ((int)Math.ceil(remainingBytes / this.optimalPartSize));
    if (origReq.getInputStream() != null) {
      wrappedStream = ReleasableInputStream.wrap(origReq.getInputStream());
    }
  }
  
  public synchronized boolean hasMoreRequests()
  {
    return remainingBytes > 0L;
  }
  
  public synchronized UploadPartRequest getNextUploadPartRequest()
  {
    long partSize = Math.min(optimalPartSize, remainingBytes);
    boolean isLastPart = remainingBytes - partSize <= 0L;
    
    UploadPartRequest req = null;
    if (wrappedStream != null) {
      req = new UploadPartRequest().withBucketName(bucketName).withKey(key).withUploadId(uploadId).withInputStream(new InputSubstream(wrappedStream, 0L, partSize, isLastPart)).withPartNumber(partNumber++).withPartSize(partSize);
    } else {
      req = new UploadPartRequest().withBucketName(bucketName).withKey(key).withUploadId(uploadId).withFile(file).withFileOffset(offset).withPartNumber(partNumber++).withPartSize(partSize);
    }
    ObjectMetadata origReqMetadata = origReq.getMetadata();
    if ((origReqMetadata != null) && 
      (origReqMetadata.getRawMetadataValue("x-amz-server-side-encryption-customer-key") != null) && 
      (origReqMetadata.getSSECustomerAlgorithm() != null) && 
      (origReqMetadata.getSSECustomerKeyMd5() != null))
    {
      ObjectMetadata metadata = new ObjectMetadata();
      metadata.setHeader("x-amz-server-side-encryption-customer-key", origReqMetadata
        .getRawMetadataValue("x-amz-server-side-encryption-customer-key"));
      metadata.setSSECustomerAlgorithm(origReqMetadata.getSSECustomerAlgorithm());
      metadata.setSSECustomerKeyMd5(origReqMetadata.getSSECustomerKeyMd5());
      
      req.withObjectMetadata(metadata);
    }
    req.withRequesterPays(origReq.isRequesterPays());
    TransferManager.appendMultipartUserAgent(req);
    if (sseCustomerKey != null) {
      req.setSSECustomerKey(sseCustomerKey);
    }
    offset += partSize;
    remainingBytes -= partSize;
    
    req.setLastPart(isLastPart);
    
    req.withGeneralProgressListener(origReq.getGeneralProgressListener())
      .withRequestMetricCollector(origReq.getRequestMetricCollector());
    
    req.getRequestClientOptions().setReadLimit(origReq.getReadLimit());
    return req;
  }
  
  public int getTotalNumberOfParts()
  {
    return totalNumberOfParts;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.UploadPartRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */