package com.amazonaws.auth;

public abstract interface AWSCredentials
{
  public abstract String getAWSAccessKeyId();
  
  public abstract String getAWSSecretKey();
}

/* Location:
 * Qualified Name:     com.amazonaws.auth.AWSCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */