package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SdkInternalApi
public class AwsProfileFileLocationProviderChain
  implements AwsProfileFileLocationProvider
{
  private final List<AwsProfileFileLocationProvider> providers = new ArrayList();
  
  public AwsProfileFileLocationProviderChain(AwsProfileFileLocationProvider... providers)
  {
    Collections.addAll(this.providers, providers);
  }
  
  public File getLocation()
  {
    for (AwsProfileFileLocationProvider provider : providers)
    {
      File path = provider.getLocation();
      if (path != null) {
        return path;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.profile.path.AwsProfileFileLocationProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */