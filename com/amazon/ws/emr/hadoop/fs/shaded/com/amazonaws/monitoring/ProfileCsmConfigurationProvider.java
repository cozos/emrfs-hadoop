package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import java.util.Map;

@ThreadSafe
public final class ProfileCsmConfigurationProvider
  implements CsmConfigurationProvider
{
  public static final String CSM_ENABLED_PROPERTY = "csm_enabled";
  public static final String CSM_HOST_PROPERTY = "csm_host";
  public static final String CSM_PORT_PROPERTY = "csm_port";
  public static final String CSM_CLIENT_ID_PROPERTY = "csm_client_id";
  private final AwsProfileFileLocationProvider configFileLocationProvider;
  private volatile String profileName;
  private volatile ProfilesConfigFile configFile;
  
  public ProfileCsmConfigurationProvider()
  {
    this(null, AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER);
  }
  
  public ProfileCsmConfigurationProvider(String profileName)
  {
    this(profileName, AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER);
  }
  
  public ProfileCsmConfigurationProvider(String profileName, AwsProfileFileLocationProvider configFileLocationProvider)
  {
    this.profileName = profileName;
    this.configFileLocationProvider = configFileLocationProvider;
  }
  
  public CsmConfiguration getConfiguration()
  {
    String profileName = getProfileName();
    
    BasicProfile profile = getProfile(profileName);
    if (profile == null) {
      throw new SdkClientException(String.format("Could not find the '%s' profile!", new Object[] { profileName }));
    }
    String enabled = profile.getPropertyValue("csm_enabled");
    if (enabled == null) {
      throw new SdkClientException(String.format("The '%s' profile does not define all the required properties!", new Object[] { profileName }));
    }
    String host = profile.getPropertyValue("csm_host");
    host = host == null ? "127.0.0.1" : host;
    String port = profile.getPropertyValue("csm_port");
    String clientId = profile.getPropertyValue("csm_client_id");
    clientId = clientId == null ? "" : clientId;
    try
    {
      int portNumber = port == null ? 31000 : Integer.parseInt(port);
      
      return CsmConfiguration.builder()
        .withEnabled(Boolean.valueOf(Boolean.parseBoolean(enabled)))
        .withHost(host)
        .withPort(Integer.valueOf(portNumber))
        .withClientId(clientId)
        .build();
    }
    catch (Exception e)
    {
      throw new SdkClientException(String.format("Unable to load configuration from the '%s' profile!", new Object[] { profileName }), e);
    }
  }
  
  private String getProfileName()
  {
    if (profileName == null) {
      synchronized (this)
      {
        if (profileName == null) {
          profileName = AwsProfileNameLoader.INSTANCE.loadProfileName();
        }
      }
    }
    return profileName;
  }
  
  private synchronized BasicProfile getProfile(String profileName)
  {
    return (BasicProfile)getProfilesConfigFile().getAllBasicProfiles().get(profileName);
  }
  
  private ProfilesConfigFile getProfilesConfigFile()
  {
    if (configFile == null) {
      synchronized (this)
      {
        if (configFile == null) {
          try
          {
            configFile = new ProfilesConfigFile(configFileLocationProvider.getLocation());
          }
          catch (Exception e)
          {
            throw new SdkClientException("Unable to load config file", e);
          }
        }
      }
    }
    return configFile;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.ProfileCsmConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */