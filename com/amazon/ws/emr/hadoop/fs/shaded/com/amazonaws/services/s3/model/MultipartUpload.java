package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.Date;

public class MultipartUpload
  implements Serializable
{
  private String key;
  private String uploadId;
  private Owner owner;
  private Owner initiator;
  private String storageClass;
  private Date initiated;
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public String getUploadId()
  {
    return uploadId;
  }
  
  public void setUploadId(String uploadId)
  {
    this.uploadId = uploadId;
  }
  
  public Owner getOwner()
  {
    return owner;
  }
  
  public void setOwner(Owner owner)
  {
    this.owner = owner;
  }
  
  public Owner getInitiator()
  {
    return initiator;
  }
  
  public void setInitiator(Owner initiator)
  {
    this.initiator = initiator;
  }
  
  public String getStorageClass()
  {
    return storageClass;
  }
  
  public void setStorageClass(String storageClass)
  {
    this.storageClass = storageClass;
  }
  
  public Date getInitiated()
  {
    return initiated;
  }
  
  public void setInitiated(Date initiated)
  {
    this.initiated = initiated;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.MultipartUpload
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */