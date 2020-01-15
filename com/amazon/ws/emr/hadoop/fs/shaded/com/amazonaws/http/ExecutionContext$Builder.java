package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.RequestHandler2;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.NoOpSignerProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import java.util.List;

public class ExecutionContext$Builder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.http.ExecutionContext.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */