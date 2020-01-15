package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@ThreadSafe
public class STSProfileCredentialsServiceProvider
  implements AWSCredentialsProvider
{
  private static final String CLASS_NAME = "com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService";
  private static volatile ProfileCredentialsService STS_CREDENTIALS_SERVICE;
  private final RoleInfo roleInfo;
  private volatile AWSCredentialsProvider profileCredentialsProvider;
  
  public STSProfileCredentialsServiceProvider(RoleInfo roleInfo)
  {
    this.roleInfo = roleInfo;
  }
  
  private AWSCredentialsProvider getProfileCredentialsProvider()
  {
    if (profileCredentialsProvider == null) {
      synchronized (STSProfileCredentialsServiceProvider.class)
      {
        if (profileCredentialsProvider == null) {
          profileCredentialsProvider = getProfileCredentialService().getAssumeRoleCredentialsProvider(roleInfo);
        }
      }
    }
    return profileCredentialsProvider;
  }
  
  private static synchronized ProfileCredentialsService getProfileCredentialService()
  {
    if (STS_CREDENTIALS_SERVICE == null) {
      try
      {
        STS_CREDENTIALS_SERVICE = (ProfileCredentialsService)Class.forName("com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService").newInstance();
      }
      catch (ClassNotFoundException ex)
      {
        throw new SdkClientException("To use assume role profiles the aws-java-sdk-sts module must be on the class path.", ex);
      }
      catch (InstantiationException ex)
      {
        throw new SdkClientException("Failed to instantiate com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService", ex);
      }
      catch (IllegalAccessException ex)
      {
        throw new SdkClientException("Failed to instantiate com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService", ex);
      }
    }
    return STS_CREDENTIALS_SERVICE;
  }
  
  public AWSCredentials getCredentials()
  {
    return getProfileCredentialsProvider().getCredentials();
  }
  
  public void refresh()
  {
    getProfileCredentialsProvider().refresh();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.STSProfileCredentialsServiceProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */