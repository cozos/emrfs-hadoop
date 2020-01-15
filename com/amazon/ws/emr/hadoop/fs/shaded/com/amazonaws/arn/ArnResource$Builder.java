package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

public final class ArnResource$Builder
{
  private String resourceType;
  private String resource;
  private String qualifier;
  
  public void setResourceType(String resourceType)
  {
    this.resourceType = resourceType;
  }
  
  public Builder withResourceType(String resourceType)
  {
    setResourceType(resourceType);
    return this;
  }
  
  public void setResource(String resource)
  {
    this.resource = resource;
  }
  
  public Builder withResource(String resource)
  {
    setResource(resource);
    return this;
  }
  
  public void setQualifier(String qualifier)
  {
    this.qualifier = qualifier;
  }
  
  public Builder withQualifier(String qualifier)
  {
    setQualifier(qualifier);
    return this;
  }
  
  public ArnResource build()
  {
    return new ArnResource(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.ArnResource.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */