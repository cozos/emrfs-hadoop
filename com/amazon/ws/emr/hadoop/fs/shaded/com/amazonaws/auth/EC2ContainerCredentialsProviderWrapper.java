package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class EC2ContainerCredentialsProviderWrapper
  implements AWSCredentialsProvider
{
  private static final Log LOG = LogFactory.getLog(EC2ContainerCredentialsProviderWrapper.class);
  private final AWSCredentialsProvider provider;
  
  public EC2ContainerCredentialsProviderWrapper()
  {
    provider = initializeProvider();
  }
  
  private AWSCredentialsProvider initializeProvider()
  {
    try
    {
      if (System.getenv("AWS_CONTAINER_CREDENTIALS_RELATIVE_URI") != null) {
        return new ContainerCredentialsProvider(new ContainerCredentialsProvider.ECSCredentialsEndpointProvider());
      }
      if (System.getenv("AWS_CONTAINER_CREDENTIALS_FULL_URI") != null) {
        return new ContainerCredentialsProvider(new ContainerCredentialsProvider.FullUriCredentialsEndpointProvider());
      }
      return InstanceProfileCredentialsProvider.getInstance();
    }
    catch (SecurityException securityException)
    {
      LOG.debug("Security manager did not allow access to the ECS credentials environment variable AWS_CONTAINER_CREDENTIALS_RELATIVE_URIor the container full URI environment variable AWS_CONTAINER_CREDENTIALS_FULL_URI. Please provide access to this environment variable if you want to load credentials from ECS Container.");
    }
    return InstanceProfileCredentialsProvider.getInstance();
  }
  
  public AWSCredentials getCredentials()
  {
    return provider.getCredentials();
  }
  
  public void refresh()
  {
    provider.refresh();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */