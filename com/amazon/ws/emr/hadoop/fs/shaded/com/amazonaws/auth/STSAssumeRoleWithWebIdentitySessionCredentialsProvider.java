package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonServiceException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.PredefinedBackoffStrategies.SDKDefaultBackoffStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryPolicy.RetryCondition;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.RetryUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.IDPCommunicationErrorException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.InvalidIdentityTokenException;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

public class STSAssumeRoleWithWebIdentitySessionCredentialsProvider
  implements AWSSessionCredentialsProvider, Closeable
{
  private final AWSSecurityTokenService securityTokenService;
  private final String roleArn;
  private final String roleSessionName;
  private final String webIdentityTokenFile;
  private final Callable<SessionCredentialsHolder> refreshCallable = new Callable()
  {
    public SessionCredentialsHolder call()
      throws Exception
    {
      return STSAssumeRoleWithWebIdentitySessionCredentialsProvider.this.newSession();
    }
  };
  private volatile RefreshableTask<SessionCredentialsHolder> refreshableTask;
  
  private RefreshableTask<SessionCredentialsHolder> createRefreshableTask()
  {
    return 
    
      new RefreshableTask.Builder().withRefreshCallable(refreshCallable).withBlockingRefreshPredicate(new ShouldDoBlockingSessionRefresh()).withAsyncRefreshPredicate(new ShouldDoAsyncSessionRefresh()).build();
  }
  
  private STSAssumeRoleWithWebIdentitySessionCredentialsProvider(Builder builder)
  {
    roleArn = roleArn;
    roleSessionName = roleSessionName;
    webIdentityTokenFile = webIdentityTokenFile;
    securityTokenService = buildStsClient(builder);
    refreshableTask = createRefreshableTask();
  }
  
  private static AWSSecurityTokenService buildStsClient(Builder builder)
    throws IllegalArgumentException
  {
    if (sts != null) {
      return sts;
    }
    RetryPolicy retryPolicy = new RetryPolicy(new StsRetryCondition(null), new PredefinedBackoffStrategies.SDKDefaultBackoffStrategy(), 3, true);
    
    ClientConfiguration clientConfiguration = new ClientConfiguration();
    clientConfiguration.setRetryPolicy(retryPolicy);
    
    return 
    
      (AWSSecurityTokenService)((AWSSecurityTokenServiceClientBuilder)((AWSSecurityTokenServiceClientBuilder)AWSSecurityTokenServiceClientBuilder.standard().withClientConfiguration(clientConfiguration)).withCredentials(new AWSStaticCredentialsProvider(new AnonymousAWSCredentials()))).build();
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
    AssumeRoleWithWebIdentityRequest assumeRoleRequest = new AssumeRoleWithWebIdentityRequest().withRoleArn(roleArn).withWebIdentityToken(getWebIdentityToken()).withRoleSessionName(roleSessionName);
    
    AssumeRoleWithWebIdentityResult assumeRoleResult = securityTokenService.assumeRoleWithWebIdentity(assumeRoleRequest);
    return new SessionCredentialsHolder(assumeRoleResult.getCredentials());
  }
  
  private String getWebIdentityToken()
  {
    BufferedReader br = null;
    try
    {
      br = new BufferedReader(new InputStreamReader(new FileInputStream(webIdentityTokenFile), "UTF-8"));
      return br.readLine();
    }
    catch (FileNotFoundException e)
    {
      throw new SdkClientException("Unable to locate specified web identity token file: " + webIdentityTokenFile);
    }
    catch (IOException e)
    {
      throw new SdkClientException("Unable to read web identity token from file: " + webIdentityTokenFile);
    }
    finally
    {
      try
      {
        br.close();
      }
      catch (Exception localException1) {}
    }
  }
  
  public void close()
  {
    refreshableTask.close();
  }
  
  public static final class Builder
  {
    private final String roleArn;
    private final String roleSessionName;
    private final String webIdentityTokenFile;
    private AWSSecurityTokenService sts;
    
    public Builder(String roleArn, String roleSessionName, String webIdentityTokenFile)
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
  
  private static class StsRetryCondition
    implements RetryPolicy.RetryCondition
  {
    public boolean shouldRetry(AmazonWebServiceRequest originalRequest, AmazonClientException exception, int retriesAttempted)
    {
      if ((exception.getCause() instanceof IOException)) {
        return true;
      }
      if ((exception.getCause() instanceof InvalidIdentityTokenException)) {
        return true;
      }
      if ((exception.getCause() instanceof IDPCommunicationErrorException)) {
        return true;
      }
      if ((exception instanceof AmazonServiceException))
      {
        AmazonServiceException ase = (AmazonServiceException)exception;
        if (RetryUtils.isRetryableServiceException(ase)) {
          return true;
        }
        if (RetryUtils.isThrottlingException(ase)) {
          return true;
        }
        if (RetryUtils.isClockSkewError(ase)) {
          return true;
        }
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSAssumeRoleWithWebIdentitySessionCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */