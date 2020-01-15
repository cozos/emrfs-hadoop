package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazonaws.auth.AWSCredentials;

public class AnonymousAWSCredentials
  implements AWSCredentials
{
  public String getAWSAccessKeyId()
  {
    return null;
  }
  
  public String getAWSSecretKey()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AnonymousAWSCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */