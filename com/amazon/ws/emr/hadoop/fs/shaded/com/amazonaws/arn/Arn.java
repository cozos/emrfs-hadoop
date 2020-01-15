package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;

public class Arn
{
  private final String partition;
  private final String service;
  private final String region;
  private final String accountId;
  private final String resource;
  private final ArnResource arnResource;
  
  private Arn(Builder builder)
  {
    partition = ValidationUtils.assertStringNotEmpty(partition, "partition");
    service = ValidationUtils.assertStringNotEmpty(service, "service");
    region = region;
    accountId = accountId;
    resource = ValidationUtils.assertStringNotEmpty(resource, "resource");
    arnResource = ArnResource.fromString(resource);
  }
  
  public String getPartition()
  {
    return partition;
  }
  
  public String getService()
  {
    return service;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public String getAccountId()
  {
    return accountId;
  }
  
  public ArnResource getResource()
  {
    return arnResource;
  }
  
  public String getResourceAsString()
  {
    return resource;
  }
  
  public Builder toBuilder()
  {
    return 
    
      builder().withPartition(getPartition()).withService(getService()).withAccountId(getAccountId()).withRegion(getRegion()).withResource(getResourceAsString());
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static Arn fromString(String arn)
  {
    int arnColonIndex = arn.indexOf(':');
    if ((arnColonIndex < 0) || (!"arn".equals(arn.substring(0, arnColonIndex)))) {
      throw new IllegalArgumentException("Malformed ARN - doesn't start with 'arn:'");
    }
    int partitionColonIndex = arn.indexOf(':', arnColonIndex + 1);
    if (partitionColonIndex < 0) {
      throw new IllegalArgumentException("Malformed ARN - no AWS partition specified");
    }
    String partition = arn.substring(arnColonIndex + 1, partitionColonIndex);
    
    int serviceColonIndex = arn.indexOf(':', partitionColonIndex + 1);
    if (serviceColonIndex < 0) {
      throw new IllegalArgumentException("Malformed ARN - no service specified");
    }
    String service = arn.substring(partitionColonIndex + 1, serviceColonIndex);
    
    int regionColonIndex = arn.indexOf(':', serviceColonIndex + 1);
    if (regionColonIndex < 0) {
      throw new IllegalArgumentException("Malformed ARN - no AWS region partition specified");
    }
    String region = arn.substring(serviceColonIndex + 1, regionColonIndex);
    
    int accountColonIndex = arn.indexOf(':', regionColonIndex + 1);
    if (accountColonIndex < 0) {
      throw new IllegalArgumentException("Malformed ARN - no AWS account specified");
    }
    String accountId = arn.substring(regionColonIndex + 1, accountColonIndex);
    
    String resource = arn.substring(accountColonIndex + 1);
    if (resource.isEmpty()) {
      throw new IllegalArgumentException("Malformed ARN - no resource specified");
    }
    return 
    
      builder().withPartition(partition).withService(service).withRegion(region).withAccountId(accountId).withResource(resource).build();
  }
  
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    sb.append("arn:");
    sb.append(partition);
    sb.append(":");
    sb.append(service);
    sb.append(":");
    sb.append(region);
    sb.append(":");
    sb.append(accountId);
    sb.append(":");
    sb.append(resource);
    return sb.toString();
  }
  
  public boolean equals(Object o)
  {
    if (this == o) {
      return true;
    }
    if ((o == null) || (getClass() != o.getClass())) {
      return false;
    }
    Arn arn = (Arn)o;
    if (!partition.equals(partition)) {
      return false;
    }
    if (!service.equals(service)) {
      return false;
    }
    if (region != null ? !region.equals(region) : region != null) {
      return false;
    }
    if (accountId != null ? !accountId.equals(accountId) : accountId != null) {
      return false;
    }
    return resource.equals(resource);
  }
  
  public int hashCode()
  {
    int result = partition.hashCode();
    result = 31 * result + service.hashCode();
    result = 31 * result + (region != null ? region.hashCode() : 0);
    result = 31 * result + (accountId != null ? accountId.hashCode() : 0);
    result = 31 * result + resource.hashCode();
    return result;
  }
  
  public static final class Builder
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.Arn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */