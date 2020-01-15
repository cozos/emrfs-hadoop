package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ProcessCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.ProcessCredentialsProvider.Builder;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class ProfileProcessCredentialsProvider
  implements AWSCredentialsProvider
{
  private final ProcessCredentialsProvider delegate;
  
  public ProfileProcessCredentialsProvider(BasicProfile profile)
  {
    delegate = ProcessCredentialsProvider.builder().withCommand(profile.getCredentialProcess()).build();
  }
  
  public AWSCredentials getCredentials()
  {
    return delegate.getCredentials();
  }
  
  public void refresh()
  {
    delegate.refresh();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileProcessCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */