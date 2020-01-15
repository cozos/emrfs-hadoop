package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public final class SystemPropertyCsmConfigurationProvider
  implements CsmConfigurationProvider
{
  public CsmConfiguration getConfiguration()
    throws SdkClientException
  {
    String enabled = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.enabled");
    if (enabled == null) {
      throw new SdkClientException("Unable to load Client Side Monitoring configurations from system properties variables!");
    }
    String host = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.host", "127.0.0.1");
    String port = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.port");
    String clientId = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.sdk.csm.clientId", "");
    try
    {
      int portNumber = port == null ? 31000 : Integer.parseInt(port);
      return CsmConfiguration.builder()
        .withEnabled(Boolean.valueOf(Boolean.parseBoolean(enabled)))
        .withHost(host)
        .withPort(Integer.valueOf(portNumber))
        .withClientId(clientId)
        .build();
    }
    catch (Exception e)
    {
      throw new SdkClientException("Unable to load Client Side Monitoring configurations from system properties variables!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.SystemPropertyCsmConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */