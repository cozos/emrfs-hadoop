package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsDirectoryBasePathProvider;
import java.io.File;

@SdkInternalApi
public class SharedConfigDefaultLocationProvider
  extends AwsDirectoryBasePathProvider
{
  private static final String DEFAULT_CONFIG_FILE_NAME = "config";
  
  public File getLocation()
  {
    File file = new File(getAwsDirectory(), "config");
    if ((file.exists()) && (file.isFile())) {
      return file;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.config.SharedConfigDefaultLocationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */