package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazonaws.auth.AWSCredentialsProvider;

@SdkInternalApi
public class STSProfileCredentialsServiceLoader
  implements ProfileCredentialsService
{
  private static final STSProfileCredentialsServiceLoader INSTANCE = new STSProfileCredentialsServiceLoader();
  
  public AWSCredentialsProvider getAssumeRoleCredentialsProvider(RoleInfo targetRoleInfo)
  {
    return new STSProfileCredentialsServiceProvider(targetRoleInfo);
  }
  
  public static STSProfileCredentialsServiceLoader getInstance()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.STSProfileCredentialsServiceLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */