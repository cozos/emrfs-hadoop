package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class ListTagsOfResourceRequest
  extends AmazonWebServiceRequest
  implements Serializable, Cloneable
{
  private String resourceArn;
  private String nextToken;
  
  public void setResourceArn(String resourceArn)
  {
    this.resourceArn = resourceArn;
  }
  
  public String getResourceArn()
  {
    return resourceArn;
  }
  
  public ListTagsOfResourceRequest withResourceArn(String resourceArn)
  {
    setResourceArn(resourceArn);
    return this;
  }
  
  public void setNextToken(String nextToken)
  {
    this.nextToken = nextToken;
  }
  
  public String getNextToken()
  {
    return nextToken;
  }
  
  public ListTagsOfResourceRequest withNextToken(String nextToken)
  {
    setNextToken(nextToken);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getResourceArn() != null) {
      sb.append("ResourceArn: ").append(getResourceArn()).append(",");
    }
    if (getNextToken() != null) {
      sb.append("NextToken: ").append(getNextToken());
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
    if (!(obj instanceof ListTagsOfResourceRequest)) {
      return false;
    }
    ListTagsOfResourceRequest other = (ListTagsOfResourceRequest)obj;
    if (((other.getResourceArn() == null ? 1 : 0) ^ (getResourceArn() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getResourceArn() != null) && (!other.getResourceArn().equals(getResourceArn()))) {
      return false;
    }
    if (((other.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getNextToken() != null) && (!other.getNextToken().equals(getNextToken()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getResourceArn() == null ? 0 : getResourceArn().hashCode());
    hashCode = 31 * hashCode + (getNextToken() == null ? 0 : getNextToken().hashCode());
    return hashCode;
  }
  
  public ListTagsOfResourceRequest clone()
  {
    return (ListTagsOfResourceRequest)super.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */