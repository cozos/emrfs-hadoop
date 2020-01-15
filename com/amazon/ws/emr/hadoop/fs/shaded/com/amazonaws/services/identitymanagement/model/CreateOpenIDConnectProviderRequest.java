package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.SdkInternalList;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class CreateOpenIDConnectProviderRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String url;
  private SdkInternalList<String> clientIDList;
  private SdkInternalList<String> thumbprintList;
  
  public void setUrl(String url)
  {
    this.url = url;
  }
  
  public String getUrl()
  {
    return url;
  }
  
  public CreateOpenIDConnectProviderRequest withUrl(String url)
  {
    setUrl(url);
    return this;
  }
  
  public List<String> getClientIDList()
  {
    if (clientIDList == null) {
      clientIDList = new SdkInternalList();
    }
    return clientIDList;
  }
  
  public void setClientIDList(Collection<String> clientIDList)
  {
    if (clientIDList == null)
    {
      this.clientIDList = null;
      return;
    }
    this.clientIDList = new SdkInternalList(clientIDList);
  }
  
  public CreateOpenIDConnectProviderRequest withClientIDList(String... clientIDList)
  {
    if (this.clientIDList == null) {
      setClientIDList(new SdkInternalList(clientIDList.length));
    }
    for (String ele : clientIDList) {
      this.clientIDList.add(ele);
    }
    return this;
  }
  
  public CreateOpenIDConnectProviderRequest withClientIDList(Collection<String> clientIDList)
  {
    setClientIDList(clientIDList);
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
  
  public CreateOpenIDConnectProviderRequest withThumbprintList(String... thumbprintList)
  {
    if (this.thumbprintList == null) {
      setThumbprintList(new SdkInternalList(thumbprintList.length));
    }
    for (String ele : thumbprintList) {
      this.thumbprintList.add(ele);
    }
    return this;
  }
  
  public CreateOpenIDConnectProviderRequest withThumbprintList(Collection<String> thumbprintList)
  {
    setThumbprintList(thumbprintList);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getUrl() != null) {
      sb.append("Url: ").append(getUrl()).append(",");
    }
    if (getClientIDList() != null) {
      sb.append("ClientIDList: ").append(getClientIDList()).append(",");
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
    if (!(obj instanceof CreateOpenIDConnectProviderRequest)) {
      return false;
    }
    CreateOpenIDConnectProviderRequest other = (CreateOpenIDConnectProviderRequest)obj;
    if (((other.getUrl() == null ? 1 : 0) ^ (getUrl() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getUrl() != null) && (!other.getUrl().equals(getUrl()))) {
      return false;
    }
    if (((other.getClientIDList() == null ? 1 : 0) ^ (getClientIDList() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getClientIDList() != null) && (!other.getClientIDList().equals(getClientIDList()))) {
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
    
    hashCode = 31 * hashCode + (getUrl() == null ? 0 : getUrl().hashCode());
    hashCode = 31 * hashCode + (getClientIDList() == null ? 0 : getClientIDList().hashCode());
    hashCode = 31 * hashCode + (getThumbprintList() == null ? 0 : getThumbprintList().hashCode());
    return hashCode;
  }
  
  public CreateOpenIDConnectProviderRequest clone()
  {
    return (CreateOpenIDConnectProviderRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */