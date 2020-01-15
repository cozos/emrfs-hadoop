package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonCreator;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;

public class EC2MetadataUtils$InstanceInfo
{
  private final String pendingTime;
  private final String instanceType;
  private final String imageId;
  private final String instanceId;
  private final String[] billingProducts;
  private final String architecture;
  private final String accountId;
  private final String kernelId;
  private final String ramdiskId;
  private final String region;
  private final String version;
  private final String availabilityZone;
  private final String privateIp;
  private final String[] devpayProductCodes;
  
  @JsonCreator
  public EC2MetadataUtils$InstanceInfo(@JsonProperty(value="pendingTime", required=true) String pendingTime, @JsonProperty(value="instanceType", required=true) String instanceType, @JsonProperty(value="imageId", required=true) String imageId, @JsonProperty(value="instanceId", required=true) String instanceId, @JsonProperty(value="billingProducts", required=false) String[] billingProducts, @JsonProperty(value="architecture", required=true) String architecture, @JsonProperty(value="accountId", required=true) String accountId, @JsonProperty(value="kernelId", required=true) String kernelId, @JsonProperty(value="ramdiskId", required=false) String ramdiskId, @JsonProperty(value="region", required=true) String region, @JsonProperty(value="version", required=true) String version, @JsonProperty(value="availabilityZone", required=true) String availabilityZone, @JsonProperty(value="privateIp", required=true) String privateIp, @JsonProperty(value="devpayProductCodes", required=false) String[] devpayProductCodes)
  {
    this.pendingTime = pendingTime;
    this.instanceType = instanceType;
    this.imageId = imageId;
    this.instanceId = instanceId;
    this.billingProducts = (billingProducts == null ? null : 
      (String[])billingProducts.clone());
    this.architecture = architecture;
    this.accountId = accountId;
    this.kernelId = kernelId;
    this.ramdiskId = ramdiskId;
    this.region = region;
    this.version = version;
    this.availabilityZone = availabilityZone;
    this.privateIp = privateIp;
    this.devpayProductCodes = (devpayProductCodes == null ? null : 
      (String[])devpayProductCodes.clone());
  }
  
  public String getPendingTime()
  {
    return pendingTime;
  }
  
  public String getInstanceType()
  {
    return instanceType;
  }
  
  public String getImageId()
  {
    return imageId;
  }
  
  public String getInstanceId()
  {
    return instanceId;
  }
  
  public String[] getBillingProducts()
  {
    return billingProducts == null ? null : (String[])billingProducts.clone();
  }
  
  public String getArchitecture()
  {
    return architecture;
  }
  
  public String getAccountId()
  {
    return accountId;
  }
  
  public String getKernelId()
  {
    return kernelId;
  }
  
  public String getRamdiskId()
  {
    return ramdiskId;
  }
  
  public String getRegion()
  {
    return region;
  }
  
  public String getVersion()
  {
    return version;
  }
  
  public String getAvailabilityZone()
  {
    return availabilityZone;
  }
  
  public String getPrivateIp()
  {
    return privateIp;
  }
  
  public String[] getDevpayProductCodes()
  {
    return devpayProductCodes == null ? null : (String[])devpayProductCodes.clone();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils.InstanceInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */