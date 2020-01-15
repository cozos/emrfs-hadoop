package com.amazonaws.auth;

public abstract interface AWSSessionCredentials
  extends AWSCredentials
{
  public abstract String getSessionToken();
}

/* Location:
 * Qualified Name:     com.amazonaws.auth.AWSSessionCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */