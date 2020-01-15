package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import java.io.Serializable;
import java.util.EnumSet;

@Deprecated
public class CloudFunctionConfiguration
  extends NotificationConfiguration
  implements Serializable
{
  private final String invocationRoleARN;
  private final String cloudFunctionARN;
  
  public CloudFunctionConfiguration(String invocationRole, String function, EnumSet<S3Event> events)
  {
    super(events);
    invocationRoleARN = invocationRole;
    cloudFunctionARN = function;
  }
  
  public CloudFunctionConfiguration(String invocationRole, String function, String... events)
  {
    super(events);
    invocationRoleARN = invocationRole;
    cloudFunctionARN = function;
  }
  
  public String getInvocationRoleARN()
  {
    return invocationRoleARN;
  }
  
  public String getCloudFunctionARN()
  {
    return cloudFunctionARN;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CloudFunctionConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */