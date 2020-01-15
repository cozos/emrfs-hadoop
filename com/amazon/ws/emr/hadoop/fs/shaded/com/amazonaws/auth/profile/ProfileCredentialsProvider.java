package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.internal.AwsProfileNameLoader;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.util.concurrent.Semaphore;

public class ProfileCredentialsProvider
  implements AWSCredentialsProvider
{
  private static final long DEFAULT_REFRESH_INTERVAL_NANOS = 300000000000L;
  private static final long DEFAULT_FORCE_RELOAD_INTERVAL_NANOS = 600000000000L;
  private volatile ProfilesConfigFile profilesConfigFile;
  private volatile long lastRefreshed;
  private final String profileName;
  private final Semaphore refreshSemaphore = new Semaphore(1);
  private long refreshIntervalNanos = 300000000000L;
  private long refreshForceIntervalNanos = 600000000000L;
  
  public ProfileCredentialsProvider()
  {
    this(null);
  }
  
  public ProfileCredentialsProvider(String profileName)
  {
    this((ProfilesConfigFile)null, profileName);
  }
  
  public ProfileCredentialsProvider(String profilesConfigFilePath, String profileName)
  {
    this(new ProfilesConfigFile(profilesConfigFilePath), profileName);
  }
  
  public ProfileCredentialsProvider(ProfilesConfigFile profilesConfigFile, String profileName)
  {
    this.profilesConfigFile = profilesConfigFile;
    if (this.profilesConfigFile != null) {
      lastRefreshed = System.nanoTime();
    }
    if (profileName == null) {
      this.profileName = AwsProfileNameLoader.INSTANCE.loadProfileName();
    } else {
      this.profileName = profileName;
    }
  }
  
  public AWSCredentials getCredentials()
  {
    if (profilesConfigFile == null) {
      synchronized (this)
      {
        if (profilesConfigFile == null)
        {
          profilesConfigFile = new ProfilesConfigFile();
          lastRefreshed = System.nanoTime();
        }
      }
    }
    long now = System.nanoTime();
    long age = now - lastRefreshed;
    if (age > refreshForceIntervalNanos) {
      refresh();
    } else if ((age > refreshIntervalNanos) && 
      (refreshSemaphore.tryAcquire())) {
      try
      {
        refresh();
      }
      finally
      {
        refreshSemaphore.release();
      }
    }
    return profilesConfigFile.getCredentials(profileName);
  }
  
  public void refresh()
  {
    if (profilesConfigFile != null)
    {
      profilesConfigFile.refresh();
      lastRefreshed = System.nanoTime();
    }
  }
  
  public long getRefreshIntervalNanos()
  {
    return refreshIntervalNanos;
  }
  
  public void setRefreshIntervalNanos(long refreshIntervalNanos)
  {
    this.refreshIntervalNanos = refreshIntervalNanos;
  }
  
  public long getRefreshForceIntervalNanos()
  {
    return refreshForceIntervalNanos;
  }
  
  public void setRefreshForceIntervalNanos(long refreshForceIntervalNanos)
  {
    this.refreshForceIntervalNanos = refreshForceIntervalNanos;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.profile.ProfileCredentialsProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */