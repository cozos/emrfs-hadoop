package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config.ConfigEnvVarOverrideLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config.SharedConfigDefaultLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsDefaultLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsEnvVarOverrideLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.cred.CredentialsLegacyConfigLocationProvider;
import java.io.File;

@SdkInternalApi
public abstract interface AwsProfileFileLocationProvider
{
  public static final AwsProfileFileLocationProvider DEFAULT_CREDENTIALS_LOCATION_PROVIDER = new AwsProfileFileLocationProviderChain(new AwsProfileFileLocationProvider[] { new CredentialsEnvVarOverrideLocationProvider(), new CredentialsDefaultLocationProvider(), new CredentialsLegacyConfigLocationProvider() });
  public static final AwsProfileFileLocationProvider DEFAULT_CONFIG_LOCATION_PROVIDER = new AwsProfileFileLocationProviderChain(new AwsProfileFileLocationProvider[] { new ConfigEnvVarOverrideLocationProvider(), new SharedConfigDefaultLocationProvider() });
  
  public abstract File getLocation();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */