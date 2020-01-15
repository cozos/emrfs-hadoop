package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.Signer;
import java.net.URI;

@Immutable
public class AuthRetryParameters
{
  private final Signer signerForRetry;
  private final URI endpointForRetry;
  
  public AuthRetryParameters(Signer signer, URI endpoint)
  {
    if (signer == null) {
      throw new NullPointerException("signer");
    }
    if (endpoint == null) {
      throw new NullPointerException("endpoint");
    }
    signerForRetry = signer;
    endpointForRetry = endpoint;
  }
  
  public Signer getSignerForRetry()
  {
    return signerForRetry;
  }
  
  public URI getEndpointForRetry()
  {
    return endpointForRetry;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.AuthRetryParameters
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */