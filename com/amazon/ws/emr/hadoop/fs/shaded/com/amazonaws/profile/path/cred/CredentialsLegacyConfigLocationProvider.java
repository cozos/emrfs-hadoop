package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsDirectoryBasePathProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;

@SdkInternalApi
public class CredentialsLegacyConfigLocationProvider
  extends AwsDirectoryBasePathProvider
{
  private static final Log LOG = LogFactory.getLog(CredentialsLegacyConfigLocationProvider.class);
  private static final String LEGACY_CONFIG_PROFILES_FILENAME = "config";
  
  public File getLocation()
  {
    File legacyConfigProfiles = new File(getAwsDirectory(), "config");
    if ((legacyConfigProfiles.exists()) && (legacyConfigProfiles.isFile()))
    {
      LOG.warn("Found the legacy config profiles file at [" + legacyConfigProfiles
        .getAbsolutePath() + "]. Please move it to the latest default location [~/.aws/credentials].");
      
      return legacyConfigProfiles;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsLegacyConfigLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */