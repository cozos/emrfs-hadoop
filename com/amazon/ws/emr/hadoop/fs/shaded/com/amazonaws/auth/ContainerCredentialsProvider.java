package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.retry.internal.CredentialsEndpointRetryPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.CollectionUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainerCredentialsProvider
  implements AWSCredentialsProvider
{
  static final String ECS_CONTAINER_CREDENTIALS_PATH = "AWS_CONTAINER_CREDENTIALS_RELATIVE_URI";
  static final String CONTAINER_CREDENTIALS_FULL_URI = "AWS_CONTAINER_CREDENTIALS_FULL_URI";
  static final String CONTAINER_AUTHORIZATION_TOKEN = "AWS_CONTAINER_AUTHORIZATION_TOKEN";
  private static final Set<String> ALLOWED_FULL_URI_HOSTS = ;
  private static final String ECS_CREDENTIALS_ENDPOINT = "http://169.254.170.2";
  private final EC2CredentialsFetcher credentialsFetcher;
  
  @Deprecated
  public ContainerCredentialsProvider()
  {
    this(new ECSCredentialsEndpointProvider());
  }
  
  public ContainerCredentialsProvider(CredentialsEndpointProvider credentialsEndpointProvider)
  {
    credentialsFetcher = new EC2CredentialsFetcher(credentialsEndpointProvider);
  }
  
  public AWSCredentials getCredentials()
  {
    return credentialsFetcher.getCredentials();
  }
  
  public void refresh()
  {
    credentialsFetcher.refresh();
  }
  
  public Date getCredentialsExpiration()
  {
    return credentialsFetcher.getCredentialsExpiration();
  }
  
  static class ECSCredentialsEndpointProvider
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
  
  static class FullUriCredentialsEndpointProvider
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
      if (!ContainerCredentialsProvider.ALLOWED_FULL_URI_HOSTS.contains(uri.getHost())) {
        throw new SdkClientException("The full URI (" + uri + ") contained withing environment variable " + "AWS_CONTAINER_CREDENTIALS_FULL_URI" + " has an invalid host. Host can only be one of [" + CollectionUtils.join(ContainerCredentialsProvider.ALLOWED_FULL_URI_HOSTS, ", ") + "]");
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
  
  private static Set<String> allowedHosts()
  {
    HashSet<String> hosts = new HashSet();
    hosts.add("127.0.0.1");
    hosts.add("localhost");
    return Collections.unmodifiableSet(hosts);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ContainerCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */