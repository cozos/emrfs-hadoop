package com.amazonaws.auth;

public abstract interface AWSCredentialsProvider
{
  public abstract AWSCredentials getCredentials();
  
  public abstract void refresh();
}

/* Location:
 * Qualified Name:     com.amazonaws.auth.AWSCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */