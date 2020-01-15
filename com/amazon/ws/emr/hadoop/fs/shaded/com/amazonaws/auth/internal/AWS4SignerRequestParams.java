package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SignableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.SdkClock.Instance;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.AwsHostNameUtils;
import java.net.URI;
import java.util.Date;

public final class AWS4SignerRequestParams
{
  private final SignableRequest<?> request;
  private final long signingDateTimeMilli;
  private final String scope;
  private final String regionName;
  private final String serviceName;
  private final String formattedSigningDateTime;
  private final String formattedSigningDate;
  private final String signingAlgorithm;
  
  public AWS4SignerRequestParams(SignableRequest<?> request, Date signingDateOverride, String regionNameOverride, String serviceName, String signingAlgorithm)
  {
    this(request, signingDateOverride, regionNameOverride, serviceName, signingAlgorithm, null);
  }
  
  public AWS4SignerRequestParams(SignableRequest<?> request, Date signingDateOverride, String regionNameOverride, String serviceName, String signingAlgorithm, String endpointPrefix)
  {
    if (request == null) {
      throw new IllegalArgumentException("Request cannot be null");
    }
    if (signingAlgorithm == null) {
      throw new IllegalArgumentException("Signing Algorithm cannot be null");
    }
    this.request = request;
    
    signingDateTimeMilli = (signingDateOverride != null ? signingDateOverride.getTime() : getSigningDate(request));
    
    formattedSigningDate = AWS4SignerUtils.formatDateStamp(signingDateTimeMilli);
    this.serviceName = serviceName;
    
    regionName = (regionNameOverride != null ? regionNameOverride : resolveRegion(endpointPrefix, this.serviceName));
    
    scope = generateScope(request, formattedSigningDate, this.serviceName, regionName);
    
    formattedSigningDateTime = AWS4SignerUtils.formatTimestamp(signingDateTimeMilli);
    this.signingAlgorithm = signingAlgorithm;
  }
  
  private String resolveRegion(String endpointPrefix, String serviceSigningName)
  {
    return AwsHostNameUtils.parseRegionName(request.getEndpoint().getHost(), endpointPrefix != null ? endpointPrefix : serviceSigningName);
  }
  
  private final long getSigningDate(SignableRequest<?> request)
  {
    return SdkClock.Instance.get().currentTimeMillis() - request.getTimeOffset() * 1000L;
  }
  
  private String generateScope(SignableRequest<?> request, String dateStamp, String serviceName, String regionName)
  {
    StringBuilder scopeBuilder = new StringBuilder();
    return dateStamp + "/" + regionName + "/" + 
      serviceName + "/" + "aws4_request";
  }
  
  public SignableRequest<?> getRequest()
  {
    return request;
  }
  
  public String getScope()
  {
    return scope;
  }
  
  public String getFormattedSigningDateTime()
  {
    return formattedSigningDateTime;
  }
  
  public long getSigningDateTimeMilli()
  {
    return signingDateTimeMilli;
  }
  
  public String getRegionName()
  {
    return regionName;
  }
  
  public String getServiceName()
  {
    return serviceName;
  }
  
  public String getFormattedSigningDate()
  {
    return formattedSigningDate;
  }
  
  public String getSigningAlgorithm()
  {
    return signingAlgorithm;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.internal.AWS4SignerRequestParams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */