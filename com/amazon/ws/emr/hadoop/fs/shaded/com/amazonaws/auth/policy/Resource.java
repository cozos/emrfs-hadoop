package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

public class Resource
{
  private final String resource;
  private boolean isNotType;
  
  public Resource(String resource)
  {
    this.resource = resource;
  }
  
  public String getId()
  {
    return resource;
  }
  
  public boolean isNotType()
  {
    return isNotType;
  }
  
  public Resource withIsNotType(boolean isNotType)
  {
    this.isNotType = isNotType;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Resource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */