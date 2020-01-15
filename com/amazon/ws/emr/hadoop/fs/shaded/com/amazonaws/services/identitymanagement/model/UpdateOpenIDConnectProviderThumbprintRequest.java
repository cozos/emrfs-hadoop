package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class UpdateOpenIDConnectProviderThumbprintRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String openIDConnectProviderArn;
  private SdkInternalList<String> thumbprintList;
  
  public void setOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    this.openIDConnectProviderArn = openIDConnectProviderArn;
  }
  
  public String getOpenIDConnectProviderArn()
  {
    return openIDConnectProviderArn;
  }
  
  public UpdateOpenIDConnectProviderThumbprintRequest withOpenIDConnectProviderArn(String openIDConnectProviderArn)
  {
    setOpenIDConnectProviderArn(openIDConnectProviderArn);
    return this;
  }
  
  public List<String> getThumbprintList()
  {
    if (thumbprintList == null) {
      thumbprintList = new SdkInternalList();
    }
    return thumbprintList;
  }
  
  public void setThumbprintList(Collection<String> thumbprintList)
  {
    if (thumbprintList == null)
    {
      this.thumbprintList = null;
      return;
    }
    this.thumbprintList = new SdkInternalList(thumbprintList);
  }
  
  public UpdateOpenIDConnectProviderThumbprintRequest withThumbprintList(String... thumbprintList)
  {
    if (this.thumbprintList == null) {
      setThumbprintList(new SdkInternalList(thumbprintList.length));
    }
    for (String ele : thumbprintList) {
      this.thumbprintList.add(ele);
    }
    return this;
  }
  
  public UpdateOpenIDConnectProviderThumbprintRequest withThumbprintList(Collection<String> thumbprintList)
  {
    setThumbprintList(thumbprintList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getOpenIDConnectProviderArn() != null) {
      sb.append("OpenIDConnectProviderArn: ").append(getOpenIDConnectProviderArn()).append(",");
    }
    if (getThumbprintList() != null) {
      sb.append("ThumbprintList: ").append(getThumbprintList());
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
    if (!(obj instanceof UpdateOpenIDConnectProviderThumbprintRequest)) {
      return false;
    }
    UpdateOpenIDConnectProviderThumbprintRequest other = (UpdateOpenIDConnectProviderThumbprintRequest)obj;
    if (((other.getOpenIDConnectProviderArn() == null ? 1 : 0) ^ (getOpenIDConnectProviderArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getOpenIDConnectProviderArn() != null) && (!other.getOpenIDConnectProviderArn().equals(getOpenIDConnectProviderArn()))) {
      return false;
    }
    if (((other.getThumbprintList() == null ? 1 : 0) ^ (getThumbprintList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getThumbprintList() != null) && (!other.getThumbprintList().equals(getThumbprintList()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getOpenIDConnectProviderArn() == null ? 0 : getOpenIDConnectProviderArn().hashCode());
    hashCode = 31 * hashCode + (getThumbprintList() == null ? 0 : getThumbprintList().hashCode());
    return hashCode;
  }
  
  public UpdateOpenIDConnectProviderThumbprintRequest clone()
  {
    return (UpdateOpenIDConnectProviderThumbprintRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateOpenIDConnectProviderThumbprintRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */