package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import java.io.File;

@SdkInternalApi
public class CredentialsEnvVarOverrideLocationProvider
  implements AwsProfileFileLocationProvider
{
  private static final String CREDENTIAL_PROFILES_FILE_ENVIRONMENT_VARIABLE = "AWS_CREDENTIAL_PROFILES_FILE";
  
  public File getLocation()
  {
    String credentialProfilesFileOverride = System.getenv("AWS_CREDENTIAL_PROFILES_FILE");
    if (credentialProfilesFileOverride == null) {
      return null;
    }
    return new File(credentialProfilesFileOverride);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsEnvVarOverrideLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */