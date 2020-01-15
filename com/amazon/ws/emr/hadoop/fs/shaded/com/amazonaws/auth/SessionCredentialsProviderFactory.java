package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentials;
import java.util.HashMap;
import java.util.Map;

public class SessionCredentialsProviderFactory
{
  private static final class Key
  {
    private final String awsAccessKeyId;
    private final String serviceEndpoint;
    
    public Key(String awsAccessKeyId, String serviceEndpoint)
    {
      this.awsAccessKeyId = awsAccessKeyId;
      this.serviceEndpoint = serviceEndpoint;
    }
    
    public int hashCode()
    {
      int prime = 31;
      int result = 1;
      result = 31 * result + (awsAccessKeyId == null ? 0 : awsAccessKeyId.hashCode());
      result = 31 * result + (serviceEndpoint == null ? 0 : serviceEndpoint.hashCode());
      return result;
    }
    
    public boolean equals(Object obj)
    {
      if (this == obj) {
        return true;
      }
      if (obj == null) {
        return false;
      }
      if (getClass() != obj.getClass()) {
        return false;
      }
      Key other = (Key)obj;
      if (awsAccessKeyId == null)
      {
        if (awsAccessKeyId != null) {
          return false;
        }
      }
      else if (!awsAccessKeyId.equals(awsAccessKeyId)) {
        return false;
      }
      if (serviceEndpoint == null)
      {
        if (serviceEndpoint != null) {
          return false;
        }
      }
      else if (!serviceEndpoint.equals(serviceEndpoint)) {
        return false;
      }
      return true;
    }
  }
  
  private static final Map<Key, STSSessionCredentialsProvider> cache = new HashMap();
  
  public static synchronized STSSessionCredentialsProvider getSessionCredentialsProvider(AWSCredentials longTermCredentials, String serviceEndpoint, ClientConfiguration stsClientConfiguration)
  {
    Key key = new Key(longTermCredentials.getAWSAccessKeyId(), serviceEndpoint);
    if (!cache.containsKey(key)) {
      cache.put(key, new STSSessionCredentialsProvider(longTermCredentials, stsClientConfiguration));
    }
    return (STSSessionCredentialsProvider)cache.get(key);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SessionCredentialsProviderFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */