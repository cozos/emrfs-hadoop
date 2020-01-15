package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;

public final class STSAssumeRoleWithWebIdentitySessionCredentialsProvider$Builder
{
  private final String roleArn;
  private final String roleSessionName;
  private final String webIdentityTokenFile;
  private AWSSecurityTokenService sts;
  
  public STSAssumeRoleWithWebIdentitySessionCredentialsProvider$Builder(String roleArn, String roleSessionName, String webIdentityTokenFile)
  {
    if ((roleArn == null) || (roleSessionName == null) || (webIdentityTokenFile == null)) {
      throw new NullPointerException("You must specify a value for roleArn, roleSessionName and webIdentityTokenFile");
    }
    this.roleArn = roleArn;
    this.roleSessionName = roleSessionName;
    this.webIdentityTokenFile = webIdentityTokenFile;
  }
  
  public Builder withStsClient(AWSSecurityTokenService sts)
  {
    this.sts = sts;
    return this;
  }
  
  public STSAssumeRoleWithWebIdentitySessionCredentialsProvider build()
  {
    return new STSAssumeRoleWithWebIdentitySessionCredentialsProvider(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleWithWebIdentitySessionCredentialsProvider.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */