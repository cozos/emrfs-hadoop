package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.LinkedList;
import java.util.List;

public class AWSCredentialsProviderChain
  implements AWSCredentialsProvider
{
  private static final Log log = LogFactory.getLog(AWSCredentialsProviderChain.class);
  private final List<AWSCredentialsProvider> credentialsProviders = new LinkedList();
  private boolean reuseLastProvider = true;
  private AWSCredentialsProvider lastUsedProvider;
  
  public AWSCredentialsProviderChain(List<? extends AWSCredentialsProvider> credentialsProviders)
  {
    if ((credentialsProviders == null) || (credentialsProviders.size() == 0)) {
      throw new IllegalArgumentException("No credential providers specified");
    }
    this.credentialsProviders.addAll(credentialsProviders);
  }
  
  public AWSCredentialsProviderChain(AWSCredentialsProvider... credentialsProviders)
  {
    if ((credentialsProviders == null) || (credentialsProviders.length == 0)) {
      throw new IllegalArgumentException("No credential providers specified");
    }
    for (AWSCredentialsProvider provider : credentialsProviders) {
      this.credentialsProviders.add(provider);
    }
  }
  
  public boolean getReuseLastProvider()
  {
    return reuseLastProvider;
  }
  
  public void setReuseLastProvider(boolean b)
  {
    reuseLastProvider = b;
  }
  
  public AWSCredentials getCredentials()
  {
    if ((reuseLastProvider) && (lastUsedProvider != null)) {
      return lastUsedProvider.getCredentials();
    }
    List<String> exceptionMessages = null;
    for (AWSCredentialsProvider provider : credentialsProviders) {
      try
      {
        AWSCredentials credentials = provider.getCredentials();
        if ((credentials.getAWSAccessKeyId() != null) && 
          (credentials.getAWSSecretKey() != null))
        {
          log.debug("Loading credentials from " + provider.toString());
          
          lastUsedProvider = provider;
          return credentials;
        }
      }
      catch (Exception e)
      {
        String message = provider + ": " + e.getMessage();
        log.debug("Unable to load credentials from " + message);
        if (exceptionMessages == null) {
          exceptionMessages = new LinkedList();
        }
        exceptionMessages.add(message);
      }
    }
    throw new SdkClientException("Unable to load AWS credentials from any provider in the chain: " + exceptionMessages);
  }
  
  public void refresh()
  {
    for (AWSCredentialsProvider provider : credentialsProviders) {
      provider.refresh();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWSCredentialsProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */