package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeEndpointsResult
  extends AmazonWebServiceResult<ResponseMetadata>
  implements Serializable, Cloneable
{
  private List<Endpoint> endpoints;
  
  public List<Endpoint> getEndpoints()
  {
    return endpoints;
  }
  
  public void setEndpoints(Collection<Endpoint> endpoints)
  {
    if (endpoints == null)
    {
      this.endpoints = null;
      return;
    }
    this.endpoints = new ArrayList(endpoints);
  }
  
  public DescribeEndpointsResult withEndpoints(Endpoint... endpoints)
  {
    if (this.endpoints == null) {
      setEndpoints(new ArrayList(endpoints.length));
    }
    for (Endpoint ele : endpoints) {
      this.endpoints.add(ele);
    }
    return this;
  }
  
  public DescribeEndpointsResult withEndpoints(Collection<Endpoint> endpoints)
  {
    setEndpoints(endpoints);
    return this;
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (getEndpoints() != null) {
      sb.append("Endpoints: ").append(getEndpoints());
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
    if (!(obj instanceof DescribeEndpointsResult)) {
      return false;
    }
    DescribeEndpointsResult other = (DescribeEndpointsResult)obj;
    if (((other.getEndpoints() == null ? 1 : 0) ^ (getEndpoints() == null ? 1 : 0)) != 0) {
      return false;
    }
    if ((other.getEndpoints() != null) && (!other.getEndpoints().equals(getEndpoints()))) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int hashCode = 1;
    
    hashCode = 31 * hashCode + (getEndpoints() == null ? 0 : getEndpoints().hashCode());
    return hashCode;
  }
  
  public DescribeEndpointsResult clone()
  {
    try
    {
      return (DescribeEndpointsResult)super.clone();
    }
    catch (CloneNotSupportedException e)
    {
      throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeEndpointsResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */