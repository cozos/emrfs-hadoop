package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsDirectoryBasePathProvider;
import java.io.File;

@SdkInternalApi
public class CredentialsDefaultLocationProvider
  extends AwsDirectoryBasePathProvider
{
  private static final String DEFAULT_CREDENTIAL_PROFILES_FILENAME = "credentials";
  
  public File getLocation()
  {
    File credentialProfiles = new File(getAwsDirectory(), "credentials");
    if ((credentialProfiles.exists()) && (credentialProfiles.isFile())) {
      return credentialProfiles;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsDefaultLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */