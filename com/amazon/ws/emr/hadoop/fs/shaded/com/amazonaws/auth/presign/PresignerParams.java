package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;

@Immutable
@SdkProtectedApi
public class PresignerParams
{
  private final URI endpoint;
  private final AWSCredentialsProvider credentialsProvider;
  private final SignerProvider signerProvider;
  private final SdkClock clock;
  
  public PresignerParams(URI endpoint, AWSCredentialsProvider credentialsProvider, SignerProvider signerProvider, SdkClock clock)
  {
    this.endpoint = endpoint;
    this.credentialsProvider = credentialsProvider;
    this.signerProvider = signerProvider;
    this.clock = clock;
  }
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public URI endpoint()
  {
    return endpoint;
  }
  
  public AWSCredentialsProvider credentialsProvider()
  {
    return credentialsProvider;
  }
  
  public SignerProvider signerProvider()
  {
    return signerProvider;
  }
  
  public SdkClock clock()
  {
    return clock;
  }
  
  public static class Builder
  {
    private URI endpoint;
    private AWSCredentialsProvider credentialsProvider;
    private SignerProvider signerProvider;
    private SdkClock clock;
    
    public Builder endpoint(URI endpoint)
    {
      this.endpoint = endpoint;
      return this;
    }
    
    public Builder credentialsProvider(AWSCredentialsProvider credentialsProvider)
    {
      this.credentialsProvider = credentialsProvider;
      return this;
    }
    
    public Builder signerProvider(SignerProvider signerProvider)
    {
      this.signerProvider = signerProvider;
      return this;
    }
    
    @SdkTestInternalApi
    public Builder clock(SdkClock clock)
    {
      this.clock = clock;
      return this;
    }
    
    public PresignerParams build()
    {
      return new PresignerParams(endpoint, credentialsProvider, signerProvider, resolveClock());
    }
    
    private SdkClock resolveClock()
    {
      return clock == null ? SdkClock.STANDARD : clock;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign.PresignerParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */