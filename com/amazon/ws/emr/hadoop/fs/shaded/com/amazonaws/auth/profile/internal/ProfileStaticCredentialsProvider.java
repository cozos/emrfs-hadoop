package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicAWSCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.BasicSessionCredentials;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@SdkInternalApi
@Immutable
public class ProfileStaticCredentialsProvider
  implements AWSCredentialsProvider
{
  private final BasicProfile profile;
  private final AWSCredentialsProvider credentialsProvider;
  
  public ProfileStaticCredentialsProvider(BasicProfile profile)
  {
    this.profile = profile;
    credentialsProvider = new StaticCredentialsProvider(fromStaticCredentials());
  }
  
  public AWSCredentials getCredentials()
  {
    return credentialsProvider.getCredentials();
  }
  
  public void refresh() {}
  
  private AWSCredentials fromStaticCredentials()
  {
    if (StringUtils.isNullOrEmpty(profile.getAwsAccessIdKey())) {
      throw new SdkClientException(String.format("Unable to load credentials into profile [%s]: AWS Access Key ID is not specified.", new Object[] {profile
      
        .getProfileName() }));
    }
    if (StringUtils.isNullOrEmpty(profile.getAwsSecretAccessKey())) {
      throw new SdkClientException(String.format("Unable to load credentials into profile [%s]: AWS Secret Access Key is not specified.", new Object[] {profile
      
        .getAwsSecretAccessKey() }));
    }
    if (profile.getAwsSessionToken() == null) {
      return new BasicAWSCredentials(profile.getAwsAccessIdKey(), profile
        .getAwsSecretAccessKey());
    }
    if (profile.getAwsSessionToken().isEmpty()) {
      throw new SdkClientException(String.format("Unable to load credentials into profile [%s]: AWS Session Token is empty.", new Object[] {profile
      
        .getProfileName() }));
    }
    return new BasicSessionCredentials(profile.getAwsAccessIdKey(), profile
      .getAwsSecretAccessKey(), profile
      .getAwsSessionToken());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileStaticCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */