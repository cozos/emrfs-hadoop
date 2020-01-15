package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AllProfiles;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfileConfigLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.File;

public class AwsProfileEndpointDiscoveryProvider
  implements EndpointDiscoveryProvider
{
  private final String profileName;
  private final AwsProfileFileLocationProvider locationProvider;
  private final BasicProfileConfigLoader profileConfigLoader;
  
  public AwsProfileEndpointDiscoveryProvider()
  {
    this(AwsProfileNameLoader.INSTANCE.loadProfileName());
  }
  
  public AwsProfileEndpointDiscoveryProvider(String profileName)
  {
    this(profileName, AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER, BasicProfileConfigLoader.INSTANCE);
  }
  
  @SdkTestInternalApi
  AwsProfileEndpointDiscoveryProvider(String profileName, AwsProfileFileLocationProvider locationProvider, BasicProfileConfigLoader configLoader)
  {
    this.profileName = profileName;
    this.locationProvider = locationProvider;
    profileConfigLoader = configLoader;
  }
  
  public Boolean endpointDiscoveryEnabled()
  {
    Boolean endpointDiscoveryEnabled = null;
    File configFile = locationProvider.getLocation();
    if ((configFile != null) && (configFile.exists()))
    {
      BasicProfile profile = loadProfile(configFile);
      if ((profile != null) && (!StringUtils.isNullOrEmpty(profile.getEndpointDiscovery()))) {
        try
        {
          endpointDiscoveryEnabled = Boolean.valueOf(Boolean.parseBoolean(profile.getEndpointDiscovery()));
        }
        catch (Exception e)
        {
          throw new RuntimeException("Unable to parse value for aws_enable_endpoint_discovery");
        }
      }
    }
    return endpointDiscoveryEnabled;
  }
  
  private BasicProfile loadProfile(File configFile)
  {
    AllProfiles allProfiles = profileConfigLoader.loadProfiles(configFile);
    return allProfiles.getProfile(profileName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.endpointdiscovery.AwsProfileEndpointDiscoveryProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */