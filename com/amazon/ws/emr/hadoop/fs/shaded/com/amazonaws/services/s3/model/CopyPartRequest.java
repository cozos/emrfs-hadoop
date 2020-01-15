package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyPartRequest
  extends AmazonWebServiceRequest
  implements Serializable, S3AccelerateUnsupported
{
  private String uploadId;
  private int partNumber;
  private String sourceBucketName;
  private String sourceKey;
  private String sourceVersionId;
  private String destinationBucketName;
  private String destinationKey;
  private final List<String> matchingETagConstraints = new ArrayList();
  private final List<String> nonmatchingEtagConstraints = new ArrayList();
  private Date unmodifiedSinceConstraint;
  private Date modifiedSinceConstraint;
  private Long firstByte;
  private Long lastByte;
  private SSECustomerKey sourceSSECustomerKey;
  private SSECustomerKey destinationSSECustomerKey;
  private boolean isRequesterPays;
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public CopyPartRequest withUploadId(String uploadId)
  {
    this.uploadId = uploadId;
    return this;
  }
  
  public int getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public CopyPartRequest withPartNumber(int partNumber)
  {
    this.partNumber = partNumber;
    return this;
  }
  
  public String getSourceBucketName()
  {
    return sourceBucketName;
  }
  
  public void setSourceBucketName(String sourceBucketName)
  {
    this.sourceBucketName = sourceBucketName;
  }
  
  public CopyPartRequest withSourceBucketName(String sourceBucketName)
  {
    this.sourceBucketName = sourceBucketName;
    return this;
  }
  
  public String getSourceKey()
  {
    return sourceKey;
  }
  
  public void setSourceKey(String sourceKey)
  {
    this.sourceKey = sourceKey;
  }
  
  public CopyPartRequest withSourceKey(String sourceKey)
  {
    this.sourceKey = sourceKey;
    return this;
  }
  
  public String getSourceVersionId()
  {
    return sourceVersionId;
  }
  
  public void setSourceVersionId(String sourceVersionId)
  {
    this.sourceVersionId = sourceVersionId;
  }
  
  public CopyPartRequest withSourceVersionId(String sourceVersionId)
  {
    this.sourceVersionId = sourceVersionId;
    return this;
  }
  
  public String getDestinationBucketName()
  {
    return destinationBucketName;
  }
  
  public void setDestinationBucketName(String destinationBucketName)
  {
    this.destinationBucketName = destinationBucketName;
  }
  
  public CopyPartRequest withDestinationBucketName(String destinationBucketName)
  {
    setDestinationBucketName(destinationBucketName);
    return this;
  }
  
  public String getDestinationKey()
  {
    return destinationKey;
  }
  
  public void setDestinationKey(String destinationKey)
  {
    this.destinationKey = destinationKey;
  }
  
  public CopyPartRequest withDestinationKey(String destinationKey)
  {
    setDestinationKey(destinationKey);
    return this;
  }
  
  public Long getFirstByte()
  {
    return firstByte;
  }
  
  public void setFirstByte(Long firstByte)
  {
    this.firstByte = firstByte;
  }
  
  public CopyPartRequest withFirstByte(Long firstByte)
  {
    this.firstByte = firstByte;
    return this;
  }
  
  public Long getLastByte()
  {
    return lastByte;
  }
  
  public void setLastByte(Long lastByte)
  {
    this.lastByte = lastByte;
  }
  
  public CopyPartRequest withLastByte(Long lastByte)
  {
    this.lastByte = lastByte;
    return this;
  }
  
  public List<String> getMatchingETagConstraints()
  {
    return matchingETagConstraints;
  }
  
  public void setMatchingETagConstraints(List<String> eTagList)
  {
    matchingETagConstraints.clear();
    matchingETagConstraints.addAll(eTagList);
  }
  
  public CopyPartRequest withMatchingETagConstraints(List<String> eTagList)
  {
    setMatchingETagConstraints(eTagList);
    return this;
  }
  
  public CopyPartRequest withMatchingETagConstraint(String eTag)
  {
    matchingETagConstraints.add(eTag);
    return this;
  }
  
  public List<String> getNonmatchingETagConstraints()
  {
    return nonmatchingEtagConstraints;
  }
  
  public void setNonmatchingETagConstraints(List<String> eTagList)
  {
    nonmatchingEtagConstraints.clear();
    nonmatchingEtagConstraints.addAll(eTagList);
  }
  
  public CopyPartRequest withNonmatchingETagConstraints(List<String> eTagList)
  {
    setNonmatchingETagConstraints(eTagList);
    return this;
  }
  
  public CopyPartRequest withNonmatchingETagConstraint(String eTag)
  {
    nonmatchingEtagConstraints.add(eTag);
    return this;
  }
  
  public Date getUnmodifiedSinceConstraint()
  {
    return unmodifiedSinceConstraint;
  }
  
  public void setUnmodifiedSinceConstraint(Date date)
  {
    unmodifiedSinceConstraint = date;
  }
  
  public CopyPartRequest withUnmodifiedSinceConstraint(Date date)
  {
    setUnmodifiedSinceConstraint(date);
    return this;
  }
  
  public Date getModifiedSinceConstraint()
  {
    return modifiedSinceConstraint;
  }
  
  public void setModifiedSinceConstraint(Date date)
  {
    modifiedSinceConstraint = date;
  }
  
  public CopyPartRequest withModifiedSinceConstraint(Date date)
  {
    setModifiedSinceConstraint(date);
    return this;
  }
  
  public SSECustomerKey getSourceSSECustomerKey()
  {
    return sourceSSECustomerKey;
  }
  
  public void setSourceSSECustomerKey(SSECustomerKey sseKey)
  {
    sourceSSECustomerKey = sseKey;
  }
  
  public CopyPartRequest withSourceSSECustomerKey(SSECustomerKey sseKey)
  {
    setSourceSSECustomerKey(sseKey);
    return this;
  }
  
  public SSECustomerKey getDestinationSSECustomerKey()
  {
    return destinationSSECustomerKey;
  }
  
  public void setDestinationSSECustomerKey(SSECustomerKey sseKey)
  {
    destinationSSECustomerKey = sseKey;
  }
  
  public CopyPartRequest withDestinationSSECustomerKey(SSECustomerKey sseKey)
  {
    setDestinationSSECustomerKey(sseKey);
    return this;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public CopyPartRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyPartRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */