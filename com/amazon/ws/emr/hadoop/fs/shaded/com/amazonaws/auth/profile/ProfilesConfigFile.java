package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AllProfiles;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.BasicProfileConfigLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.Profile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileAssumeRoleCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileProcessCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.ProfileStaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.ProfileCredentialsService;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.securitytoken.STSProfileCredentialsServiceLoader;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.StaticCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class ProfilesConfigFile
{
  @Deprecated
  public static final String AWS_PROFILE_ENVIRONMENT_VARIABLE = "AWS_PROFILE";
  @Deprecated
  public static final String AWS_PROFILE_SYSTEM_PROPERTY = "aws.profile";
  @Deprecated
  public static final String DEFAULT_PROFILE_NAME = "default";
  private final File profileFile;
  private final ProfileCredentialsService profileCredentialsService;
  private final ConcurrentHashMap<String, AWSCredentialsProvider> credentialProviderCache = new ConcurrentHashMap();
  private volatile AllProfiles allProfiles;
  private volatile long profileFileLastModified;
  
  public ProfilesConfigFile()
    throws SdkClientException
  {
    this(getCredentialProfilesFile());
  }
  
  public ProfilesConfigFile(String filePath)
  {
    this(new File(validateFilePath(filePath)));
  }
  
  public ProfilesConfigFile(String filePath, ProfileCredentialsService credentialsService)
    throws SdkClientException
  {
    this(new File(validateFilePath(filePath)), credentialsService);
  }
  
  private static String validateFilePath(String filePath)
  {
    if (filePath == null) {
      throw new IllegalArgumentException("Unable to load AWS profiles: specified file path is null.");
    }
    return filePath;
  }
  
  public ProfilesConfigFile(File file)
    throws SdkClientException
  {
    this(file, STSProfileCredentialsServiceLoader.getInstance());
  }
  
  public ProfilesConfigFile(File file, ProfileCredentialsService credentialsService)
    throws SdkClientException
  {
    profileFile = ((File)ValidationUtils.assertNotNull(file, "profile file"));
    profileCredentialsService = credentialsService;
    profileFileLastModified = file.lastModified();
    allProfiles = loadProfiles(profileFile);
  }
  
  public AWSCredentials getCredentials(String profileName)
  {
    AWSCredentialsProvider provider = (AWSCredentialsProvider)credentialProviderCache.get(profileName);
    if (provider != null) {
      return provider.getCredentials();
    }
    BasicProfile profile = allProfiles.getProfile(profileName);
    if (profile == null) {
      throw new IllegalArgumentException("No AWS profile named '" + profileName + "'");
    }
    AWSCredentialsProvider newProvider = fromProfile(profile);
    credentialProviderCache.put(profileName, newProvider);
    return newProvider.getCredentials();
  }
  
  public void refresh()
  {
    if (profileFile.lastModified() > profileFileLastModified) {
      synchronized (this)
      {
        if (profileFile.lastModified() > profileFileLastModified)
        {
          allProfiles = loadProfiles(profileFile);
          profileFileLastModified = profileFile.lastModified();
        }
      }
    }
    credentialProviderCache.clear();
  }
  
  public Map<String, BasicProfile> getAllBasicProfiles()
  {
    return allProfiles.getProfiles();
  }
  
  @Deprecated
  public Map<String, Profile> getAllProfiles()
  {
    Map<String, Profile> legacyProfiles = new HashMap();
    for (Map.Entry<String, BasicProfile> entry : getAllBasicProfiles().entrySet())
    {
      String profileName = (String)entry.getKey();
      legacyProfiles.put(profileName, new Profile(profileName, 
        ((BasicProfile)entry.getValue()).getProperties(), new StaticCredentialsProvider(
        
        getCredentials(profileName))));
    }
    return legacyProfiles;
  }
  
  private static File getCredentialProfilesFile()
  {
    return AwsProfileFileLocationProvider.DEFAULT_CREDENTIALS_LOCATION_PROVIDER.getLocation();
  }
  
  private static AllProfiles loadProfiles(File file)
  {
    return BasicProfileConfigLoader.INSTANCE.loadProfiles(file);
  }
  
  private AWSCredentialsProvider fromProfile(BasicProfile profile)
  {
    if (profile.isRoleBasedProfile()) {
      return new ProfileAssumeRoleCredentialsProvider(profileCredentialsService, allProfiles, profile);
    }
    if (profile.isProcessBasedProfile()) {
      return new ProfileProcessCredentialsProvider(profile);
    }
    return new ProfileStaticCredentialsProvider(profile);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfilesConfigFile
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */