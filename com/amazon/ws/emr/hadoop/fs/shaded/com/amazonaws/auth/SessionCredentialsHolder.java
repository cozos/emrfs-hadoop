package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.util.Date;

@ThreadSafe
@SdkInternalApi
final class SessionCredentialsHolder
{
  private final AWSSessionCredentials sessionCredentials;
  private final Date sessionCredentialsExpiration;
  
  SessionCredentialsHolder(Credentials credentials)
  {
    sessionCredentials = new BasicSessionCredentials(credentials.getAccessKeyId(), credentials.getSecretAccessKey(), credentials.getSessionToken());
    sessionCredentialsExpiration = credentials.getExpiration();
  }
  
  public AWSSessionCredentials getSessionCredentials()
  {
    return sessionCredentials;
  }
  
  public Date getSessionCredentialsExpiration()
  {
    return sessionCredentialsExpiration;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SessionCredentialsHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */