package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

final class WebIdentityTokenCredentialsProvider$BuilderImpl
  implements WebIdentityTokenCredentialsProvider.Builder
{
  private String roleArn;
  private String roleSessionName;
  private String webIdentityTokenFile;
  
  public WebIdentityTokenCredentialsProvider.Builder roleArn(String roleArn)
  {
    this.roleArn = roleArn;
    return this;
  }
  
  public void setRoleArn(String roleArn)
  {
    roleArn(roleArn);
  }
  
  public WebIdentityTokenCredentialsProvider.Builder roleSessionName(String roleSessionName)
  {
    this.roleSessionName = roleSessionName;
    return this;
  }
  
  public void setRoleSessionName(String roleSessionName)
  {
    roleSessionName(roleSessionName);
  }
  
  public WebIdentityTokenCredentialsProvider.Builder webIdentityTokenFile(String webIdentityTokenFile)
  {
    this.webIdentityTokenFile = webIdentityTokenFile;
    return this;
  }
  
  public void setWebIdentityTokenFile(String webIdentityTokenFile)
  {
    webIdentityTokenFile(webIdentityTokenFile);
  }
  
  public WebIdentityTokenCredentialsProvider build()
  {
    return new WebIdentityTokenCredentialsProvider(this, null);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.WebIdentityTokenCredentialsProvider.BuilderImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */