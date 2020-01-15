package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class BucketLifecycleConfiguration$NoncurrentVersionTransition
  implements Serializable
{
  private int days = -1;
  private String storageClass;
  
  public void setDays(int expirationInDays)
  {
    days = expirationInDays;
  }
  
  public int getDays()
  {
    return days;
  }
  
  public NoncurrentVersionTransition withDays(int expirationInDays)
  {
    days = expirationInDays;
    return this;
  }
  
  public void setStorageClass(StorageClass storageClass)
  {
    if (storageClass == null) {
      setStorageClass((String)null);
    } else {
      setStorageClass(storageClass.toString());
    }
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  @Deprecated
  public StorageClass getStorageClass()
  {
    try
    {
      return StorageClass.fromValue(storageClass);
    }
    catch (IllegalArgumentException ignored) {}
    return null;
  }
  
  public String getStorageClassAsString()
  {
    return storageClass;
  }
  
  public NoncurrentVersionTransition withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public NoncurrentVersionTransition withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketLifecycleConfiguration.NoncurrentVersionTransition
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */