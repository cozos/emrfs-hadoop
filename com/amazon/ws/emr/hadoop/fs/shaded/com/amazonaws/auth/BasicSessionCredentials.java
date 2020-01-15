package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazonaws.auth.AWSSessionCredentials;

public class BasicSessionCredentials
  implements AWSSessionCredentials
{
  private final String awsAccessKey;
  private final String awsSecretKey;
  private final String sessionToken;
  
  public BasicSessionCredentials(String awsAccessKey, String awsSecretKey, String sessionToken)
  {
    this.awsAccessKey = awsAccessKey;
    this.awsSecretKey = awsSecretKey;
    this.sessionToken = sessionToken;
  }
  
  public String getAWSAccessKeyId()
  {
    return awsAccessKey;
  }
  
  public String getAWSSecretKey()
  {
    return awsSecretKey;
  }
  
  public String getSessionToken()
  {
    return sessionToken;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicSessionCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */