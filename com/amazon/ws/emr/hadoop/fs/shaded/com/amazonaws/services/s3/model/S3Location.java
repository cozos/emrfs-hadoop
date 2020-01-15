package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.List;

public class S3Location
  implements Serializable, Cloneable
{
  private String bucketName;
  private String prefix;
  private Encryption encryption;
  private String cannedACL;
  private AccessControlList accessControlList;
  private ObjectTagging tagging;
  private List<MetadataEntry> userMetadata;
  private String storageClass;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public S3Location withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getPrefix()
  {
    return prefix;
  }
  
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
  }
  
  public S3Location withPrefix(String prefix)
  {
    setPrefix(prefix);
    return this;
  }
  
  public Encryption getEncryption()
  {
    return encryption;
  }
  
  public void setEncryption(Encryption encryption)
  {
    this.encryption = encryption;
  }
  
  public S3Location withEncryption(Encryption encryption)
  {
    setEncryption(encryption);
    return this;
  }
  
  public String getCannedACL()
  {
    return cannedACL;
  }
  
  public void setCannedACL(String cannedACL)
  {
    this.cannedACL = cannedACL;
  }
  
  public S3Location withCannedACL(String cannedACL)
  {
    setCannedACL(cannedACL);
    return this;
  }
  
  public S3Location withCannedACL(CannedAccessControlList cannedACL)
  {
    setCannedACL(cannedACL == null ? null : cannedACL.toString());
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
  
  public S3Location withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
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
  
  public S3Location withTagging(ObjectTagging tagging)
  {
    setTagging(tagging);
    return this;
  }
  
  public List<MetadataEntry> getUserMetadata()
  {
    return userMetadata;
  }
  
  public void setUserMetadata(List<MetadataEntry> userMetadata)
  {
    this.userMetadata = userMetadata;
  }
  
  public S3Location withUserMetaData(List<MetadataEntry> userMetadata)
  {
    setUserMetadata(userMetadata);
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
  
  public S3Location withStorageClass(String storageClass)
  {
    setStorageClass(storageClass);
    return this;
  }
  
  public S3Location withStorageClass(StorageClass storageClass)
  {
    setStorageClass(storageClass == null ? null : storageClass.toString());
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof S3Location))) {
      return false;
    }
    S3Location other = (S3Location)obj;
    if (((other.getBucketName() == null ? 1 : 0) ^ (getBucketName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBucketName() != null) && (!other.getBucketName().equals(getBucketName()))) {
      return false;
    }
    if (((other.getPrefix() == null ? 1 : 0) ^ (getPrefix() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getPrefix() != null) && (!other.getPrefix().equals(getPrefix()))) {
      return false;
    }
    if (((other.getEncryption() == null ? 1 : 0) ^ (getEncryption() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEncryption() != null) && (!other.getEncryption().equals(getEncryption()))) {
      return false;
    }
    if (((other.getCannedACL() == null ? 1 : 0) ^ (getCannedACL() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getCannedACL() != null) && (!other.getCannedACL().equals(getCannedACL()))) {
      return false;
    }
    if (((other.getAccessControlList() == null ? 1 : 0) ^ (getAccessControlList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getAccessControlList() != null) && (!other.getAccessControlList().equals(getAccessControlList()))) {
      return false;
    }
    if (((other.getTagging() == null ? 1 : 0) ^ (getTagging() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTagging() != null) && (!other.getTagging().equals(getTagging()))) {
      return false;
    }
    if (((other.getUserMetadata() == null ? 1 : 0) ^ (getUserMetadata() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUserMetadata() != null) && (!other.getUserMetadata().equals(getUserMetadata()))) {
      return false;
    }
    if (((other.getStorageClass() == null ? 1 : 0) ^ (getStorageClass() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getStorageClass() != null) && (!other.getStorageClass().equals(getStorageClass()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBucketName() == null ? 0 : getBucketName().hashCode());
    hashCode = 31 * hashCode + (getPrefix() == null ? 0 : getPrefix().hashCode());
    hashCode = 31 * hashCode + (getEncryption() == null ? 0 : getEncryption().hashCode());
    hashCode = 31 * hashCode + (getCannedACL() == null ? 0 : getCannedACL().hashCode());
    hashCode = 31 * hashCode + (getAccessControlList() == null ? 0 : getAccessControlList().hashCode());
    hashCode = 31 * hashCode + (getTagging() != null ? getTagging().hashCode() : 0);
    hashCode = 31 * hashCode + (getUserMetadata() != null ? getUserMetadata().hashCode() : 0);
    hashCode = 31 * hashCode + (getStorageClass() != null ? getStorageClass().hashCode() : 0);
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
    }
    if (getPrefix() != null) {
      sb.append("Prefix: ").append(getPrefix()).append(",");
    }
    if (getEncryption() != null) {
      sb.append("Encryption: ").append(getEncryption()).append(",");
    }
    if (getCannedACL() != null) {
      sb.append("CannedACL: ").append(getCannedACL()).append(",");
    }
    if (getAccessControlList() != null) {
      sb.append("AccessControlList: ").append(getAccessControlList()).append(",");
    }
    if (getTagging() != null) {
      sb.append("Tagging: ").append(getTagging()).append(",");
    }
    if (getUserMetadata() != null) {
      sb.append("UserMetadata: ").append(getUserMetadata()).append(",");
    }
    if (getStorageClass() != null) {
      sb.append("StorageClass: ").append(getStorageClass());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public S3Location clone()
  {
    try
    {
      return (S3Location)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Location
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */