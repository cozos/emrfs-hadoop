package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

@SdkInternalApi
public abstract class CredentialsEndpointProvider
{
  public abstract URI getCredentialsEndpoint()
    throws URISyntaxException, IOException;
  
  public CredentialsEndpointRetryPolicy getRetryPolicy()
  {
    return CredentialsEndpointRetryPolicy.NO_RETRY;
  }
  
  public Map<String, String> getHeaders()
  {
    return new HashMap();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */