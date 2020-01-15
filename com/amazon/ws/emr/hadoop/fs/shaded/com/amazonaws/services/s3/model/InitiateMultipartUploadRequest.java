package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.Date;

public class InitiateMultipartUploadRequest
  extends AmazonWebServiceRequest
  implements SSECustomerKeyProvider, SSEAwsKeyManagementParamsProvider, Serializable
{
  private String bucketName;
  private String key;
  public ObjectMetadata objectMetadata;
  private CannedAccessControlList cannedACL;
  private AccessControlList accessControlList;
  private StorageClass storageClass;
  private String redirectLocation;
  private SSECustomerKey sseCustomerKey;
  private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
  private boolean isRequesterPays;
  private ObjectTagging tagging;
  private String objectLockMode;
  private Date objectLockRetainUntilDate;
  private String objectLockLegalHoldStatus;
  
  public InitiateMultipartUploadRequest(String bucketName, String key)
  {
    this.bucketName = bucketName;
    this.key = key;
  }
  
  public InitiateMultipartUploadRequest(String bucketName, String key, ObjectMetadata objectMetadata)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.objectMetadata = objectMetadata;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public InitiateMultipartUploadRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
    return this;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public InitiateMultipartUploadRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public CannedAccessControlList getCannedACL()
  {
    return cannedACL;
  }
  
  public void setCannedACL(CannedAccessControlList cannedACL)
  {
    this.cannedACL = cannedACL;
  }
  
  public InitiateMultipartUploadRequest withCannedACL(CannedAccessControlList acl)
  {
    cannedACL = acl;
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
  
  public InitiateMultipartUploadRequest withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
    return this;
  }
  
  public StorageClass getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public InitiateMultipartUploadRequest withStorageClass(StorageClass storageClass)
  {
    this.storageClass = storageClass;
    return this;
  }
  
  public InitiateMultipartUploadRequest withStorageClass(String storageClass)
  {
    if (storageClass != null) {
      this.storageClass = StorageClass.fromValue(storageClass);
    } else {
      this.storageClass = null;
    }
    return this;
  }
  
  public ObjectMetadata getObjectMetadata()
  {
    return objectMetadata;
  }
  
  public void setObjectMetadata(ObjectMetadata objectMetadata)
  {
    this.objectMetadata = objectMetadata;
  }
  
  public InitiateMultipartUploadRequest withObjectMetadata(ObjectMetadata objectMetadata)
  {
    setObjectMetadata(objectMetadata);
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
  
  public InitiateMultipartUploadRequest withRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
    return this;
  }
  
  public SSECustomerKey getSSECustomerKey()
  {
    return sseCustomerKey;
  }
  
  public void setSSECustomerKey(SSECustomerKey sseKey)
  {
    if ((sseKey != null) && (sseAwsKeyManagementParams != null)) {
      throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }
    sseCustomerKey = sseKey;
  }
  
  public InitiateMultipartUploadRequest withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    return this;
  }
  
  public SSEAwsKeyManagementParams getSSEAwsKeyManagementParams()
  {
    return sseAwsKeyManagementParams;
  }
  
  public void setSSEAwsKeyManagementParams(SSEAwsKeyManagementParams params)
  {
    if ((params != null) && (sseCustomerKey != null)) {
      throw new IllegalArgumentException("Either SSECustomerKey or SSEAwsKeyManagementParams must not be set at the same time.");
    }
    sseAwsKeyManagementParams = params;
  }
  
  public InitiateMultipartUploadRequest withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sseAwsKeyManagementParams)
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
  
  public InitiateMultipartUploadRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public ObjectTagging getTagging()
  {
    return tagging;
  }
  
  public void setTagging(ObjectTagging tagging)
  {
    this.tagging = tagging;
  }
  
  public InitiateMultipartUploadRequest withTagging(ObjectTagging tagging)
  {
    setTagging(tagging);
    return this;
  }
  
  public String getObjectLockMode()
  {
    return objectLockMode;
  }
  
  public InitiateMultipartUploadRequest withObjectLockMode(String objectLockMode)
  {
    this.objectLockMode = objectLockMode;
    return this;
  }
  
  public InitiateMultipartUploadRequest withObjectLockMode(ObjectLockMode objectLockMode)
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
  
  public InitiateMultipartUploadRequest withObjectLockRetainUntilDate(Date objectLockRetainUntilDate)
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
  
  public InitiateMultipartUploadRequest withObjectLockLegalHoldStatus(String objectLockLegalHoldStatus)
  {
    this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
    return this;
  }
  
  public InitiateMultipartUploadRequest withObjectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus)
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.InitiateMultipartUploadRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */