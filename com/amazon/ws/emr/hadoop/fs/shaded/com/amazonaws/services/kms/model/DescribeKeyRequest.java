package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class DescribeKeyRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String keyId;
  private SdkInternalList<String> grantTokens;
  
  public void setKeyId(String keyId)
  {
    this.keyId = keyId;
  }
  
  public String getKeyId()
  {
    return keyId;
  }
  
  public DescribeKeyRequest withKeyId(String keyId)
  {
    setKeyId(keyId);
    return this;
  }
  
  public List<String> getGrantTokens()
  {
    if (grantTokens == null) {
      grantTokens = new SdkInternalList();
    }
    return grantTokens;
  }
  
  public void setGrantTokens(Collection<String> grantTokens)
  {
    if (grantTokens == null)
    {
      this.grantTokens = null;
      return;
    }
    this.grantTokens = new SdkInternalList(grantTokens);
  }
  
  public DescribeKeyRequest withGrantTokens(String... grantTokens)
  {
    if (this.grantTokens == null) {
      setGrantTokens(new SdkInternalList(grantTokens.length));
    }
    for (String ele : grantTokens) {
      this.grantTokens.add(ele);
    }
    return this;
  }
  
  public DescribeKeyRequest withGrantTokens(Collection<String> grantTokens)
  {
    setGrantTokens(grantTokens);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getKeyId() != null) {
      sb.append("KeyId: ").append(getKeyId()).append(",");
    }
    if (getGrantTokens() != null) {
      sb.append("GrantTokens: ").append(getGrantTokens());
    }
    sb.append("}");
    return sb.toString();
  }
  
  public boolean equals(Object obj)
  {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof DescribeKeyRequest)) {
      return false;
    }
    DescribeKeyRequest other = (DescribeKeyRequest)obj;
    if (((other.getKeyId() == null ? 1 : 0) ^ (getKeyId() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getKeyId() != null) && (!other.getKeyId().equals(getKeyId()))) {
      return false;
    }
    if (((other.getGrantTokens() == null ? 1 : 0) ^ (getGrantTokens() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getGrantTokens() != null) && (!other.getGrantTokens().equals(getGrantTokens()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getKeyId() == null ? 0 : getKeyId().hashCode());
    hashCode = 31 * hashCode + (getGrantTokens() == null ? 0 : getGrantTokens().hashCode());
    return hashCode;
  }
  
  public DescribeKeyRequest clone()
  {
    return (DescribeKeyRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeKeyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */