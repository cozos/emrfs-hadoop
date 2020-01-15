package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CsmConfigurationProviderChain
  implements CsmConfigurationProvider
{
  private static final Log log = LogFactory.getLog(CsmConfigurationProviderChain.class);
  private final List<CsmConfigurationProvider> providers = new ArrayList();
  
  public CsmConfigurationProviderChain(CsmConfigurationProvider... providers)
  {
    if (providers != null) {
      Collections.addAll(this.providers, providers);
    }
  }
  
  public CsmConfiguration getConfiguration()
  {
    for (CsmConfigurationProvider p : providers) {
      try
      {
        return p.getConfiguration();
      }
      catch (SdkClientException e)
      {
        if (log.isDebugEnabled()) {
          log.debug("Unable to load configuration from " + p.toString() + ": " + e.getMessage());
        }
      }
    }
    throw new SdkClientException("Could not resolve client side monitoring configuration from the configured providers in the chain");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */