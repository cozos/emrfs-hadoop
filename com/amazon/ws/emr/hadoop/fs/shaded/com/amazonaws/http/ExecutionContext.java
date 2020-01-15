package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.NotThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.timers.client.ClientExecutionAbortTrackerTask;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.NoOpSignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProviderContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthErrorRetryStrategy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetrics;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AWSRequestMetricsFullSupport;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.util.List;

@NotThreadSafe
public class ExecutionContext
{
  private final AWSRequestMetrics awsRequestMetrics;
  private final List<RequestHandler2> requestHandler2s;
  private final AmazonWebServiceClient awsClient;
  private final SignerProvider signerProvider;
  private boolean retryCapacityConsumed;
  private AWSCredentialsProvider credentialsProvider;
  private AuthErrorRetryStrategy authErrorRetryStrategy;
  private ClientExecutionAbortTrackerTask clientExecutionTrackerTask;
  
  public ExecutionContext(boolean isMetricEnabled)
  {
    this(builder().withUseRequestMetrics(isMetricEnabled).withSignerProvider(new NoOpSignerProvider()));
  }
  
  public ExecutionContext()
  {
    this(builder().withSignerProvider(new NoOpSignerProvider()));
  }
  
  @Deprecated
  public ExecutionContext(List<RequestHandler2> requestHandler2s, boolean isMetricEnabled, AmazonWebServiceClient awsClient)
  {
    this.requestHandler2s = requestHandler2s;
    awsRequestMetrics = (isMetricEnabled ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics());
    this.awsClient = awsClient;
    signerProvider = new SignerProvider()
    {
      public Signer getSigner(SignerProviderContext context)
      {
        return getSignerByURI(context.getUri());
      }
    };
  }
  
  private ExecutionContext(Builder builder)
  {
    requestHandler2s = requestHandler2s;
    awsRequestMetrics = (useRequestMetrics ? new AWSRequestMetricsFullSupport() : new AWSRequestMetrics());
    awsClient = awsClient;
    signerProvider = signerProvider;
  }
  
  public List<RequestHandler2> getRequestHandler2s()
  {
    return requestHandler2s;
  }
  
  public AWSRequestMetrics getAwsRequestMetrics()
  {
    return awsRequestMetrics;
  }
  
  protected AmazonWebServiceClient getAwsClient()
  {
    return awsClient;
  }
  
  @Deprecated
  public void setSigner(Signer signer) {}
  
  public boolean retryCapacityConsumed()
  {
    return retryCapacityConsumed;
  }
  
  public void markRetryCapacityConsumed()
  {
    retryCapacityConsumed = true;
  }
  
  public Signer getSigner(SignerProviderContext context)
  {
    return signerProvider.getSigner(context);
  }
  
  @Deprecated
  public Signer getSignerByURI(URI uri)
  {
    return awsClient == null ? null : awsClient.getSignerByURI(uri);
  }
  
  public void setCredentialsProvider(AWSCredentialsProvider credentialsProvider)
  {
    this.credentialsProvider = credentialsProvider;
  }
  
  public AWSCredentialsProvider getCredentialsProvider()
  {
    return credentialsProvider;
  }
  
  public AuthErrorRetryStrategy getAuthErrorRetryStrategy()
  {
    return authErrorRetryStrategy;
  }
  
  public void setAuthErrorRetryStrategy(AuthErrorRetryStrategy authErrorRetryStrategy)
  {
    this.authErrorRetryStrategy = authErrorRetryStrategy;
  }
  
  public ClientExecutionAbortTrackerTask getClientExecutionTrackerTask()
  {
    return clientExecutionTrackerTask;
  }
  
  public void setClientExecutionTrackerTask(ClientExecutionAbortTrackerTask clientExecutionTrackerTask)
  {
    this.clientExecutionTrackerTask = clientExecutionTrackerTask;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static class Builder
  {
    private boolean useRequestMetrics;
    private List<RequestHandler2> requestHandler2s;
    private AmazonWebServiceClient awsClient;
    private SignerProvider signerProvider = new NoOpSignerProvider();
    
    public boolean useRequestMetrics()
    {
      return useRequestMetrics;
    }
    
    public void setUseRequestMetrics(boolean useRequestMetrics)
    {
      this.useRequestMetrics = useRequestMetrics;
    }
    
    public Builder withUseRequestMetrics(boolean withUseRequestMetrics)
    {
      setUseRequestMetrics(withUseRequestMetrics);
      return this;
    }
    
    public List<RequestHandler2> getRequestHandler2s()
    {
      return requestHandler2s;
    }
    
    public void setRequestHandler2s(List<RequestHandler2> requestHandler2s)
    {
      this.requestHandler2s = requestHandler2s;
    }
    
    public Builder withRequestHandler2s(List<RequestHandler2> requestHandler2s)
    {
      setRequestHandler2s(requestHandler2s);
      return this;
    }
    
    public AmazonWebServiceClient getAwsClient()
    {
      return awsClient;
    }
    
    public void setAwsClient(AmazonWebServiceClient awsClient)
    {
      this.awsClient = awsClient;
    }
    
    public Builder withAwsClient(AmazonWebServiceClient awsClient)
    {
      setAwsClient(awsClient);
      return this;
    }
    
    public SignerProvider getSignerProvider()
    {
      return signerProvider;
    }
    
    public void setSignerProvider(SignerProvider signerProvider)
    {
      this.signerProvider = signerProvider;
    }
    
    public Builder withSignerProvider(SignerProvider signerProvider)
    {
      setSignerProvider(signerProvider);
      return this;
    }
    
    public ExecutionContext build()
    {
      return new ExecutionContext(this, null);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */