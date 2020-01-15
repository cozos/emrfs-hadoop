package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.AuthScope;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.auth.Credentials;

public abstract interface CredentialsProvider
{
  public abstract void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials);
  
  public abstract Credentials getCredentials(AuthScope paramAuthScope);
  
  public abstract void clear();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.http.client.CredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */