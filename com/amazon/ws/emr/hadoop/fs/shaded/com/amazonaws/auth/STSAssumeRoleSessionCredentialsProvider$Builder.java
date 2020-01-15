package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public final class STSAssumeRoleSessionCredentialsProvider$Builder
{
  private final String roleArn;
  private final String roleSessionName;
  private AWSCredentialsProvider longLivedCredentialsProvider;
  private AWSCredentials longLivedCredentials;
  private ClientConfiguration clientConfiguration;
  private String roleExternalId;
  private String serviceEndpoint;
  private int roleSessionDurationSeconds;
  private String scopeDownPolicy;
  private AWSSecurityTokenService sts;
  
  public STSAssumeRoleSessionCredentialsProvider$Builder(String roleArn, String roleSessionName)
  {
    if ((roleArn == null) || (roleSessionName == null)) {
      throw new NullPointerException("You must specify a value for roleArn and roleSessionName");
    }
    this.roleArn = roleArn;
    this.roleSessionName = roleSessionName;
  }
  
  @Deprecated
  public Builder withLongLivedCredentials(AWSCredentials longLivedCredentials)
  {
    this.longLivedCredentials = longLivedCredentials;
    return this;
  }
  
  @Deprecated
  public Builder withLongLivedCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider)
  {
    this.longLivedCredentialsProvider = longLivedCredentialsProvider;
    return this;
  }
  
  @Deprecated
  public Builder withClientConfiguration(ClientConfiguration clientConfiguration)
  {
    this.clientConfiguration = clientConfiguration;
    return this;
  }
  
  public Builder withExternalId(String roleExternalId)
  {
    this.roleExternalId = roleExternalId;
    return this;
  }
  
  public Builder withRoleSessionDurationSeconds(int roleSessionDurationSeconds)
  {
    this.roleSessionDurationSeconds = roleSessionDurationSeconds;
    return this;
  }
  
  @Deprecated
  public Builder withServiceEndpoint(String serviceEndpoint)
  {
    this.serviceEndpoint = serviceEndpoint;
    return this;
  }
  
  public Builder withScopeDownPolicy(String scopeDownPolicy)
  {
    this.scopeDownPolicy = scopeDownPolicy;
    return this;
  }
  
  public Builder withStsClient(AWSSecurityTokenService sts)
  {
    this.sts = sts;
    return this;
  }
  
  public STSAssumeRoleSessionCredentialsProvider build()
  {
    return new STSAssumeRoleSessionCredentialsProvider(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */