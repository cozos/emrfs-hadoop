package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.auth.SignerProvider;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;

public class PresignerParams$Builder
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.presign.PresignerParams.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */