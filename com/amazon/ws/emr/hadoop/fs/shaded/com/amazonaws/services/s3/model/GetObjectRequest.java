package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class GetObjectRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, Serializable
{
  private S3ObjectIdBuilder s3ObjectIdBuilder = new S3ObjectIdBuilder();
  private long[] range;
  private List<String> matchingETagConstraints = new ArrayList();
  private List<String> nonmatchingEtagConstraints = new ArrayList();
  private Date unmodifiedSinceConstraint;
  private Date modifiedSinceConstraint;
  private ResponseHeaderOverrides responseHeaders;
  private boolean isRequesterPays;
  private SSECustomerKey sseCustomerKey;
  private Integer partNumber;
  
  public GetObjectRequest(String bucketName, String key)
  {
    this(bucketName, key, null);
  }
  
  public GetObjectRequest(String bucketName, String key, String versionId)
  {
    setBucketName(bucketName);
    setKey(key);
    setVersionId(versionId);
  }
  
  public GetObjectRequest(S3ObjectId s3ObjectId)
  {
    s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
  }
  
  public GetObjectRequest(String bucketName, String key, boolean isRequesterPays)
  {
    s3ObjectIdBuilder.withBucket(bucketName).withKey(key);
    
    this.isRequesterPays = isRequesterPays;
  }
  
  public String getBucketName()
  {
    return s3ObjectIdBuilder.getBucket();
  }
  
  public void setBucketName(String bucketName)
  {
    s3ObjectIdBuilder.setBucket(bucketName);
  }
  
  public GetObjectRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getKey()
  {
    return s3ObjectIdBuilder.getKey();
  }
  
  public void setKey(String key)
  {
    s3ObjectIdBuilder.setKey(key);
  }
  
  public GetObjectRequest withKey(String key)
  {
    setKey(key);
    return this;
  }
  
  public String getVersionId()
  {
    return s3ObjectIdBuilder.getVersionId();
  }
  
  public void setVersionId(String versionId)
  {
    s3ObjectIdBuilder.setVersionId(versionId);
  }
  
  public GetObjectRequest withVersionId(String versionId)
  {
    setVersionId(versionId);
    return this;
  }
  
  public long[] getRange()
  {
    return range == null ? null : (long[])range.clone();
  }
  
  public void setRange(long start, long end)
  {
    range = new long[] { start, end };
  }
  
  public void setRange(long start)
  {
    setRange(start, 9223372036854775806L);
  }
  
  public GetObjectRequest withRange(long start, long end)
  {
    setRange(start, end);
    return this;
  }
  
  public GetObjectRequest withRange(long start)
  {
    setRange(start);
    return this;
  }
  
  public List<String> getMatchingETagConstraints()
  {
    return matchingETagConstraints;
  }
  
  public void setMatchingETagConstraints(List<String> eTagList)
  {
    matchingETagConstraints = eTagList;
  }
  
  public GetObjectRequest withMatchingETagConstraint(String eTag)
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
    nonmatchingEtagConstraints = eTagList;
  }
  
  public GetObjectRequest withNonmatchingETagConstraint(String eTag)
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
  
  public GetObjectRequest withUnmodifiedSinceConstraint(Date date)
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
  
  public GetObjectRequest withModifiedSinceConstraint(Date date)
  {
    setModifiedSinceConstraint(date);
    return this;
  }
  
  public ResponseHeaderOverrides getResponseHeaders()
  {
    return responseHeaders;
  }
  
  public void setResponseHeaders(ResponseHeaderOverrides responseHeaders)
  {
    this.responseHeaders = responseHeaders;
  }
  
  public GetObjectRequest withResponseHeaders(ResponseHeaderOverrides responseHeaders)
  {
    setResponseHeaders(responseHeaders);
    return this;
  }
  
  @Deprecated
  public void setProgressListener(ProgressListener progressListener)
  {
    setGeneralProgressListener(new LegacyS3ProgressListener(progressListener));
  }
  
  @Deprecated
  public ProgressListener getProgressListener()
  {
    com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.event.ProgressListener generalProgressListener = getGeneralProgressListener();
    if ((generalProgressListener instanceof LegacyS3ProgressListener)) {
      return ((LegacyS3ProgressListener)generalProgressListener).unwrap();
    }
    return null;
  }
  
  @Deprecated
  public GetObjectRequest withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
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
  
  public GetObjectRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseKey)
  {
    sseCustomerKey = sseKey;
  }
  
  public GetObjectRequest withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    return this;
  }
  
  public Integer getPartNumber()
  {
    return partNumber;
  }
  
  public void setPartNumber(Integer partNumber)
  {
    this.partNumber = partNumber;
  }
  
  public GetObjectRequest withPartNumber(Integer partNumber)
  {
    setPartNumber(partNumber);
    return this;
  }
  
  public S3ObjectId getS3ObjectId()
  {
    return s3ObjectIdBuilder.build();
  }
  
  public void setS3ObjectId(S3ObjectId s3ObjectId)
  {
    s3ObjectIdBuilder = new S3ObjectIdBuilder(s3ObjectId);
  }
  
  public GetObjectRequest withS3ObjectId(S3ObjectId s3ObjectId)
  {
    setS3ObjectId(s3ObjectId);
    return this;
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    GetObjectRequest that = (GetObjectRequest)o;
    if (isRequesterPays != isRequesterPays) {
      return false;
    }
    if (s3ObjectIdBuilder != null ? !s3ObjectIdBuilder.equals(s3ObjectIdBuilder) : s3ObjectIdBuilder != null) {
      return false;
    }
    if (!Arrays.equals(range, range)) {
      return false;
    }
    if (matchingETagConstraints != null ? !matchingETagConstraints.equals(matchingETagConstraints) : matchingETagConstraints != null) {
      return false;
    }
    if (nonmatchingEtagConstraints != null ? !nonmatchingEtagConstraints.equals(nonmatchingEtagConstraints) : nonmatchingEtagConstraints != null) {
      return false;
    }
    if (unmodifiedSinceConstraint != null ? !unmodifiedSinceConstraint.equals(unmodifiedSinceConstraint) : unmodifiedSinceConstraint != null) {
      return false;
    }
    if (modifiedSinceConstraint != null ? !modifiedSinceConstraint.equals(modifiedSinceConstraint) : modifiedSinceConstraint != null) {
      return false;
    }
    if (responseHeaders != null ? !responseHeaders.equals(responseHeaders) : responseHeaders != null) {
      return false;
    }
    if (sseCustomerKey != null ? !sseCustomerKey.equals(sseCustomerKey) : sseCustomerKey != null) {
      return false;
    }
    return partNumber == null ? true : partNumber != null ? partNumber.equals(partNumber) : false;
  }
  
  public int hashCode()
  {
    int result = s3ObjectIdBuilder != null ? s3ObjectIdBuilder.hashCode() : 0;
    result = 31 * result + Arrays.hashCode(range);
    result = 31 * result + (matchingETagConstraints != null ? matchingETagConstraints.hashCode() : 0);
    result = 31 * result + (nonmatchingEtagConstraints != null ? nonmatchingEtagConstraints.hashCode() : 0);
    result = 31 * result + (unmodifiedSinceConstraint != null ? unmodifiedSinceConstraint.hashCode() : 0);
    result = 31 * result + (modifiedSinceConstraint != null ? modifiedSinceConstraint.hashCode() : 0);
    result = 31 * result + (responseHeaders != null ? responseHeaders.hashCode() : 0);
    result = 31 * result + (isRequesterPays ? 1 : 0);
    result = 31 * result + (sseCustomerKey != null ? sseCustomerKey.hashCode() : 0);
    result = 31 * result + (partNumber != null ? partNumber.hashCode() : 0);
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */