package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import java.io.Closeable;
import java.util.concurrent.Callable;

@ThreadSafe
public class STSSessionCredentialsProvider
  implements AWSSessionCredentialsProvider, Closeable
{
  public static final int DEFAULT_DURATION_SECONDS = 3600;
  private final AWSSecurityTokenService securityTokenService;
  private final Callable<SessionCredentialsHolder> refreshCallable = new Callable()
  {
    public SessionCredentialsHolder call()
      throws Exception
    {
      return STSSessionCredentialsProvider.this.newSession();
    }
  };
  private volatile RefreshableTask<SessionCredentialsHolder> refreshableTask;
  
  public STSSessionCredentialsProvider(AWSCredentials longLivedCredentials)
  {
    this(longLivedCredentials, new ClientConfiguration());
  }
  
  public STSSessionCredentialsProvider(AWSCredentials longLivedCredentials, ClientConfiguration clientConfiguration)
  {
    this(new AWSSecurityTokenServiceClient(longLivedCredentials, clientConfiguration));
  }
  
  public STSSessionCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider)
  {
    this(new AWSSecurityTokenServiceClient(longLivedCredentialsProvider));
  }
  
  public STSSessionCredentialsProvider(AWSCredentialsProvider longLivedCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(new AWSSecurityTokenServiceClient(longLivedCredentialsProvider, clientConfiguration));
  }
  
  private RefreshableTask<SessionCredentialsHolder> createRefreshableTask()
  {
    return 
    
      new RefreshableTask.Builder().withRefreshCallable(refreshCallable).withBlockingRefreshPredicate(new ShouldDoBlockingSessionRefresh()).withAsyncRefreshPredicate(new ShouldDoAsyncSessionRefresh()).build();
  }
  
  public STSSessionCredentialsProvider(AWSSecurityTokenService sts)
  {
    securityTokenService = sts;
    refreshableTask = createRefreshableTask();
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
    GetSessionTokenResult sessionTokenResult = securityTokenService.getSessionToken(new GetSessionTokenRequest()
      .withDurationSeconds(Integer.valueOf(3600)));
    return new SessionCredentialsHolder(sessionTokenResult.getCredentials());
  }
  
  public void close()
  {
    refreshableTask.close();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSSessionCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */