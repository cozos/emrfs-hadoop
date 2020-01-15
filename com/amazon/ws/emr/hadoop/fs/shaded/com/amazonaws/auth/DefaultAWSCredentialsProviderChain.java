package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.auth.AWSCredentialsProvider;

public class DefaultAWSCredentialsProviderChain
  extends AWSCredentialsProviderChain
{
  private static final DefaultAWSCredentialsProviderChain INSTANCE = new DefaultAWSCredentialsProviderChain();
  
  public DefaultAWSCredentialsProviderChain()
  {
    super(new AWSCredentialsProvider[] { new EnvironmentVariableCredentialsProvider(), new SystemPropertiesCredentialsProvider(), new ProfileCredentialsProvider(), 
    
      WebIdentityTokenCredentialsProvider.create(), new EC2ContainerCredentialsProviderWrapper() });
  }
  
  public static DefaultAWSCredentialsProviderChain getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */