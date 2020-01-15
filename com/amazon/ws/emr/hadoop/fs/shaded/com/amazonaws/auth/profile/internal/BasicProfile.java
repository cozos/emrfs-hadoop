package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.Collections;
import java.util.Map;

@Immutable
@SdkInternalApi
public class BasicProfile
{
  private final String profileName;
  private final Map<String, String> properties;
  
  public BasicProfile(String profileName, Map<String, String> properties)
  {
    this.profileName = profileName;
    this.properties = properties;
  }
  
  public String getProfileName()
  {
    return profileName;
  }
  
  public Map<String, String> getProperties()
  {
    return Collections.unmodifiableMap(properties);
  }
  
  public String getPropertyValue(String propertyName)
  {
    return (String)getProperties().get(propertyName);
  }
  
  public String getAwsAccessIdKey()
  {
    return getPropertyValue("aws_access_key_id");
  }
  
  public String getAwsSecretAccessKey()
  {
    return getPropertyValue("aws_secret_access_key");
  }
  
  public String getAwsSessionToken()
  {
    return getPropertyValue("aws_session_token");
  }
  
  public String getRoleArn()
  {
    return getPropertyValue("role_arn");
  }
  
  public String getRoleSourceProfile()
  {
    return getPropertyValue("source_profile");
  }
  
  public String getRoleSessionName()
  {
    return getPropertyValue("role_session_name");
  }
  
  public String getRoleExternalId()
  {
    return getPropertyValue("external_id");
  }
  
  public String getRegion()
  {
    return getPropertyValue("region");
  }
  
  public String getEndpointDiscovery()
  {
    return getPropertyValue("aws_enable_endpoint_discovery");
  }
  
  public String getCredentialProcess()
  {
    return getPropertyValue("credential_process");
  }
  
  public String getWebIdentityTokenFilePath()
  {
    return getPropertyValue("web_identity_token_file");
  }
  
  public boolean isRoleBasedProfile()
  {
    return getRoleArn() != null;
  }
  
  public boolean isProcessBasedProfile()
  {
    return getCredentialProcess() != null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */