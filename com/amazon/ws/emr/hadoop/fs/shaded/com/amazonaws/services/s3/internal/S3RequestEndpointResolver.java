package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.Request;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.ServiceEndpointBuilder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.SdkHttpUtils;
import java.net.URI;
import java.net.URISyntaxException;

public class S3RequestEndpointResolver
{
  private final ServiceEndpointBuilder endpointBuilder;
  private final boolean isPathStyleAccess;
  private final String bucketName;
  private final String key;
  
  public S3RequestEndpointResolver(ServiceEndpointBuilder endpointBuilder, boolean isPathStyleAccess, String bucketName, String key)
  {
    this.endpointBuilder = endpointBuilder;
    this.isPathStyleAccess = isPathStyleAccess;
    this.bucketName = bucketName;
    this.key = key;
  }
  
  static boolean isValidIpV4Address(String ipAddr)
  {
    if (ipAddr == null) {
      return false;
    }
    String[] tokens = ipAddr.split("\\.");
    if (tokens.length != 4) {
      return false;
    }
    for (String token : tokens) {
      try
      {
        int tokenInt = Integer.parseInt(token);
        if ((tokenInt < 0) || (tokenInt > 255)) {
          return false;
        }
      }
      catch (NumberFormatException ase)
      {
        return false;
      }
    }
    return true;
  }
  
  private static URI convertToVirtualHostEndpoint(URI endpoint, String bucketName)
  {
    try
    {
      return new URI(String.format("%s://%s.%s", new Object[] { endpoint.getScheme(), bucketName, endpoint.getAuthority() }));
    }
    catch (URISyntaxException e)
    {
      throw new IllegalArgumentException("Invalid bucket name: " + bucketName, e);
    }
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void resolveRequestEndpoint(Request<?> request)
  {
    resolveRequestEndpoint(request, null);
  }
  
  public void resolveRequestEndpoint(Request<?> request, String regionString)
  {
    if (regionString != null)
    {
      Region r = RegionUtils.getRegion(regionString);
      if (r == null) {
        throw new SdkClientException("Not able to determine region for " + regionString + ".Please upgrade to a newer version of the SDK");
      }
      endpointBuilder.withRegion(r);
    }
    URI endpoint = endpointBuilder.getServiceEndpoint();
    if (shouldUseVirtualAddressing(endpoint))
    {
      request.setEndpoint(convertToVirtualHostEndpoint(endpoint, bucketName));
      request.setResourcePath(SdkHttpUtils.urlEncode(getHostStyleResourcePath(), true));
    }
    else
    {
      request.setEndpoint(endpoint);
      if (bucketName != null) {
        request.setResourcePath(SdkHttpUtils.urlEncode(getPathStyleResourcePath(), true));
      }
    }
  }
  
  private boolean shouldUseVirtualAddressing(URI endpoint)
  {
    return (!isPathStyleAccess) && (BucketNameUtils.isDNSBucketName(bucketName)) && 
      (!isValidIpV4Address(endpoint.getHost()));
  }
  
  private String getHostStyleResourcePath()
  {
    String resourcePath = key;
    if ((key != null) && (key.startsWith("/"))) {
      resourcePath = "/" + key;
    }
    return resourcePath;
  }
  
  private String getPathStyleResourcePath()
  {
    return bucketName + "/" + (key != null ? key : "");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.S3RequestEndpointResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */