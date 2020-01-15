package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;

@SdkInternalApi
@Immutable
public class AwsProfileNameLoader
{
  public static final String DEFAULT_PROFILE_NAME = "default";
  public static final String AWS_PROFILE_ENVIRONMENT_VARIABLE = "AWS_PROFILE";
  public static final String AWS_PROFILE_SYSTEM_PROPERTY = "aws.profile";
  public static final AwsProfileNameLoader INSTANCE = new AwsProfileNameLoader();
  
  public final String loadProfileName()
  {
    String profileEnvVarOverride = getEnvProfileName();
    if (!StringUtils.isNullOrEmpty(profileEnvVarOverride)) {
      return profileEnvVarOverride;
    }
    String profileSysPropOverride = getSysPropertyProfileName();
    if (!StringUtils.isNullOrEmpty(profileSysPropOverride)) {
      return profileSysPropOverride;
    }
    return "default";
  }
  
  private String getSysPropertyProfileName()
  {
    return StringUtils.trim(System.getProperty("aws.profile"));
  }
  
  private String getEnvProfileName()
  {
    return StringUtils.trim(System.getenv("AWS_PROFILE"));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */