package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy;

public enum Principal$Services
{
  AmazonApiGateway("apigateway.amazonaws.com"),  AWSDataPipeline("datapipeline.amazonaws.com"),  AmazonElasticTranscoder("elastictranscoder.amazonaws.com"),  AmazonEC2("ec2.amazonaws.com"),  AWSOpsWorks("opsworks.amazonaws.com"),  AWSCloudHSM("cloudhsm.amazonaws.com"),  AllServices("*");
  
  private String serviceId;
  
  private Principal$Services(String serviceId)
  {
    this.serviceId = serviceId;
  }
  
  public String getServiceId()
  {
    return serviceId;
  }
  
  public static Services fromString(String serviceId)
  {
    if (serviceId != null) {
      for (Services s : values()) {
        if (s.getServiceId().equalsIgnoreCase(serviceId)) {
          return s;
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.policy.Principal.Services
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */