package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.io.File;

@SdkInternalApi
public abstract class AwsDirectoryBasePathProvider
  implements AwsProfileFileLocationProvider
{
  protected final File getAwsDirectory()
  {
    return new File(getHomeDirectory(), ".aws");
  }
  
  private String getHomeDirectory()
  {
    String userHome = System.getProperty("user.home");
    if (userHome == null) {
      throw new SdkClientException("Unable to load AWS profiles: 'user.home' System property is not set.");
    }
    return userHome;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsDirectoryBasePathProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */