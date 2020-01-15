package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

public final class Arn$Builder
{
  private String partition;
  private String service;
  private String region;
  private String accountId;
  private String resource;
  
  public void setPartition(String partition)
  {
    this.partition = partition;
  }
  
  public Builder withPartition(String partition)
  {
    setPartition(partition);
    return this;
  }
  
  public void setService(String service)
  {
    this.service = service;
  }
  
  public Builder withService(String service)
  {
    setService(service);
    return this;
  }
  
  public void setRegion(String region)
  {
    this.region = region;
  }
  
  public Builder withRegion(String region)
  {
    setRegion(region);
    return this;
  }
  
  public void setAccountId(String accountId)
  {
    this.accountId = accountId;
  }
  
  public Builder withAccountId(String accountId)
  {
    setAccountId(accountId);
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
  
  public Arn build()
  {
    return new Arn(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.Arn.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */