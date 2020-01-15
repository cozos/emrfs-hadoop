package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy;
import java.net.URI;
import java.net.URISyntaxException;

class ContainerCredentialsProvider$ECSCredentialsEndpointProvider
  extends CredentialsEndpointProvider
{
  public URI getCredentialsEndpoint()
    throws URISyntaxException
  {
    String path = System.getenv("AWS_CONTAINER_CREDENTIALS_RELATIVE_URI");
    if (path == null) {
      throw new SdkClientException("The environment variable AWS_CONTAINER_CREDENTIALS_RELATIVE_URI is empty");
    }
    return new URI("http://169.254.170.2" + path);
  }
  
  public CredentialsEndpointRetryPolicy getRetryPolicy()
  {
    return ContainerCredentialsRetryPolicy.getInstance();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ContainerCredentialsProvider.ECSCredentialsEndpointProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */