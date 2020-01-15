package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceClient;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.ValidationUtils;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.lang.reflect.Constructor;
import java.util.Collection;

public class Region
{
  private final RegionImpl regionImpl;
  
  public Region(RegionImpl regionImpl)
  {
    ValidationUtils.assertNotNull(regionImpl, "region implementation");
    this.regionImpl = regionImpl;
  }
  
  public static Region getRegion(Regions region)
  {
    return RegionUtils.getRegion(region.getName());
  }
  
  public String getName()
  {
    return regionImpl.getName();
  }
  
  public String getDomain()
  {
    return regionImpl.getDomain();
  }
  
  public String getPartition()
  {
    return regionImpl.getPartition();
  }
  
  public String getServiceEndpoint(String endpointPrefix)
  {
    return regionImpl.getServiceEndpoint(endpointPrefix);
  }
  
  public boolean isServiceSupported(String serviceName)
  {
    return regionImpl.isServiceSupported(serviceName);
  }
  
  public boolean hasHttpsEndpoint(String serviceName)
  {
    return regionImpl.hasHttpsEndpoint(serviceName);
  }
  
  public boolean hasHttpEndpoint(String serviceName)
  {
    return regionImpl.hasHttpEndpoint(serviceName);
  }
  
  public Collection<String> getAvailableEndpoints()
  {
    return regionImpl.getAvailableEndpoints();
  }
  
  @Deprecated
  public <T extends AmazonWebServiceClient> T createClient(Class<T> serviceClass, AWSCredentialsProvider credentials, ClientConfiguration config)
  {
    try
    {
      T client;
      T client;
      if ((credentials == null) && (config == null))
      {
        Constructor<T> constructor = serviceClass.getConstructor(new Class[0]);
        client = (AmazonWebServiceClient)constructor.newInstance(new Object[0]);
      }
      else
      {
        T client;
        if (credentials == null)
        {
          Constructor<T> constructor = serviceClass.getConstructor(new Class[] { ClientConfiguration.class });
          client = (AmazonWebServiceClient)constructor.newInstance(new Object[] { config });
        }
        else
        {
          T client;
          if (config == null)
          {
            Constructor<T> constructor = serviceClass.getConstructor(new Class[] { AWSCredentialsProvider.class });
            client = (AmazonWebServiceClient)constructor.newInstance(new Object[] { credentials });
          }
          else
          {
            Constructor<T> constructor = serviceClass.getConstructor(new Class[] { AWSCredentialsProvider.class, ClientConfiguration.class });
            client = (AmazonWebServiceClient)constructor.newInstance(new Object[] { credentials, config });
          }
        }
      }
      client.setRegion(this);
      return client;
    }
    catch (Exception e)
    {
      throw new RuntimeException("Couldn't instantiate instance of " + serviceClass, e);
    }
  }
  
  public boolean equals(Object obj)
  {
    if (!(obj instanceof Region)) {
      return false;
    }
    Region region = (Region)obj;
    return getName().equals(region.getName());
  }
  
  public int hashCode()
  {
    return getName().hashCode();
  }
  
  public String toString()
  {
    return getName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */