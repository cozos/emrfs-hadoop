package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class RestoreObjectRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private int expirationInDays;
  private String bucketName;
  private String key;
  private String versionId;
  private boolean isRequesterPays;
  private GlacierJobParameters glacierJobParameters;
  private String type;
  private String tier;
  private String description;
  private SelectParameters selectParameters;
  private OutputLocation outputLocation;
  
  public RestoreObjectRequest(String bucketName, String key)
  {
    this(bucketName, key, -1);
  }
  
  public RestoreObjectRequest(String bucketName, String key, int expirationInDays)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.expirationInDays = expirationInDays;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public RestoreObjectRequest withBucketName(String bucketName)
  {
    this.bucketName = bucketName;
    return this;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public void setKey(String key)
  {
    this.key = key;
  }
  
  public RestoreObjectRequest withKey(String key)
  {
    this.key = key;
    return this;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public void setVersionId(String versionId)
  {
    this.versionId = versionId;
  }
  
  public RestoreObjectRequest withVersionId(String versionId)
  {
    this.versionId = versionId;
    return this;
  }
  
  public void setExpirationInDays(int expirationInDays)
  {
    this.expirationInDays = expirationInDays;
  }
  
  public int getExpirationInDays()
  {
    return expirationInDays;
  }
  
  public RestoreObjectRequest withExpirationInDays(int expirationInDays)
  {
    this.expirationInDays = expirationInDays;
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
  
  public RestoreObjectRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
  
  public GlacierJobParameters getGlacierJobParameters()
  {
    return glacierJobParameters;
  }
  
  public void setGlacierJobParameters(GlacierJobParameters glacierJobParameters)
  {
    this.glacierJobParameters = glacierJobParameters;
  }
  
  public RestoreObjectRequest withGlacierJobParameters(GlacierJobParameters glacierJobParameters)
  {
    setGlacierJobParameters(glacierJobParameters);
    return this;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public RestoreObjectRequest withType(String restoreRequestType)
  {
    setType(restoreRequestType);
    return this;
  }
  
  public RestoreObjectRequest withType(RestoreRequestType restoreRequestType)
  {
    setType(restoreRequestType == null ? null : restoreRequestType.toString());
    return this;
  }
  
  public String getTier()
  {
    return tier;
  }
  
  public void setTier(String tier)
  {
    this.tier = tier;
  }
  
  public RestoreObjectRequest withTier(String tier)
  {
    this.tier = tier;
    return this;
  }
  
  public RestoreObjectRequest withTier(Tier tier)
  {
    this.tier = (tier == null ? null : tier.toString());
    return this;
  }
  
  public String getDescription()
  {
    return description;
  }
  
  public void setDescription(String description)
  {
    this.description = description;
  }
  
  public RestoreObjectRequest withDescription(String description)
  {
    this.description = description;
    return this;
  }
  
  public SelectParameters getSelectParameters()
  {
    return selectParameters;
  }
  
  public void setSelectParameters(SelectParameters selectParameters)
  {
    this.selectParameters = selectParameters;
  }
  
  public RestoreObjectRequest withSelectParameters(SelectParameters selectParameters)
  {
    this.selectParameters = selectParameters;
    return this;
  }
  
  public OutputLocation getOutputLocation()
  {
    return outputLocation;
  }
  
  public void setOutputLocation(OutputLocation outputLocation)
  {
    this.outputLocation = outputLocation;
  }
  
  public RestoreObjectRequest withOutputLocation(OutputLocation outputLocation)
  {
    this.outputLocation = outputLocation;
    return this;
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if ((obj == null) || (!(obj instanceof RestoreObjectRequest))) {
      return false;
    }
    RestoreObjectRequest other = (RestoreObjectRequest)obj;
    if (other.getExpirationInDays() != getExpirationInDays()) {
      return false;
    }
    if (((other.getBucketName() == null ? 1 : 0) ^ (getBucketName() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getBucketName() != null) && (!other.getBucketName().equals(getBucketName()))) {
      return false;
    }
    if (((other.getKey() == null ? 1 : 0) ^ (getKey() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKey() != null) && (!other.getKey().equals(getKey()))) {
      return false;
    }
    if (((other.getVersionId() == null ? 1 : 0) ^ (getVersionId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getVersionId() != null) && (!other.getVersionId().equals(getVersionId()))) {
      return false;
    }
    if (((other.getGlacierJobParameters() == null ? 1 : 0) ^ (getGlacierJobParameters() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGlacierJobParameters() != null) && (!other.getGlacierJobParameters().equals(getGlacierJobParameters()))) {
      return false;
    }
    if (((other.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getType() != null) && (!other.getType().equals(getType()))) {
      return false;
    }
    if (((other.getTier() == null ? 1 : 0) ^ (getTier() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getTier() != null) && (!other.getTier().equals(getTier()))) {
      return false;
    }
    if (((other.getDescription() == null ? 1 : 0) ^ (getDescription() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getDescription() != null) && (!other.getDescription().equals(getDescription()))) {
      return false;
    }
    if (((other.getSelectParameters() == null ? 1 : 0) ^ (getSelectParameters() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getSelectParameters() != null) && (!other.getSelectParameters().equals(getSelectParameters()))) {
      return false;
    }
    if (((other.getOutputLocation() == null ? 1 : 0) ^ (getOutputLocation() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOutputLocation() != null) && (!other.getOutputLocation().equals(getOutputLocation()))) {
      return false;
    }
    if (other.isRequesterPays() != isRequesterPays()) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getBucketName() == null ? 0 : getBucketName().hashCode());
    hashCode = 31 * hashCode + (getKey() == null ? 0 : getKey().hashCode());
    hashCode = 31 * hashCode + (getVersionId() == null ? 0 : getVersionId().hashCode());
    hashCode = 31 * hashCode + (getGlacierJobParameters() == null ? 0 : getGlacierJobParameters().hashCode());
    hashCode = 31 * hashCode + (getType() == null ? 0 : getType().hashCode());
    hashCode = 31 * hashCode + (getTier() != null ? getTier().hashCode() : 0);
    hashCode = 31 * hashCode + (getDescription() != null ? getDescription().hashCode() : 0);
    hashCode = 31 * hashCode + (getSelectParameters() != null ? getSelectParameters().hashCode() : 0);
    hashCode = 31 * hashCode + (getOutputLocation() != null ? getOutputLocation().hashCode() : 0);
    return hashCode;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    sb.append("ExpirationInDays: ").append(expirationInDays).append(",");
    sb.append("IsRequesterPays").append(isRequesterPays()).append(",");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
    }
    if (getKey() != null) {
      sb.append("Key: ").append(getKey()).append(",");
    }
    if (getVersionId() != null) {
      sb.append("VersionId: ").append(getVersionId()).append(",");
    }
    if (getGlacierJobParameters() != null) {
      sb.append("GlacierJobParameters: ").append(getGlacierJobParameters()).append(",");
    }
    if (getType() != null) {
      sb.append("RestoreRequestType: ").append(getType()).append(",");
    }
    if (getTier() != null) {
      sb.append("Tier: ").append(getTier()).append(",");
    }
    if (getDescription() != null) {
      sb.append("Description: ").append(getDescription()).append(",");
    }
    if (getSelectParameters() != null) {
      sb.append("SelectParameters: ").append(getSelectParameters()).append(",");
    }
    if (getOutputLocation() != null) {
      sb.append("OutputLocation").append(getOutputLocation());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public RestoreObjectRequest clone()
  {
    return (RestoreObjectRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.RestoreObjectRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */