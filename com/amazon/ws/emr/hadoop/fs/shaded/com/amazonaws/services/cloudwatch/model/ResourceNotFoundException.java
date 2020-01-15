package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model;

public class ResourceNotFoundException
  extends AmazonCloudWatchException
{
  private static final long serialVersionUID = 1L;
  private String resourceType;
  private String resourceId;
  
  public ResourceNotFoundException(String message)
  {
    super(message);
  }
  
  public void setResourceType(String resourceType)
  {
    this.resourceType = resourceType;
  }
  
  public String getResourceType()
  {
    return resourceType;
  }
  
  public ResourceNotFoundException withResourceType(String resourceType)
  {
    setResourceType(resourceType);
    return this;
  }
  
  public void setResourceId(String resourceId)
  {
    this.resourceId = resourceId;
  }
  
  public String getResourceId()
  {
    return resourceId;
  }
  
  public ResourceNotFoundException withResourceId(String resourceId)
  {
    setResourceId(resourceId);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ResourceNotFoundException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */