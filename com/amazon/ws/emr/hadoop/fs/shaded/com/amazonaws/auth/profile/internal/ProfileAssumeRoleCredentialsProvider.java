package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.Immutable;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.ProfileCredentialsService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.RoleInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

@SdkInternalApi
@Immutable
public class ProfileAssumeRoleCredentialsProvider
  implements AWSCredentialsProvider
{
  private final AllProfiles allProfiles;
  private final BasicProfile profile;
  private final ProfileCredentialsService profileCredentialsService;
  private final AWSCredentialsProvider assumeRoleCredentialsProvider;
  
  public ProfileAssumeRoleCredentialsProvider(ProfileCredentialsService profileCredentialsService, AllProfiles allProfiles, BasicProfile profile)
  {
    this.allProfiles = allProfiles;
    this.profile = profile;
    this.profileCredentialsService = profileCredentialsService;
    assumeRoleCredentialsProvider = fromAssumeRole();
  }
  
  public AWSCredentials getCredentials()
  {
    return assumeRoleCredentialsProvider.getCredentials();
  }
  
  public void refresh() {}
  
  private AWSCredentialsProvider fromAssumeRole()
  {
    if (StringUtils.isNullOrEmpty(profile.getRoleSourceProfile())) {
      throw new SdkClientException(String.format("Unable to load credentials from profile [%s]: Source profile name is not specified", new Object[] {profile
      
        .getProfileName() }));
    }
    BasicProfile sourceProfile = allProfiles.getProfile(profile.getRoleSourceProfile());
    if (sourceProfile == null) {
      throw new SdkClientException(String.format("Unable to load source profile [%s]: Source profile was not found [%s]", new Object[] {profile
      
        .getProfileName(), profile.getRoleSourceProfile() }));
    }
    AWSCredentials sourceCredentials = new ProfileStaticCredentialsProvider(sourceProfile).getCredentials();
    
    String roleSessionName = profile.getRoleSessionName() == null ? "aws-sdk-java-" + System.currentTimeMillis() : profile.getRoleSessionName();
    
    RoleInfo roleInfo = new RoleInfo().withRoleArn(profile.getRoleArn()).withRoleSessionName(roleSessionName).withExternalId(profile.getRoleExternalId()).withLongLivedCredentials(sourceCredentials).withWebIdentityTokenFilePath(profile.getWebIdentityTokenFilePath());
    return profileCredentialsService.getAssumeRoleCredentialsProvider(roleInfo);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileAssumeRoleCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */