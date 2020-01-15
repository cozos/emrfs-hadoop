package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@Deprecated
public class StaticCredentialsProvider
  implements AWSCredentialsProvider
{
  private final AWSCredentials credentials;
  
  public StaticCredentialsProvider(AWSCredentials credentials)
  {
    this.credentials = credentials;
  }
  
  public AWSCredentials getCredentials()
  {
    return credentials;
  }
  
  public void refresh() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */