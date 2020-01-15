package com.amazonaws.services.securitytoken.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleWithWebIdentitySessionCredentialsProvider.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.ProfileCredentialsService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.RoleInfo;
import com.amazonaws.auth.AWSCredentialsProvider;

public class STSProfileCredentialsService
  implements ProfileCredentialsService
{
  public AWSCredentialsProvider getAssumeRoleCredentialsProvider(RoleInfo targetRoleInfo)
  {
    if (targetRoleInfo.getWebIdentityTokenFilePath() == null) {
      return 
      
        new STSAssumeRoleSessionCredentialsProvider.Builder(targetRoleInfo.getRoleArn(), targetRoleInfo.getRoleSessionName()).withLongLivedCredentialsProvider(targetRoleInfo.getLongLivedCredentialsProvider()).withExternalId(targetRoleInfo.getExternalId()).build();
    }
    return 
    
      new STSAssumeRoleWithWebIdentitySessionCredentialsProvider.Builder(targetRoleInfo.getRoleArn(), targetRoleInfo.getRoleSessionName(), targetRoleInfo.getWebIdentityTokenFilePath()).build();
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.securitytoken.internal.STSProfileCredentialsService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */