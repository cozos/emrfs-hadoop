package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazonaws.auth.AWSCredentialsProvider;

@SdkProtectedApi
public abstract interface ProfileCredentialsService
{
  public abstract AWSCredentialsProvider getAssumeRoleCredentialsProvider(RoleInfo paramRoleInfo);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.ProfileCredentialsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */