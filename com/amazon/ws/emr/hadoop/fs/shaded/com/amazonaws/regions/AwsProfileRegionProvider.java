package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkTestInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AllProfiles;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfileConfigLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import java.io.File;

public class AwsProfileRegionProvider
  extends AwsRegionProvider
{
  private final String profileName;
  private final AwsProfileFileLocationProvider locationProvider;
  private final BasicProfileConfigLoader profileConfigLoader;
  
  public AwsProfileRegionProvider()
  {
    this(AwsProfileNameLoader.INSTANCE.loadProfileName());
  }
  
  public AwsProfileRegionProvider(String profileName)
  {
    this(profileName, AwsProfileFileLocationProvider.DEFAULT_CONFIG_LOCATION_PROVIDER, BasicProfileConfigLoader.INSTANCE);
  }
  
  @SdkTestInternalApi
  AwsProfileRegionProvider(String profileName, AwsProfileFileLocationProvider locationProvider, BasicProfileConfigLoader configLoader)
  {
    this.profileName = profileName;
    this.locationProvider = locationProvider;
    profileConfigLoader = configLoader;
  }
  
  public String getRegion()
    throws SdkClientException
  {
    File configFile = locationProvider.getLocation();
    if ((configFile != null) && (configFile.exists()))
    {
      BasicProfile profile = loadProfile(configFile);
      if ((profile != null) && (!StringUtils.isNullOrEmpty(profile.getRegion()))) {
        return profile.getRegion();
      }
    }
    return null;
  }
  
  private BasicProfile loadProfile(File configFile)
  {
    AllProfiles allProfiles = profileConfigLoader.loadProfiles(configFile);
    return allProfiles.getProfile(profileName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsProfileRegionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */