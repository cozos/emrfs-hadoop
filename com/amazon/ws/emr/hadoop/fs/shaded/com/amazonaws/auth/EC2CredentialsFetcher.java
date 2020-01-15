package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.CredentialsEndpointProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.EC2CredentialsUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.DateUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonNode;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import com.amazonaws.auth.AWSCredentials;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

@SdkInternalApi
class EC2CredentialsFetcher
{
  private static final Log LOG = LogFactory.getLog(EC2CredentialsFetcher.class);
  private static final int REFRESH_THRESHOLD = 3600000;
  private static final int EXPIRATION_THRESHOLD = 900000;
  private static final String ACCESS_KEY_ID = "AccessKeyId";
  private static final String SECRET_ACCESS_KEY = "SecretAccessKey";
  private static final String TOKEN = "Token";
  private volatile AWSCredentials credentials;
  private volatile Date credentialsExpiration;
  protected volatile Date lastInstanceProfileCheck;
  private final CredentialsEndpointProvider credentialsEndpointProvider;
  
  public EC2CredentialsFetcher(CredentialsEndpointProvider credentialsEndpointProvider)
  {
    this.credentialsEndpointProvider = credentialsEndpointProvider;
  }
  
  public AWSCredentials getCredentials()
  {
    if (needsToLoadCredentials()) {
      fetchCredentials();
    }
    if (expired()) {
      throw new SdkClientException("The credentials received have been expired");
    }
    return credentials;
  }
  
  protected boolean needsToLoadCredentials()
  {
    if (credentials == null) {
      return true;
    }
    if ((credentialsExpiration != null) && 
      (isWithinExpirationThreshold())) {
      return true;
    }
    if ((lastInstanceProfileCheck != null) && 
      (isPastRefreshThreshold())) {
      return true;
    }
    return false;
  }
  
  private synchronized void fetchCredentials()
  {
    if (!needsToLoadCredentials()) {
      return;
    }
    try
    {
      lastInstanceProfileCheck = new Date();
      
      String credentialsResponse = EC2CredentialsUtils.getInstance().readResource(credentialsEndpointProvider
        .getCredentialsEndpoint(), credentialsEndpointProvider
        .getRetryPolicy(), credentialsEndpointProvider
        .getHeaders());
      
      JsonNode node = (JsonNode)Jackson.fromSensitiveJsonString(credentialsResponse, JsonNode.class);
      JsonNode accessKey = node.get("AccessKeyId");
      JsonNode secretKey = node.get("SecretAccessKey");
      JsonNode token = node.get("Token");
      if ((null == accessKey) || (null == secretKey)) {
        throw new SdkClientException("Unable to load credentials.");
      }
      if (null != token) {
        credentials = new BasicSessionCredentials(accessKey.asText(), secretKey.asText(), token.asText());
      } else {
        credentials = new BasicAWSCredentials(accessKey.asText(), secretKey.asText());
      }
      JsonNode expirationJsonNode = node.get("Expiration");
      if (null != expirationJsonNode)
      {
        String expiration = expirationJsonNode.asText();
        expiration = expiration.replaceAll("\\+0000$", "Z");
        try
        {
          credentialsExpiration = DateUtils.parseISO8601Date(expiration);
        }
        catch (Exception ex)
        {
          handleError("Unable to parse credentials expiration date from Amazon EC2 instance", ex);
        }
      }
    }
    catch (JsonMappingException e)
    {
      handleError("Unable to parse response returned from service endpoint", e);
    }
    catch (IOException e)
    {
      handleError("Unable to load credentials from service endpoint", e);
    }
    catch (URISyntaxException e)
    {
      handleError("Unable to load credentials from service endpoint", e);
    }
  }
  
  private void handleError(String errorMessage, Exception e)
  {
    if ((credentials == null) || (expired())) {
      throw new SdkClientException(errorMessage, e);
    }
    LOG.debug(errorMessage, e);
  }
  
  public void refresh()
  {
    credentials = null;
  }
  
  private boolean isWithinExpirationThreshold()
  {
    return credentialsExpiration.getTime() - System.currentTimeMillis() < 900000L;
  }
  
  private boolean isPastRefreshThreshold()
  {
    return System.currentTimeMillis() - lastInstanceProfileCheck.getTime() > 3600000L;
  }
  
  private boolean expired()
  {
    if ((credentialsExpiration != null) && 
      (credentialsExpiration.getTime() < System.currentTimeMillis())) {
      return true;
    }
    return false;
  }
  
  public Date getCredentialsExpiration()
  {
    return credentialsExpiration;
  }
  
  public String toString()
  {
    return getClass().getSimpleName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.EC2CredentialsFetcher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */