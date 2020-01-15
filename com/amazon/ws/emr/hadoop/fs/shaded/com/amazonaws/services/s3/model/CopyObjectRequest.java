package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CopyObjectRequest
  extends AmazonWebServiceRequest
  implements SSEAwsKeyManagementParamsProvider, Serializable, S3AccelerateUnsupported
{
  private String sourceBucketName;
  private String sourceKey;
  private String sourceVersionId;
  private String destinationBucketName;
  private String destinationKey;
  private String storageClass;
  private ObjectMetadata newObjectMetadata;
  private CannedAccessControlList cannedACL;
  private AccessControlList accessControlList;
  private List<String> matchingETagConstraints = new ArrayList();
  private List<String> nonmatchingEtagConstraints = new ArrayList();
  private Date unmodifiedSinceConstraint;
  private Date modifiedSinceConstraint;
  private String redirectLocation;
  private SSECustomerKey sourceSSECustomerKey;
  private SSECustomerKey destinationSSECustomerKey;
  private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
  private boolean isRequesterPays;
  private ObjectTagging newObjectTagging;
  private String metadataDirective;
  private String objectLockMode;
  private Date objectLockRetainUntilDate;
  private String objectLockLegalHoldStatus;
  
  public CopyObjectRequest(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey)
  {
    this(sourceBucketName, sourceKey, null, destinationBucketName, destinationKey);
  }
  
  public CopyObjectRequest(String sourceBucketName, String sourceKey, String sourceVersionId, String destinationBucketName, String destinationKey)
  {
    this.sourceBucketName = sourceBucketName;
    this.sourceKey = sourceKey;
    this.sourceVersionId = sourceVersionId;
    this.destinationBucketName = destinationBucketName;
    this.destinationKey = destinationKey;
  }
  
  public String getSourceBucketName()
  {
    return sourceBucketName;
  }
  
  public void setSourceBucketName(String sourceBucketName)
  {
    this.sourceBucketName = sourceBucketName;
  }
  
  public CopyObjectRequest withSourceBucketName(String sourceBucketName)
  {
    setSourceBucketName(sourceBucketName);
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
  
  public CopyObjectRequest withSourceKey(String sourceKey)
  {
    setSourceKey(sourceKey);
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
  
  public CopyObjectRequest withSourceVersionId(String sourceVersionId)
  {
    setSourceVersionId(sourceVersionId);
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
  
  public CopyObjectRequest withDestinationBucketName(String destinationBucketName)
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
  
  public CopyObjectRequest withDestinationKey(String destinationKey)
  {
    setDestinationKey(destinationKey);
    return this;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public CopyObjectRequest withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    this.storageClass = storageClass.toString();
  }
  
  public CopyObjectRequest withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public CannedAccessControlList getCannedAccessControlList()
  {
    return cannedACL;
  }
  
  public void setCannedAccessControlList(CannedAccessControlList cannedACL)
  {
    this.cannedACL = cannedACL;
  }
  
  public CopyObjectRequest withCannedAccessControlList(CannedAccessControlList cannedACL)
  {
    setCannedAccessControlList(cannedACL);
    return this;
  }
  
  public AccessControlList getAccessControlList()
  {
    return accessControlList;
  }
  
  public void setAccessControlList(AccessControlList accessControlList)
  {
    this.accessControlList = accessControlList;
  }
  
  public CopyObjectRequest withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
    return this;
  }
  
  public ObjectMetadata getNewObjectMetadata()
  {
    return newObjectMetadata;
  }
  
  public void setNewObjectMetadata(ObjectMetadata newObjectMetadata)
  {
    this.newObjectMetadata = newObjectMetadata;
  }
  
  public CopyObjectRequest withNewObjectMetadata(ObjectMetadata newObjectMetadata)
  {
    setNewObjectMetadata(newObjectMetadata);
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
  
  public CopyObjectRequest withMatchingETagConstraint(String eTag)
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
  
  public CopyObjectRequest withNonmatchingETagConstraint(String eTag)
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
  
  public CopyObjectRequest withUnmodifiedSinceConstraint(Date date)
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
  
  public CopyObjectRequest withModifiedSinceConstraint(Date date)
  {
    setModifiedSinceConstraint(date);
    return this;
  }
  
  public void setRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
  }
  
  public String getRedirectLocation()
  {
    return redirectLocation;
  }
  
  public CopyObjectRequest withRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
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
  
  public CopyObjectRequest withSourceSSECustomerKey(SSECustomerKey sseKey)
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
    if ((sseKey != null) && (sseAwsKeyManagementParams != null)) {
      throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }
    destinationSSECustomerKey = sseKey;
  }
  
  public CopyObjectRequest withDestinationSSECustomerKey(SSECustomerKey sseKey)
  {
    setDestinationSSECustomerKey(sseKey);
    return this;
  }
  
  public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams()
  {
    return sseAwsKeyManagementParams;
  }
  
  public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams params)
  {
    if ((params != null) && (destinationSSECustomerKey != null)) {
      throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }
    sseAwsKeyManagementParams = params;
  }
  
  public CopyObjectRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sseAwsKeyManagementParams)
  {
    setSSEAwsKeyManagementParams(sseAwsKeyManagementParams);
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
  
  public CopyObjectRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public ObjectTagging getNewObjectTagging()
  {
    return newObjectTagging;
  }
  
  public void setNewObjectTagging(ObjectTagging newObjectTagging)
  {
    this.newObjectTagging = newObjectTagging;
  }
  
  public CopyObjectRequest withNewObjectTagging(ObjectTagging newObjectTagging)
  {
    setNewObjectTagging(newObjectTagging);
    return this;
  }
  
  public String getMetadataDirective()
  {
    return metadataDirective;
  }
  
  public void setMetadataDirective(String metadataDirective)
  {
    this.metadataDirective = metadataDirective;
  }
  
  public CopyObjectRequest withMetadataDirective(String metadataDirective)
  {
    setMetadataDirective(metadataDirective);
    return this;
  }
  
  public CopyObjectRequest withMetadataDirective(MetadataDirective metadataDirective)
  {
    return withMetadataDirective(metadataDirective == null ? null : metadataDirective.toString());
  }
  
  public String getObjectLockMode()
  {
    return objectLockMode;
  }
  
  public CopyObjectRequest withObjectLockMode(String objectLockMode)
  {
    this.objectLockMode = objectLockMode;
    return this;
  }
  
  public CopyObjectRequest withObjectLockMode(ObjectLockMode objectLockMode)
  {
    return withObjectLockMode(objectLockMode.toString());
  }
  
  public void setObjectLockMode(String objectLockMode)
  {
    withObjectLockMode(objectLockMode);
  }
  
  public void setObjectLockMode(ObjectLockMode objectLockMode)
  {
    setObjectLockMode(objectLockMode.toString());
  }
  
  public Date getObjectLockRetainUntilDate()
  {
    return objectLockRetainUntilDate;
  }
  
  public CopyObjectRequest withObjectLockRetainUntilDate(Date objectLockRetainUntilDate)
  {
    this.objectLockRetainUntilDate = objectLockRetainUntilDate;
    return this;
  }
  
  public void setObjectLockRetainUntilDate(Date objectLockRetainUntilDate)
  {
    withObjectLockRetainUntilDate(objectLockRetainUntilDate);
  }
  
  public String getObjectLockLegalHoldStatus()
  {
    return objectLockLegalHoldStatus;
  }
  
  public CopyObjectRequest withObjectLockLegalHoldStatus(String objectLockLegalHoldStatus)
  {
    this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
    return this;
  }
  
  public CopyObjectRequest withObjectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus)
  {
    return withObjectLockLegalHoldStatus(objectLockLegalHoldStatus.toString());
  }
  
  public void setObjectLockLegalHoldStatus(String objectLockLegalHoldStatus)
  {
    withObjectLockLegalHoldStatus(objectLockLegalHoldStatus);
  }
  
  public void setObjectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus)
  {
    setObjectLockLegalHoldStatus(objectLockLegalHoldStatus.toString());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CopyObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */