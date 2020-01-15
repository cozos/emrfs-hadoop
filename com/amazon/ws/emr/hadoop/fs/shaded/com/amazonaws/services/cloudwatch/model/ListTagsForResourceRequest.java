package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTagsForResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceARN;
  
  public void setResourceARN(String resourceARN)
  {
    this.resourceARN = resourceARN;
  }
  
  public String getResourceARN()
  {
    return resourceARN;
  }
  
  public ListTagsForResourceRequest withResourceARN(String resourceARN)
  {
    setResourceARN(resourceARN);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceARN() != null) {
      sb.append("ResourceARN: ").append(getResourceARN());
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
    if (!(obj instanceof ListTagsForResourceRequest)) {
      return false;
    }
    ListTagsForResourceRequest other = (ListTagsForResourceRequest)obj;
    if (((other.getResourceARN() == null ? 1 : 0) ^ (getResourceARN() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceARN() != null) && (!other.getResourceARN().equals(getResourceARN()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getResourceARN() == null ? 0 : getResourceARN().hashCode());
    return hashCode;
  }
  
  public ListTagsForResourceRequest clone()
  {
    return (ListTagsForResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListTagsForResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */