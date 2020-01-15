package com.amazonaws.auth;

public abstract interface AWSSessionCredentialsProvider
  extends AWSCredentialsProvider
{
  public abstract AWSSessionCredentials getCredentials();
}

/* Location:
 * Qualified Name:     com.amazonaws.auth.AWSSessionCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */