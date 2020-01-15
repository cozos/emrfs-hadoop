package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetPublicAccessBlockRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String bucketName;
  private PublicAccessBlockConfiguration publicAccessBlockConfiguration;
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetPublicAccessBlockRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public PublicAccessBlockConfiguration getPublicAccessBlockConfiguration()
  {
    return publicAccessBlockConfiguration;
  }
  
  public void setPublicAccessBlockConfiguration(PublicAccessBlockConfiguration publicAccessBlockConfiguration)
  {
    this.publicAccessBlockConfiguration = publicAccessBlockConfiguration;
  }
  
  public SetPublicAccessBlockRequest withPublicAccessBlockConfiguration(PublicAccessBlockConfiguration publicAccessBlockConfiguration)
  {
    setPublicAccessBlockConfiguration(publicAccessBlockConfiguration);
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
    SetPublicAccessBlockRequest that = (SetPublicAccessBlockRequest)o;
    if (bucketName != null ? !bucketName.equals(bucketName) : bucketName != null) {
      return false;
    }
    return publicAccessBlockConfiguration == null ? true : publicAccessBlockConfiguration != null ? publicAccessBlockConfiguration.equals(publicAccessBlockConfiguration) : false;
  }
  
  public int hashCode()
  {
    int result = bucketName != null ? bucketName.hashCode() : 0;
    result = 31 * result + (publicAccessBlockConfiguration != null ? publicAccessBlockConfiguration.hashCode() : 0);
    return result;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBucketName() != null) {
      sb.append("BucketName: ").append(getBucketName()).append(",");
    }
    if (getPublicAccessBlockConfiguration() != null) {
      sb.append("PublicAccessBlockConfiguration: ").append(getPublicAccessBlockConfiguration()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public SetPublicAccessBlockRequest clone()
  {
    return (SetPublicAccessBlockRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetPublicAccessBlockRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */