package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest;

public class CopyPartRequestFactory
{
  private final String uploadId;
  private final long optimalPartSize;
  private final CopyObjectRequest origReq;
  private int partNumber = 1;
  private long offset = 0L;
  private long remainingBytes;
  
  public CopyPartRequestFactory(CopyObjectRequest origReq, String uploadId, long optimalPartSize, long contentLength)
  {
    this.origReq = origReq;
    this.uploadId = uploadId;
    this.optimalPartSize = optimalPartSize;
    remainingBytes = contentLength;
  }
  
  public synchronized boolean hasMoreRequests()
  {
    return remainingBytes > 0L;
  }
  
  public synchronized CopyPartRequest getNextCopyPartRequest()
  {
    long partSize = Math.min(optimalPartSize, remainingBytes);
    
    CopyPartRequest req = (CopyPartRequest)new CopyPartRequest().withSourceBucketName(origReq.getSourceBucketName()).withSourceKey(origReq.getSourceKey()).withUploadId(uploadId).withPartNumber(partNumber++).withDestinationBucketName(origReq.getDestinationBucketName()).withDestinationKey(origReq.getDestinationKey()).withSourceVersionId(origReq.getSourceVersionId()).withFirstByte(Long.valueOf(offset)).withLastByte(Long.valueOf(offset + partSize - 1L)).withSourceSSECustomerKey(origReq.getSourceSSECustomerKey()).withDestinationSSECustomerKey(origReq.getDestinationSSECustomerKey()).withRequesterPays(origReq.isRequesterPays()).withMatchingETagConstraints(origReq.getMatchingETagConstraints()).withModifiedSinceConstraint(origReq.getModifiedSinceConstraint()).withNonmatchingETagConstraints(origReq.getNonmatchingETagConstraints()).withSourceVersionId(origReq.getSourceVersionId()).withUnmodifiedSinceConstraint(origReq.getUnmodifiedSinceConstraint()).withGeneralProgressListener(origReq.getGeneralProgressListener()).withRequestMetricCollector(origReq.getRequestMetricCollector());
    
    offset += partSize;
    remainingBytes -= partSize;
    return req;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.internal.CopyPartRequestFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */