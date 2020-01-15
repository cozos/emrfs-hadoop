package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazonaws.auth.AWSCredentials;

public class BasicAWSCredentials
  implements AWSCredentials
{
  private final String accessKey;
  private final String secretKey;
  
  public BasicAWSCredentials(String accessKey, String secretKey)
  {
    if (accessKey == null) {
      throw new IllegalArgumentException("Access key cannot be null.");
    }
    if (secretKey == null) {
      throw new IllegalArgumentException("Secret key cannot be null.");
    }
    this.accessKey = accessKey;
    this.secretKey = secretKey;
  }
  
  public String getAWSAccessKeyId()
  {
    return accessKey;
  }
  
  public String getAWSSecretKey()
  {
    return secretKey;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicAWSCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */