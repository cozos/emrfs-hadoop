package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.client.AwsAsyncClientParams;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@ThreadSafe
public class AWSSecurityTokenServiceAsyncClient
  extends AWSSecurityTokenServiceClient
  implements AWSSecurityTokenServiceAsync
{
  private static final int DEFAULT_THREAD_POOL_SIZE = 50;
  private final ExecutorService executorService;
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient()
  {
    this(DefaultAWSCredentialsProviderChain.getInstance());
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(ClientConfiguration clientConfiguration)
  {
    this(DefaultAWSCredentialsProviderChain.getInstance(), clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentials awsCredentials)
  {
    this(awsCredentials, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentials awsCredentials, ExecutorService executorService)
  {
    this(awsCredentials, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentials awsCredentials, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentials, clientConfiguration);
    this.executorService = executorService;
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider awsCredentialsProvider)
  {
    this(awsCredentialsProvider, Executors.newFixedThreadPool(50));
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration)
  {
    this(awsCredentialsProvider, clientConfiguration, Executors.newFixedThreadPool(clientConfiguration.getMaxConnections()));
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ExecutorService executorService)
  {
    this(awsCredentialsProvider, configFactory.getConfig(), executorService);
  }
  
  @Deprecated
  public AWSSecurityTokenServiceAsyncClient(AWSCredentialsProvider awsCredentialsProvider, ClientConfiguration clientConfiguration, ExecutorService executorService)
  {
    super(awsCredentialsProvider, clientConfiguration);
    this.executorService = executorService;
  }
  
  public static AWSSecurityTokenServiceAsyncClientBuilder asyncBuilder()
  {
    return AWSSecurityTokenServiceAsyncClientBuilder.standard();
  }
  
  AWSSecurityTokenServiceAsyncClient(AwsAsyncClientParams asyncClientParams)
  {
    super(asyncClientParams);
    executorService = asyncClientParams.getExecutor();
  }
  
  public ExecutorService getExecutorService()
  {
    return executorService;
  }
  
  public Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest request)
  {
    return assumeRoleAsync(request, null);
  }
  
  public Future<AssumeRoleResult> assumeRoleAsync(AssumeRoleRequest request, final AsyncHandler<AssumeRoleRequest, AssumeRoleResult> asyncHandler)
  {
    final AssumeRoleRequest finalRequest = (AssumeRoleRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AssumeRoleResult call()
        throws Exception
      {
        AssumeRoleResult result = null;
        try
        {
          result = executeAssumeRole(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest request)
  {
    return assumeRoleWithSAMLAsync(request, null);
  }
  
  public Future<AssumeRoleWithSAMLResult> assumeRoleWithSAMLAsync(AssumeRoleWithSAMLRequest request, final AsyncHandler<AssumeRoleWithSAMLRequest, AssumeRoleWithSAMLResult> asyncHandler)
  {
    final AssumeRoleWithSAMLRequest finalRequest = (AssumeRoleWithSAMLRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AssumeRoleWithSAMLResult call()
        throws Exception
      {
        AssumeRoleWithSAMLResult result = null;
        try
        {
          result = executeAssumeRoleWithSAML(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest request)
  {
    return assumeRoleWithWebIdentityAsync(request, null);
  }
  
  public Future<AssumeRoleWithWebIdentityResult> assumeRoleWithWebIdentityAsync(AssumeRoleWithWebIdentityRequest request, final AsyncHandler<AssumeRoleWithWebIdentityRequest, AssumeRoleWithWebIdentityResult> asyncHandler)
  {
    final AssumeRoleWithWebIdentityRequest finalRequest = (AssumeRoleWithWebIdentityRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public AssumeRoleWithWebIdentityResult call()
        throws Exception
      {
        AssumeRoleWithWebIdentityResult result = null;
        try
        {
          result = executeAssumeRoleWithWebIdentity(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest request)
  {
    return decodeAuthorizationMessageAsync(request, null);
  }
  
  public Future<DecodeAuthorizationMessageResult> decodeAuthorizationMessageAsync(DecodeAuthorizationMessageRequest request, final AsyncHandler<DecodeAuthorizationMessageRequest, DecodeAuthorizationMessageResult> asyncHandler)
  {
    final DecodeAuthorizationMessageRequest finalRequest = (DecodeAuthorizationMessageRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public DecodeAuthorizationMessageResult call()
        throws Exception
      {
        DecodeAuthorizationMessageResult result = null;
        try
        {
          result = executeDecodeAuthorizationMessage(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest request)
  {
    return getAccessKeyInfoAsync(request, null);
  }
  
  public Future<GetAccessKeyInfoResult> getAccessKeyInfoAsync(GetAccessKeyInfoRequest request, final AsyncHandler<GetAccessKeyInfoRequest, GetAccessKeyInfoResult> asyncHandler)
  {
    final GetAccessKeyInfoRequest finalRequest = (GetAccessKeyInfoRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetAccessKeyInfoResult call()
        throws Exception
      {
        GetAccessKeyInfoResult result = null;
        try
        {
          result = executeGetAccessKeyInfo(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest request)
  {
    return getCallerIdentityAsync(request, null);
  }
  
  public Future<GetCallerIdentityResult> getCallerIdentityAsync(GetCallerIdentityRequest request, final AsyncHandler<GetCallerIdentityRequest, GetCallerIdentityResult> asyncHandler)
  {
    final GetCallerIdentityRequest finalRequest = (GetCallerIdentityRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetCallerIdentityResult call()
        throws Exception
      {
        GetCallerIdentityResult result = null;
        try
        {
          result = executeGetCallerIdentity(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest request)
  {
    return getFederationTokenAsync(request, null);
  }
  
  public Future<GetFederationTokenResult> getFederationTokenAsync(GetFederationTokenRequest request, final AsyncHandler<GetFederationTokenRequest, GetFederationTokenResult> asyncHandler)
  {
    final GetFederationTokenRequest finalRequest = (GetFederationTokenRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetFederationTokenResult call()
        throws Exception
      {
        GetFederationTokenResult result = null;
        try
        {
          result = executeGetFederationToken(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest request)
  {
    return getSessionTokenAsync(request, null);
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(GetSessionTokenRequest request, final AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler)
  {
    final GetSessionTokenRequest finalRequest = (GetSessionTokenRequest)beforeClientExecution(request);
    
    executorService.submit(new Callable()
    {
      public GetSessionTokenResult call()
        throws Exception
      {
        GetSessionTokenResult result = null;
        try
        {
          result = executeGetSessionToken(finalRequest);
        }
        catch (Exception ex)
        {
          if (asyncHandler != null) {
            asyncHandler.onError(ex);
          }
          throw ex;
        }
        if (asyncHandler != null) {
          asyncHandler.onSuccess(finalRequest, result);
        }
        return result;
      }
    });
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync()
  {
    return getSessionTokenAsync(new GetSessionTokenRequest());
  }
  
  public Future<GetSessionTokenResult> getSessionTokenAsync(AsyncHandler<GetSessionTokenRequest, GetSessionTokenResult> asyncHandler)
  {
    return getSessionTokenAsync(new GetSessionTokenRequest(), asyncHandler);
  }
  
  public void shutdown()
  {
    super.shutdown();
    executorService.shutdownNow();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */