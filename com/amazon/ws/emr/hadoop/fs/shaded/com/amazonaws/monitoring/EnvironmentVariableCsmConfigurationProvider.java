package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.ThreadSafe;

@ThreadSafe
public final class EnvironmentVariableCsmConfigurationProvider
  implements CsmConfigurationProvider
{
  public CsmConfiguration getConfiguration()
  {
    String enabled = System.getenv("AWS_CSM_ENABLED");
    if (enabled == null) {
      throw new SdkClientException("Unable to load Client Side Monitoring configurations from environment variables!");
    }
    String host = System.getenv("AWS_CSM_HOST");
    host = host == null ? "127.0.0.1" : host;
    String port = System.getenv("AWS_CSM_PORT");
    String clientId = System.getenv("AWS_CSM_CLIENT_ID");
    clientId = clientId == null ? "" : clientId;
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
      throw new SdkClientException("Unable to load Client Side Monitoring configurations from environment variables!", e);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.EnvironmentVariableCsmConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */