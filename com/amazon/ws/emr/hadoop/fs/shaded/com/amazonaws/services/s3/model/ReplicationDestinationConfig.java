package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import java.io.Serializable;

public class ReplicationDestinationConfig
  implements Serializable
{
  private String bucketARN;
  private String account;
  private String storageClass;
  private AccessControlTranslation accessControlTranslation;
  private EncryptionConfiguration encryptionConfiguration;
  
  public String getBucketARN()
  {
    return bucketARN;
  }
  
  public void setBucketARN(String bucketARN)
  {
    if (bucketARN == null) {
      throw new IllegalArgumentException("Bucket name cannot be null");
    }
    this.bucketARN = bucketARN;
  }
  
  public ReplicationDestinationConfig withBucketARN(String bucketARN)
  {
    setBucketARN(bucketARN);
    return this;
  }
  
  public String getAccount()
  {
    return account;
  }
  
  public void setAccount(String account)
  {
    this.account = account;
  }
  
  public ReplicationDestinationConfig withAccount(String account)
  {
    setAccount(account);
    return this;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass == null ? (String)null : storageClass.toString());
  }
  
  public ReplicationDestinationConfig withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public ReplicationDestinationConfig withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass == null ? (String)null : storageClass.toString());
    return this;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public AccessControlTranslation getAccessControlTranslation()
  {
    return accessControlTranslation;
  }
  
  public void setAccessControlTranslation(AccessControlTranslation accessControlTranslation)
  {
    this.accessControlTranslation = accessControlTranslation;
  }
  
  public ReplicationDestinationConfig withAccessControlTranslation(AccessControlTranslation accessControlTranslation)
  {
    setAccessControlTranslation(accessControlTranslation);
    return this;
  }
  
  public EncryptionConfiguration getEncryptionConfiguration()
  {
    return encryptionConfiguration;
  }
  
  public void setEncryptionConfiguration(EncryptionConfiguration encryptionConfiguration)
  {
    this.encryptionConfiguration = encryptionConfiguration;
  }
  
  public ReplicationDestinationConfig withEncryptionConfiguration(EncryptionConfiguration encryptionConfiguration)
  {
    setEncryptionConfiguration(encryptionConfiguration);
    return this;
  }
  
  public String toString()
  {
    return Jackson.toJsonString(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ReplicationDestinationConfig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */