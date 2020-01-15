package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;

public class PublicAccessBlockConfiguration
  implements Serializable, Cloneable
{
  private Boolean blockPublicAcls;
  private Boolean ignorePublicAcls;
  private Boolean blockPublicPolicy;
  private Boolean restrictPublicBuckets;
  
  public Boolean getBlockPublicAcls()
  {
    return blockPublicAcls;
  }
  
  public void setBlockPublicAcls(Boolean blockPublicAcls)
  {
    this.blockPublicAcls = blockPublicAcls;
  }
  
  public PublicAccessBlockConfiguration withBlockPublicAcls(Boolean blockPublicAcls)
  {
    setBlockPublicAcls(blockPublicAcls);
    return this;
  }
  
  public Boolean getIgnorePublicAcls()
  {
    return ignorePublicAcls;
  }
  
  public void setIgnorePublicAcls(Boolean ignorePublicAcls)
  {
    this.ignorePublicAcls = ignorePublicAcls;
  }
  
  public PublicAccessBlockConfiguration withIgnorePublicAcls(Boolean ignorePublicAcls)
  {
    setIgnorePublicAcls(ignorePublicAcls);
    return this;
  }
  
  public Boolean getBlockPublicPolicy()
  {
    return blockPublicPolicy;
  }
  
  public void setBlockPublicPolicy(Boolean blockPublicPolicy)
  {
    this.blockPublicPolicy = blockPublicPolicy;
  }
  
  public PublicAccessBlockConfiguration withBlockPublicPolicy(Boolean blockPublicPolicy)
  {
    setBlockPublicPolicy(blockPublicPolicy);
    return this;
  }
  
  public Boolean getRestrictPublicBuckets()
  {
    return restrictPublicBuckets;
  }
  
  public void setRestrictPublicBuckets(Boolean restrictPublicBuckets)
  {
    this.restrictPublicBuckets = restrictPublicBuckets;
  }
  
  public PublicAccessBlockConfiguration withRestrictPublicBuckets(Boolean restrictPublicBuckets)
  {
    setRestrictPublicBuckets(restrictPublicBuckets);
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
    PublicAccessBlockConfiguration that = (PublicAccessBlockConfiguration)o;
    if (blockPublicAcls != null ? !blockPublicAcls.equals(blockPublicAcls) : blockPublicAcls != null) {
      return false;
    }
    if (ignorePublicAcls != null ? !ignorePublicAcls.equals(ignorePublicAcls) : ignorePublicAcls != null) {
      return false;
    }
    if (blockPublicPolicy != null ? !blockPublicPolicy.equals(blockPublicPolicy) : blockPublicPolicy != null) {
      return false;
    }
    return restrictPublicBuckets == null ? true : restrictPublicBuckets != null ? restrictPublicBuckets.equals(restrictPublicBuckets) : false;
  }
  
  public int hashCode()
  {
    int result = blockPublicAcls != null ? blockPublicAcls.hashCode() : 0;
    result = 31 * result + (ignorePublicAcls != null ? ignorePublicAcls.hashCode() : 0);
    result = 31 * result + (blockPublicPolicy != null ? blockPublicPolicy.hashCode() : 0);
    result = 31 * result + (restrictPublicBuckets != null ? restrictPublicBuckets.hashCode() : 0);
    return result;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getBlockPublicAcls() != null) {
      sb.append("BlockPublicAcls: ").append(getBlockPublicAcls()).append(",");
    }
    if (getIgnorePublicAcls() != null) {
      sb.append("IgnorePublicAcls: ").append(getIgnorePublicAcls()).append(",");
    }
    if (getBlockPublicPolicy() != null) {
      sb.append("BlockPublicPolicy: ").append(getBlockPublicPolicy()).append(",");
    }
    if (getRestrictPublicBuckets() != null) {
      sb.append("RestrictPublicBuckets: ").append(getRestrictPublicBuckets()).append(",");
    }
    sb.append("}");
    return sb.toString();
  }
  
  public PublicAccessBlockConfiguration clone()
  {
    try
    {
      return (PublicAccessBlockConfiguration)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PublicAccessBlockConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */