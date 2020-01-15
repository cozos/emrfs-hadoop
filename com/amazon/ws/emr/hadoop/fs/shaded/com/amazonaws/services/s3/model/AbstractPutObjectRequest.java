package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;

public abstract class AbstractPutObjectRequest
  extends AmazonWebServiceRequest
  implements Cloneable, SSECustomerKeyProvider, SSEAwsKeyManagementParamsProvider, S3DataSource, Serializable
{
  private String bucketName;
  private String key;
  private File file;
  private transient InputStream inputStream;
  private ObjectMetadata metadata;
  private CannedAccessControlList cannedAcl;
  private AccessControlList accessControlList;
  private String storageClass;
  private String redirectLocation;
  private SSECustomerKey sseCustomerKey;
  private SSEAwsKeyManagementParams sseAwsKeyManagementParams;
  private ObjectTagging tagging;
  private String objectLockMode;
  private Date objectLockRetainUntilDate;
  private String objectLockLegalHoldStatus;
  
  public AbstractPutObjectRequest(String bucketName, String key, File file)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.file = file;
  }
  
  public AbstractPutObjectRequest(String bucketName, String key, String redirectLocation)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.redirectLocation = redirectLocation;
  }
  
  protected AbstractPutObjectRequest(String bucketName, String key, InputStream input, ObjectMetadata metadata)
  {
    this.bucketName = bucketName;
    this.key = key;
    inputStream = input;
    this.metadata = metadata;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public <T extends AbstractPutObjectRequest> T withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    T t = this;
    return t;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public <T extends AbstractPutObjectRequest> T withKey(String key)
  {
    setKey(key);
    T t = this;
    return t;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public <T extends AbstractPutObjectRequest> T withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    T t = this;
    return t;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    this.storageClass = storageClass.toString();
  }
  
  public <T extends AbstractPutObjectRequest> T withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass);
    T t = this;
    return t;
  }
  
  public File getFile()
  {
    return file;
  }
  
  public void setFile(File file)
  {
    this.file = file;
  }
  
  public <T extends AbstractPutObjectRequest> T withFile(File file)
  {
    setFile(file);
    T t = this;
    return t;
  }
  
  public ObjectMetadata getMetadata()
  {
    return metadata;
  }
  
  public void setMetadata(ObjectMetadata metadata)
  {
    this.metadata = metadata;
  }
  
  public <T extends AbstractPutObjectRequest> T withMetadata(ObjectMetadata metadata)
  {
    setMetadata(metadata);
    T t = this;
    return t;
  }
  
  public CannedAccessControlList getCannedAcl()
  {
    return cannedAcl;
  }
  
  public void setCannedAcl(CannedAccessControlList cannedAcl)
  {
    this.cannedAcl = cannedAcl;
  }
  
  public <T extends AbstractPutObjectRequest> T withCannedAcl(CannedAccessControlList cannedAcl)
  {
    setCannedAcl(cannedAcl);
    T t = this;
    return t;
  }
  
  public AccessControlList getAccessControlList()
  {
    return accessControlList;
  }
  
  public void setAccessControlList(AccessControlList accessControlList)
  {
    this.accessControlList = accessControlList;
  }
  
  public <T extends AbstractPutObjectRequest> T withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
    T t = this;
    return t;
  }
  
  public InputStream getInputStream()
  {
    return inputStream;
  }
  
  public void setInputStream(InputStream inputStream)
  {
    this.inputStream = inputStream;
  }
  
  public <T extends AbstractPutObjectRequest> T withInputStream(InputStream inputStream)
  {
    setInputStream(inputStream);
    T t = this;
    return t;
  }
  
  public void setRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
  }
  
  public String getRedirectLocation()
  {
    return redirectLocation;
  }
  
  public <T extends AbstractPutObjectRequest> T withRedirectLocation(String redirectLocation)
  {
    this.redirectLocation = redirectLocation;
    T t = this;
    return t;
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
  
  public <T extends AbstractPutObjectRequest> T withSSECustomerKey(SSECustomerKey sseKey)
  {
    setSSECustomerKey(sseKey);
    T t = this;
    return t;
  }
  
  public ObjectTagging getTagging()
  {
    return tagging;
  }
  
  public void setTagging(ObjectTagging tagging)
  {
    this.tagging = tagging;
  }
  
  public <T extends PutObjectRequest> T withTagging(ObjectTagging tagSet)
  {
    setTagging(tagSet);
    T t = (PutObjectRequest)this;
    return t;
  }
  
  public String getObjectLockMode()
  {
    return objectLockMode;
  }
  
  public <T extends PutObjectRequest> T withObjectLockMode(String objectLockMode)
  {
    this.objectLockMode = objectLockMode;
    return (PutObjectRequest)this;
  }
  
  public <T extends PutObjectRequest> T withObjectLockMode(ObjectLockMode objectLockMode)
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
  
  public <T extends PutObjectRequest> T withObjectLockRetainUntilDate(Date objectLockRetainUntilDate)
  {
    this.objectLockRetainUntilDate = objectLockRetainUntilDate;
    return (PutObjectRequest)this;
  }
  
  public void setObjectLockRetainUntilDate(Date objectLockRetainUntilDate)
  {
    withObjectLockRetainUntilDate(objectLockRetainUntilDate);
  }
  
  public String getObjectLockLegalHoldStatus()
  {
    return objectLockLegalHoldStatus;
  }
  
  public <T extends PutObjectRequest> T withObjectLockLegalHoldStatus(String objectLockLegalHoldStatus)
  {
    this.objectLockLegalHoldStatus = objectLockLegalHoldStatus;
    return (PutObjectRequest)this;
  }
  
  public <T extends PutObjectRequest> T withObjectLockLegalHoldStatus(ObjectLockLegalHoldStatus objectLockLegalHoldStatus)
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
  public <T extends AbstractPutObjectRequest> T withProgressListener(ProgressListener progressListener)
  {
    setProgressListener(progressListener);
    T t = this;
    return t;
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
  
  public <T extends AbstractPutObjectRequest> T withSSEAwsKeyManagementParams(SSEAwsKeyManagementParams sseAwsKeyManagementParams)
  {
    setSSEAwsKeyManagementParams(sseAwsKeyManagementParams);
    T t = this;
    return t;
  }
  
  public AbstractPutObjectRequest clone()
  {
    return (AbstractPutObjectRequest)super.clone();
  }
  
  protected final <T extends AbstractPutObjectRequest> T copyPutObjectBaseTo(T target)
  {
    copyBaseTo(target);
    ObjectMetadata metadata = getMetadata();
    return target.withAccessControlList(getAccessControlList())
      .withCannedAcl(getCannedAcl())
      .withInputStream(getInputStream())
      .withMetadata(metadata == null ? null : metadata.clone())
      .withRedirectLocation(getRedirectLocation())
      .withStorageClass(getStorageClass())
      .withSSEAwsKeyManagementParams(getSSEAwsKeyManagementParams())
      .withSSECustomerKey(getSSECustomerKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AbstractPutObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */