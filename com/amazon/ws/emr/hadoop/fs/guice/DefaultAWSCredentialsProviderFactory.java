package com.amazon.ws.emr.hadoop.fs.guice;

import com.amazon.ws.emr.hadoop.fs.HadoopConfigurationAWSCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.ReflectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultAWSCredentialsProviderFactory
  implements AWSCredentialsProviderFactory
{
  private static final Logger LOG = LoggerFactory.getLogger(DefaultAWSCredentialsProviderFactory.class);
  
  public AWSCredentialsProvider getAwsCredentialsProvider(String service, URI uri, Configuration configuration)
  {
    return getAwsCredentialsProviderChain(service, uri, configuration);
  }
  
  private AWSCredentialsProvider getAwsCredentialsProviderChain(String service, URI uri, Configuration configuration)
  {
    List<AWSCredentialsProvider> providers = new ArrayList();
    AWSCredentialsProvider customProvider = getCustomAwsCredentialsProvider(uri, configuration);
    if (customProvider != null) {
      providers.add(customProvider);
    }
    providers.add(new UserGroupMappingAWSSessionCredentialsProvider());
    if ("dynamodb".equals(service)) {
      providers.add(new HadoopConfigurationAWSCredentialsProvider(configuration, "fs.s3.consistent.metadata.accessKey", "fs.s3.consistent.metadata.secretKey"));
    }
    providers.add(new HadoopConfigurationAWSCredentialsProvider(configuration, uri));
    providers.add(new InstanceProfileCredentialsProvider());
    return getChainForCredentialsProviders(providers);
  }
  
  public AWSCredentialsProvider getAwsCredentialsProvidersAsChain(AWSCredentialsProvider... providers)
  {
    return getChainForCredentialsProviders(Arrays.asList(providers));
  }
  
  protected AWSCredentialsProvider getChainForCredentialsProviders(List<AWSCredentialsProvider> providers)
  {
    AWSCredentialsProviderChain providerChain = new AWSCredentialsProviderChain(providers);
    providerChain.setReuseLastProvider(true);
    return providerChain;
  }
  
  private AWSCredentialsProvider getCustomAwsCredentialsProvider(URI uri, Configuration configuration)
  {
    String providerClass = configuration.get("fs.s3.customAWSCredentialsProvider");
    if (!Strings.isNullOrEmpty(providerClass))
    {
      try
      {
        clazz = Class.forName(providerClass);
      }
      catch (ClassNotFoundException e)
      {
        Class clazz;
        throw new RuntimeException("Custom AWSCredentialsProvider not found: " + providerClass, e);
      }
      try
      {
        Constructor<AWSCredentialsProvider> constructor = clazz.getConstructor(new Class[] { URI.class, Configuration.class });
        constructor.setAccessible(true);
        return (AWSCredentialsProvider)constructor.newInstance(new Object[] { uri, configuration });
      }
      catch (NoSuchMethodException|IllegalAccessException|InstantiationException|InvocationTargetException e)
      {
        Class clazz;
        LOG.info("Unable to create provider using constructor: {}({}, {})", new Object[] {clazz
          .getSimpleName(), URI.class.getName(), Configuration.class.getName() });
        
        return (AWSCredentialsProvider)ReflectionUtils.newInstance(clazz, configuration);
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.guice.DefaultAWSCredentialsProviderFactory
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */