package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import java.io.Closeable;
import java.util.concurrent.Callable;

@ThreadSafe
public class STSAssumeRoleSessionCredentialsProvider
  implements AWSSessionCredentialsProvider, Closeable
{
  public static final int DEFAULT_DURATION_SECONDS = 900;
  private final AWSSecurityTokenService securityTokenService;
  private final String roleArn;
  private final String roleSessionName;
  private final String roleExternalId;
  private final int roleSessionDurationSeconds;
  private final String scopeDownPolicy;
  private final Callable<SessionCredentialsHolder> refreshCallable = new Callable()
  {
    public SessionCredentialsHolder call()
      throws Exception
    {
      return STSAssumeRoleSessionCredentialsProvider.this.newSession();
    }
  };
  private volatile RefreshableTask<SessionCredentialsHolder> refreshableTask;
  
  @Deprecated
  public STSAssumeRoleSessionCredentialsProvider(String roleArn, String roleSessionName)
  {
    this(new Builder(roleArn, roleSessionName));
  }
  
  @Deprecated
  public STSAssumeRoleSessionCredentialsProvider(AWSCredentials longLivedCredentials, String roleArn, String roleSessionName)
  {
    this(longLivedCredentials, roleArn, roleSessionName, new ClientConfiguration());
  }
  
  @Deprecated
  public STSAssumeRoleSessionCredentialsProvider(AWSCredentials longLivedCredentials, String roleArn, String roleSessionName, ClientConfiguration clientConfiguration)
  {
    this(new Builder(roleArn, roleSessionName).withLongLivedCredentials(longLivedCredentials)
      .withClientConfiguration(clientConfiguration));
  }
  
  @Deprecated
  public STSAssumeRoleSessionCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider, String roleArn, String roleSessionName)
  {
    this(new Builder(roleArn, roleSessionName)
      .withLongLivedCredentialsProvider(longLivedCredentialsProvider));
  }
  
  @Deprecated
  public STSAssumeRoleSessionCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider, String roleArn, String roleSessionName, ClientConfiguration clientConfiguration)
  {
    this(new Builder(roleArn, roleSessionName)
      .withLongLivedCredentialsProvider(longLivedCredentialsProvider)
      .withClientConfiguration(clientConfiguration));
  }
  
  private RefreshableTask<SessionCredentialsHolder> createRefreshableTask()
  {
    return 
    
      new RefreshableTask.Builder().withRefreshCallable(refreshCallable).withBlockingRefreshPredicate(new ShouldDoBlockingSessionRefresh()).withAsyncRefreshPredicate(new ShouldDoAsyncSessionRefresh()).build();
  }
  
  private STSAssumeRoleSessionCredentialsProvider(Builder builder)
  {
    if (sts != null)
    {
      ValidationUtils.assertAllAreNull("If a custom STS client is set you must not set any other client related fields (ClientConfiguration, AWSCredentials, Endpoint, etc", new Object[] {
      
        longLivedCredentials, longLivedCredentialsProvider, 
        clientConfiguration, serviceEndpoint });
      securityTokenService = sts;
    }
    else
    {
      securityTokenService = buildStsClient(builder);
      if (serviceEndpoint != null) {
        securityTokenService.setEndpoint(serviceEndpoint);
      }
    }
    roleArn = roleArn;
    roleSessionName = roleSessionName;
    
    roleExternalId = roleExternalId;
    if (roleSessionDurationSeconds != 0) {
      roleSessionDurationSeconds = roleSessionDurationSeconds;
    } else {
      roleSessionDurationSeconds = 900;
    }
    refreshableTask = createRefreshableTask();
    scopeDownPolicy = scopeDownPolicy;
  }
  
  private static AWSSecurityTokenService buildStsClient(Builder builder)
    throws IllegalArgumentException
  {
    if ((longLivedCredentials != null) && (builder.longLivedCredentialsProvider != null)) {
      throw new IllegalArgumentException("It is illegal to set both an AWSCredentials and an AWSCredentialsProvider for an " + STSAssumeRoleSessionCredentialsProvider.class.getName());
    }
    AWSCredentialsProvider longLivedCredentialsProvider = null;
    if (longLivedCredentials != null) {
      longLivedCredentialsProvider = new StaticCredentialsProvider(longLivedCredentials);
    } else if (builder.longLivedCredentialsProvider != null) {
      longLivedCredentialsProvider = builder.longLivedCredentialsProvider;
    }
    if (longLivedCredentialsProvider == null)
    {
      if (clientConfiguration == null) {
        return new AWSSecurityTokenServiceClient();
      }
      return new AWSSecurityTokenServiceClient(clientConfiguration);
    }
    if (clientConfiguration == null) {
      return new AWSSecurityTokenServiceClient(longLivedCredentialsProvider);
    }
    return new AWSSecurityTokenServiceClient(longLivedCredentialsProvider, 
      clientConfiguration);
  }
  
  @Deprecated
  public synchronized void setSTSClientEndpoint(String endpoint)
  {
    securityTokenService.setEndpoint(endpoint);
    refreshableTask = createRefreshableTask();
  }
  
  public AWSSessionCredentials getCredentials()
  {
    return ((SessionCredentialsHolder)refreshableTask.getValue()).getSessionCredentials();
  }
  
  public void refresh()
  {
    refreshableTask.forceGetValue();
  }
  
  private SessionCredentialsHolder newSession()
  {
    AssumeRoleRequest assumeRoleRequest = new AssumeRoleRequest().withRoleArn(roleArn).withDurationSeconds(Integer.valueOf(roleSessionDurationSeconds)).withRoleSessionName(roleSessionName).withPolicy(scopeDownPolicy);
    if (roleExternalId != null) {
      assumeRoleRequest = assumeRoleRequest.withExternalId(roleExternalId);
    }
    AssumeRoleResult assumeRoleResult = securityTokenService.assumeRole(assumeRoleRequest);
    return new SessionCredentialsHolder(assumeRoleResult.getCredentials());
  }
  
  public void close()
  {
    refreshableTask.close();
  }
  
  public static final class Builder
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
    
    public Builder(String roleArn, String roleSessionName)
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */