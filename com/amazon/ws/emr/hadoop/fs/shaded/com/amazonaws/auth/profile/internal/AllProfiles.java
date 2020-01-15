package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.util.Collections;
import java.util.Map;

@Immutable
@SdkInternalApi
public class AllProfiles
{
  private final Map<String, BasicProfile> profiles;
  
  public AllProfiles(Map<String, BasicProfile> profiles)
  {
    this.profiles = profiles;
  }
  
  public Map<String, BasicProfile> getProfiles()
  {
    return Collections.unmodifiableMap(profiles);
  }
  
  public BasicProfile getProfile(String profileName)
  {
    return (BasicProfile)profiles.get(profileName);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AllProfiles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */