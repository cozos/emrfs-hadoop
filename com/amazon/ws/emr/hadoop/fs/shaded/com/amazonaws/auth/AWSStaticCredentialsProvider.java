package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class AWSStaticCredentialsProvider
  implements AWSCredentialsProvider
{
  private final AWSCredentials credentials;
  
  public AWSStaticCredentialsProvider(AWSCredentials credentials)
  {
    this.credentials = ((AWSCredentials)ValidationUtils.assertNotNull(credentials, "credentials"));
  }
  
  public AWSCredentials getCredentials()
  {
    return credentials;
  }
  
  public void refresh() {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWSStaticCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */