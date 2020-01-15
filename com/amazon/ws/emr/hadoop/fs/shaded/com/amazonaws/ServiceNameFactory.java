package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.HttpClientConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.InternalConfig.Factory;

 enum ServiceNameFactory
{
  private ServiceNameFactory() {}
  
  static String getServiceName(String httpClientName)
  {
    InternalConfig config = InternalConfig.Factory.getInternalConfig();
    HttpClientConfig clientConfig = config.getHttpClientConfig(httpClientName);
    return clientConfig == null ? null : clientConfig.getServiceName();
  }
  
  static String getServiceNameInRegionMetadata(String httpClientName)
  {
    InternalConfig config = InternalConfig.Factory.getInternalConfig();
    HttpClientConfig clientConfig = config.getHttpClientConfig(httpClientName);
    return clientConfig == null ? null : clientConfig.getRegionMetadataServiceName();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ServiceNameFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */