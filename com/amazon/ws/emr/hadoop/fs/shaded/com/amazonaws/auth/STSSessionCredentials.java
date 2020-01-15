package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.Credentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSRefreshableSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentials;
import java.util.Date;

@Deprecated
public class STSSessionCredentials
  implements AWSRefreshableSessionCredentials
{
  private final AWSSecurityTokenService securityTokenService;
  private final int sessionDurationSeconds;
  private Credentials sessionCredentials;
  public static final int DEFAULT_DURATION_SECONDS = 3600;
  
  public STSSessionCredentials(AWSCredentials credentials)
  {
    this(credentials, 3600);
  }
  
  public STSSessionCredentials(AWSCredentials credentials, int sessionDurationSeconds)
  {
    securityTokenService = new AWSSecurityTokenServiceClient(credentials);
    this.sessionDurationSeconds = sessionDurationSeconds;
  }
  
  public STSSessionCredentials(AWSSecurityTokenService stsClient)
  {
    this(stsClient, 3600);
  }
  
  public STSSessionCredentials(AWSSecurityTokenService stsClient, int sessionDuratinSeconds)
  {
    securityTokenService = stsClient;
    sessionDurationSeconds = sessionDuratinSeconds;
  }
  
  public synchronized String getAWSAccessKeyId()
  {
    return getSessionCredentials().getAccessKeyId();
  }
  
  public synchronized String getAWSSecretKey()
  {
    return getSessionCredentials().getSecretAccessKey();
  }
  
  public synchronized String getSessionToken()
  {
    return getSessionCredentials().getSessionToken();
  }
  
  public synchronized AWSSessionCredentials getImmutableCredentials()
  {
    Credentials creds = getSessionCredentials();
    return new BasicSessionCredentials(creds.getAccessKeyId(), creds.getSecretAccessKey(), creds.getSessionToken());
  }
  
  public synchronized void refreshCredentials()
  {
    GetSessionTokenResult sessionTokenResult = securityTokenService.getSessionToken(new GetSessionTokenRequest().withDurationSeconds(Integer.valueOf(sessionDurationSeconds)));
    sessionCredentials = sessionTokenResult.getCredentials();
  }
  
  private synchronized Credentials getSessionCredentials()
  {
    if (needsNewSession()) {
      refreshCredentials();
    }
    return sessionCredentials;
  }
  
  private boolean needsNewSession()
  {
    if (sessionCredentials == null) {
      return true;
    }
    Date expiration = sessionCredentials.getExpiration();
    long timeRemaining = expiration.getTime() - System.currentTimeMillis();
    if (timeRemaining < 60000L) {
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.STSSessionCredentials
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */