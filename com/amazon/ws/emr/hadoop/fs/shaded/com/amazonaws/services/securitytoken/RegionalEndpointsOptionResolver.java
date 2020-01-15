package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfilesConfigFile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.util.Map;

@ThreadSafe
@SdkInternalApi
final class RegionalEndpointsOptionResolver
{
  private static enum Option
  {
    LEGACY,  REGIONAL;
    
    private Option() {}
  }
  
  private static final Log log = LogFactory.getLog(RegionalEndpointsOptionResolver.class);
  private static final String ENV_VAR = "AWS_STS_REGIONAL_ENDPOINTS";
  private static final String PROFILE_PROPERTY = "sts_regional_endpoints";
  private final AwsProfileFileLocationProvider configFileLocationProvider;
  private volatile String profileName;
  private volatile ProfilesConfigFile configFile;
  private volatile boolean profileLoadAttempted;
  
  public RegionalEndpointsOptionResolver()
  {
    configFileLocationProvider = AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER;
  }
  
  public RegionalEndpointsOptionResolver(AwsProfileFileLocationProvider configFileLocationProvider)
  {
    this.configFileLocationProvider = configFileLocationProvider;
  }
  
  public boolean useLegacyMode()
  {
    Option option = envVarOption();
    if (option == null) {
      option = profileOption();
    }
    return option != Option.REGIONAL;
  }
  
  private Option envVarOption()
  {
    String val = System.getenv("AWS_STS_REGIONAL_ENDPOINTS");
    return resolveOption(val, String.format("Unexpected value set for %s environment variable: '%s'", new Object[] { "AWS_STS_REGIONAL_ENDPOINTS", val }));
  }
  
  private synchronized Option profileOption()
  {
    String profileName = getProfileName();
    BasicProfile profile = getProfile(profileName);
    if (profile == null) {
      return null;
    }
    String val = profile.getPropertyValue("sts_regional_endpoints");
    return resolveOption(val, String.format("Unexpected option for '%s' property in profile '%s': %s", new Object[] { "sts_regional_endpoints", profileName, val }));
  }
  
  private Option resolveOption(String value, String errMsg)
  {
    if (value == null) {
      return null;
    }
    if ("legacy".equalsIgnoreCase(value)) {
      return Option.LEGACY;
    }
    if ("regional".equalsIgnoreCase(value)) {
      return Option.REGIONAL;
    }
    throw new SdkClientException(errMsg);
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
    ProfilesConfigFile profilesConfigFile = getProfilesConfigFile();
    if (profilesConfigFile != null) {
      return (BasicProfile)profilesConfigFile.getAllBasicProfiles().get(profileName);
    }
    return null;
  }
  
  private ProfilesConfigFile getProfilesConfigFile()
  {
    if (!profileLoadAttempted) {
      synchronized (this)
      {
        if (!profileLoadAttempted)
        {
          File location = null;
          try
          {
            location = configFileLocationProvider.getLocation();
            if (location != null) {
              configFile = new ProfilesConfigFile(location);
            }
          }
          catch (Exception e)
          {
            if (log.isWarnEnabled()) {
              log.warn("Unable to load config file " + location, e);
            }
          }
          finally
          {
            profileLoadAttempted = true;
          }
        }
      }
    }
    return configFile;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.RegionalEndpointsOptionResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */