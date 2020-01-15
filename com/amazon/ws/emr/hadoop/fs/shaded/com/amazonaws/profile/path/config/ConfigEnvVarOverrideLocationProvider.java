package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import java.io.File;

@SdkInternalApi
public class ConfigEnvVarOverrideLocationProvider
  implements AwsProfileFileLocationProvider
{
  public File getLocation()
  {
    String overrideLocation = System.getenv("AWS_CONFIG_FILE");
    if (overrideLocation != null) {
      return new File(overrideLocation);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config.ConfigEnvVarOverrideLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */