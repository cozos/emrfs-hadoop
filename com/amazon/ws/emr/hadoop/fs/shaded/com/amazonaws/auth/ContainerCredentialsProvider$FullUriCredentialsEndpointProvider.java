package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ContainerCredentialsProvider$FullUriCredentialsEndpointProvider
  extends CredentialsEndpointProvider
{
  public URI getCredentialsEndpoint()
    throws URISyntaxException
  {
    String fullUri = System.getenv("AWS_CONTAINER_CREDENTIALS_FULL_URI");
    if ((fullUri == null) || (fullUri.length() == 0)) {
      throw new SdkClientException("The environment variable AWS_CONTAINER_CREDENTIALS_FULL_URI is empty");
    }
    URI uri = new URI(fullUri);
    if (!ContainerCredentialsProvider.access$000().contains(uri.getHost())) {
      throw new SdkClientException("The full URI (" + uri + ") contained withing environment variable " + "AWS_CONTAINER_CREDENTIALS_FULL_URI" + " has an invalid host. Host can only be one of [" + CollectionUtils.join(ContainerCredentialsProvider.access$000(), ", ") + "]");
    }
    return uri;
  }
  
  public Map<String, String> getHeaders()
  {
    if (System.getenv("AWS_CONTAINER_AUTHORIZATION_TOKEN") != null) {
      return Collections.singletonMap("Authorization", System.getenv("AWS_CONTAINER_AUTHORIZATION_TOKEN"));
    }
    return new HashMap();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ContainerCredentialsProvider.FullUriCredentialsEndpointProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */