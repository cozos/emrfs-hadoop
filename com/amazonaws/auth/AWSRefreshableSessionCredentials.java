package com.amazonaws.auth;

public abstract interface AWSRefreshableSessionCredentials
  extends AWSSessionCredentials
{
  public abstract void refreshCredentials();
}

/* Location:
 * Qualified Name:     com.amazonaws.auth.AWSRefreshableSessionCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */