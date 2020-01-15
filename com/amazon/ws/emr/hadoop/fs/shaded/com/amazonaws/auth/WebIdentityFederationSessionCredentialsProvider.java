package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.Credentials;
import com.amazonaws.auth.AWSSessionCredentials;
import com.amazonaws.auth.AWSSessionCredentialsProvider;
import java.util.Date;

public class WebIdentityFederationSessionCredentialsProvider
  implements AWSSessionCredentialsProvider
{
  public static final int DEFAULT_DURATION_SECONDS = 3600;
  public static final int DEFAULT_THRESHOLD_SECONDS = 500;
  private final AWSSecurityTokenService securityTokenService;
  private AWSSessionCredentials sessionCredentials;
  private Date sessionCredentialsExpiration;
  private final String wifToken;
  private final String wifProvider;
  private final String roleArn;
  private int sessionDuration;
  private int refreshThreshold;
  private String subjectFromWIF;
  
  public WebIdentityFederationSessionCredentialsProvider(String wifToken, String wifProvider, String roleArn)
  {
    this(wifToken, wifProvider, roleArn, new ClientConfiguration());
  }
  
  public WebIdentityFederationSessionCredentialsProvider(String wifToken, String wifProvider, String roleArn, ClientConfiguration clientConfiguration)
  {
    this(wifToken, wifProvider, roleArn, new AWSSecurityTokenServiceClient(new AnonymousAWSCredentials(), clientConfiguration));
  }
  
  public WebIdentityFederationSessionCredentialsProvider(String wifToken, String wifProvider, String roleArn, AWSSecurityTokenService stsClient)
  {
    securityTokenService = stsClient;
    this.wifProvider = wifProvider;
    this.wifToken = wifToken;
    this.roleArn = roleArn;
    sessionDuration = 3600;
    refreshThreshold = 500;
  }
  
  public AWSSessionCredentials getCredentials()
  {
    if (needsNewSession()) {
      startSession();
    }
    return sessionCredentials;
  }
  
  public void refresh()
  {
    startSession();
  }
  
  public void setSessionDuration(int sessionDuration)
  {
    this.sessionDuration = sessionDuration;
  }
  
  public WebIdentityFederationSessionCredentialsProvider withSessionDuration(int sessionDuration)
  {
    setSessionDuration(sessionDuration);
    return this;
  }
  
  public int getSessionDuration()
  {
    return sessionDuration;
  }
  
  public void setRefreshThreshold(int refreshThreshold)
  {
    this.refreshThreshold = refreshThreshold;
  }
  
  public WebIdentityFederationSessionCredentialsProvider withRefreshThreshold(int refreshThreshold)
  {
    setRefreshThreshold(refreshThreshold);
    return this;
  }
  
  public int getRefreshThreshold()
  {
    return refreshThreshold;
  }
  
  public String getSubjectFromWIF()
  {
    return subjectFromWIF;
  }
  
  private void startSession()
  {
    AssumeRoleWithWebIdentityResult sessionTokenResult = securityTokenService.assumeRoleWithWebIdentity(new AssumeRoleWithWebIdentityRequest().withWebIdentityToken(wifToken)
      .withProviderId(wifProvider)
      .withRoleArn(roleArn)
      .withRoleSessionName("ProviderSession")
      .withDurationSeconds(Integer.valueOf(sessionDuration)));
    Credentials stsCredentials = sessionTokenResult.getCredentials();
    
    subjectFromWIF = sessionTokenResult.getSubjectFromWebIdentityToken();
    
    sessionCredentials = new BasicSessionCredentials(stsCredentials.getAccessKeyId(), stsCredentials.getSecretAccessKey(), stsCredentials.getSessionToken());
    sessionCredentialsExpiration = stsCredentials.getExpiration();
  }
  
  private boolean needsNewSession()
  {
    if (sessionCredentials == null) {
      return true;
    }
    long timeRemaining = sessionCredentialsExpiration.getTime() - System.currentTimeMillis();
    return timeRemaining < refreshThreshold * 1000;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.WebIdentityFederationSessionCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */