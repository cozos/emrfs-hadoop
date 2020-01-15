package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.RoleInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.STSProfileCredentialsServiceLoader;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class WebIdentityTokenCredentialsProvider
  implements AWSCredentialsProvider
{
  private final AWSCredentialsProvider credentialsProvider;
  private final RuntimeException loadException;
  
  private WebIdentityTokenCredentialsProvider(BuilderImpl builder)
  {
    AWSCredentialsProvider credentialsProvider = null;
    RuntimeException loadException = null;
    try
    {
      String webIdentityTokenFile = webIdentityTokenFile != null ? webIdentityTokenFile : System.getenv("AWS_WEB_IDENTITY_TOKEN_FILE");
      
      String roleArn = roleArn != null ? roleArn : System.getenv("AWS_ROLE_ARN");
      
      String roleSessionName = roleSessionName != null ? roleSessionName : System.getenv("AWS_ROLE_SESSION_NAME");
      if (roleSessionName == null) {
        roleSessionName = "aws-sdk-java-" + System.currentTimeMillis();
      }
      RoleInfo roleInfo = new RoleInfo().withRoleArn(roleArn).withRoleSessionName(roleSessionName).withWebIdentityTokenFilePath(webIdentityTokenFile);
      
      credentialsProvider = STSProfileCredentialsServiceLoader.getInstance().getAssumeRoleCredentialsProvider(roleInfo);
    }
    catch (RuntimeException e)
    {
      loadException = e;
    }
    this.loadException = loadException;
    this.credentialsProvider = credentialsProvider;
  }
  
  public AWSCredentials getCredentials()
  {
    if (loadException != null) {
      throw loadException;
    }
    return credentialsProvider.getCredentials();
  }
  
  public void refresh() {}
  
  public static WebIdentityTokenCredentialsProvider create()
  {
    return builder().build();
  }
  
  public static Builder builder()
  {
    return new BuilderImpl();
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
  
  static final class BuilderImpl
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
  
  public static abstract interface Builder
  {
    public abstract Builder roleArn(String paramString);
    
    public abstract Builder roleSessionName(String paramString);
    
    public abstract Builder webIdentityTokenFile(String paramString);
    
    public abstract WebIdentityTokenCredentialsProvider build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.WebIdentityTokenCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */